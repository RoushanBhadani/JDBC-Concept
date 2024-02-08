package in.insert_operation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class UserInput_insertion_04 {

	public static void main(String[] args) {
		Connection connection = null;
		Statement statement = null;
		Scanner sc = null;
		String Name = null;
		int age = 0;
		String add = null;
		String st = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String url = "jdbc:mysql://localhost:3306/irctc";
			String username = "root";
			String password = "802215";
			
			connection = DriverManager.getConnection(url, username, password);
			System.out.println("connection establish");
			sc = new Scanner(System.in);
			if(sc!=null) {
				System.out.print("Enter Name : ");
				Name=sc.nextLine();
				System.out.print("Enter age : ");
				age=sc.nextInt();
				System.out.print("Enter address : ");
				add = sc.nextLine();
				System.out.print("Enter state : ");
				st = sc.nextLine();
			}
			
			String query = "insert into rajdhani(`name`,`age`,`address`,`state`)values('"+Name+"','"+age+"','"+add+"','"+st+"')";
			System.out.println(query);
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
				sc.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		

	}

}
