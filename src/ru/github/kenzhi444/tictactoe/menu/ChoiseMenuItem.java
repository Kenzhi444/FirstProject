package ru.github.kenzhi444.tictactoe.menu;

public enum ChoiseMenuItem {

    START_GAME("Start Game", 1),
    OPTIONS("Options", 2),
    LEADERS_TABLE("Leaders Table", 3),
    EXIT("Exit", 4);

    private String title;
    private int item;

    ChoiseMenuItem(String title, int item) {
        this.title = title;
        this.item = item;
    }

    public String getTitle() {
        return title;
    }

    public int getItem() {
        return item;
    }
}
