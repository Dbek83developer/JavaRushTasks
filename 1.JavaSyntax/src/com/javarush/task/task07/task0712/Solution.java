package com.javarush.task.task07.task0712;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Самые-самые
*/


public class Solution {
    public static void main(String[] args) throws Exception {
        ArrayList<String> list = new ArrayList<String>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int max = 0;
        int min = 2147483647;
        String s = "";
        for (int i = 0; i < 10; i++) {
            s = reader.readLine();
            list.add(i, s);
            max = s.length() > max ? s.length() : max;
            min = s.length() < min ? s.length() : min;
        }
        for (int i = 0; i < 10; i++) {
            if (list.get(i).length() == max || list.get(i).length() == min) {
                System.out.println(list.get(i));
                break;
            }
        }
    }
}
