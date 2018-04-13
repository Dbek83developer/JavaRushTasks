package com.javarush.task.task30.task3008.client;

import com.javarush.task.task30.task3008.Connection;
import com.javarush.task.task30.task3008.ConsoleHelper;
import com.javarush.task.task30.task3008.Message;
import com.javarush.task.task30.task3008.MessageType;

import java.io.IOException;

/**
 * Created by DBek on 12.06.2017.
 */
public class Client {
    protected Connection connection;
    private volatile boolean clientConnected = false;

    public class SocketThread extends Thread {
        //15.1.
        protected void processIncomingMessage(String message) {
            ConsoleHelper.writeMessage(message);
        }

        protected void informAboutAddingNewUser(String userName) {
            ConsoleHelper.writeMessage(userName + " присоединился к чату");
        }

        protected void informAboutDeletingNewUser(String userName) {
            ConsoleHelper.writeMessage(userName + " покинул чат");
        }

        protected void notifyConnectionStatusChanged(boolean clientConnected) {
            Client.this.clientConnected = clientConnected;
            synchronized (Client.this) {
                Client.this.notify();
            }
        }

        //16.1.
        protected void clientHandshake() throws IOException, ClassNotFoundException {
            boolean accepted = false;
            //16.1.1.
            while (!accepted) {
                Message message = connection.receive();
                switch (message.getType()) {
                    //16.1.2.
                    case NAME_REQUEST:
                        String clientName = getUserName();
                        connection.send(new Message(MessageType.USER_NAME, clientName));
                        break;
                    //16.1.3.
                    case NAME_ACCEPTED:
                        notifyConnectionStatusChanged(true);
                        return;
                    //16.1.4.
                    default:
                        throw new IOException("Unexpected MessageType");
                }
            }
        }


        //16.2.
        protected void clientMainLoop() throws IOException, ClassNotFoundException {
            //16.2.6.
            while (!Thread.currentThread().isInterrupted()) { //but interrupted checking for daemon isn't necessary
                //16.2.1.
                Message message = connection.receive();
                switch (message.getType()) {
                    //16.2.2.
                    case TEXT:
                        processIncomingMessage(message.getData());
                        break;
                    //16.2.3.
                    case USER_ADDED:
                        informAboutAddingNewUser(message.getData());
                        break;
                    //16.2.4.
                    case USER_REMOVED:
                        informAboutDeletingNewUser(message.getData());
                        break;
                    //16.2.5.
                    default:
                        throw new IOException("Unexpected MessageType");
                }
            }
        }
    }

    protected String getServerAddress() {
        ConsoleHelper.writeMessage("Введите адрес сервера:");
        return ConsoleHelper.readString();
    }

    protected int getServerPort() {
        ConsoleHelper.writeMessage("Введите порт сервера:");
        return ConsoleHelper.readInt();
    }

    protected String getUserName() {
        ConsoleHelper.writeMessage("Введите имя пользователя:");
        return ConsoleHelper.readString();
    }

    protected boolean shouldSentTextFromConsole() {
        return true;
    }

    protected SocketThread getSocketThread() {
        return new SocketThread();
    }

    protected void sendTextMessage(String text) {
        try {
            connection.send(new Message(MessageType.TEXT, text));
        } catch (IOException e) {
            ConsoleHelper.writeMessage("Ошибка при отправке сообщения. Соединение будет закрыто.");
            clientConnected = false;
        }
    }

    public void run() {
        //14.1.1.
        SocketThread socketThread = getSocketThread();
        //14.1.2.
        socketThread.setDaemon(true);
        //14.1.3.
        socketThread.start();
        //14.1.4.
        synchronized (this) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                ConsoleHelper.writeMessage("Выход из программы по ошибке.");
                return;
            }
        }
        //14.1.5.
        if (clientConnected)
            ConsoleHelper.writeMessage("Соединение установлено. Для выхода наберите команду 'exit'.");
        else
            ConsoleHelper.writeMessage("Произошла ошибка во время работы клиента.");
        //14.1.6
        while (clientConnected) {
            String text = ConsoleHelper.readString();
            if (text.toLowerCase().equals("exit")) break;
            //14.1.7.
            if (shouldSentTextFromConsole())
                sendTextMessage(text);
        }
    }

    //14.2.
    public static void main(String[] args) {
        Client client = new Client();
        client.run();
    }
}



