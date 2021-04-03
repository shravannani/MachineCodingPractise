package com.MC.snakeLadder;

import com.MC.Helpers;
import com.MC.snakeLadder.models.PlayersModel;

public class Main {
    static int[] board;
    int noOfCells;
    int noOfDices;

    public Main(int noOfCells, int noOfDices) {
        this.noOfCells = noOfCells;
        board = new int[noOfCells + 1];
        this.noOfDices = noOfDices;
    }

    public static void main(String[] args) {
        Main main = new Main(100, 2);
        Helpers helpers = new Helpers();
        helpers.readInputForSnakeLadder(true, board);
        helpers.readInputForSnakeLadder(false, board);
        PlayersModel playersModel = helpers.readInputForPlayers();

        Game game1 = new Game(playersModel.getNoOfPlayers());
        game1.startGame(main.noOfDices, playersModel.getPlayers(), board);
    }
}
