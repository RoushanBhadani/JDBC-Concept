package com.rkb.collableStatement;
import java.sql.*;
import java.util.Scanner;
public class DynamicInputProcedure01 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","802215");
		CallableStatement cst = con.prepareCall("{call sumNumber(?,?,?)}");
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter first Number : ");
		int a = sc.nextInt();
		System.out.println("Enter second Number :");
		int b = sc.nextInt();
		cst.setInt(1,a);
		cst.setInt(2, b);
		cst.registerOutParameter(3, Types.INTEGER);
		cst.execute();
		int result = cst.getInt(3);
		System.out.println("Sum of the number is : "+result);
		con.close();
	}
}
