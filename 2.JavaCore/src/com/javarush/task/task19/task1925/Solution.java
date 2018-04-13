package com.javarush.task.task19.task1925;

/* 
Длинные слова
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        if (args.length != 2) return;
        BufferedReader fileIn = new BufferedReader(new FileReader(args[0]));
        BufferedWriter fileOut = new BufferedWriter(new FileWriter(args[1]));
        String str;
        StringBuilder result = new StringBuilder();
        while ((str = fileIn.readLine()) != null) {
            String[] bufferWord = str.split(" ");
            for (String s : bufferWord) {
                if (s.length() > 6) result.append(s).append(",");
            }
        }
        result.deleteCharAt(result.length() - 1);
        fileOut.write(result.toString());
        fileIn.close();
        fileOut.close();
    }
}
