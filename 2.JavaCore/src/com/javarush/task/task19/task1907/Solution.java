package com.javarush.task.task19.task1907;

/* 
Считаем слово
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String sourceFileName = reader.readLine();
        FileReader readerFile = new FileReader(sourceFileName);
        int count = 0;
        String s = null;
        while (readerFile.ready()) {
            s += String.valueOf((char) readerFile.read());
        }
        String[] arr = s.split("\\W");
        for (String t : arr) {
            if (t.equals("world")) count++;
        }

      /*  while (readerFile.ready()) //пока есть непрочитанные байты в потоке ввода
        {
            char data = (char) readerFile.read(); //читаем один символ (char будет расширен до int)
            if (data == ',' || data == '.' || data == '!') count++;

        }*/

        System.out.println(count);
        //закрываем потоки после использования
        reader.close();
        readerFile.close();
    }
}
