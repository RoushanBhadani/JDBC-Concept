package in.insert_operation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Insertion_01 {

	public static void main(String[] args) {
		Connection connection = null;
		Statement statement = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Registered");
			
			String url = "jdbc:mysql://localhost:3306/ipl";
			String username = "root";
			String password = "802215";
			connection = DriverManager.getConnection(url, username, password);
			System.out.println("Connection establish");
		
			
			String sqlqry = "insert into player(`name`,`jersy no`,`rr`)values('mahadev','01','500.00')";
			System.out.println(sqlqry);
			statement = connection.createStatement();
			
			int rowAffected = statement.executeUpdate(sqlqry);
			System.out.println("No. of Row affected is : "+rowAffected);

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				connection.close();
				statement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
