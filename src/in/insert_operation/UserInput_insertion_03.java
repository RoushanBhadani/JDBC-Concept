package in.insert_operation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class UserInput_insertion_03 {

	public static void main(String[] args) {
		Connection connection = null;
		Statement statement = null;
		Scanner  sc=null;
		String Name=null;
		int num=0;
		float rr=1.0f;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Registered");
			
			String url = "jdbc:mysql://localhost:3306/ipl";
			String username = "root";
			String password = "802215";
			connection = DriverManager.getConnection(url, username, password);
			System.out.println("Connection establish");
			sc=new Scanner(System.in);
			if(sc!=null)
			{
				System.out.println("Enter name");
				Name=sc.nextLine();
				System.out.println("Enter jursy no");
				num=sc.nextInt();
				System.out.println("Enter run rate");
				rr=sc.nextFloat();
			}
		
			
			String sqlqry = "insert into player(`name`,`jersy no`,`rr`)values('"+Name+"','"+num+"','"+rr+"')";
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
