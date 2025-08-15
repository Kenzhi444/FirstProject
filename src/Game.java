import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Game {
    Set<Player> players = new HashSet<>();
    Grid grid = new Grid();
    HumanPlayer playerOne;
    HumanPlayer playerTwo;
    ComputerPlayer playerAI;

    public void play() {
        // Определяем первого игрока
        System.out.println("Введите имя первого игрока. Ваш символ для игры: X");
        Scanner scanner = new Scanner(System.in);
        String namePlayerOne = scanner.nextLine();
        playerOne = new HumanPlayer(namePlayerOne, 'X');
        players.add(playerOne);
        // Играем со вторым игроком или с компьютером
        System.out.println("Чтобы добавить второго игрока нажмите Y");
        System.out.println("Чтобы играть с компьютером нажмите N");
        Scanner scanner1 = new Scanner(System.in);
        String result = scanner1.nextLine();
        if (result.equals("Y")) {
            System.out.println("Введите имя второго игрока. Ваш символ для игры: 0");
            Scanner scanner2 = new Scanner(System.in);
            String namePlayerTwo = scanner2.nextLine();
            playerTwo = new HumanPlayer(namePlayerTwo, '0');
            players.add(playerTwo);
        } else if (result.equals("N")) {
            ComputerPlayer playerAI = new ComputerPlayer("Компьютер", '0');
            players.add(playerAI);
        } else {
            System.out.println("Введите ответ заново. Y или N");
        }
        // Рисуем поле
        grid.print();
        int countMove = 0;
        boolean victory = false;
        while (!victory && countMove != 9) {
            // Игрок №1 делает ход
            int[] cords = playerOne.getCords();
            grid.setSymbol(cords[0], cords[1], 'X');
            grid.isWinner(playerOne.getSymbol());
            countMove++;
            grid.print();
            if (players.contains(playerTwo)) { // Если играем со вторым игроком
                int[] cords2 = playerTwo.getCords();
                grid.setSymbol(cords2[0], cords2[1], '0');
                grid.isWinner(playerTwo.getSymbol());
                countMove++;
                grid.print();
            } else { // Если играем с компьютером
                int[] cords3 = playerAI.getCords();
                grid.setSymbol(cords3[0], cords3[1], '0');
                grid.isWinner(playerAI.getSymbol());
                countMove++;
                grid.print();
            }
            if (countMove == 9) {
                System.out.println("Ничья");
            }
        }
    }
}
