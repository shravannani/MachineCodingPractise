package com.MC.snakeLadder;

import com.MC.snakeLadder.helper.InputHelper;
import com.MC.snakeLadder.controller.Game;
import com.MC.snakeLadder.models.PlayersModel;

public class Main {
    // TODO: Add a model for Board and move the below attributes to that
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

        InputHelper helpers = new InputHelper();
        helpers.readInputForSnakeLadder(true, board);
        helpers.readInputForSnakeLadder(false, board);
        PlayersModel playersModel = helpers.readInputForPlayers();

        Game game1 = new Game(playersModel.getNoOfPlayers());
        game1.startGame(main.noOfDices, playersModel.getPlayers(), board);
    }
}
