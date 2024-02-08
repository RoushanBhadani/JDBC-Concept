package com.rkb.collableStatement;
import java.sql.*;
public class Procedure02 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","802215");
		CallableStatement cst = con.prepareCall("{call squareNumber(?,?)}");
		cst.setInt(1, 5);
		cst.registerOutParameter(2, Types.INTEGER);
		cst.execute();
		int result = cst.getInt(2);
		System.out.println("Square of the number is : "+result);
		con.close();

	}

}
