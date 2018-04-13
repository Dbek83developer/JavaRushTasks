package com.javarush.task.task20.task2002;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/*
Читаем и пишем в файл: JavaRush
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File your_file_name = File.createTempFile("1.txt", null);
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);
            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            {
                User user = new User();
                user.setFirstName("Vanya");
                user.setLastName("Kupriyanov");
                user.setBirthDate(new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH).parse("29.01.1986"));
                user.setMale(true);
                user.setCountry(User.Country.RUSSIA);
                javaRush.users.add(user);
            }
            {
                User user = new User();
                user.setFirstName("Kolya");
                user.setLastName("Vagitov");
                user.setBirthDate(new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH).parse("10.09.1984"));
                user.setMale(true);
                user.setCountry(User.Country.RUSSIA);
                javaRush.users.add(user);
            }
            javaRush.users.add(new User());
            javaRush.save(outputStream);
            outputStream.flush();
            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //check here that javaRush object equals to loadedObject object - проверьте тут, что javaRush и loadedObject равны
            if (javaRush.equals(loadedObject)) System.out.println("spiski odinakovi");
            else System.out.println("spiski raznie");
            for (int i = 0; i < loadedObject.users.size(); i++) {
                System.out.print(loadedObject.users.get(i).getFirstName() + " ");
                System.out.print(loadedObject.users.get(i).getLastName() + " ");
                System.out.print(loadedObject.users.get(i).getBirthDate() + " ");
                System.out.print(loadedObject.users.get(i).isMale() + " ");
                System.out.print(loadedObject.users.get(i).getCountry() + " ");
                System.out.println();
            }
            outputStream.close();
            inputStream.close();
        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);

        public void save(OutputStream outputStream) throws Exception {
            PrintWriter writer = new PrintWriter(outputStream, true);
            int countUsers = users.size();
            writer.println(countUsers);
            for (int i = 0; i < countUsers; i++) {
                if (users.get(i).getFirstName() != null) writer.println(users.get(i).getFirstName());
                else writer.println("null");
                if (users.get(i).getLastName() != null) writer.println(users.get(i).getLastName());
                else writer.println("null");
                if (users.get(i).getBirthDate() != null)
                    writer.println(dateFormat.format(users.get(i).getBirthDate().getTime()));
                else writer.println("null");
                writer.println(users.get(i).isMale() ? "male" : "female");
                if (users.get(i).getCountry() != null) writer.println(users.get(i).getCountry().getDisplayedName());
                else writer.println("null");
            }
            writer.flush();
        }

        public void load(InputStream inputStream) throws Exception {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            int countUsers = Integer.parseInt(reader.readLine());
            String s;
            for (int i = 0; i < countUsers; i++) {
                User user = new User();
                s = reader.readLine();
                if (!s.equals("null")) user.setFirstName(s);
                s = reader.readLine();
                if (!s.equals("null")) user.setLastName(s);
                s = reader.readLine();
                if (!s.equals("null")) user.setBirthDate(dateFormat.parse(s));
                user.setMale(reader.readLine().equals("male"));
                s = reader.readLine();
                if (s.equals(User.Country.RUSSIA.getDisplayedName())) user.setCountry(User.Country.RUSSIA);
                if (s.equals(User.Country.UKRAINE.getDisplayedName())) user.setCountry(User.Country.UKRAINE);
                if (s.equals(User.Country.OTHER.getDisplayedName())) user.setCountry(User.Country.OTHER);
                users.add(user);
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            JavaRush javaRush = (JavaRush) o;
            return users != null ? users.equals(javaRush.users) : javaRush.users == null;
        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }
}