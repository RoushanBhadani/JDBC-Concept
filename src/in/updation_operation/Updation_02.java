package in.updation_operation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Updation_02 {

	public static void main(String[] args) {
		Connection connection = null;
		Statement statement = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String url = "jdbc:mysql://localhost:3306/irctc";
			String username = "root";
			String password = "802215";
			
			connection = DriverManager.getConnection(url,username,password);
	
			String query = "update war set firstname='dhoni' where id=2";
			
			statement = connection.createStatement();
			int rowAffected = statement.executeUpdate(query);
			
			System.out.println("No. of row affected : "+rowAffected);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		finally {
			try {
				connection.close();
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
	}

}
