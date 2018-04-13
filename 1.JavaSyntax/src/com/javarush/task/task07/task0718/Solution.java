package com.javarush.task.task07.task0718;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/*
Проверка на упорядоченность
*/

public class Solution {
    public static void main(String[] args) throws IOException {
/*        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] list = new String[10];
        int[] lengthMass = new int[10];

        for (int i = 0; i < list.length; i++) {
            list[i] = reader.readLine();
            lengthMass[i] = list[i].length();
        }
        // sortirovka
        sort(lengthMass, 0, lengthMass.length - 1);

        for (int i = 0; i < lengthMass.length; i++) {
            if (list[i].length() != lengthMass[i]) {
                System.out.println(i+1);
                break;
            }
        }*/
        BufferedReader g = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> a = new ArrayList<String>();
        for (int i = 0; i < 10; i++) a.add(g.readLine());
        for (int i = 0; i < a.size() - 1; i++) {
            if (a.get(i + 1).length() < a.get(i).length()) System.out.println(i + 1);

        }
    }

    // sortirovka po vozrastaniyu
    public static void sort(int[] array, int low, int high) {
        int i = low;
        int j = high;
        int x = array[low + (high - low) / 2];
        do {
            while (array[i] < x) ++i;
            while (array[j] > x) --j;
            if (i <= j) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
        } while (i <= j);
        if (low < j) sort(array, low, j);
        if (i < high) sort(array, i, high);
    }
}

