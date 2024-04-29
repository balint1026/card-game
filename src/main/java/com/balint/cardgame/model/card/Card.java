package com.balint.cardgame.model.card;

public class Card {
    private Suit suit;
    private Rank rank;

    public void setSuit(Suit suit) {
        this.suit = suit;
    }

    public void setValue(Rank rank) {
        this.rank = rank;
    }

    public Suit getSuit() {
        return suit;
    }

    public Rank getValue() {
        return rank;
    }

    @Override
    public String toString() {
        return rank +  " of " + suit;
    }

    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public String getName() {
        return rank + "_OF_" + suit;
    }
}
