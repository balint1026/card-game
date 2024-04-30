package com.balint.cardgame.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

import java.util.Random;

public class Scoreboard extends GridPane {


    private int scoreToBeat;
    private int currentScore;

    private Label scoreToBeatLabel;
    private Label currentScoreLabel;
    private Text scoreToBeatText;
    private Text currentScoreText;


    private Text scoringInfoText;

    public Scoreboard() {
        super();
        this.getStyleClass().add("scoreboard");
        generateScoreToBeat();

        scoreToBeatLabel = new Label("Score to Beat: ");
        scoreToBeatText = new Text(String.valueOf(scoreToBeat));
        currentScoreLabel = new Label("Current Score: ");
        currentScoreText = new Text("0");

        scoringInfoText = new Text("Scoring:\nLower: 11,\nUpper: 12,\nKing: 13,\nAce: 14");
        add(scoringInfoText, 0, 4);

        scoringInfoText.getStyleClass().add("scoring-info");

        add(scoreToBeatLabel, 0, 0);
        add(scoreToBeatText, 1, 0);
        add(currentScoreLabel, 0, 1);
        add(currentScoreText, 1, 1);

        scoreToBeatLabel.getStyleClass().add("score-label");
        scoreToBeatText.getStyleClass().add("score-text");
        currentScoreLabel.getStyleClass().add("score-label");
        currentScoreText.getStyleClass().add("score-value");
    }

    public void updateCurrentScore(int scoredPoints) {
        int updatedScore = getCurrentScore() + scoredPoints;
        currentScoreText.setText(String.valueOf(updatedScore));
        setCurrentScore(updatedScore);
    }


    public int getScoreToBeat() {
        return scoreToBeat;
    }

    public int getCurrentScore() {
        return currentScore;
    }

    public void setCurrentScore(int currentScore) {
        this.currentScore = currentScore;
    }





        public void incrementScore(int num){
        currentScore += num;
    }

    public void clearScore(){
        currentScore = 0;
    }

    public void setScoreToBeat(int num){
        this.scoreToBeat = num;
    }


    private void generateScoreToBeat(){
        Random random = new Random();
        int score = random.nextInt(50, 100);
        this.setScoreToBeat(score);
    }

    public Text getScoreToBeatText() {
        return scoreToBeatText;
    }

    public void setScoreToBeatText(Text scoreToBeatText) {
        this.scoreToBeatText = scoreToBeatText;
    }

    public Text getCurrentScoreText() {
        return currentScoreText;
    }

    public void setCurrentScoreText(Text currentScoreText) {
        this.currentScoreText = currentScoreText;
    }

}
