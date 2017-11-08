package io.github.tdurova;

import java.awt.*;
import java.io.*;
import java.util.Scanner;

/**
 * main method to accept arguments from command line
 */
public class App {
    public static void main(String[] args) {

        Game game = new Game();
        Console console = System.console();

        System.out.println("Game starts! Choose number from 0 to 10 or press enter to generate a random value!");


        System.out.println(game.scoreGame());
        System.out.println(game.isFinished());

        System.exit(0);

        System.out.println("Round one. Toss one.");
        System.out.println("Round one. Toss two.");

    }
}
