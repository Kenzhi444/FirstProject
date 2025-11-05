package ru.github.kenzhi444.tictactoe;
import ru.github.kenzhi444.tictactoe.grid.Grid;
import ru.github.kenzhi444.tictactoe.leaderboard.LeaderBoard;
import ru.github.kenzhi444.tictactoe.player.Player;
import ru.github.kenzhi444.tictactoe.player.PlayerSettings;

import java.util.*;

public class Game {
    private Queue<Player> players;
    private Grid grid;

    public Game(PlayerSettings setup) {
        players = new LinkedList<>(setup.getPlayers());
        grid = new Grid();
    }

    public void play(LeaderBoard board) {
        int countMove = 0;
        int countMax = grid.countMax();

        while (countMove != countMax) {
            grid.print();
            Player player = players.poll();
            boolean result = false;
            while (!result) {
                int[] cords = player.getCords();
                result = grid.setSymbol(cords[0], cords[1], player.getSymbol());
                ++countMove;
            }
            players.add(player);

            if (grid.isWinner(player.getSymbol())) {
                System.out.println("Победа игрока " + player.getName());
                board.statistic(player);
                break;
            }

            if (countMove == countMax) {
                System.out.println("Ничья");
            }
        }
    }
}
