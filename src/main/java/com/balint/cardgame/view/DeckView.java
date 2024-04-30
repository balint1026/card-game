package com.balint.cardgame.view;

import com.balint.cardgame.model.Hand;
import com.balint.cardgame.model.card.Card;
import com.balint.cardgame.model.card.Deck;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class DeckView extends VBox {

    private final Deck deck;

    public DeckView(Deck deck) {
        this.deck = deck;
        initialize();
    }

    private void initialize() {
        setSpacing(10);
        setAlignment(Pos.CENTER);
        setPadding(new Insets(10));

        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        int row = 0;
        int col = 0;
        for (Card card : deck.getCards()) {
            CardView cardView = new CardView(card);
            gridPane.add(cardView, col, row);
            col++;
            if (col == 4) {
                col = 0;
                row++;
            }
        }

        getChildren().add(gridPane);
    }
}
