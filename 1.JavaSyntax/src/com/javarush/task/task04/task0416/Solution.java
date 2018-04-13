package com.javarush.task.task04.task0416;

/* 
Переходим дорогу вслепую
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        double a = scanner.nextDouble();
        //зелёный
        if (a % 5 < 3 || a % 5 == 0) {
            System.out.println("зелёный");
        }

        //желтый
        if (a % 5 >= 3 && a % 5 < 4) {
            System.out.println("желтый");
        }

        //красный
        if (a % 5 >= 4) {
            System.out.println("красный");
        }
        //напишите тут ваш код
    }
}