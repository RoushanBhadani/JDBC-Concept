package com.rkb.aggregate_function;
import java.util.Scanner;
import java.sql.*;
public class CountRow {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","802215");
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("SELECT COUNT(*) FROM employees");
		if(rs.next()) {
			System.out.println("The no. of employees : "+rs.getInt(1));
		}
		con.close();
		st.close();
	}

}
