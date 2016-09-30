package com.helloSQL.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

import org.apache.commons.dbcp.BasicDataSource;

public class Hello3 {

	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/cloud_study";
	static final String USER = "root";
	static final String PASSWORD = "";
	public static BasicDataSource dSource = null;

	public static void insertId (Set<String> Id) throws ClassNotFoundException {
		Connection connection = null;
		Statement statement = null;

		ResultSet resultSet = null;

		Class.forName(JDBC_DRIVER);
		try {
			connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
			statement = connection.createStatement();
			for (String id : Id) {
				statement.addBatch("insert into user(Id) values("+id+")");
			}
			statement.executeBatch();
			statement.clearBatch();

		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

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

	public static void main(String[] args) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		Set<String> Id = new HashSet<String>();
		Id.add("5");
		Id.add("6");
		insertId(Id);
	}

}
