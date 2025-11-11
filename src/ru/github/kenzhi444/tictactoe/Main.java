package ru.github.kenzhi444.tictactoe;
import ru.github.kenzhi444.tictactoe.leaderboard.LeaderBoard;
import ru.github.kenzhi444.tictactoe.leaderboard.MemoryLeaderBoard;
import ru.github.kenzhi444.tictactoe.settings.Settings;
import ru.github.kenzhi444.tictactoe.settings.SettingsConsoleGame;


public class Main {
    public static void main(String[] args) {
        LeaderBoard board = new MemoryLeaderBoard();
        Settings setGame = new SettingsConsoleGame();
        Game game = new Game(setGame);
    }
}