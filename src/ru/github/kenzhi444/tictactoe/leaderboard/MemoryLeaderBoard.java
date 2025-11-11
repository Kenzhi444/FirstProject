package ru.github.kenzhi444.tictactoe.leaderboard;

import ru.github.kenzhi444.tictactoe.player.Player;

import java.util.HashMap;
import java.util.Map;

public class MemoryLeaderBoard implements LeaderBoard {
    private Map<String, Long> table;

    public MemoryLeaderBoard() {
        table = new HashMap<>();
    }

    @Override
    public void createStatistic(Player player) {
        table.put(player.getName(), table.getOrDefault(player.getName(), 0L) + 1);
    }

    public void printMapStatistic() {
        System.out.println(table);
    }
}
