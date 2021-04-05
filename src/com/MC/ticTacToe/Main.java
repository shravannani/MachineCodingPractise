package com.MC.ticTacToe;

import com.MC.ticTacToe.controller.Game;

public class Main {

    public static void main(String[] args) {
        Game game = new Game(2, 3);
        game.start();
    }
}
