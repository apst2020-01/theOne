package application;
//*******************************
//This class uses the DatabaseUtility class to perform an INSERT  statement to the EMPLOYEES database, where the user manually enters the database field 
//*******************************

public class UpdateEmployeeDB {

	public static void main(String args[]){  
		
		
	     // insert the data
	             
                  
		//Declare a DELETE statement
        String updateStmt = "UPDATE EMPLOYEES  SET rate = 25 WHERE Employee_number = 110";
        System.out.println("Row successfully updated into table...");
        //Execute DELETE operation
        try {
            DatabaseUtility.dbExecuteUpdate(updateStmt);
	         DatabaseUtility.dbDisconnect();
	     } catch (Exception e) { 
	         System.err.println("Got an exception! "); //manage exceptions
	         System.err.println(e.getMessage()); 
	     } 

	 }
}



//employee_id
    public int getEmployeeId() {
        return employee_id.get();
    }
 
    public void setEmployeeId(int employeeId){
        this.employee_id.set(employeeId);
    }
 
    public IntegerProperty employeeIdProperty(){
        return employee_id;
    }