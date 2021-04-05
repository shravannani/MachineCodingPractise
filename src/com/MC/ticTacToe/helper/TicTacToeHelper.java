package com.MC.ticTacToe.helper;

public class TicTacToeHelper {

    public boolean isRowOrColumnEqual(String[][] grid, boolean isRow) {

        for (int i = 1; i < grid.length; i++) {
            for (int j = 2; j < grid.length; j++) {
                if (grid[i][j - 1].equals("-")) {
                    break;
                }

                if (!isRow) {
                    if (!grid[j - 1][i].equals(grid[j][i])) {
                        break;
                    }
                } else {
                    if (!grid[i][j - 1].equals(grid[i][j])) {
                        break;
                    }
                }

                if (j == 3) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean isDiagonalEqual(String[][] grid) {
        for (int i = 2; i < grid.length; i++) {
            if (grid[i][i].equals("-") || grid[i - 1][i - 1] != grid[i][i]) {
                break;
            }

            if (i == 3) {
                return true;
            }
        }

        for (int i = 2; i < grid.length; i++) {
            if (grid[i - 1][grid.length - i + 1].equals("-") || grid[i - 1][grid.length - i + 1] != grid[i][grid.length - i]) {
                return false;
            }
        }

        return true;
    }

    public boolean isWinningMove(String[][] grid, int x, int y) {
        return isRowOrColumnEqual(grid, true) || isRowOrColumnEqual(grid, false) || isDiagonalEqual(grid);
    }

    public boolean isValid(int x, int y, String[][] grid) {
        return grid[x][y].equals("-");
    }

    public void displayGrid(String[][] grid) {
        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid.length; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }

}
