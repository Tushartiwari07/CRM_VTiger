package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.jdbc.Driver;

public class JDBC_Insert_Values {
	@Test
	public void insertIntoTable() throws SQLException
	{
		Connection conn=null;
		
		try {			Driver driver= new Driver();
			DriverManager.registerDriver(driver);
		 conn = DriverManager.getConnection("jdbc:mysql://49.249.28.218:3333/Qspider2024","root","root");
		Statement stat = conn.createStatement();
		stat.executeUpdate("insert into StudentsQsp values(16,'Tushar','Tiwari','Java','2002-01-16','1')");
		stat.executeUpdate("insert into StudentsQsp values(11,'Suraj','Kumar','Selenium','1999-01-11','1*')");
		stat.executeUpdate("insert into StudentsQsp values(02,'Amrendra','Mishra','Manul Testing','1994-12-02','2')");
		stat.executeUpdate("insert into StudentsQsp values(01,'Saurabh','Srivastava','SQL','1992-10-01','1')");
		} finally {
			conn.close();

		}

	}

}
