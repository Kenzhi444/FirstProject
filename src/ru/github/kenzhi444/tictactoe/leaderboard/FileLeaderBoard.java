package ru.github.kenzhi444.tictactoe.leaderboard;

import ru.github.kenzhi444.tictactoe.player.Player;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class FileLeaderBoard implements LeaderBoard {
    private final Map<String, Long> tableFile;
    private final BufferedWriter writer;

    public FileLeaderBoard() throws IOException {
        String leaderBoard = "Таблица лидеров.txt";
        tableFile = new HashMap<>();
        writer = new BufferedWriter(new FileWriter(leaderBoard));
    }

    @Override
    public void statistic(Player player) {
        tableFile.put(player.getName(), tableFile.getOrDefault(player.getName(), 0L) + 1);

    }

    @Override
    public void getStatistic() {
        try {
          for (Map.Entry<String, Long> entry : tableFile.entrySet()) {
              writer.write(entry.getKey() + " : " + entry.getValue());
              writer.newLine();
          }
        } catch (IOException exp) {
            System.out.println("Ошибка записи данных в файл");
        }
    }
}
