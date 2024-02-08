package com.rkb.blobs;
import java.sql.*;
import java.io.*;
public class CreatetableImage01 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","802215");
		PreparedStatement pst = con.prepareStatement("CREATE TABLE persons(Name varchar(20), Image LONGBLOB)");
		pst.executeUpdate();
		System.out.println("Table Created");
	}
}
