public class Grid {

    private final int LINES = 4;
    private final int COLUMN = 4;
    char[][] grid = new char[LINES][COLUMN];

    private void print() {
        for (int i = 0; i < LINES; i++) {
            for (int j = 0; j < COLUMN; j++) {
                grid[LINES][COLUMN] = ' ';
            }
        }
        System.out.print("  ");
        for (int i = 0; i < COLUMN - 1; i++) {
            System.out.print("  " + (i + 1) + " ");
        }
        System.out.println();
        System.out.print("  +");
        for (int i = 0; i < LINES - 1; i++) {
            System.out.print("---+");
        }
        System.out.println();

        for (int i = 0; i < LINES - 1; i++) {
            System.out.print((i + 1) + " ");
            System.out.print("|");
            for (int j = 0; j < LINES - 1; j++) {
                System.out.print(" " + grid[i][j] + " |");
            }
            System.out.println();
            if (i < LINES - 2) {
                System.out.print("  +");
                for (int k = 0; k < LINES - 1; k++) {
                    System.out.print("---+");
                }
                System.out.println();
            }
        }
        System.out.print("  +");
        for (int k = 0; k < LINES - 1; k++) {
            System.out.print("---+");
        }
        System.out.println();
    }
    public void setSymbol(int x, int y, char symbol) {
        if (x < 1 || x > 3 || y < 1 || y > 3) {
            System.out.println("Координаты ячейки введены неверно, попробуйте еще раз");
        }
        if (grid[x][y] != ' ') {
            System.out.println("Ячейка занята, выберите другую!");
        } else {
            grid[x][y] = symbol;
        }
    }

    private boolean isWinner(char symbol) {
        boolean victory = false;
        int count = 0;
        for (int i = 1; i < 4; i++) {
            for (int j = 1; j < 4; j++) {
                if (grid[i][j] == symbol) {
                    count++;
                }
            }
            if (count == 3) {
                victory = true;
            }
        }
        return victory;
    }
}
