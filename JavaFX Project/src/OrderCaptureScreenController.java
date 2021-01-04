package application;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
import java.util.Date;



public class OrderCaptureScreenController {
	
	
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
	private TextField   TextFieldQuotationNo; 
	
	@FXML 
	private TextField TextFieldProdCode;
	
	@FXML 
	private TextField FieldTextQuantity;
	
	@FXML 
	private TextField textFieldCustCategory;
	
	@FXML 
	private TextField txtFieldPrice;

	@FXML
	private Text  TextFieldSubTotal;
		
	@FXML
	private Text  TextFieldVAT;
		
	@FXML
	private Text  TextFieldDiscountedAmount;
	

	@FXML
	private Text  TextFieldTotalAmountDue;
	
	
	@FXML
	private CheckBox  checkBoxAccountPayment;
	
	@FXML 
	private Button  buttonClose;
	
	@FXML 
	private Button  ButtonCaptureOrder;
	
	@FXML
	 private TextArea displayCustInfo;

	private double orderDiscountAmount;

	private double vatAmount;

	private double subTotalAmount;

	private double TotalAmountDue;
	 
	
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
	protected void captureOrder (ActionEvent event) throws SQLException, ClassNotFoundException {	
	
		/*
		if (checkBoxAccountPayment.setSelected(true)) {
			
		} else {
			
		}
		*/
				

		// create instance of customer cash order  
	CustomerOrder custCashOrder = new CustomerOrder(); 
		
	   
	
		//declare variables from the GUI which will be used to capture the cash order
		int quant = Integer.parseInt(FieldTextQuantity.getText()) ; 
		double price = Double.parseDouble(txtFieldPrice.getText());
		int customerCategory = Integer.parseInt(textFieldCustCategory.getText()) ;
						
		//declare date variable which user doesn't capture 
		DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
		Date orderDate   = new Date();
		System.out.println(df.format(orderDate));	
	
		//declare quotation number textfield 
		//int quotationNumber = Integer.parseInt(TextFieldQuotationNo.getText()) ; 

		// pass variables to the CalculateAmountDue method of the Customer Cash order class 
		custCashOrder.CalculateTotalAmountDue(customerCategory, quant, price);
		
		
		//retrieve values from CustomerCashORder returned from CalculateTotalAmountDue method
		//display output fields for customer cash order to the GUI
		
	
		String subTotalAmountText = String.valueOf(custCashOrder.getsubTotalAmountReturnValue());
		TextFieldSubTotal.setText(subTotalAmountText);
		
		String vatText = String.valueOf(custCashOrder.getvatAmountReturnValue());
		TextFieldVAT.setText(vatText);
		
		String orderDiscountAmountText = String.valueOf(custCashOrder.getOrderDiscountAmountReturnValue());
		TextFieldDiscountedAmount.setText(orderDiscountAmountText);
		
		String TotalAmountDueText = String.valueOf(custCashOrder.getTotalAmountDueReturnValue());
		TextFieldTotalAmountDue.setText(TotalAmountDueText);
		
		
		// int custNo = Integer.parseInt(TextFieldCustNo.getText()) ; 
		 
		
		//Insert an order to the DB
	    try {
	    	//CustomerOrderDAO.insertOrder(Integer.parseInt(TextFieldCustNo.getText()), Integer.parseInt(TextFieldQuotationNo.getText()),Integer.parseInt(textFieldCustCategory.getText()), Integer.parseInt(TextFieldProdCode.getText()), Integer.parseInt(FieldTextQuantity.getText()), Double.parseDouble(txtFieldPrice.getText()), Double.parseDouble(TextFieldSubTotal.getText()), Double.parseDouble(TextFieldVAT.getText()), Double.parseDouble(TextFieldDiscountedAmount.getText()), Double.parseDouble(TextFieldTotalAmountDue.getText()), orderDate);

	    	CustomerOrderDAO.insertOrder(Integer.parseInt(TextFieldTotalAmountDue.getText()), Integer.parseInt(TextFieldCustNo.getText()),Integer.parseInt(TextFieldCustNo.getText()), Integer.parseInt(TextFieldCustNo.getText()), Integer.parseInt(TextFieldCustNo.getText()), Double.parseDouble(txtFieldPrice.getText()), Double.parseDouble(txtFieldPrice.getText()), Double.parseDouble(txtFieldPrice.getText()), Double.parseDouble(txtFieldPrice.getText()), Double.parseDouble(txtFieldPrice.getText()), orderDate);
	         } catch (SQLException e) {
	            throw e;
	        }
			
	}
	
			
		
		
		
		
		
		
		
		
		
		
	    
		
		
		
		

		
	@FXML
	protected void CloseApplication (ActionEvent event) {}
	
	@FXML
	protected void AccountPayment (ActionEvent event) {}
	
	
}
