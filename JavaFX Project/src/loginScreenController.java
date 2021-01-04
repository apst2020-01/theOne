package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import javafx.stage.Window;

public class loginScreenController {

	@FXML 
	private TextField UserNameField; //inject the UI components 
	
	@FXML
	private PasswordField passwordField;
	
	@FXML
	private Button loginButton;
	
	@SuppressWarnings("null")
	@FXML //method to handle the login button action
	protected void handleLoginButtonAction (ActionEvent event) throws IOException {
		 Window owner = loginButton.getScene().getWindow();
		 //check to see if user has entered any text 
		 if(UserNameField.getText().isEmpty()) {
	            MessageScreen.showAlert(Alert.AlertType.ERROR, owner, "Blank Field!", 
	                    "Please enter a valid User Name");
	            return;
	        }
		 
		 if(passwordField.getText().isEmpty()) {
	            MessageScreen.showAlert(Alert.AlertType.ERROR, owner, "Blank Field !", 
	                    "Please enter a Valid Password ");
	            return;
	        }
		
		 
		 // validate the correct Username/password combination
				String userName= UserNameField.getText();
				String password =String.valueOf(passwordField.getText());
				if(userName.equals("user1")&&password.equals("password123"))
				{
					MessageScreen.showAlert(Alert.AlertType.CONFIRMATION, owner, "Login Successful!", 
			                "Welcome " + UserNameField.getText());
					
				
				
				
				
				}	
				
					
					
					
	        else{
	        	MessageScreen.showAlert(Alert.AlertType.CONFIRMATION, owner, "Invalid login!", 
		                "Incorrect User Name/Password combination");	
	        }
		    
	}
	
}
