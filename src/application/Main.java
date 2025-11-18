package application;

import java.net.URL;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class Main extends Application {
	public static void main(String[] args) {
		launch(args);
	}
	@Override
	public void start(Stage stage) throws Exception {
		URL url = getClass().getResource("WhackAMole.fxml");
		if (url == null) {
		    throw new RuntimeException("FXML file not found!");
		}
		FXMLLoader fxmlLoader= new FXMLLoader(url);
		Parent root = fxmlLoader.load();
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
}
