package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.testng.annotations.Test;
import com.mysql.jdbc.Driver;

public class JDBC_RetriveData {
	@Test
	public void retriveDataFromDataBase() throws SQLException
	{
		Connection conn = null;
		try {
		Driver driverRef = new Driver();
		DriverManager.registerDriver(driverRef);
		 conn = DriverManager.getConnection("jdbc:mysql://49.249.28.218:3333/qspider2024","root","root");
		Statement stat = conn.createStatement();
		ResultSet resultSet = stat.executeQuery("Select * from studentsqsp");
		while(resultSet.next())
		{
			System.out.println(resultSet.getString(1)+"\t"+resultSet.getString(2)+"\t"+resultSet.getString(3)+"\t"+resultSet.getString(4)+"\t"+resultSet.getString(5));
		}
		}
		catch (Exception e) {
			System.out.println("No DataBase Present");

		}
		finally {
			conn.close();
		}
	}
}
