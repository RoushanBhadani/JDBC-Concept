package com.rkb.Properties;
import java.util.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.io.*;
public class Properties03 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee?user=root&password=802215");
		PreparedStatement pst = con.prepareStatement("select * from user");
		ResultSet rs = pst.executeQuery();
		SimpleDateFormat sdf = new SimpleDateFormat();
		while(rs.next()) {
			String name = rs.getString(1);
			java.sql.Date sdate = rs.getDate(2);
			String s = sdf.format(sdate);
			System.out.println(name+" "+s);
		}
		con.close();
	}
}