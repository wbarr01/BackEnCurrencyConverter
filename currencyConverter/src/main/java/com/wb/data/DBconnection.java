package com.wb.data;
import java.sql.Connection;
import java.sql.DriverManager;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class DBconnection {

	 
	public static Properties loadPropertiesFile() throws Exception {

		Properties prop = new Properties();
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		InputStream in = classLoader.getResourceAsStream("jdbc.properties");
		prop.load(in);
		in.close();
		return prop;
	}
	public Connection getConnection() throws Exception
	{
		try
		{
			Properties prop = loadPropertiesFile();
			
			String driverClass = prop.getProperty("MYSQLJDBC.driver");
			String url = prop.getProperty("MYSQLJDBC.url");
			String username = prop.getProperty("MYSQLJDBC.username");
			String password = prop.getProperty("MYSQLJDBC.password");
			
			String connectionURL = url+"?serverTimezone=UTC";
			Connection connection = null;
			Class.forName(driverClass).newInstance();
			connection = DriverManager.getConnection(connectionURL,username, password);
			return connection;
		} catch (Exception e)
		{
		throw e;
		}
	}
	 
	
}
