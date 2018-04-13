package com.javarush.task.task06.task0605;


import java.io.*;

/* 
Контролируем массу тела
*/

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader bis = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the your mass: ");
        double weight = Double.parseDouble(bis.readLine());
        System.out.println("Enter the your height in meter: ");
        double height = Double.parseDouble(bis.readLine());

        Body.massIndex(weight, height);
    }

    public static class Body {
        public static void massIndex(double weight, double height) {
            double indMasTelo = 0;
            indMasTelo = weight / (height * height);
            // <18.5
            if (indMasTelo < 18.5) {
                System.out.println("Недовес: меньше чем 18.5");
            }

            // >=18.5 24.9<=
            if (indMasTelo >= 18.5 && indMasTelo <= 24.9) {
                System.out.println("Нормальный: между 18.5 и 24.9");
            }

            // >=25  29.9<=
            if (indMasTelo >= 25 && indMasTelo <= 29.9) {
                System.out.println("Избыточный вес: между 25 и 29.9");
            }

            // >=30
            if (indMasTelo >= 30) {
                System.out.println("Ожирение: 30 или больше");
            }
        }
    }
}
