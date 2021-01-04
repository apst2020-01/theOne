package application;

import java.sql.ResultSet;

//*******************************
//This class uses the DatabaseUtility class to perform a select statement from the EMPLOYEES database
//*******************************

public class SelectEmployeeDB {

	public static void main(String args[]){  
	 //Declare a SELECT statement
        String selectStmt = "SELECT * FROM EMPLOYEES";
 
        //Execute SELECT statement
        try {
            //Get ResultSet from dbExecuteQuery method
            ResultSet rs = DatabaseUtility.dbExecuteQuery(selectStmt);
 
          //(3.2) Extract the data	
    		while(rs.next()){ 
    	         //Retrieve by column name 
    	         int employeeId  = rs.getInt("employee_number"); 
    	         String jobTitle = rs.getString("job_title"); 
    	         double rate = rs.getDouble("Rate"); 
    	     	
    	         //STEP4: Print values
    	         System.out.println(employeeId+"  "+jobTitle+"  "+rate);  //(Step 4)
    	  
    		   }
    		    DatabaseUtility.dbDisconnect();
    		    }catch(Exception e){ System.out.println(e);} 

	}
}
