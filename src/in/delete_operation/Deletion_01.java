package in.delete_operation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Deletion_01 {

	public static void main(String[] args) {
		Connection connection = null;
		Statement statement = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String url = "jdbc:mysql://localhost:3306/irctc";
			String username = "root";
			String password = "802215";
	
			connection = DriverManager.getConnection(url,username,password);
			System.out.println(connection.getClass().getName());
			
			String deletequery = "delete from war where id = 1";
			statement = connection.createStatement();
			
			int rowAffected = statement.executeUpdate(deletequery);
			
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
