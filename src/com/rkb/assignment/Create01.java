package com.rkb.assignment;
import java.sql.*;
import java.io.*;
public class Create01 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","802215");
		PreparedStatement pst = con.prepareStatement("CREATE TABLE userinfo(name VARCHAR(20), dob DATE, city VARCHAR(20), image LONGBLOB, resume LONGTEXT)");
		pst.executeUpdate();
		System.out.println("Table Created");
		con.close();
	}

}
