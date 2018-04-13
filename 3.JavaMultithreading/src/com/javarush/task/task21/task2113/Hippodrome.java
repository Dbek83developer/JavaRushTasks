package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DbekDeveloper on 25.05.2017.
 */
public class Hippodrome {

    private List<Horse> horses;

    public List<Horse> getHorses() {
        return horses;
    }

    Hippodrome(List list) {
        horses = list;
    }

    public static Hippodrome game;

    void run() throws InterruptedException {
        for (int i = 1; i <= 100; i++) {
            move();
            print();
            Thread.sleep(200);
        }

    }

    void move() {
        for (Horse horse : horses) {
            horse.move();
        }

    }

    void print() {
        for (Horse horse : horses) {
            horse.print();
        }
        for (int i = 0; i < 10; i++) {
            System.out.println();
        }

    }

    public Horse getWinner() {
        Horse winner = horses.get(0);
        for (int i = 1; i < horses.size(); i++) {
            if (winner.distance < horses.get(i).distance) {
                winner = horses.get(i);
            }
        }
        return winner;
    }

    public void printWinner() {
        System.out.print("Winner is " + getWinner().getName() + "!");
    }

    public static void main(String[] args) throws InterruptedException {
        List<Horse> horseList = new ArrayList<>();
        Horse horse1 = new Horse("Aygir", 3, 0);
        Horse horse2 = new Horse("Iskander", 3, 0);
        Horse horse3 = new Horse("Tango", 3, 0);
        horseList.add(horse1);
        horseList.add(horse2);
        horseList.add(horse3);
        game = new Hippodrome(horseList);
        game.run();
        game.printWinner();
    }
}
