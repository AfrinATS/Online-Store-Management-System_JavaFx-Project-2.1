package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import java.io.IOException;

public class foodItemsController {
    @FXML private TextField idField;
    @FXML private TextField nameField;
    @FXML private TextField priceField;
    @FXML private TextField quantityField;
    @FXML private TextField manufacturingField;
    @FXML private TextField expiryField;
    @FXML private TextField onSaleField;

    @FXML
    private void handleAddFood(ActionEvent event) {
        try {
            // Validate required inputs
            if (idField.getText().isEmpty() || nameField.getText().isEmpty() || 
                priceField.getText().isEmpty() || quantityField.getText().isEmpty() ||
                manufacturingField.getText().isEmpty() || expiryField.getText().isEmpty()) {
                showAlert("Input Error", "Please fill in all required fields", Alert.AlertType.ERROR);
                return;
            }

            // Create new FoodItem
            FoodItem newFood = new FoodItem(
                idField.getText(),
                nameField.getText(),
                Double.parseDouble(priceField.getText()),
                Integer.parseInt(quantityField.getText()),
                manufacturingField.getText(),
                expiryField.getText(),
                onSaleField.getText().isEmpty() ? false : Boolean.parseBoolean(onSaleField.getText())
            );

            // Add to storage
            FoodStorage.addFoodItem(newFood);
            showAlert("Success", "Food item added successfully!", Alert.AlertType.INFORMATION);
            clearForm();
            navigateToFoodList(event);

        } catch (NumberFormatException e) {
            showAlert("Input Error", "Please enter valid numbers for price and quantity", Alert.AlertType.ERROR);
        }
    }

    private void navigateToFoodList(ActionEvent event) {
		// TODO Auto-generated method stub
		
	}

	private void clearForm() {
		// TODO Auto-generated method stub
		
	}

	private void showAlert(String title, String message, Alert.AlertType type) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    // Rest of your existing methods remain the same...
}