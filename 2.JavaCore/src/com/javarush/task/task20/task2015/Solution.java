package com.javarush.task.task20.task2015;

import java.io.*;

/* 
Переопределение сериализации
*/
public class Solution implements Serializable, Runnable {
    transient private Thread runner;
    public int speed;

    public Solution(int speed) {
        this.speed = speed;
        runner = new Thread(this);
        runner.start();
    }

    public void run() {
        // do something here, does not matter
    }

    /**
     * Переопределяем сериализацию.
     * Для этого необходимо объявить методы:
     * private void writeObject(ObjectOutputStream out) throws IOException
     * private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException
     * Теперь сериализация/десериализация пойдет по нашему сценарию :)
     */
    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        Thread newObj;
        newObj = new Thread(this);
        newObj.start();
    }

    public static void main(String[] args) {
        Solution sol1 = new Solution(228);
        File myfile = new File("test.txt");
        ObjectOutputStream out = null;
        try {
            out = new ObjectOutputStream(new FileOutputStream(myfile));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            out.writeObject(sol1);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Solution sol2 = null;
        ObjectInputStream objectInputStream = null;
        try {
            objectInputStream = new ObjectInputStream(new FileInputStream(myfile));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            sol2 = (Solution) objectInputStream.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(sol1.speed);
        System.out.println(sol2.speed);
    }
}
