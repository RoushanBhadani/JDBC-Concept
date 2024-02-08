package com.rkb.create_table;
import java.sql.*;
public class Create01 {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		String url = "jdbc:mysql://localhost:3306/employee";
		String username = "root";
		String password = "802215";
		Connection con = DriverManager.getConnection(url, username, password);
		Statement st = con.createStatement();
		st.executeUpdate("create table employees(eno int,ename varchar(10),esal decimal(10,2),eaddr varchar(10))");
		System.out.println("Table created successfully");
	}
}
