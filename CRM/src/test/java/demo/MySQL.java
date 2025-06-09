package demo;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.tek.crm.databaseutility.DataBaseUtility;

public class MySQL {
	public static void main(String[] args) throws SQLException {
		DataBaseUtility dlib= new DataBaseUtility();

		try {
              dlib= new DataBaseUtility();
		dlib.getDataBaseConnection("tekgorilla", "root", "root");
		ResultSet resultSet = dlib.executeSelectQuery("Select * from cricket;");
		while(resultSet.next())
		  {
			System.out.println(resultSet.getString(1)+"\t"+resultSet.getString(2)+"\t"+resultSet.getString(3)+"\t"+resultSet.getString(4)+"\t"+resultSet.getString(5)+"\t"+resultSet.getString(6));
		  }
		}
		catch (Exception e) {
			System.out.println("WrongDataBase name");
		}
		finally {
			dlib.closeDataBaseConnection();
		}
		
	}
	

}
