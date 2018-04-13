package com.javarush.task.task18.task1826;

/* 
Шифровка
*/

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) {
        try {
            switch (args[0]) {
                case "-e":
                    encode(args[1], args[2]);
                    break;
                case "-d":
                    decode(args[1], args[2]);
                    break;
            }
        } catch (Exception e) {
            System.out.println(e);
        }


    }

    public static void encode(String fileInName, String fileOutname) throws IOException {
        FileInputStream fis = new FileInputStream(fileInName);
        FileOutputStream fos = new FileOutputStream(fileOutname);
        if (!new File(fileOutname).exists()) new File(fileOutname).createNewFile();
        while (fis.available() > 0) fos.write(fis.read() + 1);
        fis.close();
        fos.close();
    }

    public static void decode(String fileInName, String fileOutname) throws IOException {
        FileInputStream fis = new FileInputStream(fileInName);
        FileOutputStream fos = new FileOutputStream(fileOutname);
        if (!new File(fileOutname).exists()) new File(fileOutname).createNewFile();
        while (fis.available() > 0) fos.write(fis.read() - 1);
        fis.close();
        fos.close();
    }
}
