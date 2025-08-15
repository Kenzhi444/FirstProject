import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Game {
    Set<Player> players = new HashSet<>();
    Grid grid = new Grid();

    public void play() {
        // Определяем первого игрока
        System.out.println("Введите имя первого игрока. Ваш символ для игры: X");
        Scanner scanner = new Scanner(System.in);
        String namePlayerOne = scanner.nextLine();
        HumanPlayer playerOne = new HumanPlayer(namePlayerOne, 'X');
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
            HumanPlayer playerTwo = new HumanPlayer(namePlayerTwo, '0');
            players.add(playerTwo);
        } else if (result.equals("N")) {
            ComputerPlayer playerAI = new ComputerPlayer("Компьютер", '0');
            players.add(playerAI);
        } else {
            System.out.println("Введите ответ заново. Y или N");
        }

        grid.print();


    }
}
