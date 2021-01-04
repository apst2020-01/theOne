import javafx.beans.property.*;
import java.sql.Date;

public class Customer {
	 //Declare Customer Model variables
	private IntegerProperty Customer_Number;
	private StringProperty Customer_Name;
	private IntegerProperty Customer_Category;
	private StringProperty Customer_Telno;
	private StringProperty Customer_DeliveryAddress;
	
	
	
	//Constructor
    public Customer() {
        this.Customer_Number = new SimpleIntegerProperty();
        this.Customer_Name = new SimpleStringProperty();
        this.Customer_Category = new SimpleIntegerProperty();
        this.Customer_Telno = new SimpleStringProperty();
        this.Customer_DeliveryAddress = new SimpleStringProperty();
    }

    
    //get and set methods 
    //customerNumber
    public int getCustomerNumber() {
        return Customer_Number.get();
    }
 
    public void setCustomerNumber(int customerNumber){
       	Customer_Number.set(customerNumber);
    }
 
    public IntegerProperty customerNumberProperty(){
        return Customer_Number;
    }
            
  //customer Name
    public String getCustomer_Name () {
        return Customer_Name.get();
    }
 
    public void setCustomerName(String customerName){
        Customer_Name.set(customerName);
    }
 
    public StringProperty customerNameProperty() {
        return Customer_Name;
    }
  
   //Customer_Category
    public int getCustomer_Category () {
        return Customer_Category.get();
    }
 
    public void setCustomerCategory(int customerCategory){
        Customer_Category.set(customerCategory);
    }
 
    public IntegerProperty customerCategoryProperty() {
        return Customer_Category;
    }
    
   
    //Customer_Telno
    
    public String getCustomer_Telno () {
        return Customer_Telno.get();
    }
 
    public void setCustomerTelNo(String customerTelNo){
        Customer_Telno.set(customerTelNo);
    }
 
    public StringProperty customerTelNoProperty() {
        return Customer_Telno;
    }
    
    
    //Customer_DeliveryAddress
    
    public String getCustomer_DeliveryAddress () {
        return Customer_DeliveryAddress.get();
    }
 
    public void setCustomerDelAddress(String customerDelAddress){
        Customer_DeliveryAddress.set(customerDelAddress);
    }
 
    public StringProperty customerDelAddressoProperty() {
        return Customer_DeliveryAddress;
    }
	
	public static void placeORder () {
		}

	
	
	
	
}






