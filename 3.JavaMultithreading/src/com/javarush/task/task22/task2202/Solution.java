package com.javarush.task.task22.task2202;

/* 
Найти подстроку
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(getPartOfString("JavaRush — лучший сервис обучения Java."));
    }

    public static String getPartOfString(String string) {
        if (string == null) {
            throw new TooShortStringException();
        }
        String array[] = string.split(" ");
        StringBuffer buffer = new StringBuffer();
        if (array.length >= 5) {
            for (int i = 1; i < 5; i++) {
                buffer.append(array[i]);
                buffer.append(" ");
            }
        } else {
            throw new TooShortStringException();
        }
        return buffer.toString().trim();
    }

    public static class TooShortStringException extends RuntimeException {
    }
}
