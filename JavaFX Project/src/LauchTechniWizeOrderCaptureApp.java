import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class LauchTechniWizeOrderCaptureApp extends Application {
	@Override
	
	public void start (Stage primaryStage) throws Exception {
		Parent root = (Parent) FXMLLoader.load(getClass().getResource ("MainMenu.fxml"));
		primaryStage.setTitle("AB Corporation Order Capture System");
		primaryStage.setScene(new Scene (root, 500, 600));
		primaryStage.show();
		
	}

	public static void main (String[] args) {
		launch (args);
				
	}

}
