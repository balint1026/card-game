package com.balint.cardgame.logic;

import com.balint.cardgame.model.Hand;
import com.balint.cardgame.model.card.Card;
import com.balint.cardgame.model.card.Deck;
import com.balint.cardgame.view.HandView;
import com.balint.cardgame.view.Scoreboard;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;

import java.util.List;
import java.util.Stack;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class Controller {
    @FXML
    private BorderPane rootPane;

    @FXML
    private ImageView cardImageView;

    private Deck deck;
    private HandView handView;

    @FXML
    private Scoreboard scoreboard;





    public void initialize() {
        deck = new Deck(new Stack<>(), 32);
        deck.generateDeck();
        Hand hand = new Hand(deck.drawCards(5));
        handView = new HandView(hand);
        rootPane.setCenter(handView);

        scoreboard = new Scoreboard();
        rootPane.setRight(scoreboard);
    }

    public void shuffleDeck(ActionEvent actionEvent) {
        initialize();
    }


    @FXML
    public void handlePlayCardsButton(ActionEvent event) {
         List<Card> clickedCards = handView.getClickedCards();
         playCards(clickedCards);
         deck.drawCards(clickedCards.size());
         System.out.println("Clicked Cards: " + clickedCards);
         handView.emptyClickedCards();

        System.out.println(scoreboard.getScoreToBeat());

         showPopup();
         refreshHandView();
    }



    private void playCards(List<Card> clickedCards) {
        List<Card> newHand = handView.getHand().getCards();
        Hand hand = handView.getHand();
        updateScore(hand.getScore());
        for (Card card : clickedCards){
        hand.removeCard(card);
        newHand.add(deck.drawCard());
        }
       hand.setCards(newHand);
    }

    private void updateScore(int scoredPoints) {
        scoreboard.updateCurrentScore(scoredPoints);
    }

    private void refreshHandView() {
        Hand newHand = handView.getHand();
        rootPane.setCenter(null);
        HandView updatedHandView = new HandView(newHand);
        rootPane.setCenter(updatedHandView);
    }

    public void showPopup() {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setHeaderText(null);

        if (scoreboard.getCurrentScore() == scoreboard.getScoreToBeat()) {
            alert.setContentText("Congratulations! You win!");
        } else if (scoreboard.getCurrentScore() > scoreboard.getScoreToBeat()) {
            alert.setContentText("Sorry, you lose.");
        } else {
            return;
        }

        alert.showAndWait();
    }
}
