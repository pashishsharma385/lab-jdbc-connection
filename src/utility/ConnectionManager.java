package utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import java.io.InputStream;

public class ConnectionManager {
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
	
		
		Properties prop = null ;   		//properties of object

		try {
			prop = loadPropertiesFile();
		} catch (Exception e1) {
			
			e1.printStackTrace();
		}
		final String driver = prop.getProperty("driver");
		final String url = prop.getProperty("url");
		final String username = prop.getProperty("username");
		final String password = prop.getProperty("password");
		
		

		Class.forName(driver); 		// driver class
		
		

		Connection con = null;		//creating  connection object
		con =DriverManager.getConnection(url,username,password);
		return con;
	}
	
	

	  public static Properties loadPropertiesFile() throws Exception 		  //properties method
	   {
		Properties prop = new Properties();
		InputStream in = ConnectionManager.class.getClassLoader().getResourceAsStream("jdbc.properties");
		prop.load(in);in.close();
		return prop; 
	   } 
	
}