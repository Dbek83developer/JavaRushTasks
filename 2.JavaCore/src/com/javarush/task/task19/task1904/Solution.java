package com.javarush.task.task19.task1904;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/*
И еще один адаптер
*/

public class Solution {

    public static void main(String[] args) {

    }

    public static class PersonScannerAdapter implements PersonScanner {
        private final Scanner fileScanner;

        PersonScannerAdapter(Scanner fileScanner) {
            this.fileScanner = fileScanner;
        }

        @Override
        public Person read() throws IOException {
            String str = fileScanner.nextLine();
            String[] array = str.split(" ");
            String strDate = array[array.length - 3] + " " + array[array.length - 2]
                    + " " + array[array.length - 1];
            SimpleDateFormat format = new SimpleDateFormat("dd MM yyyy");
            Date date = new Date();
            try {
                date = format.parse(strDate);
            } catch (ParseException e) {
            }
            Person person = new Person(array[1], array[2], array[0], date);
            return person;
        }

        @Override
        public void close() throws IOException {
            fileScanner.close();
        }
    }
}