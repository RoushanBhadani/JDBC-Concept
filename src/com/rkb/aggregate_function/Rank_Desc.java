package com.rkb.aggregate_function;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Rank_Desc {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","802215");
		Statement st = con.createStatement();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Number: ");
		int n = sc.nextInt();
		String sqlQuery = "SELECT * FROM (SELECT eno, ename, esal, eaddr, RANK() OVER (ORDER BY esal DESC) as ranking FROM employees) AS ranked_employees WHERE ranking = " + n;
		ResultSet rs = st.executeQuery(sqlQuery);
		
		while(rs.next()) {
			System.out.println(rs.getInt(1)+"\t"+rs.getNString(2)+"\t"+rs.getDouble(3)+"\t"+rs.getNString(4));
		}
		con.close();
		st.close();
	}

}
