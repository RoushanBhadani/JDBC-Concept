package com.rkb.collableStatement;

import java.sql.*;

public class Procedure3 {
	public static void main(String[] args) throws Exception {
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","802215");
		CallableStatement cst = con.prepareCall("{call getEmp(?,?,?)}");
		cst.setInt(1,1001);
		cst.registerOutParameter(2, Types.VARCHAR);
		cst.registerOutParameter(3, Types.DOUBLE);
		cst.execute();
		System.out.println("Employee Name : "+cst.getString(2));
		System.out.println("Employee Salary : "+cst.getDouble(3));
		con.close();
	}
}
