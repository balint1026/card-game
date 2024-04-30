module com.balint.cardgame {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.balint.cardgame to javafx.fxml;
    exports com.balint.cardgame;
    exports com.balint.cardgame.view;
    opens com.balint.cardgame.view to javafx.fxml;
    exports com.balint.cardgame.logic;
    opens com.balint.cardgame.logic to javafx.fxml;
}
