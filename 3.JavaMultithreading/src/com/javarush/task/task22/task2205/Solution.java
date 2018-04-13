package com.javarush.task.task22.task2205;

import java.util.Formatter;

/*
МНЕ нравится курс JavaRush
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(String.format(getFormattedString(), "JavaRush", "курс", "мне", "нравится"));
        //должен быть вывод
        //"МНЕ нравится курс JavaRush"
    }

    public static String getFormattedString() {
       /* Formatter f = new Formatter();
        Number n[] = { 4, 2.2, 3, 1.1 }; f.format("%4$.1f %2$.1f %3$d %1$d", n[0], n[1], n[2], n[3]);
*/
        return "%3$S %4$s %2$s %1$s";
    }
}
