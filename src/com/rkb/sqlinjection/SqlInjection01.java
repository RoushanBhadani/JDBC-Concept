package com.rkb.sqlinjection;
import java.util.Scanner;
import java.sql.*;
public class SqlInjection01 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","802215");
		Statement st = con.createStatement();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter username:");
		String un = sc.next();
		System.out.println("Enter password:");
		String pass = sc.next();
		String sqlQuery = "select count(*) from logindata where username='"+un+"' and password = '"+pass+"'";
		ResultSet rs = st.executeQuery(sqlQuery);
		int c=0;
		if(rs.next()) {
			c=rs.getInt(1);
		}
		if(c==0) {
			System.out.println("Invalid credential");
		}else {
			System.out.println("Valid credential");
		}
		con.close();
	}
}