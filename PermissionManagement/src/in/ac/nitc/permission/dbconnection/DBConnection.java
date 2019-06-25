package in.ac.nitc.permission.dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/* This class purely written for creating,requesting and closing database connection. It also ensures
 * that for one DBConnection object only one connection is created*/
public class DBConnection {
	/*Before running program change user name and password to your mysql user and password
	 * in which you have imported the database  
	 */
	private Connection con=null;
	private String url="jdbc:mysql://localhost:3306/PermissionManagement";
	private String mysqluser="mithun"; 
	private String mysqlpass="kumar";
	
	//To get database connection 
	public Connection getDBConnection() {
		if(con==null) {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				con=DriverManager.getConnection(url,mysqluser,mysqlpass);
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		return con;
	}
	
	//To close database Connection
	public void closeDBConnection() {
		if(con!=null) {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
