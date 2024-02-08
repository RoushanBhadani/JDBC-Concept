package com.rkb.date;
import java.sql.*;
import java.text.SimpleDateFormat;
public class Select01 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","802215");
		PreparedStatement pst = con.prepareStatement("SELECT * FROM user");
		ResultSet rs = pst.executeQuery();
		while(rs.next()) {
			System.out.println(rs.getString(1)+"------"+rs.getDate(2));
		}
		con.close();
	}
}
//it will print in the format of (yyyy-mm-dd);