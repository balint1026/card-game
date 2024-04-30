package com.balint.cardgame.view;

import com.balint.cardgame.model.Hand;
import com.balint.cardgame.model.card.Card;
import com.balint.cardgame.model.card.Deck;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.List;

public class HandView extends VBox {

    public Hand getHand() {
        return hand;
    }

    private final Hand hand;
    private final List<Card> clickedCards;


    public HandView(Hand hand) {
        this.hand = hand;
        this.clickedCards = new ArrayList<>();
        initialize();
    }

    private void initialize() {
        setSpacing(10);
        setAlignment(Pos.BOTTOM_CENTER);
        setPadding(new Insets(10));

        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.BOTTOM_CENTER);
        gridPane.setHgap(0);
        gridPane.setVgap(0);


        int col = 0;
        for (Card card : hand.getCards()) {
            CardView cardView = new CardView(card);
            gridPane.add(cardView, col, 0);
            col++;
            if (col == hand.getHandSize()) {
                col = 0;
            }
        }
        getChildren().add(gridPane);
    }

    public List<Card> getClickedCards(){
        for (Card card : hand.getCards()){
         if (card.isClicked()){
             clickedCards.add(card);
         }
        }
        return clickedCards;
    }

    public void emptyClickedCards() {
        for (Card card : hand.getCards()){
            card.setClicked(false);
        }
        clickedCards.clear();
    }
}

