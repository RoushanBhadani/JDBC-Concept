package com.rkb.delete_operation;

import java.sql.*;
import java.util.Scanner;
public class Delete01 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","802215");
		Statement st = con.createStatement();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter cutoff salary : ");
		double cutoff = sc.nextDouble();
		String sqlQuery = String.format("DELETE FROM employees WHERE esal>=%f",cutoff);
		int updaterow = st.executeUpdate(sqlQuery);
		System.out.println("The number of row deleted : "+updaterow);
		con.close();
		st.close();
	}

}
