package com.mycompany.lab04_francesco;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputControl;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class App extends Application {
    boolean carTracker = false;
    
    @Override
    public void start(Stage stage) {
        Button calcButton = new Button("Calculate Reimbursment");
        GridPane gridPane = new GridPane();
         
        String[] labels = {"Trip Days: ", "Airfare Fees: ", "Miles Driven: ", "Lodging Fees: "};
        TextInputControl[] fields = {
            new TextField(),   
            new TextField(),  
            new TextField(), 
            new TextField(), 
        };
        
        for (int i = 0; i < labels.length; i++) {
            gridPane.add(new Label(labels[i]), 0, i);
            gridPane.add(fields[i], 1, i);
           
            fields[i].textProperty().addListener((observable, oldValue, newValue) -> {
                updateRegisterButtonState(fields, calcButton);
            });
           
        }
        
        Button carBoolean = new Button("Was a Private Car Used?");
        Label carLabel = new Label("No");
        
        carBoolean.setOnAction(event -> {
            if (carTracker == false) {
                carLabel.setText("Yes");
                carTracker = true;
            } else {
                carLabel.setText("No");
                carTracker = false;
            }
            
            
        });
       
        gridPane.add(carBoolean, 0, 5);
        gridPane.add(carLabel, 1, 5);
        gridPane.add(calcButton, 0, 8);
        calcButton.setDisable(true);
        
        Scene scene = new Scene(gridPane, 640, 480);
        scene.getStylesheets().add("styles.css");
        stage.setScene(scene);
        stage.show();
    }
    
    /**
     * Placeholder
     * @param fields Placeholder
     * @param registerBtn  Placeholder
     */
    private void updateRegisterButtonState(TextInputControl[] fields, Button calcButton) {
        for (TextInputControl field : fields) {
            if (field.getText() == null || field.getText().trim().isEmpty()) {
                calcButton.setDisable(true);
                return;
            }
        }
        calcButton.setDisable(false);
    }

    public static void main(String[] args) {
        launch();
    }

}