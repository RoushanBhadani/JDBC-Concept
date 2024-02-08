package in.delete_operation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Deletion_2 {

	public static void main(String[] args) {
		Connection connection = null;
		PreparedStatement pstm = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String url = "jdbc:mysql://localhost:3306/irctc";
			String username = "root";
			String password = "802215";
	
			connection = DriverManager.getConnection(url,username,password);
			System.out.println(connection.getClass().getName());
			
			String deletequery = "delete from war where id = ?";
			pstm = connection.prepareStatement(deletequery );
			System.out.println("INSET");
			pstm.setInt(1,2);
			
			
		     int rowcount=pstm.executeUpdate();
		   System.out.println(rowcount);
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				connection.close();
				pstm.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

}
