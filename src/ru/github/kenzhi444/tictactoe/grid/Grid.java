package ru.github.kenzhi444.tictactoe.grid;


import ru.github.kenzhi444.tictactoe.settings.Settings;

import java.util.Objects;

public class Grid {
    private final String[][] grid;
    private final int LINES;
    private final int COLUMN;

    public Grid(int[] strings) {
        LINES = strings[0];
        COLUMN = strings[1];
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
        if (!Objects.equals(grid[x][y], " ")) {
            System.out.println("Ячейка занята, выберите другую!");
            return false;
        } else {
            grid[x][y]  = symbol;
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
                    if (count == LINES - 1) {
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
                    if (count == LINES - 1) {
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
                    if (countDiag == LINES - 1) {
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
                    if (countDiag == LINES - 1) {
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
    public int countMax () {
        int result = (LINES - 1) * (COLUMN - 1);
        return result;
    }
}
