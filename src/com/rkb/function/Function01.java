package com.rkb.function;
import java.sql.*;

public class Function01 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost/employee","root","802215");
		CallableStatement cst = con.prepareCall("{?=call getAvg(?,?)}");
		cst.setInt(2, 1001);
		cst.setInt(3, 1002);
		cst.registerOutParameter(1, Types.FLOAT);
		cst.execute();
		System.out.println("Average Salary is : "+cst.getFloat(1));
		con.close();
	}

}
