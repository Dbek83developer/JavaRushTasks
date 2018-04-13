package com.javarush.task.task22.task2213;


/**
 * Created by DBek on 12.06.2017.
 */
public class Field {

    private int width;
    private int height;
    private int[][] matrix;

    public Field(int width, int height) {
        this.width = width;
        this.height = height;
        matrix = new int[height][width];
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int[][] getMatrix() {
        return matrix;
    }

    public Integer getValue(int x, int y) {
        return null;
    }


    public void setValue(int x, int y, int value) {

    }


    public void print() {
        for (int i = 0; i < getHeight(); i++)
            for (int j = 0; j < getWidth(); j++) {
                if (getValue(i, j) == 0)
                    System.out.print(".");
                else
                    System.out.print("X");
            }
        System.out.println();
    }


    public void removeFullLines() {
    }
}
