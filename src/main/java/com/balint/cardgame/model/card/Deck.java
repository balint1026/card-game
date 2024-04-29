package com.balint.cardgame.model.card;


import com.balint.cardgame.model.Hand;

import java.util.*;

public class Deck {

   private final Stack<Card> cards;

   private int numberOfCards;

   public Deck(Stack<Card> cards, int numberOfCards) {
      this.cards = cards;
      this.numberOfCards = numberOfCards;
   }

   public void generateDeck() {

      for (Suit suit : Suit.values()) {
         for (Rank rank : Rank.values()) {
            Card card = new Card(suit, rank);
            cards.push(card);
         }
      }
      Collections.shuffle(cards);

   }

   public List<Card> drawCards(int num) {
      List<Card> hand = new ArrayList<>();
      for (int i = 0; i < num; i++) {
         hand.add(drawCard());
      }
      return hand;
   }

   public Card drawCard() {
      if (!cards.isEmpty()) {
         return cards.pop();
      } else {
         System.out.println("The deck is empty!");
         return null;
      }
   }

   public Stack<Card> getCards() {
      return cards;
   }
}
