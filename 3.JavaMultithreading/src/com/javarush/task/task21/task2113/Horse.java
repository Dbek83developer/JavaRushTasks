package com.javarush.task.task21.task2113;

/**
 * Created by DbekDeveloper on 25.05.2017.
 */
/*Добавь в класс Horse переменные name (String), speed (double), distance (double).*/

public class Horse {
    String name;
    double speed;
    double distance;

    public Horse(String name, double speed, double distance) {
        this.name = name;
        this.speed = speed;
        this.distance = distance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public void move() {
        distance += Math.random() * speed;
    }

    public void print() {
        for (int i = 0; i < (int) distance; i++) {
            System.out.print('.');
        }
        System.out.println(name);
    }
}
