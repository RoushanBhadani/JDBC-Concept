package com.rkb.select_operation;
import java.util.Scanner;
import java.sql.*;
public class Select01 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","802215");
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("SELECT * FROM university");
		System.out.println("sno\tsname\tscity\tsstate");
		while(rs.next()) {
			System.out.println(rs.getInt(1)+"\t"+rs.getNString(2)+"\t"+rs.getNString(3)+"\t"+rs.getNString(4));
		}
		con.close();
		st.close();
	}

}
