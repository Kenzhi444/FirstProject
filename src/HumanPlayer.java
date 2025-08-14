import java.util.Scanner;

public class HumanPlayer extends Player {

    public HumanPlayer(String name, char symbol) {
        super(name, symbol);
    }

    public int[] getCords() {
        Scanner console = new Scanner(System.in);
        int line = console.nextInt();
        int column = console.nextInt();
        int[] cords = new int[]{line, column};
        return cords;
    }
}
