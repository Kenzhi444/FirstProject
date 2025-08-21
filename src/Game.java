import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Game {
    Set<Player> players = new HashSet<>();
    Grid grid = new Grid();
    HumanPlayer playerOne;
    HumanPlayer playerTwo;
    ComputerPlayer playerAI;
    Player currentPlayer;

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
        grid.start();
        grid.print();
        int countMove = 0;
        boolean victory = false;
        currentPlayer = playerOne;
        while (!victory && countMove != 9) {
            // Игрок №1 делает ход
            if (currentPlayer == playerOne) {
                int[] cords = playerOne.getCords();
                grid.setSymbol(cords[0], cords[1], 'X');
                victory = grid.isWinner(playerOne.getSymbol());
                countMove++;
                if (players.contains(playerTwo)) {
                    currentPlayer = playerTwo;
                } else if (players.contains(playerAI)){
                    currentPlayer = playerAI;
                }
                grid.print();
            } else if (players.contains(playerTwo) && currentPlayer == playerTwo) { // Если играем со вторым игроком
                int[] cords2 = playerTwo.getCords();
                grid.setSymbol(cords2[0], cords2[1], '0');
                victory = grid.isWinner(playerTwo.getSymbol());
                countMove++;
                currentPlayer = playerOne;
                grid.print();
            } else if (players.contains(playerAI) && currentPlayer == playerAI) { // Если играем с компьютером
                int[] cords3 = playerAI.getCords();
                grid.setSymbol(cords3[0], cords3[1], '0');
                victory = grid.isWinner(playerAI.getSymbol());
                countMove++;
                currentPlayer = playerOne;
                grid.print();
            }
            if (countMove == 9) {
                System.out.println("Ничья");
            }
            if (victory) {
                System.out.println("Победа игрока " + currentPlayer.getName());
            }
        }
    }
}
