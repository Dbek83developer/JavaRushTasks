package com.javarush.task.task07.task0706;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/* 
Улицы и дома
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        int[] doma = new int[15];
        int sumEven = 0;
        int sumOdd = 0;
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < doma.length; i++) {
            doma[i] = scanner.nextInt();
            if (i % 2 == 0 || i == 0) sumEven += doma[i];
            if (i % 2 == 1) sumOdd += doma[i];
        }
        if (sumEven > sumOdd) {
            System.out.println("В домах с четными номерами проживает больше жителей.");
        }

        if (sumEven < sumOdd) {
            System.out.println("В домах с нечетными номерами проживает больше жителей.");
        }
        //напишите тут ваш код
    }
}
