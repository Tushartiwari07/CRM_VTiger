package com.tek.crm.databaseutility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class DataBaseUtility {
	Connection conn;
	public void getDataBaseConnection(String dataBaseName,String userName,String password)
	{
		try {
			Driver driver = new Driver();
			DriverManager.registerDriver(driver);
			conn=DriverManager.getConnection("jdbc:mysql://49.249.28.218:3333/"+dataBaseName, userName, password);
		}catch (Exception e) {		}
		
//		jdbc:mysql://49.249.28.218:3333/
	}
	public int executeNonSelectQuery(String query) throws SQLException
	{
		int result = 0;
		try {
			Statement stat = conn.createStatement();
			result=stat.executeUpdate(query);
		} catch (Exception e) {
		}
		return result;
	}
	public ResultSet executeSelectQuery(String query) throws SQLException
	{
		ResultSet value = null ;
		try {
			Statement stat = conn.createStatement();
			value=stat.executeQuery(query);
		} catch (Exception e) {
		}
		return value;
	}
	public void closeDataBaseConnection() throws SQLException
	{
		conn.close();
	}

	
}
