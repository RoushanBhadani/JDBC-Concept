package in.insert_operation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Insertion_02 {

	public static void main(String[] args) {
		Connection connection = null;
		Statement statement = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Registered");
			
			
			String url = "jdbc:mysql://localhost:3306/irctc";
			String username = "root";
			String password = "802215";
			
			connection = DriverManager.getConnection(url,username,password);
		
			System.out.println(connection.getClass().getName());
			
			
			String query = "insert into war(`firstname`,`lastname`)values('ajay','kumar')";
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
