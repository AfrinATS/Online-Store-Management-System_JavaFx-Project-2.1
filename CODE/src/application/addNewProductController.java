package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class addNewProductController {
	@FXML
    private void openNewFood(ActionEvent event) {
        try {
            Parent adminRoot = FXMLLoader.load(getClass().getResource("addFood.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(adminRoot));
            stage.setTitle("Add New Food");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }@FXML
    private void openNewClothes(ActionEvent event) {
        try {
            Parent adminRoot = FXMLLoader.load(getClass().getResource("addClothes.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(adminRoot));
            stage.setTitle("Add New Food");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    	@FXML
        private void backtoAdmin(ActionEvent event) {
            try {
                Parent adminRoot = FXMLLoader.load(getClass().getResource("Admin_Dashboard.fxml"));
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(new Scene(adminRoot));
                stage.setTitle("Admin Dashboard");
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
}
