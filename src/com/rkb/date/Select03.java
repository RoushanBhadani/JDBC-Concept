package com.rkb.date;
import java.sql.*;
import java.text.SimpleDateFormat;
public class Select03 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","802215");
		PreparedStatement pst = con.prepareStatement("SELECT * FROM user");
		ResultSet rs = pst.executeQuery();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MMMM-yyyy");
		while(rs.next()) {
			String name = rs.getString(1);
			java.sql.Date sdate = rs.getDate(2);
			String s = sdf.format(sdate);
			System.out.println(name+"------"+s);
		}
		con.close();
	}

}
