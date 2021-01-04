package application;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TechniWizeApplication extends Application {
	@Override
	public void start (Stage primaryStage) throws Exception {
		Parent root = (Parent) FXMLLoader.load(getClass().getResource ("OrderCaptureScreen.fxml"));
		primaryStage.setTitle("TechniWize Order Capture System");
		primaryStage.setScene(new Scene (root, 800, 600));
		primaryStage.show();
		
	}

	public static void main (String[] args) {
		launch (args);
				
	}

}