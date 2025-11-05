package ru.github.kenzhi444.tictactoe.player;

import java.util.LinkedList;
import java.util.Queue;

public class PlayerDefaultSettings implements PlayerSettings {

    private Queue<Player> playDefault;

    public PlayerDefaultSettings() {
        playDefault = new LinkedList<>();
    }

    @Override
    public void settings() {
        Player playerOne = new HumanPlayer("Стас", "Х");
        Player playerTwo = new HumanPlayer("Вася", "О");
       playDefault.add(playerOne);
       playDefault.add(playerTwo);
    }

    @Override
    public Queue<Player> getPlayers() {
        return new LinkedList<>(playDefault);
    }
}
