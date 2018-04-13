package com.javarush.task.task06.task0606;

import java.io.*;
import java.util.Scanner;

/* 
Чётные и нечётные циферки
*/

public class Solution {

    public static int even;
    public static int odd;

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String number = scanner.nextLine().trim();
        char[] array = number.toCharArray();
        for (char c : array) {
            if (!Character.isDigit(c)) {
                throw new IllegalArgumentException();
            }
            if (Character.getNumericValue(c) % 2 == 0) even++;
            else odd++;

        }
        System.out.println("Even: " + even + " Odd: " + odd);

        //напишите тут ваш код
    }
}
