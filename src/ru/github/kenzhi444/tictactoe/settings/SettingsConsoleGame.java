package ru.github.kenzhi444.tictactoe.settings;


import ru.github.kenzhi444.tictactoe.player.ComputerPlayer;
import ru.github.kenzhi444.tictactoe.player.HumanPlayer;
import ru.github.kenzhi444.tictactoe.player.Player;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SettingsConsoleGame implements Settings {

    private final Queue<Player> play;
    private final Scanner console;
    private Player player;

    public SettingsConsoleGame() {
        play = new LinkedList<>();
        console = new Scanner(System.in);
        createQueuePlayers();
        createSizeGrid();
    }

    @Override
    public void createQueuePlayers() {
        boolean set = true;
        while (set) {
            System.out.println("Создать нового игрока (+) или выйти (-) ?");
            String result = console.nextLine();
            if (result.equals("+")) {
                System.out.println("Введите имя игрока");
                String name = console.nextLine();
                System.out.println("Введите символ игрока для игры");
                String symbol = console.nextLine();
                System.out.println("Введите тип игрока: П - Пользователь, К - компьютер");
                boolean typeSet = true;
                while (typeSet) {
                    String type = console.nextLine();
                    if (type.equals("П")) {
                        player = new HumanPlayer(name, symbol);
                        typeSet = false;
                    } else if (type.equals("К")) {
                        player = new ComputerPlayer(name, symbol);
                        typeSet = false;
                    } else {
                        System.out.println("Некорректно введен тип игрока. Введите (П) или (К)");
                    }
                }
                play.add(player);
            } else {
                set = false;
            }
        }

    }

    @Override
    public int[] createSizeGrid() {
        Scanner consoleGrid = new Scanner(System.in);
        System.out.println("Введите количество строк поля");
        int GORIZONT = consoleGrid.nextInt() + 1;
        System.out.println("Введите количество столбцов поля");
        int VERTICAL = consoleGrid.nextInt() + 1;
        return new int[]{GORIZONT, VERTICAL};
    }

    public Queue<Player> getPlay() {
        return new LinkedList<>(play);
    }

}
