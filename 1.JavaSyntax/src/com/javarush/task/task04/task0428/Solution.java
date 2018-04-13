package com.javarush.task.task04.task0428;

/* 
Положительное число
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int count = 0;
        for (int i = 0; i < 3; i++) {
            if (scanner.nextInt() > 0) count++;
        }
        System.out.println(count);
    }
}
