package com.MC.snakeLadder.helper;

import com.MC.snakeLadder.models.PlayersModel;

import java.util.Scanner;

public class InputHelper {
    Scanner scanner;

    public InputHelper(){
        this.scanner = new Scanner(System.in);
    }

    public void readInputForSnakeLadder(boolean isInputForSnake, int[] board) {
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

    public PlayersModel readInputForPlayers() {
        PlayersModel playersModel = new PlayersModel();
        int noOfPlayers = scanner.nextInt();
        String[] players = new String[noOfPlayers];

        for (int i = 0; i < noOfPlayers; i++) {
            players[i] = scanner.nextLine().trim();
        }

        playersModel.setPlayers(players);
        playersModel.setNoOfPlayers(noOfPlayers);

        return playersModel;
    }
}
