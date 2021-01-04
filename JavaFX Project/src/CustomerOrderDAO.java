package application;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class CustomerOrderDAO {
	
	//*************************************
	//INSERT an Order
	//*************************************
	public static  void insertOrder (int customerNumber, int  quotationNumber, int customerCategory, int prodCode, int quant, double price, double subTotalAmount, double vat, double orderDiscountAmount, double TotalAmountDue, Date OrderDate) throws SQLException, ClassNotFoundException {
		 System.out.print("starting Order insert method: ");
		//Declare an INSERT  statement
			String updateStmt =
                         "INSERT INTO CUSTOMER_ORDERS898\n" +
                         "(customerNumber, Quotation_number, Customer_Category, Product_Code, Quantity, Price,  Sub_Total_Amount, VAT, Order_Discount_Amount, Total_Amount_Due, order_Date)\n" +
                       "VALUES\n" +
                        "('"+customerNumber+"', '"+quotationNumber+"', '"+customerCategory+"','"+prodCode+"', '"+quant+"', '"+price+"', '"+subTotalAmount+"', '"+vat+"', '"+orderDiscountAmount+"', '"+TotalAmountDue+"', '"+OrderDate+"')";
                
            
	    //Execute INSERT operation
	    try {
	        DB2.dbExecuteUpdate(updateStmt);
	    } catch (SQLException e) {
	        System.out.print("Error occurred while INSERT  Operation: " + e);
	        throw e;
	    }
	}
	
	//*******************************
    //SELECT fields from CUSTOMER CASH ORDER TABLE to build view of customer order
    //*******************************
    public static CustomerOrder buildCashOrder (String custNo) throws SQLException, ClassNotFoundException {
        //Declare a SELECT statement
       
    	
    	String selectStmt = "SELECT * FROM CUSTOMER_ORDERS89";
 
        //Execute SELECT statement
        try {
            //Get ResultSet from dbExecuteQuery method
            ResultSet rscustomerOrder = DB2.dbExecuteQuery(selectStmt);
 
            //Send ResultSet to the getEmployeeFromResultSet method and get employee object
            CustomerOrder  customerOrder = getCustomerCashORder(rscustomerOrder);
          
            
            //Return customer  object
            return customerOrder;
        } catch (SQLException e) {
            System.out.println("While searching customer with " + custNo + " id, an error occurred: " + e);
            //Return exception
            throw e;
        }
    }
	
  //Use ResultSet from DB as parameter and set CustomerOrder  Object's attributes and return CustoemrORder object.
    private static CustomerOrder getCustomerCashORder (ResultSet rs) throws SQLException
    {
    	CustomerOrder custCashOrder = null;
        if (rs.next()) {
        	custCashOrder.setcustomerNumber(rs.getInt("Customer_number"));
        	custCashOrder.setQuotationNumber(rs.getInt("Quotation_number"));
        	custCashOrder.setCustomerCategory (rs.getInt("Customer_Category"));
        	custCashOrder.setProdCode(rs.getInt("Product_Code"));
        	custCashOrder.setQuantity(rs.getInt("Quantity"));
        	custCashOrder.setPrice (rs.getDouble("Price"));
        	custCashOrder.setSubTotalAmount(rs.getDouble("Sub_Total_Amount"));
        	custCashOrder.setVat(rs.getDouble("VAT"));
        	custCashOrder.setOrderDiscountAmount(rs.getDouble("Order_Discount_Amount"));
        	custCashOrder.setTotalAmountDue(rs.getDouble("Total_Amount_Due"));
        	custCashOrder.setOrderDate(rs.getDate("Order_Date"));
        	
            System.out.println(custCashOrder);
        }
        return custCashOrder;
    }
    
    
  //*******************************
    //SELECT fields from CUSTOMER ACCOUNT ORDER TABLE to build view of customer order
    //*******************************
    public static CustomerAccountOrder buildAccountOrder (String custNo) throws SQLException, ClassNotFoundException {
        //Declare a SELECT statement
        String selectStmt = "SELECT * FROM CUSTOMER_ORDERS89";
 
        //Execute SELECT statement
        try {
            //Get ResultSet from dbExecuteQuery method
            ResultSet rscustomerOrder = DB2.dbExecuteQuery(selectStmt);
 
            //Send ResultSet to the getEmployeeFromResultSet method and get employee object
            CustomerAccountOrder  customerAccountOrder = getCustomerAccountOrder(rscustomerOrder);
          
            
            //Return customer  object
            return customerAccountOrder;
        } catch (SQLException e) {
            System.out.println("While searching customer with " + custNo + " id, an error occurred: " + e);
            //Return exception
            throw e;
        }
    }
	
    
    
    //Use ResultSet from DB as parameter and set CustomerOrder  Object's attributes and return CustoemrORder object.
    private static CustomerAccountOrder getCustomerAccountOrder (ResultSet rs) throws SQLException
    {
    	CustomerAccountOrder custAccountOrder = null;
        if (rs.next()) {
        	custAccountOrder.setcustomerNumber(rs.getInt("Customer_number"));
        	custAccountOrder.setQuotationNumber(rs.getInt("Quotation_number"));
        	custAccountOrder.setCustomerCategory (rs.getInt("Customer_Category"));
        	custAccountOrder.setProdCode(rs.getInt("Product_Code"));
        	custAccountOrder.setQuantity(rs.getInt("Quantity"));
        	custAccountOrder.setPrice (rs.getDouble("Price"));
        	custAccountOrder.setSubTotalAmount(rs.getDouble("Sub_Total_Amount"));
        	custAccountOrder.setVat(rs.getDouble("VAT"));
        	custAccountOrder.setOrderDiscountAmount(rs.getDouble("Order_Discount_Amount"));
        	custAccountOrder.setTotalAmountDue(rs.getDouble("Total_Amount_Due"));
        	custAccountOrder.setOrderDate(rs.getDate("Order_Date"));
            System.out.println(custAccountOrder);
        }
        return custAccountOrder;
    }
}
        
  
    
