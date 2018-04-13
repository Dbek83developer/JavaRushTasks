package com.javarush.task.task20.task2021;

import java.io.*;

/* 
Запрет сериализации
*/
public class Solution implements Serializable {
    public static class SubSolution extends Solution {
        private void writeObject(ObjectOutputStream out) throws IOException {
            throw new NotSerializableException("Non serializable");
        }

        private void readObject(ObjectInputStream in) throws IOException {
            throw new NotSerializableException("Non serializable class!");
        }
    }

    public static void main(String[] args) {

    }
}