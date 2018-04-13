package com.javarush.task.task18.task1827;

/* 
Прайсы
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bufRead = new BufferedReader(new InputStreamReader(System.in));
        String fileOut = bufRead.readLine();
        bufRead.close();
        List<String> list = new ArrayList();
        BufferedReader readIn = new BufferedReader(new FileReader(fileOut));
        String str;
        final Pattern pattern = Pattern.compile("^\\d+");
        Matcher matcher;
        long maxNum = 0;
        while (readIn.ready()) {
            str = readIn.readLine();
            list.add(str);
            matcher = pattern.matcher(str);
            long num = 0;
            while (matcher.find()) {
                num = Long.parseLong(matcher.group(0));
            }
            if (num > maxNum) {
                maxNum = num;
            }
        }
        readIn.close();
        if (args[0].equals("-c")) {
            list.add(String.format("%-8d%-30s%-8s%-4s", (++maxNum), args[1], args[2], args[3]));
        }

        BufferedWriter bufWrite = new BufferedWriter(new FileWriter(fileOut));
        for (String s : list) {
            bufWrite.write(s + "\n");
        }
        bufWrite.close();
    }
}
