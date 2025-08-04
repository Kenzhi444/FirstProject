import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        char[][] gameGrid = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                gameGrid[i][j] = ' ';
            }
        }
        boolean victory = false;
        while (!victory) {
            Scanner console = new Scanner(System.in);
            int line = console.nextInt();
            int column = console.nextInt();
            boolean validCell;
            if (gameGrid[line][column] == ' ') {
                validCell = true;
            } else {
                validCell = false;
            }
            if (validCell) {
                gameGrid[line][column] = 'X';
                if (gameGrid[line + 1][column] == 'X' && gameGrid[line - 1][column] == 'X') {
                    victory = true;
                    System.out.println("Победа!!!");
                } else if (gameGrid[line][column + 1] == 'X' && gameGrid[line][column - 1] == 'X') {
                    victory = true;
                    System.out.println("Победа!!!");
                }
            } else {
                System.out.println("Ячейка занята, выберите другую!");
            }
            // Проверка на ничью
            int count = 0;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (gameGrid[i][j] == ' ') {
                        count++;
                        break;
                    }
                }
                System.out.println("Ничья!!!");
            }
        }
    }
}