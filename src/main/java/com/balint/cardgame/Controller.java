package com.balint.cardgame;

import com.balint.cardgame.model.Hand;
import com.balint.cardgame.model.card.Deck;
import com.balint.cardgame.view.DeckView;
import com.balint.cardgame.view.HandView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;

import java.util.Stack;

public class Controller {
    @FXML
    private BorderPane rootPane;

    @FXML
    private ImageView cardImageView;
    private Deck deck;

    public void initialize() {
        deck = new Deck(new Stack<>(), 32);
        deck.generateDeck();
        Hand hand = new Hand(deck.drawCards(5));
        DeckView deckView = new DeckView(deck);
        HandView handView = new HandView(hand);

        rootPane.setCenter(handView);
    }

    public void shuffleDeck(ActionEvent actionEvent) {
        deck = new Deck(new Stack<>(), 32);
        deck.generateDeck();
        Hand hand = new Hand(deck.drawCards(5));
        HandView handView = new HandView(hand);
        rootPane.setCenter(handView);
    }
}
