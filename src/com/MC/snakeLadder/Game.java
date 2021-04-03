package com.MC.snakeLadder;

public class Game {
    int noOfPlayers;
    int[] playerState;

    public Game(int noOfPlayers) {
        this.noOfPlayers = noOfPlayers;
        playerState = new int[this.noOfPlayers];
    }

    public int rollDie(int noOfDies) {
        int dieValue = 0;

        for (int i = 0; i < noOfDies; i++) {
            dieValue += (Math.random() * 6) + 1;
        }

        return dieValue;
    }

    public void startGame(int noOfDies, String[] players, int[] board) {
        playGame(noOfDies, players, board);
    }

    public void playGame(int noOfDies, String[] players, int[] board) {
        int noOfCells = board.length - 1;
        int player = 0;

        while (true) {
            int dieValue = rollDie(noOfDies);
            player = player % (this.noOfPlayers);

            int currentStateOfPlayer = playerState[player];

            String printValue;
            if ((dieValue + currentStateOfPlayer) <= noOfCells) {
                playerState[player] = changeState(currentStateOfPlayer, dieValue, board);
                printValue = String.format("%s rolled a %d and moved from %d to %d", players[player],
                    dieValue, currentStateOfPlayer, playerState[player]);
            } else {
                printValue = String.format("%s rolled a %d and can't move anywhere as newState %d exceeded maxValue %d",
                    players[player], dieValue, dieValue + currentStateOfPlayer, noOfCells);
            }
            System.out.println(printValue);

            if (playerState[player] == noOfCells) {
                System.out.println(players[player] + " wins the game");
                return;
            }

            player++;
        }
    }

    public int changeState(int current, int dieValue, int[] board) {
        if (board[current + dieValue] < 0) {
            return Math.abs(board[current + dieValue]);
        }

        if (board[current + dieValue] > 0) {
            return board[current + dieValue];
        }

        return current + dieValue;
    }
}
