package com.MC.ticTacToe.controller;

import com.MC.ticTacToe.helper.TicTacToeHelper;
import java.util.Scanner;

public class Game {

    int noOfPlayers;
    int noOfCells;
    String[][] players;
    String[][] grid;
    Scanner sc;
    TicTacToeHelper ticTacToeHelper;

    public Game(int noOfPlayers, int noOfCells) {
        this.noOfPlayers = noOfPlayers;
        this.noOfCells = noOfCells;
        this.players = new String[noOfPlayers][2];
        this.grid = initializeGrid();
        this.sc = new Scanner(System.in);
        this.ticTacToeHelper = new TicTacToeHelper();
    }

    public String[][] initializeGrid() {
        String[][] grid = new String[noOfCells + 1][noOfCells + 1];

        for (int i = 1; i <= noOfCells; i++) {
            for (int j = 1; j <= noOfCells; j++) {
                grid[i][j] = "-";
            }
        }

        return grid;
    }

    public void readInput() {
        for (int i = 0; i < noOfPlayers; i++) {
            String s = sc.nextLine();
            players[i] = s.split(" ");
        }
    }

    public void start() {
        readInput();
        playGame();
    }

    public void playGame() {
        this.ticTacToeHelper.displayGrid(grid);

        int moveNumber = 0;
        while (true) {
            if (moveNumber == noOfCells * noOfCells) {
                System.out.println("Game Over");
                break;
            }

            String input = sc.nextLine();
            if (input.equals("exit")) {
                break;
            }

            int x = Integer.parseInt(input.split(" ")[0]);
            int y = Integer.parseInt(input.split(" ")[1]);

            String peice = players[moveNumber % this.noOfPlayers][0];
            if (this.ticTacToeHelper.isValid(x, y, grid)) {
                grid[x][y] = peice;

                this.ticTacToeHelper.displayGrid(grid);


                if (this.ticTacToeHelper.isWinningMove(grid, x, y)) {
                    System.out.println(players[moveNumber % this.noOfPlayers][1] + " won the game");
                }
                moveNumber++;
            } else {
                System.out.println("Invalid Move");
            }
        }
    }
}
