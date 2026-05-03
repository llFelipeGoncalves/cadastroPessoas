package oi.github.llFelipeGoncalves.models;

public enum MenuOptions {

    SAVE(1),
    UPDATE(2),
    DELETE(3),
    FIND_BY_ID(4),
    FIND_ALL(5),
    EXIT(6),
    INVALID(-1);

    private final int value;

    MenuOptions(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static MenuOptions fromValue(int value) {
        for (MenuOptions option : MenuOptions.values()) {
            if (option.getValue() == value) {
                return option;
            }
        }
        return INVALID;
    }
}
