package ru.github.kenzhi444.tictactoe.settings;

import ru.github.kenzhi444.tictactoe.player.Player;

import java.util.Queue;

public interface Settings {

    void createQueuePlayers();

    int[] createSizeGrid();

    Queue<Player> getPlay();


}
