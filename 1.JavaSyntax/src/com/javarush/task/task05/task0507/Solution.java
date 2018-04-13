package com.javarush.task.task05.task0507;

/* 
Среднее арифметическое
*/

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        double sum = 0;
        int i = 0;
        while (number != -1) {
            sum = sum + number;
            number = scanner.nextInt();
            i++;
        }
        System.out.println(sum / i); //напишите тут ваш код
    }
}

