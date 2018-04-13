package com.javarush.task.task04.task0413;

/* 
День недели
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int chislo = scanner.nextInt();
        String[] mass = {"понедельник", "вторник", "среда", "четверг", "пятница", "суббота", "воскресенье"};
        if (chislo > 0 && chislo < 8) {
            System.out.println(mass[chislo - 1]);
        } else {
            System.out.println("такого дня недели не существует");
        }
    }
}