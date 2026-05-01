package oi.github.llFelipeGoncalves.ui;

public enum MenuOptions {
    CREATE(1),
    LIST(2),
    UPDATE(3),
    DELETE(4),
    EXIT(5),
    INVALID(-1);

    private final int value;

    MenuOptions(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static MenuOptions fromValue(int value) {
        for (MenuOptions option : values()) {
            if (option.value == value) {
                return option;
            }
        }
        return INVALID;
    }
}