package com.balint.cardgame.model;

import com.balint.cardgame.model.card.Card;

import java.util.ArrayList;
import java.util.List;

public class Hand {
    private List<Card> cards;
    private int handSize;

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    public int getHandSize() {
        return handSize;
    }

    public void setHandSize(int handSize) {
        this.handSize = handSize;
    }

    public Hand(List<Card> hand) {
        this.cards = hand;
        this.handSize = 5;
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    public void removeCard(Card card) {
        cards.remove(card);
    }

    public List<Card> getCards() {
        return cards;
    }
}

