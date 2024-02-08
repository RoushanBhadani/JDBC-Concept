package com.rkb.collableStatement;

import java.sql.*;
import java.util.Scanner;

public class DynamicInputProcedure02 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","802215");
		CallableStatement cst = con.prepareCall("{call getEmp(?,?,?)}");
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter id number : ");
		int id = sc.nextInt();
		cst.setInt(1,id);
		cst.registerOutParameter(2, Types.VARCHAR);
		cst.registerOutParameter(3, Types.DOUBLE);
		cst.execute();
		
		if(cst.getString(2)==null && cst.getDouble(3)==0) {
			System.out.println("Employee not exist------");
		}else {
			System.out.println("Employee Name : "+cst.getString(2));
			System.out.println("Employee Salary : "+cst.getDouble(3));
		}
		con.close();
	}

}
