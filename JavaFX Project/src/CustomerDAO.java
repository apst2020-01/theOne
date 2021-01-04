package application;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerDAO {
	//*******************************
    //SELECT CUSTOMER 
    //*******************************
    public static Customer displayCustomerDetails (String custNo) throws SQLException, ClassNotFoundException {
        //Declare a SELECT statement
        String selectStmt = "SELECT * FROM CUSTOMER WHERE Customer_Number="+ custNo;
 
        //Execute SELECT statement
        try {
            //Get ResultSet from dbExecuteQuery method
            ResultSet rsCustomer = DB2.dbExecuteQuery(selectStmt);
 
            //Send ResultSet to the getEmployeeFromResultSet method and get employee object
            Customer  customer = getCustomerFromResultSet(rsCustomer);
 
            //Return customer  object
            return customer;
        } catch (SQLException e) {
            System.out.println("While searching customer with " + custNo + " id, an error occurred: " + e);
            //Return exception
            throw e;
        }
    }
	
    //Use ResultSet from DB as parameter and set Customer Object's attributes and return customer object.
    private static Customer getCustomerFromResultSet(ResultSet rs) throws SQLException
    {
        Customer cust = null;
        if (rs.next()) {
        	cust = new Customer();
            cust.setCustomerNumber(rs.getInt("Customer_Number"));
            cust.setCustomerName(rs.getString("Customer_Name"));
            cust.setCustomerCategory(rs.getInt("Customer_Category"));
            cust.setCustomerTelNo(rs.getString("Customer_Telno"));
            cust.setCustomerDelAddress(rs.getString("Customer_DeliveryAddress"));
            System.out.println(cust);
        }
        return cust;
    }
	
}
