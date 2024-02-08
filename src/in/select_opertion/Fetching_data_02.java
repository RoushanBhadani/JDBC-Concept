package in.select_opertion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Fetching_data_02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection connection = null;
		Statement statement = null;
		ResultSet resultset = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String url = "jdbc:mysql://localhost:3306/nasha mukti kendra";
			String username = "root";
			String password = "802215";
			
			connection = DriverManager.getConnection(url, username, password);
			
			String sqlquery = "select * from Punjab";
			
			statement = connection.createStatement();
			resultset = statement.executeQuery(sqlquery);
			
			while(resultset.next()) {
				Integer id = resultset.getInt(1);
				String name = resultset.getString(2);
				String distric = resultset.getNString(3);
				Long number = resultset.getLong(4);
				System.out.println(id+"\t"+name+"\t"+distric+"\t"+number);
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		finally {
			try {
				connection.close();
				statement.close();
				resultset.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
}
