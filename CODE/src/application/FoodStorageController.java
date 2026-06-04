package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class FoodStorageController {
    @FXML private TableView<FoodItem> foodTable;
    @FXML private TableColumn<FoodItem, String> idColumn;
    @FXML private TableColumn<FoodItem, String> nameColumn;
    @FXML private TableColumn<FoodItem, Double> priceColumn;
    @FXML private TableColumn<FoodItem, Integer> quantityColumn;
    @FXML private TableColumn<FoodItem, String> manufacturingColumn;
    @FXML private TableColumn<FoodItem, String> expiryColumn;
    @FXML private TableColumn<FoodItem, Boolean> onSaleColumn;

    @FXML
    public void initialize() {
        // Set up the columns
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
        quantityColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        manufacturingColumn.setCellValueFactory(new PropertyValueFactory<>("manufacturingDate"));
        expiryColumn.setCellValueFactory(new PropertyValueFactory<>("expiryDate"));
        onSaleColumn.setCellValueFactory(new PropertyValueFactory<>("onSale"));

        // Load initial data
        refreshTable();
    }

    public void refreshTable() {
        ObservableList<FoodItem> foodItems = FXCollections.observableArrayList(FoodStorage.getAllFoodItems());
        foodTable.setItems(foodItems);
    }

    @FXML
    private void goBackToProducts() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("addNewProduct.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) foodTable.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}