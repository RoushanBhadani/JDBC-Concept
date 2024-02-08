package com.rkb.connectionPooling;
import java.sql.*;
import javax.sql.*;
import com.mysql.cj.jdbc.MysqlConnectionPoolDataSource;
public class ConnectionPoolingSql {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		MysqlConnectionPoolDataSource ds = new MysqlConnectionPoolDataSource();
		ds.setURL("jdbc:mysql://localhost:3306/employee");
		ds.setUser("root");
		ds.setPassword("802215");
		
		Connection con = ds.getConnection();
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("SELECT * FROM employees");
		while(rs.next()) {
			System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getDouble(3)+" "+rs.getString(4));
		}
		con.close();
	}

}
