
package application;
/**
 * The database utility class is used to perform all database operations in an application such as
 * STEP 1:  Import the required JDBC package 
 * STEP 2.1	Declare and Register JDBC driver  
 * STEP 2.2 Establish connection to database  by using connection object
 * STEP 2.3 Register JDBC driver
 * STEP 2.4  Enter database credentials & establish connection
 * STEP 2.5  Close database connection
 * STEP 3: Implement methods to execute database operations 
 *       3.1  Retrieve/select values from a database 
 *       3.2  Execute Update (For Update/Insert/Delete) Operation
 * 
 */
	import com.sun.rowset.CachedRowSetImpl;

	import java.sql.*; // STEP 1:  Import the required JDBC package 
	
	public class DB2 {
		// STEP 2.1  Declare JDBC driver 
	    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";

	    //STEP 2.2  Create connection object. 
	    private static Connection conn = null;

	    public static void dbConnect() throws SQLException, ClassNotFoundException {
	        //2.3 Register JDBC driver
	        try {
	            Class.forName(JDBC_DRIVER);
	        } catch (ClassNotFoundException e) {
              e.printStackTrace();
	            throw e;
	        }

	        System.out.println("JDBC Driver Registered!");

	        //2.4 Enter database credentials and establish connection  
	        try {
	            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/TechniWizeDB","root","MdkMpo100.");
	        } catch (SQLException e) {
	            System.out.println("Connection Failed! " + e);
	            e.printStackTrace();
	            throw e;
	        }
	    }

	    //2.5 Close database  Connection
	    public static void dbDisconnect() throws SQLException {
	        try {
	            if (conn != null && !conn.isClosed()) {
	                conn.close();
	            }
	        } catch (Exception e){
	           throw e;
	        }
	    }

	    //STEP 3: Implement methods to execute database operations 
	    //     3.1  Retrieve/select values from a database 
	    public static ResultSet dbExecuteQuery(String queryStmt) throws SQLException, ClassNotFoundException {
	        //a) Declare statement, resultSet and CachedResultSet as null
	        Statement stmt = null;
	        ResultSet resultSet = null;
	        CachedRowSetImpl crs = null;
	        try {
	            //b) Connect to DB
	            dbConnect();
	            System.out.println("Select statement: " + queryStmt + "\n"); // helpful: print select statement in console

	            //c)Create statement
	            stmt = conn.createStatement();

	            //d) Execute select (query) operation
	            resultSet = stmt.executeQuery(queryStmt);
	            //CachedRowSet Implementation
	            //In order to prevent "java.sql.SQLRecoverableException: Closed Connection: next" error
	            //We are using CachedRowSet
	         
	           crs = new CachedRowSetImpl();
	           crs.populate(resultSet);
	           System.out.println("Result set printout : " + crs);
	           
	        } catch (SQLException e) {
	            System.out.println("Problem occurred at executeQuery operation : " + e);
	            throw e;
	        } finally {
	            if (resultSet != null) {
	                //Close resultSet
	                resultSet.close();
	            }
	            if (stmt != null) {
	                //Close Statement
	                stmt.close();
	            }
	            //Close connection
	            dbDisconnect();
	        }
	        //Return CachedRowSet
	        return crs;
	    }

	    //3.2 DB Execute Update (For Update/Insert/Delete) Operation
	    public static void dbExecuteUpdate(String sqlStmt) throws SQLException, ClassNotFoundException {
	        //Declare statement as null
	        Statement stmt = null;
	        try {
	            //Connect to DB 
	            dbConnect();
	            //Create Statement
	            stmt = conn.createStatement();
	            //Run executeUpdate operation with given sql statement
	            stmt.executeUpdate(sqlStmt);
	            System.out.println("Update statement: " + sqlStmt + "\n"); // helpful: print select statement in console
	        } catch (SQLException e) {
	            System.out.println("Problem occurred at executeUpdate operation : " + e);
	            throw e;
	        } finally {
	            if (stmt != null) {
	                //Close statement
	                stmt.close();
	            }
	            //Close connection
	            dbDisconnect();
	        }
	    }
	}

