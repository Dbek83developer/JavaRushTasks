package com.javarush.task.task04.task0429;

/* 
Положительные и отрицательные числа
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int countPlus = 0;
        int countMinus = 0;
        for (int i = 0; i < 3; i++) {
            int number = scanner.nextInt();
            if (number > 0) countPlus++;
            else {
                if (number != 0) countMinus++;
            }
        }
        System.out.println("количество отрицательных чисел: " + countMinus);
        System.out.println("количество положительных чисел: " + countPlus);
        //напишите тут ваш код

    }
}
