package ru.github.kenzhi444.tictactoe.settings;

import ru.github.kenzhi444.tictactoe.player.HumanPlayer;
import ru.github.kenzhi444.tictactoe.player.Player;

import java.util.LinkedList;
import java.util.Queue;

public class SettingsDefaultGame  implements Settings {

    private final Queue<Player> playDefault;

    public SettingsDefaultGame() {
        playDefault = new LinkedList<>();
        createQueuePlayers();
        createSizeGrid();
    }

    @Override
    public void createQueuePlayers() {
        Player playerOne = new HumanPlayer("Стас", "Х");
        Player playerTwo = new HumanPlayer("Вася", "О");
        playDefault.add(playerOne);
        playDefault.add(playerTwo);
    }

    @Override
    public int[] createSizeGrid() {
        int GORIZONTAL = 4;
        int VERTICAL = 4;
        return new int[]{GORIZONTAL, VERTICAL};
    }


    public Queue<Player> getPlay() {
        return new LinkedList<>(playDefault);
    }

}
