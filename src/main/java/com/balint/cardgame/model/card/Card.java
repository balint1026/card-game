package com.balint.cardgame.model.card;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;

public class Card {
    private Suit suit;
    private Rank rank;

    private final BooleanProperty clicked = new SimpleBooleanProperty(false);

    public Rank getRank() {
        return rank;
    }

    public void setRank(Rank rank) {
        this.rank = rank;
    }

    public boolean isClicked() {
        return clicked.get();
    }
    public BooleanProperty clickedProperty() {
        return clicked;
    }

    public void setClicked(boolean isClicked) {
        clicked.set(isClicked);
    }

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
