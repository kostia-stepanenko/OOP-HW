package org.kostia.hw3;

public enum Suit {
    CLUBS('\u2663'),
    DIAMONDS('\u2666'),
    SPADES('\u2660'),
    HEARTS('\u2665');

    private final char displayName;

    Suit(char displayName) {
        this.displayName = displayName;
    }

    @Override
    public String toString() {
        return String.valueOf(displayName);
    }
}
