package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtils 
{
	public static Connection connection;
	
	public static Connection openConnection() throws SQLException
	{
		String url = "jdbc:mysql://localhost:3306/advjava?createDatabaseI"
				+ "fNotExist=true&useSSL=false&allowPublicKeyRetrieval=true";
		connection = DriverManager.getConnection(url, "username", "password");
		
		return connection;
	}
	public static void closeConnection() throws SQLException
	{
		if(connection != null)
		{
			connection.close();
		}
	}
}
