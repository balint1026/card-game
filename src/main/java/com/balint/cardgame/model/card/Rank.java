package com.balint.cardgame.model.card;

public enum Rank {
    SEVEN(7),
    EIGHT(8),
    NINE(9),
    TEN(10),
    LOWER(11),
    UPPER(12),
    KING(13),
    ACE(14);

    private final int score;

    Rank(int score) {
        this.score = score;
    }

    public int getScore() {
        return score;
    }
}
