package com.javarush.task.task22.task2213;

/**
 * Created by DBek on 12.06.2017.
 */
public class Figure {
    private int[][] matrix;
    //координаты
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
     * ƒвигаем фигурку влево.
     * ѕровер€ем не вылезла ли она за границу пол€ и/или не залезла ли на зан€тые клетки.
     */
    public void left() {

    }

    /**
     * ƒвигаем фигурку вправо.
     * ѕровер€ем не вылезла ли она за границу пол€ и/или не залезла ли на зан€тые клетки.
     */
    public void right() {

    }

    /**
     * ƒвигаем фигурку вверх.
     * »спользуетс€, если фигурка залезла на зан€тые клетки.
     */
    public void up() {

    }

    /**
     * ƒвигаем фигурку вниз.
     */
    public void down() {

    }

    /**
     * ƒвигаем фигурку вниз до тех пор, пока не залезем на кого-нибудь.
     */
    public void downMaximum() {

    }

    /**
     * ѕровер€ем - может ли фигурка находитс€ на текущей позици:
     * а) не вылазиет ли она за границы пол€
     * б) не залазиет ли она на зан€тые клетки
     */
    public boolean isCurrentPositionAvailable() {


        return true;
    }

    /**
     * ѕриземл€ем фигурку - добавл€ем все ее непустые клетки к клеткам пол€.
     */
    public void landed() {

    }

}
