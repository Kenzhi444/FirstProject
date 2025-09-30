package ru.github.kenzhi444.tictactoe;

import java.util.Arrays;

public class Grid {

    protected final int LINES = 4;
    protected final int COLUMN = 4;
    String[][] grid;

    public Grid() {
        grid = new String[LINES][COLUMN];
        for (int i = 0; i < LINES; i++) {
            for (int j = 0; j < COLUMN; j++) {
                grid[i][j] = " ";
            }
        }
    }

    public void print() {
        for (int i = 1; i < LINES; i++) {
                grid[0][i] = String.valueOf(i);
        }
        for (int i = 1; i < LINES; i++) {
                grid[i][0] = String.valueOf(i);
        }
        for (int i = 0; i <LINES; i++) {
            for (int j = 0; j <COLUMN; j++) {
                System.out.print(grid[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    public boolean setSymbol(int x, int y, String symbol) {
        if (x < 1 || x > LINES - 1 || y < 1 || y > LINES - 1) {
            System.out.println("Координаты ячейки введены неверно, попробуйте еще раз");
            return false;
        }
        if (grid[x][y] != " ") {
            System.out.println("Ячейка занята, выберите другую!");
            return false;
        } else {
            grid[x][y] = symbol;
            return true;
        }
    }

    public boolean isWinner(String symbol) {
        int count = 0;
        int countDiag = 0;
        for (int i = 1; i < LINES;) {
            for (int j = 1; j < COLUMN; j++) {
                if (grid[i][j].equals(symbol)) {
                    ++count;
                    if (count == 3) {
                        return true;
                    }
                }
            }
            count = 0;
            i++;
        }
        for (int i = 1; i < COLUMN;) {
            for (int j = 1; j < LINES; j++) {
                if (grid[j][i].equals(symbol)) {
                    ++count;
                    if (count == 3) {
                        return true;
                    }
                }
            }
                count = 0;
            i++;
        }
        for (int i = 1; i < LINES;) {
            for (int j = 1; j < COLUMN;) {
                if (grid[i][j].equals(symbol)) {
                    ++countDiag;
                    if (countDiag == 3) {
                        return true;
                    }
                }
                i++;
                j++;
            }
            countDiag = 0;
        }

        for (int i = LINES - 1; i > 0;) {
            for (int j = 1; j < COLUMN;) {
                if (grid[i][j].equals(symbol)) {
                    ++countDiag;
                    if (countDiag == 3) {
                        return true;
                    }
                }
                i--;
                j++;
            }
            countDiag = 0;
        }
        return false;
    }
}
