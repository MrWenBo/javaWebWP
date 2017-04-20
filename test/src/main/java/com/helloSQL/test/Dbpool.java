package com.helloSQL.test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.commons.dbcp.BasicDataSource;

public class Dbpool {
	
	public static BasicDataSource ds =null;
	
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/cloud_study";
	static final String USER = "root";
	static final String PASSWORD = "";
	
	public static void dbpoolInit() {
		
		ds = new BasicDataSource();
		ds.setUrl(DB_URL);
		ds.setDriverClassName(JDBC_DRIVER);
		ds.setUsername(USER);
		ds.setPassword(PASSWORD);
	}
	
	public void dbpool() {
		Connection connection = null;
		Statement statement =null;
		ResultSet resultSet = null;
		
		try {
			connection = ds.getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from user where Id='1'");
			System.out.println("Id=1");
			while (resultSet.next()) {
				System.out.println("ProductName:"+resultSet.getString("ProductName")+"\nInvertory:"+resultSet.getString("Invertory"));
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if (connection != null)
					connection.close();
				if (statement != null)
					statement.close();
				if (resultSet != null)
					resultSet.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		dbpoolInit();
		new Dbpool().dbpool();
	}
}
