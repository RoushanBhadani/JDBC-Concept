package com.rkb.MetaData;

import java.sql.*;

public class DatabaseMetaData {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
//		three type of metadata in jdbc
//		1. DatabaseMataData
//		2. ResultSetMetaData
//		3. ParameterMetaData
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee?user=root&password=802215");
		java.sql.DatabaseMetaData dbmd = con.getMetaData();
		System.out.println(dbmd.getDatabaseProductName());
		System.out.println(dbmd.getDatabaseProductVersion());
		System.out.println(dbmd.getDatabaseMajorVersion());
		System.out.println(dbmd.getDatabaseMinorVersion());
		System.out.println(dbmd.getJDBCMajorVersion());
		System.out.println(dbmd.getJDBCMinorVersion());
		System.out.println(dbmd.getDriverName());
		System.out.println(dbmd.getDriverVersion());
		System.out.println(dbmd.getURL());
		System.out.println(dbmd.getUserName());
		System.out.println(dbmd.getMaxColumnNameLength());
	}

}
