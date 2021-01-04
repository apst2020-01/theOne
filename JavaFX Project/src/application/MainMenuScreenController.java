package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;


/**
 * Controller class for menuFrame.fxml
 */
public class MainMenuScreenController implements Initializable {

    @FXML private Button ButtonCaptureOrder;
    @FXML private Button buttonViewReport;
    @FXML private Button buttonCloseApplication;

   /**
     * Event handling method, loads new scene from .fxml file
     * according to clicked button and initialize all components.
     * @param event
     * @throws IOException
     */
    @FXML
    private void handleMenuButtonAction (ActionEvent event) throws IOException {
        Stage stage = null;
        Parent myNewScene = null;

        if (event.getSource() == ButtonCaptureOrder){
            stage = (Stage) ButtonCaptureOrder.getScene().getWindow();
            myNewScene = FXMLLoader.load(getClass().getResource("OrderCaptureScreen.fxml"));
        } else if (event.getSource() == buttonViewReport){
            stage = (Stage) buttonViewReport.getScene().getWindow();
            myNewScene = FXMLLoader.load(getClass().getResource("OrderCaptureScreen.fxml"));
        } else if (event.getSource() == buttonCloseApplication) {
        	 stage = (Stage) buttonCloseApplication.getScene().getWindow();
             myNewScene = FXMLLoader.load(getClass().getResource("OrderCaptureScreen.fxml"));
        }

        Scene scene = new Scene(myNewScene);
        stage.setScene(scene);
        stage.setTitle("TechniWize Order Capture System");
        stage.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) { }
    
}
	