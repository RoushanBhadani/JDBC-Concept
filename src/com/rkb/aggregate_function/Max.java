package com.rkb.aggregate_function;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Max {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","802215");
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("SELECT ename from employees where esal = (select max(esal) from employees)");
		if(rs.next()) {
			System.out.println("The maximum salaray is : "+rs.getString(1));
		}
		con.close();
		st.close();
	}
}
