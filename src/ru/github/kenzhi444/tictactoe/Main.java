package ru.github.kenzhi444.tictactoe;

import ru.github.kenzhi444.tictactoe.leaderboard.LeaderBoard;
import ru.github.kenzhi444.tictactoe.leaderboard.MemoryLeaderBoard;
import ru.github.kenzhi444.tictactoe.player.PlayerConsoleSettings;
import ru.github.kenzhi444.tictactoe.player.PlayerDefaultSettings;
import ru.github.kenzhi444.tictactoe.player.PlayerSettings;


public class Main {
    public static void main(String[] args) {
        LeaderBoard board = new MemoryLeaderBoard();
        PlayerSettings setupDefault = new PlayerConsoleSettings();
        setupDefault.settings();
        Game game = new Game(setupDefault);
        game.play(board);
        System.out.println("Таблица лидеров:");
        board.getStatistic();
    }
}