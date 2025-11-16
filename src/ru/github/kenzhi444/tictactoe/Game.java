package ru.github.kenzhi444.tictactoe;
import ru.github.kenzhi444.tictactoe.grid.Grid;
import ru.github.kenzhi444.tictactoe.leaderboard.FileLeaderBoard;
import ru.github.kenzhi444.tictactoe.player.Player;
import ru.github.kenzhi444.tictactoe.settings.Settings;
import java.util.*;

public class Game {
    private final Queue<Player> players;
    private final Grid grid;

    public Game(Settings setup) {
        players = new LinkedList<>(setup.getPlay());
        grid = new Grid(setup.getSizeGrid());
    }

    public void play(FileLeaderBoard board) {
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
                board.createStatistic(player);
                break;
            }

            if (countMove == countMax) {
                System.out.println("Ничья");
            }
        }
    }
}
