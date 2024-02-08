package com.rkb.select_operation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Select03 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","802215");
		Statement st = con.createStatement();
		
		//order is depend on the resultset not on database.
		
		ResultSet rs = st.executeQuery("SELECT sname,sno,sstate,scity FROM university");
		boolean flag = false;
		System.out.println("sname\tsno\tsstate\tscity");
		while(rs.next()) {
			flag = true;
			System.out.println(rs.getNString(1)+"\t"+rs.getInt(2)+"\t"+rs.getNString(3)+"\t"+rs.getNString(4));
		}
		if(flag == false) {
			System.out.println("NO RECORDS FOUND");
		}
		con.close();
		st.close();
	}
}
