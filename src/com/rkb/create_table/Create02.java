package com.rkb.create_table;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Create02 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","802215");
		Statement st = con.createStatement();
		st.executeUpdate("create table university(sno int, sname varchar(10), scity varchar(10), sstate varchar(10))");
		System.out.println("Table created successfully");
		con.close();
	}

}
