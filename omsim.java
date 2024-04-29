import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.Random;

public class omsim extends Application {

    // Generate a random number between 1 and 100
    private static final int SECRET_NUMBER = new Random().nextInt(50) + 1;

    @Override
    public void start(Stage stage) {
        // create and configure a text field for user entry
        TextField guessTextField = new TextField();
        guessTextField.setMaxWidth(250);

        // create and configure a label to display feedback
        Label feedbackLabel = new Label();
        feedbackLabel.setTextFill(Color.RED);
        feedbackLabel.setFont(Font.font("Arial", 10));

        // create and configure a button to check the user's guess
        Button checkButton = new Button("Check Guess");
        checkButton.setOnAction(e -> {
            try {
                int guess = Integer.parseInt(guessTextField.getText());
                if (guess < 1 || guess > 50) {
                    feedbackLabel.setText("Please enter a number between 1 and 50.");
                } else if (guess < SECRET_NUMBER) {
                    feedbackLabel.setText("Too low! Try a higher number.");
                } else if (guess > SECRET_NUMBER) {
                    feedbackLabel.setText("Too high! Try a lower number.");
                } else {
                    feedbackLabel.setText("Correct! The secret number is: " + SECRET_NUMBER);
                }
                     
            } catch (NumberFormatException ex) {
                feedbackLabel.setText("Please enter a valid number.");
            }
        });

        // create and configure a VBox to hold our components
        VBox root = new VBox();
        root.setSpacing(10);
        root.setAlignment(Pos.CENTER);

        // add the components to the VBox
        root.getChildren().addAll(guessTextField, checkButton, feedbackLabel);

        // create a new scene
        Scene scene = new Scene(root, 300, 250);

        // add the scene to the stage, then configure the stage and make it visible
        stage.setScene(scene);
        stage.setTitle("Number Guessing Game");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
