package in.select_opertion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Fetching_data_03 {

	public static void main(String[] args) {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultset = null;
		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String url = "jdbc:mysql://:3306/irctc";
			String username = "root";
			String password = "802215";
			
			connection = DriverManager.getConnection(url, username, password);
			String query = "select id,firstname,lastname from war";
			statement = connection.createStatement();
			resultset = statement.executeQuery(query);
			
			while(resultset.next()) {
				Integer id = resultset.getInt("id");
				String firstname = resultset.getNString("firstname");
				String lastname = resultset.getNString("lastname");
				System.out.println(id+"\t"+firstname+"\t"+lastname);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
