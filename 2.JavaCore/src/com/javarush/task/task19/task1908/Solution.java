package com.javarush.task.task19.task1908;

/* 
Выделяем числа
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        reader.close();

        String line = "";
        BufferedReader rd = new BufferedReader(new FileReader(file1));
        while (rd.ready()) {
            line = line + " " + rd.readLine();
        }
        rd.close();

        String[] array = line.split(" ");
        String temp = "";
        for (String x : array) {
            if (checkString(x)) {
                temp = temp + x + " ";
            }
        }

        BufferedWriter writer = new BufferedWriter(new FileWriter(file2));
        writer.write(temp.trim());
        writer.close();

    }

    public static boolean checkString(String string) {
        try {
            Integer.parseInt(string);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}

