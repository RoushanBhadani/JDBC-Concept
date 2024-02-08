package com.rkb.Properties;
import java.sql.*;
import java.util.*;
import java.io.*;
public class Properties01 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Properties p = new Properties();
		FileInputStream fis = new FileInputStream("db.properties");
		p.load(fis);
		String url = p.getProperty("url");
		String user = p.getProperty("user");
		String pwd = p.getProperty("password");
		Connection con = DriverManager.getConnection(url,user,pwd);
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("select * from university");
		while(rs.next()) {
			System.out.println(rs.getInt(1)+" "+rs.getNString(2)+" "+rs.getNString(3)+" "+rs.getNString(4));
		}
		con.close();
	}
}