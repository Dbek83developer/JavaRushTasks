package com.javarush.task.task19.task1919;

/* 
Считаем зарплаты
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        Map<String, Double> map = new TreeMap<String, Double>();

        BufferedReader reader = new BufferedReader(new FileReader(args[0]));

        while (reader.ready()) {
            String[] ar = reader.readLine().split(" ");
            try {
                if (map.containsKey(ar[0])) {
                    map.put(ar[0], map.get(ar[0]) + Double.parseDouble(ar[1]));
                } else {
                    map.put(ar[0], Double.parseDouble(ar[1]));
                }
            } catch (ArrayIndexOutOfBoundsException e) {

            }
        }

        for (Map.Entry<String, Double> pair : map.entrySet()) {
            System.out.println(pair.getKey() + " " + pair.getValue());
        }
        reader.close();
    }
}
