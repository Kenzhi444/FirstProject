package ru.github.kenzhi444.tictactoe.player;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class PlayerConsoleSettings implements PlayerSettings {

    private Queue<Player> play;
    private Scanner console;
    private Player player;

    public PlayerConsoleSettings() {
        play = new LinkedList<>();
        console = new Scanner(System.in);
    }

    public void settings() {
        boolean set = true;
        while (set) {
            System.out.println("Создать нового игрока (+) или выйти (-) ?");
            String result = console.nextLine();
            if (result.equals("+")) {
                set = true;
                System.out.println("Введите имя игрока");
                String name = console.nextLine();
                System.out.println("Введите символ игрока для игры");
                String symbol = console.nextLine();
                System.out.println("Введите тип игрока: П - Пользователь, К - компьютер");
                String type = console.nextLine();
                if (type.equals("П")) {
                    player = new HumanPlayer(name, symbol);
                } else if (type.equals("К")) {
                    player = new ComputerPlayer(name, symbol);
                } else {
                    System.out.println("Ввод некорректен, введите П или К");
                }
                play.add(player);
            } else {
                set = false;
                break;
            }
        }
    }
    public Queue<Player> getPlayers() {
        return new LinkedList<>(play);
    }
}
