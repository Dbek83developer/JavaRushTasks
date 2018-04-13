package com.javarush.task.task04.task0409;

/* 
Ближайшее к 10
*/

public class Solution {
    public static void main(String[] args) {
        closeToTen(8, 11);
        closeToTen(14, 7);
    }

    public static void closeToTen(int a, int b) {
        int rez = 0;
        if (abs(10 - a) < abs(10 - b)) {
            rez = a;
        } else {
            rez = b;
        }
        System.out.println(rez); //::CODE:
    }

    public static int abs(int a) {
        if (a < 0) {
            return -a;
        } else {
            return a;
        }
    }
}