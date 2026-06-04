package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class customerDashboardController {

@FXML
private void viewProducts(ActionEvent event) {
	try {
	Parent saleRoot = FXMLLoader.load(getClass().getResource("allProducts.fxml"));
    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    stage.setScene(new Scene(saleRoot));
    stage.setTitle("Manage Sales");
    stage.show();
} catch (IOException e) {
    e.printStackTrace();
}
}
@FXML
private void purchaseProduct(ActionEvent event) {
    try {
        Parent root = FXMLLoader.load(getClass().getResource("purchaseProduct.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.setTitle("Purchase Product");
        stage.show();
    } catch (IOException e) {
        e.printStackTrace();
    }
}
@FXML
private void viewOrder(ActionEvent event) {
    try {
        Parent root = FXMLLoader.load(getClass().getResource("viewOrder.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.setTitle("View Orders");
        stage.show();
    } catch (IOException e) {
        e.printStackTrace();
    }
}
@FXML
private void backToWelcome(ActionEvent event) {
    try {
        Parent root = FXMLLoader.load(getClass().getResource("Online_Store_welcomePage.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.setTitle("View Orders");
        stage.show();
    } catch (IOException e) {
        e.printStackTrace();
    }
}
}
