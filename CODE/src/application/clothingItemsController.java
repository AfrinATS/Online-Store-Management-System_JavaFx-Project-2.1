package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class clothingItemsController {
	@FXML
	private void backToAllProducts(ActionEvent event) {
		try {
		Parent saleRoot = FXMLLoader.load(getClass().getResource("allProducts.fxml"));
	    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
	    stage.setScene(new Scene(saleRoot));
	    stage.setTitle("View all products");
	    stage.show();
	} catch (IOException e) {
	    e.printStackTrace();
	}
	}
}
