import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Calculator extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Create text fields for user input
        TextField numField1 = new TextField();
        TextField numField2 = new TextField();

        // Create label for result
        Label resultLabel = new Label("Result:");

        // Create buttons for arithmetic operations
        Button addButton = new Button("+");
        Button subButton = new Button("-");
        Button mulButton = new Button("*");
        Button divButton = new Button("/");

        // Set button actions
        addButton.setOnAction(e -> calculateResult(numField1, numField2, resultLabel, "+"));
        subButton.setOnAction(e -> calculateResult(numField1, numField2, resultLabel, "-"));
        mulButton.setOnAction(e -> calculateResult(numField1, numField2, resultLabel, "*"));
        divButton.setOnAction(e -> calculateResult(numField1, numField2, resultLabel, "/"));

        // Create layout grid
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(20));

        // Add components to grid
        gridPane.add(new Label("Number 1:"), 0, 0);
        gridPane.add(numField1, 1, 0);
        gridPane.add(new Label("Number 2:"), 0, 1);
        gridPane.add(numField2, 1, 1);
        gridPane.add(addButton, 0, 2);
        gridPane.add(subButton, 1, 2);
        gridPane.add(mulButton, 0, 3);
        gridPane.add(divButton, 1, 3);
        gridPane.add(resultLabel, 0, 4, 2, 1);

        // Create scene and set it on stage
        Scene scene = new Scene(gridPane, 300, 250);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Calculator");
        primaryStage.show();
    }

    // Method to perform arithmetic operation and display result
    private void calculateResult(TextField numField1, TextField numField2, Label resultLabel, String operation) {
        try {
            double num1 = Double.parseDouble(numField1.getText());
            double num2 = Double.parseDouble(numField2.getText());
            double result = 0;

            switch (operation) {
                case "+":
                    result = num1 + num2;
                    break;
                case "-":
                    result = num1 - num2;
                    break;
                case "*":
                    result = num1 * num2;
                    break;
                case "/":
                    if (num2 != 0) {
                        result = num1 / num2;
                    } else {
                        resultLabel.setText("Cannot divide by zero");
                        return;
                    }
                    break;
            }

            resultLabel.setText("Result: " + result);

        } catch (NumberFormatException e) {
            resultLabel.setText("Invalid input");
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
