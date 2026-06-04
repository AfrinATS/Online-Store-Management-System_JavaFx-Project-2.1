package application;
import application.model.clothes;
import application.model.ClothingDataStore;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class addClotheController {
	@FXML
    private TextField idField;
    @FXML
    private TextField nameField;
    @FXML
    private TextField priceField;
    @FXML
    private TextField quantityField;
    @FXML
    private TextField brandField;
    @FXML
    private TextField onSaleField;
    @FXML
    private TextField sizeField;
    @FXML
    private TextField subCategoryField;
    @FXML
    private void goBackToaddNewProduct(ActionEvent event) {
        try {
            Parent adminRoot = FXMLLoader.load(getClass().getResource("addNewProducts.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(adminRoot));
            stage.setTitle("Admin Dashboard");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	@FXML
	private void handleAddClothing() {
	    String id = idField.getText();
	    String name = nameField.getText();
	    double price = Double.parseDouble(priceField.getText());
	    double quantity = Double.parseDouble(quantityField.getText());
	    String brand = brandField.getText();
	    String size = sizeField.getText();
	    String subcategory = subCategoryField.getText();
	    String onSale = onSaleField.getText(); // or getText() if it's a TextField

	    clothes newClothing = new clothes(id, name, price, quantity, brand, size, subcategory, onSale);
	    ClothingDataStore.addClothing(newClothing);

	    System.out.println("Clothing item added: " + newClothing.getName());
	}

}
