package in.select_opertion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Fetching_data_01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection connection = null;
		Statement statement = null;
		ResultSet resultset = null;
		try {
			
			//STEP:1- Load and register the driver.
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Registered successful");
			
			//STEP:2-Establish connection
			String url ="jdbc:mysql://:3306/student";
			String username = "root";
			String password = "802215";
			
			connection = DriverManager.getConnection(url, username, password);
			System.out.println("Connection successful");
			
			//STEP:3- create statement
			String mysqlquery = "select * from finalyear";
			statement = connection.createStatement();
			resultset = statement.executeQuery(mysqlquery);
			System.out.println("statement created");
			System.out.println("sid\tsname\tsbranch\tsaddress\tsnumber");

			while(resultset.next()) {
				Integer sid = resultset.getInt(1);
				String sname = resultset.getString(2);
				String sbranch = resultset.getString(3);
				String saddress = resultset.getString(4);
				Long snumber = resultset.getLong(5);
				System.out.println(sid+"\t"+sname+"\t"+sbranch+"\t"+saddress+"\t"+snumber);
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
				e.printStackTrace();
			}
		}
	}
}
