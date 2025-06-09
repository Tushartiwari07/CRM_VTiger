package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.jdbc.Driver;

public class JDBC_CreateTable {
	
	@Test
	public void createTable() throws SQLException
	{
		
	//:Load or Register DataBase Driver
			Driver driver= new Driver();
			DriverManager.registerDriver(driver);
			
			// Connect to database
		Connection conn = DriverManager.getConnection("jdbc:mysql://49.249.28.218:3333/Qspider2024","root","root");
			
		//connect SQL statement
		Statement stat = conn.createStatement();
		
		//Execute 
		 stat.executeUpdate("CREATE TABLE StudentsQsp (id INT PRIMARY KEY,first_name VARCHAR(50) NOT NULL,last_name VARCHAR(50),subject VARCHAR(100) UNIQUE, join_date DATE, mock_rating VARCHAR(5));");
		 
		 //close 
		 conn.close();
	}
			
			

}
