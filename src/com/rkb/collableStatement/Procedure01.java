package com.rkb.collableStatement;
import java.sql.*;
public class Procedure01 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","802215");
		CallableStatement cst = con.prepareCall("{call sumNumber(?,?,?)}");
		cst.setInt(1, 100);
		cst.setInt(2, 200);
		cst.registerOutParameter(3, Types.INTEGER);
		cst.execute();
		int result = cst.getInt(3);
		System.out.println("Answer : "+result);
		con.close();
	}

}
