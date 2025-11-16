package ru.github.kenzhi444.tictactoe;
import ru.github.kenzhi444.tictactoe.leaderboard.FileLeaderBoard;
import ru.github.kenzhi444.tictactoe.menu.Menu;
import ru.github.kenzhi444.tictactoe.settings.Settings;
import ru.github.kenzhi444.tictactoe.settings.SettingsConsoleGame;

import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException {
        FileLeaderBoard board = new FileLeaderBoard();
        Menu menu = new Menu(board);
    }
}