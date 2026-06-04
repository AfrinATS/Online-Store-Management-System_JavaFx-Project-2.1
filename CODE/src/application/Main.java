package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        try {
            // Load the FXML file
            Parent root = FXMLLoader.load(getClass().getResource("Online_Store_welcomePage.fxml"));

            // Create scene with loaded layout
            Scene scene = new Scene(root, 600, 600);

            // Optional: load CSS
            scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

            // Set up the stage
            primaryStage.setScene(scene);
            primaryStage.setTitle("Online Store");
            primaryStage.show();

        } catch (Exception e) {
            e.printStackTrace(); // Print any error
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
