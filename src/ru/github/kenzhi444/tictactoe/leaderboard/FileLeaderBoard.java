package ru.github.kenzhi444.tictactoe.leaderboard;

import ru.github.kenzhi444.tictactoe.player.Player;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class FileLeaderBoard implements LeaderBoard {
    private final Map<String, Long> tableFile;
    private final BufferedWriter writer;
    private final BufferedReader reader;

    public FileLeaderBoard() throws IOException {
        String leaderBoard = "Таблица лидеров.txt";
        tableFile = new HashMap<>();
        writer = new BufferedWriter(new FileWriter(leaderBoard));
        reader = new BufferedReader(new FileReader(leaderBoard));
    }

    @Override
    public void createStatistic(Player player) {
        tableFile.put(player.getName(), tableFile.getOrDefault(player.getName(), 0L) + 1);
        try {
            for (Map.Entry<String, Long> entry : tableFile.entrySet()) {
                writer.write(entry.getKey() + " : " + entry.getValue());
                writer.newLine();
            }
        } catch (IOException exp) {
            System.out.println("Ошибка записи данных в файл");
        }

    }

    public void readFileStatistic() {
        try {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            System.out.println("-----Конец файла-----");
        } catch (IOException e) {
            System.out.println("Ошибка чтения данных из файла");
        }
    }
}
