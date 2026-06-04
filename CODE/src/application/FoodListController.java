package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import java.io.IOException;

public class FoodListController {
    @FXML private TableView<FoodItem> foodTable;
    @FXML private TableColumn<FoodItem, String> idColumn;
    @FXML private TableColumn<FoodItem, String> nameColumn;
    @FXML private TableColumn<FoodItem, Double> priceColumn;
    @FXML private TableColumn<FoodItem, Integer> quantityColumn;
    @FXML private TableColumn<FoodItem, String> manufacturingColumn;
    @FXML private TableColumn<FoodItem, String> expiryColumn;
    @FXML private TableColumn<FoodItem, Boolean> onSaleColumn;
    @FXML private TableColumn<FoodItem, Integer> purchasedColumn;

    @FXML
    public void initialize() {
        // Set up the columns in the table
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
        quantityColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        manufacturingColumn.setCellValueFactory(new PropertyValueFactory<>("manufacturingDate"));
        expiryColumn.setCellValueFactory(new PropertyValueFactory<>("expiryDate"));
        onSaleColumn.setCellValueFactory(new PropertyValueFactory<>("onSale"));
        purchasedColumn.setCellValueFactory(new PropertyValueFactory<>("purchasedQuantity"));

        refreshTable();
    }

    private void refreshTable() {
        foodTable.setItems(FXCollections.observableArrayList(FoodStorage.getAllFoodItems()));
    }

    @FXML
    private void goBackToAddFood(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("addFood.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            showAlert("Error", "Failed to load add food view", Alert.AlertType.ERROR);
        }
    }

    private void showAlert(String title, String message, Alert.AlertType type) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}