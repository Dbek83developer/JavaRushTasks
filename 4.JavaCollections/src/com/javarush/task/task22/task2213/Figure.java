package com.javarush.task.task22.task2213;

/**
 * Created by DBek on 12.06.2017.
 */
public class Figure {
    private int[][] matrix;
    //����������
    private int x;
    private int y;

    public Figure(int x, int y, int[][] matrix) {
        this.x = x;
        this.y = y;
        this.matrix = matrix;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int[][] getMatrix() {
        return matrix;
    }

    public void rotate() {

    }

    /**
     * ������� ������� �����.
     * ��������� �� ������� �� ��� �� ������� ���� �/��� �� ������� �� �� ������� ������.
     */
    public void left() {

    }

    /**
     * ������� ������� ������.
     * ��������� �� ������� �� ��� �� ������� ���� �/��� �� ������� �� �� ������� ������.
     */
    public void right() {

    }

    /**
     * ������� ������� �����.
     * ������������, ���� ������� ������� �� ������� ������.
     */
    public void up() {

    }

    /**
     * ������� ������� ����.
     */
    public void down() {

    }

    /**
     * ������� ������� ���� �� ��� ���, ���� �� ������� �� ����-������.
     */
    public void downMaximum() {

    }

    /**
     * ��������� - ����� �� ������� ��������� �� ������� ������:
     * �) �� �������� �� ��� �� ������� ����
     * �) �� �������� �� ��� �� ������� ������
     */
    public boolean isCurrentPositionAvailable() {


        return true;
    }

    /**
     * ���������� ������� - ��������� ��� �� �������� ������ � ������� ����.
     */
    public void landed() {

    }

}
