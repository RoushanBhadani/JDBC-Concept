package com.rkb.Properties;
import java.util.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.io.*;
public class Properties02 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Properties p = new Properties();
		FileInputStream fis = new FileInputStream("db2.properties");
		p.load(fis);
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee",p);
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("Select * from user");
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		while(rs.next()) {
			String name = rs.getNString(1);
			java.sql.Date sdate = rs.getDate(2);
			String s = sdf.format(sdate);
			System.out.println(name+" "+s);
		}
		con.close();
	}
}
