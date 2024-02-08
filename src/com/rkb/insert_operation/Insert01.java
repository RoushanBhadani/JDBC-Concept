package com.rkb.insert_operation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Insert01 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","802215");
		Statement st = con.createStatement();
		int rowAffected = st.executeUpdate("insert into employees(`eno`,`ename`,`esal`,`eaddr`)values('1001','roushan','12000.00','Bihar')");
		System.out.println("No. of row affected is : "+ rowAffected);
		con.close();
	}
}
