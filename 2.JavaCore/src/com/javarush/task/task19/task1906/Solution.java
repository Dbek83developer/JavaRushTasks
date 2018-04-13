package com.javarush.task.task19.task1906;

/* 
Четные байты
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String sourceFileName = reader.readLine();
        String destinationFileName = reader.readLine();

        reader.close();

        FileReader fileReader = new FileReader(sourceFileName);
        FileWriter fileWriter = new FileWriter(destinationFileName);
        int count = 0;
        while (fileReader.ready()) {
            int c = fileReader.read();
            count++;
            if (count % 2 == 0) fileWriter.write(c);
        }
        fileReader.close();
        fileWriter.close();
    }
}
