import java.util.Random;

public class ComputerPlayer extends Player {

    public ComputerPlayer(String name, char symbol) {
        super(name, symbol);
    }

    public int[] getCords() {
        Random random = new Random();
        int randomLine = 1 + (random.nextInt(3));
        int randomColumn = 1 + (random.nextInt(3));
        int[] cords = new int[]{randomLine, randomColumn};
        return cords;
    }
}
