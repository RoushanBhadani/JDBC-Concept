package com.rkb.aggregate_function;
import java.util.Scanner;
import java.sql.*;
public class Min {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","802215");
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("SELECT min(esal) FROM employees");
		if(rs.next()) {
			System.out.println("The minimum salaray is : "+rs.getDouble(1));
		}
		con.close();
		st.close();
	}

}
