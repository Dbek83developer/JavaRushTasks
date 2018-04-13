package com.javarush.task.task19.task1924;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
Замена чисел
*/

public class Solution {
    public static Map<Integer, String> map = new HashMap<Integer, String>();

    static {
        map.put(0, "ноль");
        map.put(1, "один");
        map.put(2, "два");
        map.put(3, "три");
        map.put(4, "четыре");
        map.put(5, "пять");
        map.put(6, "шесть");
        map.put(7, "семь");
        map.put(8, "восемь");
        map.put(9, "девять");
        map.put(10, "десять");
        map.put(11, "одиннадцать");
        map.put(12, "двенадцать");
    }


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fr = new BufferedReader(new FileReader(reader.readLine()));
        reader.close();
        //добавляем костыль, ой то есть пробел в начало файла))) - чтобы число в начале файла корректно подходило под шаблон
        String file = " ";
        //читаем файл, добавляя разделитель на строки в конце каждой линии, чтоб строки не слипались
        while (fr.ready()) file += fr.readLine() + System.getProperty("line.separator");
        Pattern pattern = Pattern.compile("(?<=\\s)[1-9][0-2]?(?=\\s)");
        Matcher matcher = pattern.matcher(file);
        //ищем совпадения в тексте
        while (matcher.find()) {
            if ((Integer.parseInt(file.substring(matcher.start(), matcher.end()))) <= 12) {
                //найденное совпадение преобразуем в строку, для удобочитаемости вводим переменную
                String forReplce = map.get(Integer.parseInt(file.substring(matcher.start(), matcher.end())));
                //меняем в тексте найденную цифру на текст
                file = file.substring(0, matcher.start()) + forReplce + file.substring(matcher.end());
                //обновляем текст в паттерне
                matcher = pattern.matcher(file);
            }
        }
        fr.close();
        //отрезаем наш мегапробел в начале строки
        file = file.substring(1);
        System.out.println(file);
    }
}