package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.jdbc.Driver;

public class JDBC_CreateDataBase {
	@Test
	public void createDatabase() throws SQLException
	{
		//:Load or Register DataBase Driver
		Driver driver= new Driver();
		DriverManager.registerDriver(driver);
		
		// Connect to database
	Connection conn = DriverManager.getConnection("jdbc:mysql://49.249.28.218:3333","root","root");
		
	//connect SQL statement
	Statement stat = conn.createStatement();
	
	//Execute 
	 stat.executeUpdate("create database Qspider2024");
	 
	 //close 
	 conn.close();
		
		
		
	}


}
