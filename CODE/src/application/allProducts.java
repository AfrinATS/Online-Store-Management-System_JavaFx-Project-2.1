package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import java.io.IOException;

public class allProducts {
    @FXML
    private void openFoodItems(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("foodStorage.fxml")); // Changed to foodStorage.fxml
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Food Items Inventory");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void openClothingItems(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("clothingItems.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void back_to_admin_dashboard(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("Admin_Dashboard.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}