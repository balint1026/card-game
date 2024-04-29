package com.balint.cardgame.view;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class CardView extends ImageView {

    private static final int CARD_WIDTH = 80; // Adjust as needed
    private static final int CARD_HEIGHT = 120; // Adjust as needed

    private static final Map<String, String> cardImageMap = new HashMap<>();

    static {
        cardImageMap.put("SEVEN_OF_ACORNS", "7_of_acorns.png");
        cardImageMap.put("EIGHT_OF_ACORNS", "8_of_acorns.png");
        cardImageMap.put("NINE_OF_ACORNS", "9_of_acorns.png");
        cardImageMap.put("TEN_OF_ACORNS", "10_of_acorns.png");
        cardImageMap.put("UPPER_OF_ACORNS", "upper_of_acorns.png");
        cardImageMap.put("LOWER_OF_ACORNS", "lower_of_acorns.png");
        cardImageMap.put("KING_OF_ACORNS", "king_of_acorns.png");
        cardImageMap.put("ACE_OF_ACORNS", "ace_of_acorns.png");

        cardImageMap.put("SEVEN_OF_BELLS", "7_of_bells.png");
        cardImageMap.put("EIGHT_OF_BELLS", "8_of_bells.png");
        cardImageMap.put("NINE_OF_BELLS", "9_of_bells.png");
        cardImageMap.put("TEN_OF_BELLS", "10_of_bells.png");
        cardImageMap.put("UPPER_OF_BELLS", "upper_of_bells.png");
        cardImageMap.put("LOWER_OF_BELLS", "lower_of_bells.png");
        cardImageMap.put("KING_OF_BELLS", "king_of_bells.png");
        cardImageMap.put("ACE_OF_BELLS", "ace_of_bells.png");

        cardImageMap.put("SEVEN_OF_HEARTS", "7_of_hearts.png");
        cardImageMap.put("EIGHT_OF_HEARTS", "8_of_hearts.png");
        cardImageMap.put("NINE_OF_HEARTS", "9_of_hearts.png");
        cardImageMap.put("TEN_OF_HEARTS", "10_of_hearts.png");
        cardImageMap.put("UPPER_OF_HEARTS", "upper_of_hearts.png");
        cardImageMap.put("LOWER_OF_HEARTS", "lower_of_hearts.png");
        cardImageMap.put("KING_OF_HEARTS", "king_of_hearts.png");
        cardImageMap.put("ACE_OF_HEARTS", "ace_of_hearts.png");

        cardImageMap.put("SEVEN_OF_LEAVES", "7_of_leaves.png");
        cardImageMap.put("EIGHT_OF_LEAVES", "8_of_leaves.png");
        cardImageMap.put("NINE_OF_LEAVES", "9_of_leaves.png");
        cardImageMap.put("TEN_OF_LEAVES", "10_of_leaves.png");
        cardImageMap.put("UPPER_OF_LEAVES", "upper_of_leaves.png");
        cardImageMap.put("LOWER_OF_LEAVES", "lower_of_leaves.png");
        cardImageMap.put("KING_OF_LEAVES", "king_of_leaves.png");
        cardImageMap.put("ACE_OF_LEAVES", "ace_of_leaves.png");
    }

    public CardView(String cardName) {
        super();
        String suit = cardName.split("_")[2];
        String imageName = cardImageMap.get(cardName);

        if (imageName != null) {
            String imagePath = System.getenv("resourcesPath") + suit.toLowerCase() + "/" + imageName;
            System.out.println("Constructed file path: " + imagePath);
            try {
                File file = new File(imagePath);
                if (file.exists()) {
                    setImage(new Image(new FileInputStream(file)));
                    setFitWidth(CARD_WIDTH);
                    setFitHeight(CARD_HEIGHT);
                } else {
                    System.err.println("Image file does not exist: " + imagePath);
                }
            } catch (FileNotFoundException e) {
                System.err.println("Failed to load image: " + e.getMessage());
            }
        } else {
            System.err.println("Image name not found: " + cardName);
        }
    }
}

