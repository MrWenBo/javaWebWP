package com.helloSQL.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;

import org.apache.commons.dbcp.BasicDataSource;

public class Sw {
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static String DB_URL = "jdbc:mysql://localhost/cloud_study";
	static final String USER = "root";
	static final String PASSWORD = "";
	public static BasicDataSource ds = null;

	public static void dbpoolInit() {

		ds = new BasicDataSource();
		ds.setUrl(DB_URL);
		ds.setDriverClassName(JDBC_DRIVER);
		ds.setUsername(USER);
		ds.setPassword(PASSWORD);
	}

	private static void buy(String buyer, String productName) throws ClassNotFoundException {
		Connection conn = null;
		PreparedStatement ptmt = null;
		Statement statement = null;
		// Savepoint savepoint = null;
		ResultSet resultSet = null;
		int temp = 0;

		try {

			conn = ds.getConnection();
			conn.setAutoCommit(false);
			resultSet = statement.executeQuery("select * from inventory where ProductName='"+productName+"'");
			
			while (resultSet.next()) {
				temp = resultSet.getInt("Invertory");
				System.out.println(resultSet.getString("Invertory"));
				}

			ptmt = conn.prepareStatement("update inventory set Invertory=? where ProductName = ?");
			ptmt.setString(2, productName);
			ptmt.setInt(1, temp-1);
			ptmt.execute();
			ptmt = conn.prepareStatement("insert into Order("+buyer+","+productName+") values(?,?)");
			ptmt.setString(2, productName);
			ptmt.setString(1, buyer);
			ptmt.execute();

			// conn.setSavepoint();

			conn.commit();
		} catch (SQLException e) {
			if (conn != null) {
				try {
					conn.rollback();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		} finally {
			try {
				if (conn != null)
					conn.close();
				if (ptmt != null)
					ptmt.close();
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
		String Xiaoming = null;
		String bag = null;
		dbpoolInit();
		buy(Xiaoming,bag);
	}

}
