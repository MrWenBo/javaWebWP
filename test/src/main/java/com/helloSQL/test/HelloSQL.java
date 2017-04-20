package com.helloSQL.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class HelloSQL {

	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static String DB_URL = "jdbc:mysql://localhost/cloud_study";
	static final String USER = "root";
	static final String PASSWORD = "";

	public static void helloword() throws ClassNotFoundException {
		Connection connection = null;
		Statement statement = null;
		PreparedStatement preparedStatement=null;
		ResultSet resultSet = null;

		Class.forName(JDBC_DRIVER);
		try {
			DB_URL = DB_URL + "?useCursorFetch=true";
			connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
			
			preparedStatement = connection.prepareStatement("select * from user where Id='1'");
			System.out.println("Id=1");
			preparedStatement.setFetchSize(1);
			resultSet = preparedStatement.executeQuery();
			
			//statement = connection.createStatement();
			//resultSet = statement.executeQuery("select * from user");
			//resultSet = statement.executeQuery("select Id=1 form user");
			//System.out.println(resultSet.getString("ProductName") + resultSet.getInt("Invertory"));
			/*resultSet = statement.executeQuery("select Id from user");
			while (resultSet.next()) {
				System.out.println("Hello"+resultSet.getString("Id"));
			}*/
			//resultSet = statement.executeQuery("select * from user where Id='1'");
			while (resultSet.next()) {
				System.out.println("ProductName:"+resultSet.getString("ProductName")+"\nInvertory:"+resultSet.getString("Invertory"));
				}
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
		helloword();
	}
	
	public static void getStudent(String name) throws ClassNotFoundException {
	    Connection conn = null;
	    PreparedStatement preparedStatement = null;
	    ResultSet rs = null;
	    try {
	      Class.forName(JDBC_DRIVER);
	      conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
	      preparedStatement = conn.prepareStatement("select name,score from student where name = ?");
	      preparedStatement.setString(1, name);
	      
	      rs = preparedStatement.executeQuery();
	      
	      while (rs.next()) {
	        System.out.println(rs.getString("name") + ":" + rs.getInt("score"));
	      }
	    } catch (SQLException e) {
	      // ignore
	    } finally {
	      if (rs != null) {
	        try {
	          rs.close();
	        } catch (Exception e) {
	          // ignore
	        }
	      }
	      if (preparedStatement != null) {
	        try {
	          preparedStatement.close();
	        } catch (Exception e) {
	          // ignore
	        }
	      }
	      if (conn != null) {
	        try {
	          conn.close();
	        } catch (SQLException e) {
	          // ignore
	        }
	      }
	    }
	  }

}
