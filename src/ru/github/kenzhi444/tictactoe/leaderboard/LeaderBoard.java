package ru.github.kenzhi444.tictactoe.leaderboard;

import ru.github.kenzhi444.tictactoe.player.Player;

import java.util.Map;

public interface LeaderBoard {

    void statistic(Player player);

    void getStatistic();
}
