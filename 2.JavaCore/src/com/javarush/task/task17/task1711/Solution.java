package com.javarush.task.task17.task1711;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {
        switch (args[0]) {
            case "-c":
                synchronized (allPeople) {
                    addToEndOfListC(args);
                }
                break;
            case "-u":
                synchronized (allPeople) {
                    updateU(args);
                }
                break;
            case "-d":
                synchronized (allPeople) {
                    deleteD(args);
                }
                break;
            case "-i":
                synchronized (allPeople) {
                    outputI(args);
                }
        }
        //start here - начни тут
    }

    public static void addToEndOfListC(String[] args) throws ParseException {
        for (int i = 1; i < args.length; i += 3) {
            String
                    name = args[i],
                    sex = args[i + 1],
                    bd = args[i + 2];
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);


            if (sex.equals("м")) {
                Person male = Person.createMale(name, sdf.parse(bd));
                allPeople.add(male);
                System.out.println(allPeople.indexOf(male));
            } else if (sex.equals("ж")) {
                Person female = Person.createFemale(name, sdf.parse(bd));
                allPeople.add(female);
                System.out.println(allPeople.indexOf(female));
            }
        }
    }

    public static void updateU(String[] args) throws ParseException {
        for (int i = 1; i < args.length; i += 4) {
            String
                    id = args[i],
                    name = args[i + 1],
                    sex = args[i + 2],
                    bd = args[i + 3];
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
            Person person = allPeople.get(Integer.parseInt(id));
            person.setName(name);
            if (sex.equals("м")) person.setSex(Sex.MALE);
            else if (sex.equals("ж")) person.setSex(Sex.FEMALE);
            person.setBirthDay(sdf.parse(bd));
        }
    }

    public static void deleteD(String[] args) {
        for (int i = 1; i < args.length; i++) {
            int index = Integer.parseInt(args[i]);
            Person person = allPeople.get(index);
            person.setName(null);
            person.setSex(null);
            person.setBirthDay(null);
        }
    }

    public static void outputI(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        String sex = null;
        String date = null;
        for (int i = 1; i < args.length; i++) {
            int index = Integer.parseInt(args[i]);
            Person p = allPeople.get(index);

            if (p.getBirthDay() != null)
                date = sdf.format(p.getBirthDay());

            if (p.getSex() == Sex.MALE) sex = "м";
            else if (p.getSex() == Sex.FEMALE) sex = "ж";

            //System.out.print(index + ": ");
            System.out.print(p.getName() + " " + sex + " ");
            System.out.println(date);
        }
    }
}


