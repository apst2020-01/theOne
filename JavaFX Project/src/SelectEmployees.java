package application;

import java.sql.ResultSet;
import java.sql.SQLException;

//*******************************
//Employee class to illustrate DB query to select records from a database using the database utility class. 
//*******************************

public class SelectEmployee {

	public static void main(String args[]){  
	 //Declare a SELECT statement
        String selectStmt = "SELECT * FROM EMPLOYEES";
 
        //Execute SELECT statement
        try {
            //Get ResultSet from dbExecuteQuery method
            ResultSet rs = DB3.dbExecuteQuery(selectStmt);
 
          //(3.2) Extract the data	
    		while(rs.next()){ 
    	         //Retrieve by column name 
    	         int employeeId  = rs.getInt("employee_number"); 
    	         String jobTitle = rs.getString("job_title"); 
    	         double rate = rs.getDouble("Rate"); 
    	     	
    	         //STEP4: Print values
    	         System.out.println(employeeId+"  "+jobTitle+"  "+rate);  //(Step 4)
    	  
    		   }
    		    DB3.dbDisconnect();
    		    }catch(Exception e){ System.out.println(e);} 

	}
}
    			