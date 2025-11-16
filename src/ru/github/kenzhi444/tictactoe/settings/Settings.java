package ru.github.kenzhi444.tictactoe.settings;

import ru.github.kenzhi444.tictactoe.player.Player;

import java.util.Queue;

public interface Settings {

    void createQueuePlayers();

    void createSizeGrid();

    Queue<Player> getPlay();

    int[] getSizeGrid();


}
