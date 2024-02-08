package in.select_opertion;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
public class Fetching_data_04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection connection = null;
		Statement statement = null;
		ResultSet resultset = null;
		
		try {
//			String url = "jdbc:mysql://:3306//irctc";
//			String username = "root";
//			String password = "802215";
//			connection = DriverManager.getConnection(url, username, password);
			String url = "jdbc:mysql://:3306/irctc";
			String username = "root";
			String password = "802215";
			
			connection = DriverManager.getConnection(url, username, password);
			System.out.println("Connection created");
			
			String qey = "Select id,name,age,address,state from rajdhani";
			statement = connection.createStatement();
			resultset = statement.executeQuery(qey);
			while(resultset.next()) {
				Integer id = resultset.getInt("id");
				String name = resultset.getString("name");
				Integer age = resultset.getInt("age");
				String address = resultset.getString("address");
				String state = resultset.getString("state");
				System.out.println(id+"\t"+name+"\t"+age+"\t"+address+"\t"+state);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		finally {
			try {
				connection.close();
				statement.close();
				resultset.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
	}

}
