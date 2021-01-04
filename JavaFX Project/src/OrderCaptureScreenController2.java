package application;
import java.sql.*;

import java.awt.Label;
import javafx.scene.control.TextArea;
import java.util.Calendar;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Window;
import javafx.scene.control.DatePicker;



public class OrderCaptureScreenController2 {
	
	
	@FXML 
	private TextField TextFieldCustNo;
		
	@FXML
	private Button ButtonDisplayCustDetails;
	
	
	@FXML 
	private Text txtCustName;
	
	@FXML
	private Text txtFieldCustName;
	
	@FXML 
	private Text txtFieldCustTelNo;
	
	@FXML
	private Text txtFieldCustDelAddr;
		

	
	//capture order details 	
	@FXML
	private DatePicker  DatePicker; 
	
	
	@FXML
	private TextField   TextFieldProdID1; 
	
	@FXML 
	private TextField TextFieldProdID2;
	
	@FXML 
	private TextField TextFieldProdID3;
	
	@FXML 
	private TextField TextFieldProdID4;
	
	@FXML 
	private TextField TextFieldProdID5;
	
	@FXML
	private TextField TextFieldQuant1;
	
	@FXML
	private TextField TextFieldQuant2;
	
	@FXML
	private TextField TextFieldQuant3;
	
	@FXML
	private TextField TextFieldQuant4;
	
	@FXML
	private TextField TextFieldQuant5;
	
	
	//dispaly order line sub total
	
	
	@FXML
	private Text txtFieldLineItemSubTotal1;
	
	@FXML
	private Text txtFieldLineItemSubTotal2;
	
	@FXML
	private Text txtFieldLineItemSubTotal3;
	
	@FXML
	private Text txtFieldLineItemSubTotal4;
	
	@FXML
	private Text txtFieldLineItemSubTotal5;
	
	@FXML 
	private Text txtFieldOrderNo;
	
	@FXML
	private Button  ButtonGenerateOrderNo;
	
	
	@FXML
	private Text  TextFieldSubTotal;
		
	@FXML
	private Text  TextFieldVAT;
	
	@FXML
	private Text  TextFieldGrandTotal;
	
	@FXML
	private Text  TextFieldDiscountedAmount;
	
	@FXML
	private Text  TextFieldLoyaltyPoints;
	
	@FXML
	private Text  TextFieldTotalAmountDue;
	
	
	@FXML
	private CheckBox  checkBoxAccountPayment;
	
	@FXML 
	private Button  buttonClose;
	
	 @FXML
	 private  Text  displayCustName;
	 
	 @FXML 
	 private Text displayCustCat;
	 
	 @FXML
	 private Text displayCustDelAddr;
	 
	 @FXML 
	 private Text displayCustTelNo; 
	 
	 @FXML
	 private TextArea displayCustInfo;
	 
	
	@FXML
	protected void displayCustomerDetails (ActionEvent event) throws ClassNotFoundException, SQLException {
		 
		Window owner = ButtonDisplayCustDetails.getScene().getWindow();
		 //check if No Customer Number is entered!
		
		
		 
		 if(TextFieldCustNo.getText().isEmpty()) {
	            MessageScreen.showAlert(Alert.AlertType.ERROR, owner, "Blank Field!", 
	                    "Please enter a valid Customer Number");
	            return;
	        }else
	        	try{
	        		       //Get Customer  information
	        	             Customer cust = CustomerDAO.displayCustomerDetails(TextFieldCustNo.getText());
        				     ShowCustomerDetails (cust);
	        	            } catch (SQLException e) {
	        	            e.printStackTrace();
	        	            displayCustInfo.setText("Error occurred while getting employee information from DB.\n" + e);
	        	            throw e;
	        	        }
	        	    }
		        	
	
    public  void initialize(Customer cust) throws ClassNotFoundException {
    	  ShowCustomerDetails (cust);
    }
    
    
    private void setCusInfoToTextArea ( Customer cust) {
    	displayCustInfo.setText("Customer Name : " + cust.getCustomer_Name() + "\n" 
    						  + "Customer Category: " + cust.getCustomer_Category() + "\n" 
    						  + "Customer Delivery Address: " + cust.getCustomer_DeliveryAddress() + "\n"
    						  + "Customer Tel No: " + cust.getCustomer_Telno()
    						  
    			);
    	
    }

		 	 
		    //Populate Customer to display on  TextArea
		   
		    private void ShowCustomerDetails(Customer cust) throws ClassNotFoundException {
		        if (cust != null) {
		               setCusInfoToTextArea(cust);
		        } else {
		        	displayCustInfo.setText("This Customer does not exist!\n");
	        		
		        }
		    }
	      	
   		
    @FXML
	protected void getOrderDate (ActionEvent event) {	   
    
    Window owner = DatePicker.getScene().getWindow();
    if(DatePicker.getPromptText().isEmpty()) {
        MessageScreen.showAlert(Alert.AlertType.ERROR, owner, "Blank Field!", 
                "Please enter a valid Order Date");
        return;
    }else
    	try{
    		       //Get Customer  information
    	             Customer cust = CustomerDAO.displayCustomerDetails(TextFieldCustNo.getText());
				     ShowCustomerDetails (cust);
    	            } catch (SQLException e) {
    	            e.printStackTrace();
    	            displayCustInfo.setText("Error occurred while getting employee information from DB.\n" + e);
    	            throw e;
    	        }
	  	
	@FXML
	protected void generateOrderNo (ActionEvent event) throws SQLException, ClassNotFoundException {	
	 //Insert an order to the DB

        try {
            CustomerCashOrderDAO.insertOrder(TextFieldCustNo.getText()); 
          
        } catch (SQLException e) {
                       throw e;
        }
    }
	
	@FXML
	protected void CashPaymentDiscount (ActionEvent event) {}	
	
	@FXML
	protected void accountPaymentDiscount (ActionEvent event) {}
	
	@FXML
	protected void CloseApplication (ActionEvent event) {}
	
	@FXML
	protected void AccountPayment (ActionEvent event) {}
	
	
}
