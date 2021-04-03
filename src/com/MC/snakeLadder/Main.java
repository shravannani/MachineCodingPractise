package com.MC.snakeLadder;

import java.util.Scanner;

public class Main {
    static int[] board;
    static String[] players;
    static int noOfPlayers;
    static Scanner scanner;
    int noOfCells;
    int noOfDices;

    public Main(int noOfCells, int noOfDices) {
        this.noOfCells = noOfCells;
        board = new int[noOfCells + 1];
        this.noOfDices = noOfDices;
        scanner = new Scanner(System.in);
    }

    public static void readInputForSnakeLadder(boolean isInputForSnake) {
        int coefficient = 1;

        if (isInputForSnake) {
            coefficient = -1;
        }

        int s = scanner.nextInt();
        for (int i = 0; i < s; i++) {
            int upper, lower;
            if (isInputForSnake) {
                upper = scanner.nextInt();
                lower = scanner.nextInt();
                board[upper] = coefficient * lower;
            } else {
                lower = scanner.nextInt();
                upper = scanner.nextInt();
                board[lower] = coefficient * upper;
            }
        }
    }

    public static void readInputForPlayers() {
        noOfPlayers = scanner.nextInt();
        players = new String[noOfPlayers];

        for (int i = 0; i < noOfPlayers; i++) {
            players[i] = scanner.nextLine().trim();
        }
    }

    public static void main(String[] args) {
        Main main = new Main(100, 2);
        readInputForSnakeLadder(true);
        readInputForSnakeLadder(false);
        readInputForPlayers();

        Game game1 = new Game(noOfPlayers);
        game1.startGame(main.noOfDices, players, board);
    }
}
