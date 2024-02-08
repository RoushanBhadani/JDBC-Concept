package com.rkb.assignment;
import java.sql.*;
public class DeleteTable {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","802215");
		PreparedStatement pst = con.prepareStatement("DROP TABLE userinfo");
		pst.executeUpdate();
		System.out.println("table deleted");
	}

}
