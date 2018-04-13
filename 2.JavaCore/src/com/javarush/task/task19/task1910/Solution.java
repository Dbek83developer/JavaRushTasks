package com.javarush.task.task19.task1910;

/* 
Пунктуация
*/

import com.sun.org.apache.xerces.internal.impl.io.ASCIIReader;

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String file1 = br.readLine();
        String file2 = br.readLine();
        br.close();

        BufferedReader reader = new BufferedReader(new FileReader(file1));
        BufferedWriter writer = new BufferedWriter(new FileWriter(file2));

        while (reader.ready()) {
            String line;
            line = reader.readLine();
            writer.write(line.replaceAll("\\W", ""));
        }
        reader.close();
        writer.close();
    }
}
