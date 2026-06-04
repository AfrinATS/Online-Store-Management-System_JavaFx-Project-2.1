package application;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Node;

public class addFoodController {
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
                showAlert("Input Error", "Please fill in all required fields", AlertType.ERROR);
                return;
            }

            // Get all field values
            String id = idField.getText();
            String name = nameField.getText();
            double price = Double.parseDouble(priceField.getText());
            int quantity = Integer.parseInt(quantityField.getText());
            String manufacturingDate = manufacturingField.getText();
            String expiryDate = expiryField.getText();
            boolean onSale = onSaleField.getText().isEmpty() ? false : Boolean.parseBoolean(onSaleField.getText());

            // Create new FoodItem
            FoodItem newFood = new FoodItem(id, name, price, quantity, manufacturingDate, expiryDate, onSale);

            // Add to storage
            FoodStorage.addFoodItem(newFood);

            // Show success message
            showAlert("Success", "Food item added successfully!", AlertType.INFORMATION);

            // Navigate to food storage page
            navigateToFoodStorage(event);

        } catch (NumberFormatException e) {
            showAlert("Input Error", "Please enter valid numbers for price and quantity", AlertType.ERROR);
        } catch (Exception e) {
            showAlert("Error", "An error occurred: " + e.getMessage(), AlertType.ERROR);
            e.printStackTrace();
        }
    }

    private void navigateToFoodStorage(ActionEvent event) {
        try {
            // Load the foodStorage.fxml file
            FXMLLoader loader = new FXMLLoader(getClass().getResource("foodStorage.fxml"));
            Parent root = loader.load();
            
            // Get the controller and refresh the table
            FoodStorageController controller = loader.getController();
            controller.refreshTable();
            
            // Get the current stage and set the new scene
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
            showAlert("Navigation Error", "Failed to load food storage view: " + e.getMessage(), AlertType.ERROR);
        }
    }

    @FXML
    private void goBackToaddNewProduct(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("addNewProduct.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
            showAlert("Navigation Error", "Failed to load add new product view", AlertType.ERROR);
        }
    }

    private void showAlert(String title, String message, AlertType type) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}