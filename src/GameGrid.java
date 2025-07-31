public class GameGrid {

    private final int COLUMN = 3;
    private final int LINES = 3;

    public String[][] createGrid() {
        String[][] grig = new String[COLUMN][LINES];
        for (int i = 0; i < COLUMN; i++) {
            for (int j = 0; j < LINES; j++) {
                grig[i][j] = " ";
            }
        }
        return grig;
    }




}
