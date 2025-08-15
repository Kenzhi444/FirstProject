import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;

public class HumanPlayer extends Player {

    public HumanPlayer(String name, char symbol) {
        super(name, symbol);
    }

    public int[] getCords() {
        Scanner console = new Scanner(System.in);
        System.out.println("Укажите номер линии");
        int line = console.nextInt();
        System.out.println("Укажите номер столбца");
        int column = console.nextInt();
        int[] cords = new int[]{line, column};
        return cords;
    }
}
