package com.javarush.task.task23.task2301;

/* 
Запрети наследование
*/
public class Solution {

    public final static class Listener {
        public void onMouseDown(int x, int y) {
            //do something on mouse down event
            System.out.println("Mouse down: " + (x + y));
        }

        public void onMouseUp(int x, int y) {
            //do something on mouse up event
            System.out.println("Mouse up: " + (x - y));
        }
    }

    public static void main(String[] args) {
        Listener listener = new Listener();
        listener.onMouseDown(7, 5);
        listener.onMouseUp(7, 5);

    }
}
