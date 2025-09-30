package ru.github.kenzhi444.tictactoe;

import ru.github.kenzhi444.tictactoe.player.ComputerPlayer;
import ru.github.kenzhi444.tictactoe.player.HumanPlayer;
import ru.github.kenzhi444.tictactoe.player.Player;

import java.util.*;

public class Game {

    private Queue<Player> players;
    private Grid grid;

    public Game() {
        Player human = new HumanPlayer("Stas", "x");
        Player computer = new ComputerPlayer("Computer", "0");
        players = new LinkedList<>();
        players.add(human);
        players.add(computer);
        grid = new Grid();
    }

    public void play() {
        int countMove = 0;
        int countMax = (grid.LINES - 1) * (grid.COLUMN - 1);

        while (countMove != countMax) {
            grid.print();
            Player player = players.peek();
            int[] cords = player.getCords();
            boolean result = grid.setSymbol(cords[0], cords[1], player.getSymbol());
            if (result) {
                if (grid.isWinner(player.getSymbol())) {
                    System.out.println("Победа игрока " + player.getName());
                    break;
                }
                players.remove();
                ++countMove;
            }
            players.add(player);
            if (countMove == countMax) {
                System.out.println("Ничья");
            }
        }
    }
}
