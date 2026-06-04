package application;

import application.model.FoodDataStore;
import application.model.food;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class salesController {

    @FXML private TextField searchField;
    @FXML private Button search;
    @FXML private TableView<food> resultTable;
    @FXML private TableColumn<food, String> idColumn;
    @FXML private TableColumn<food, String> nameColumn;
    @FXML private TableColumn<food, Double> priceColumn;
    @FXML private TableColumn<food, Double> quantityColumn;
    @FXML private TableColumn<food, String> onSaleColumn;
    @FXML
    public void initialize() {
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
        quantityColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        onSaleColumn.setCellValueFactory(new PropertyValueFactory<>("onSale"));
    }
    @FXML
    private void handleSearch() {
        String searchId = searchField.getText().trim();
        ObservableList<food> foundItems = FXCollections.observableArrayList();

        for (food f : FoodDataStore.getFoodList()) {
            if (f.getId().equals(searchId)) {
                foundItems.add(f);
                break;
            }
        }
        if (!foundItems.isEmpty()) {
            resultTable.setItems(foundItems);
            resultTable.setVisible(true);
        } else {
            resultTable.setVisible(false);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Product Not Found");
            alert.setHeaderText(null);
            alert.setContentText("No food item found with ID: " + searchId);
            alert.showAndWait();
        }
    }
    @FXML
    private void handleDiscount(ActionEvent event) {
        if (selectedFood != null) {
            try {
                double discount = Double.parseDouble(discountField.getText());
                double newPrice = selectedFood.getPrice() * (1 - discount / 100);
                selectedFood.priceProperty().set(newPrice); // update property directly
                foodTable.refresh();
            } catch (NumberFormatException e) {
                System.out.println("Invalid discount input.");
            }
        }
    }
}
