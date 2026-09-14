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
         
        String[] labels = {"Trip Days: ", "Airfare Fees: ", "Miles Driven: ", "Lodging Fees: ", "Rental Fees: ", "Taxi Charges:", "Parking Fees: ", "Allowed Fees: "};
        TextInputControl[] fields = {
            new TextField(),   
            new TextField(),  
            new TextField(), 
            new TextField(), 
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
        Label reimbursement = new Label("0");
        Label totalText = new Label("Total expenses of trip:");
        Label totalNum = new Label("0");
        Label excessText = new Label("Total excess:");
        Label excessNum = new Label("0");
        Label savedText = new Label("Total saved:");
        Label savedNum = new Label("0");
        
        fields[4].setDisable(false);
        fields[5].setDisable(false);
        fields[6].setDisable(true);
        
        carBoolean.setOnAction(event -> {
            if (carTracker == false) {
                carLabel.setText("Yes");
                carTracker = true;
                fields[4].setDisable(true);
                fields[5].setDisable(true);
                fields[6].setDisable(false);
            } else {
                carLabel.setText("No");
                carTracker = false;
                fields[4].setDisable(false);
                fields[5].setDisable(false);
                fields[6].setDisable(true);
            }
            
        });
        
        calcButton.setOnAction(event -> {
            int tripDays = Integer.parseInt(fields[0].getText().trim());
            double airfareFees = Double.parseDouble(fields[1].getText().trim());
            double milesDriven = Double.parseDouble(fields[2].getText().trim());
            double lodgingFees = Double.parseDouble(fields[3].getText().trim());
            double rentalFees = Double.parseDouble(fields[4].getText().trim());
            double taxiCharges = Double.parseDouble(fields[5].getText().trim());
            double parkingFees = Double.parseDouble(fields[6].getText().trim());
            double allowedFees = Double.parseDouble(fields[7].getText().trim());
            
            if (carTracker == false) {
               reimbursement.setText(String.valueOf(Reimbursment.calcReimbursement(tripDays, milesDriven, carTracker, 0.0 ,taxiCharges, lodgingFees)));
               totalNum.setText(String.valueOf(airfareFees + lodgingFees + taxiCharges));
               
               if ((airfareFees + lodgingFees + taxiCharges) > allowedFees) {
                   excessNum.setText(String.valueOf((airfareFees + lodgingFees + taxiCharges) - allowedFees));
                   savedNum.setText("0");
                   
               } else {
                   savedNum.setText(String.valueOf( allowedFees - (airfareFees + lodgingFees + taxiCharges)));
                   excessNum.setText("0");
               }
              
            } else {
               reimbursement.setText(String.valueOf(Reimbursment.calcReimbursement(tripDays, milesDriven, carTracker, parkingFees,0.0, lodgingFees)));
               totalNum.setText(String.valueOf(airfareFees + lodgingFees + parkingFees + rentalFees));
               
               if ((airfareFees + lodgingFees + parkingFees + rentalFees) > allowedFees) {
                   excessNum.setText(String.valueOf((airfareFees + lodgingFees + parkingFees + rentalFees) - allowedFees));
                   savedNum.setText("0");
                   
               } else {
                   savedNum.setText(String.valueOf( allowedFees - (airfareFees + lodgingFees + parkingFees + rentalFees)));
                   excessNum.setText("0");
               }
            }
            
            
            
        });
        
        
       
        gridPane.add(carBoolean, 0, 9);
        gridPane.add(carLabel, 1, 9);
        gridPane.add(calcButton, 0, 10);
        gridPane.add(reimbursement, 1, 10);
        gridPane.add(totalText, 0, 11);
        gridPane.add(totalNum, 1, 11);
        gridPane.add(excessText, 0, 12);
        gridPane.add(excessNum, 1, 12);
        gridPane.add(savedText, 0, 13);
        gridPane.add(savedNum, 1, 13);
        calcButton.setDisable(true);
        
        Scene scene = new Scene(gridPane, 300, 300);
        scene.getStylesheets().add("styles.css");
        stage.setScene(scene);
        stage.show();
    }
    
    /**
     * Updates the state of the button that calculates the reimbursement.
     * @param fields the fields to check for.
     * @param calcButton the button to update.
     */
    private void updateRegisterButtonState(TextInputControl[] fields, Button calcButton) {
        for (TextInputControl field : fields) {
            if ( (field.getText() == null || field.getText().trim().isEmpty()) && !field.isDisabled()) {
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