package com.rkb.transaction;
import java.sql.*;
public class CreateTable {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee?user=root&password=802215");
		PreparedStatement pst = con.prepareStatement("CREATE TABLE usertransaction(name varchar(20),balance int)");
		pst.executeUpdate();
		System.out.println("Table created");
		con.close();
	}

}
