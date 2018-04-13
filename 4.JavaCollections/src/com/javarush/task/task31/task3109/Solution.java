package com.javarush.task.task31.task3109;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/* 
Читаем конфиги
*/
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Properties properties = solution.getProperties("src/com/javarush/test/level31/lesson10/task01/properties.xml");
        properties.list(System.out);

        properties = solution.getProperties("src/com/javarush/test/level31/lesson10/task01/properties.txt");
        properties.list(System.out);

        properties = solution.getProperties("src/com/javarush/test/level31/lesson10/task01/notExists");
        properties.list(System.out);
    }

    public Properties getProperties(String fileName) {
        Properties properties = new Properties();
        boolean isLoadedFromXML;

        try {
            FileInputStream inputStream = new FileInputStream(fileName);
            properties.loadFromXML(inputStream);
            isLoadedFromXML = true;
        } catch (IOException exc) {
            isLoadedFromXML = false;
        }
        if (!isLoadedFromXML) {
            FileInputStream inputStream = null;
            try {
                inputStream = new FileInputStream(fileName);
                properties.load(inputStream);

            } catch (IOException exc) {
                exc.printStackTrace();
            } finally {
                try {
                    if (inputStream != null)
                        inputStream.close();
                } catch (IOException e) {
                    /*NOP*/
                }
            }
        }
        return properties;
    }
}