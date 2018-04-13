package com.javarush.task.task19.task1922;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/*
Ищем нужные строки
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) throws IOException {
        //reading fileName
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        String file = "D:/test/start.txt";
        String file = reader.readLine();
        reader.close();

        //reading lines from the file
        BufferedReader linesReader = new BufferedReader(new FileReader(file));
        while (linesReader.ready()) {
            String line = linesReader.readLine();
            String[] array = line.split(" ");

            //Searching words
            int count = 0;
            for (String str : array) {
                if (words.contains(str)) count++;
            }

            if (count == 2) {
                for (int i = 0, n = array.length; i < n; i++) {
                    System.out.print(array[i] + " ");
                }
                System.out.println();
            }
        }
        linesReader.close();
    }
}