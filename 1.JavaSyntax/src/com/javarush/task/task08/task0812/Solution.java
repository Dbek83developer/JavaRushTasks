package com.javarush.task.task08.task0812;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Cамая длинная последовательность
*/
public class Solution {
    public static void main(String[] args) throws IOException {
/*        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in) );
        int[] array = new int[10];
        ArrayList  list = new ArrayList();
        int i = 0;

        while (i < 10) {
            String s = reader.readLine();
          //  if (s.isEmpty()) break;
            array[i] = (Integer.parseInt(s));
            i++;
        }
        sort(array, 0, array.length - 1);
        list.add(array);
        //---------------------> nado prodoljat <-----------------------

            //напишите тут ваш код*/
        ArrayList<Integer> arrayList = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 10; i++) {
            arrayList.add(i, Integer.parseInt(reader.readLine()));
        }
        int max = 1;
        int count = 1;
        for (int i = 1; i < 10; i++) {
            if ((arrayList.get(i).equals(arrayList.get(i - 1)))) {
                count++;
            } else {
                count = 1;
            }
            if (count > max) {
                max = count;
            }
        }
        System.out.println(max);
    }


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