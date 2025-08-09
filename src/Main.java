import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        int playerOne = 1;
        int playerTwo = 2;
        int currentPlayer = playerOne;

        char[][] gameGrid = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                gameGrid[i][j] = ' ';
            }
        }
        boolean victory = false;
        while (!victory) {
            // Рисуем поле
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    System.out.print("| " + gameGrid[i][j] + " |");
                }
                System.out.println();
                for (int j = 0; j < 3; j++) {
                    System.out.print("-----");
                }
                System.out.println();
            }
            // Считываем координаты ячейки с консоли
            Scanner console = new Scanner(System.in);
            System.out.println("Введите координаты ячейки");
            int line = console.nextInt();
            int column = console.nextInt();
            boolean validCell = gameGrid[line][column] == ' ';
            // Если ячейка пуста
            if (validCell) {
                // Если игрок №1
                if (currentPlayer == playerOne) {
                    gameGrid[line][column] = 'X';
                    if (gameGrid[line + 1][column] == 'X' && gameGrid[line - 1][column] == 'X') {
                        victory = true;
                        System.out.println("Победа игрока №1!");
                    } else if (gameGrid[line][column + 1] == 'X' && gameGrid[line][column - 1] == 'X') {
                        victory = true;
                        System.out.println("Победа игрока №1!");
                    }
                    // Смена игрока
                    currentPlayer = playerTwo;
                }
                // Если игрок №2
                else {
                    gameGrid[line][column] = '0';
                    if (gameGrid[line + 1][column] == '0' && gameGrid[line - 1][column] == '0') {
                        victory = true;
                        System.out.println("Победа игрока №2!");
                    } else if (gameGrid[line][column + 1] == '0' && gameGrid[line][column - 1] == '0') {
                        victory = true;
                        System.out.println("Победа игрока №2!");
                    }
                    // Смена игрока
                    currentPlayer = playerOne;
                }
            }
            // Если ячейка не пуста
            else {
                    System.out.println("Ячейка занята, выберите другую!");
            }
            // Проверка на ничью
            int count = 0;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (gameGrid[i][j] == ' ') {
                        count++;
                    }
                }
            }
            if (count == 0) {
                System.out.println("Ничья!");
            }
        }
    }
}