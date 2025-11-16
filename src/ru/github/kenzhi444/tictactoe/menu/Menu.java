package ru.github.kenzhi444.tictactoe.menu;

import ru.github.kenzhi444.tictactoe.Game;
import ru.github.kenzhi444.tictactoe.leaderboard.FileLeaderBoard;
import ru.github.kenzhi444.tictactoe.settings.Settings;
import ru.github.kenzhi444.tictactoe.settings.SettingsConsoleGame;
import ru.github.kenzhi444.tictactoe.settings.SettingsDefaultGame;
import java.util.Scanner;

public class Menu {
    private Settings settings;
    private Scanner consoleMenu;
    boolean defaultSettings;

    public Menu(FileLeaderBoard board) {
        consoleMenu = new Scanner(System.in);
        defaultSettings = true;
        display(board);
    }

    public void display(FileLeaderBoard board) {
        System.out.println("Введите номер пункта меню");
        System.out.println("1)" + ChoiseMenuItem.START_GAME.getTitle());
        System.out.println("2)" + ChoiseMenuItem.OPTIONS.getTitle());
        System.out.println("3)" + ChoiseMenuItem.LEADERS_TABLE.getTitle());
        System.out.println("4)" + ChoiseMenuItem.EXIT.getTitle());
        int choice = consoleMenu.nextInt();
        while (choice != 4) {
            if (choice == 1) {
                if (defaultSettings) {
                    settings = new SettingsDefaultGame();
                }
                Game game = new Game(settings);
                game.play(board);
                break;
            } else if (choice == 2) {
                defaultSettings = false;
                settings = new SettingsConsoleGame();
                settings.createQueuePlayers();
                settings.createSizeGrid();
                System.out.println("Настройка игры завершена");
                display(board);
            } else if (choice == 3) {
                board.readFileStatistic();
                display(board);
            }
        }
    }
}
