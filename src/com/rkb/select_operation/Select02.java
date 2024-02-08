package com.rkb.select_operation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Select02 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","802215");
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("SELECT * FROM university");
		boolean flag = false;
		System.out.println("sno\tsname\tscity\tsstate");
		while(rs.next()) {
			flag = true;
			System.out.println(rs.getInt(1)+"\t"+rs.getNString(2)+"\t"+rs.getNString(3)+"\t"+rs.getNString(4));
		}
		if(flag == false) {
			System.out.println("NO RECORDS FOUND");
		}
		con.close();
		st.close();
	}

}
