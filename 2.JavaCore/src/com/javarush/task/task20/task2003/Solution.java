package com.javarush.task.task20.task2003;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/* 
Знакомство с properties
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();

    public void fillInPropertiesMap() throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fis = new FileInputStream(reader.readLine());
        load(fis);
        reader.close();
    }

    public void save(OutputStream outputStream) throws Exception {
        //implement this method - реализуйте этот метод
        Properties myProperties = new Properties();
        // myProperties.load(outputStream);
        myProperties.putAll(properties);
        myProperties.store(outputStream, "Это мои мегаконфиги");
        outputStream.close();
    }

    public void load(InputStream inputStream) throws Exception {
        Properties myProperties = new Properties();
        myProperties.load(inputStream);
        properties.clear();
        for (Map.Entry e : myProperties.entrySet()) {
            properties.put(e.getKey().toString(), e.getValue().toString());
        }
        inputStream.close();
    }

    public static void main(String[] args) {

    }
}
