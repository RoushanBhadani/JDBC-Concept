package com.rkb.MetaData;

import java.sql.*;

public class ResultSetMetaData {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee?user=root&password=802215");
		java.sql.DatabaseMetaData dbmd = con.getMetaData();
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("select * from employees");
		java.sql.ResultSetMetaData rsmd =rs.getMetaData();
		System.out.println(rsmd.getColumnCount());
		System.out.println(rsmd.getColumnName(3));
		System.out.println(rsmd.getColumnType(1));
		
	}

}
