package in.updation_operation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class UserInput_Updation_03 {

	public static void main(String[] args) {
		Connection connection = null;
		Statement statement = null;
		Scanner sc = new Scanner(System.in);
		String name = null;
		try {
			
			String url = "jdbc:mysql://:3306/ipl";
			String username = "root";
			String password = "802215";
			connection = DriverManager.getConnection(url,username,password);
			
			if(sc!=null) {
				System.out.print("Enter name : ");
				name = sc.nextLine();
			}
			
			String query = "update player set name='"+name+"' where id = 1";
			
			statement = connection.createStatement();
			
			int rowAffected = statement.executeUpdate(query);
			System.out.println("No. of row affected : "+rowAffected);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				connection.close();
				statement.close();
				sc.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
