package com.rkb.blobs;
import java.sql.*;
import java.io.*;
public class DeleteTable {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","802215");
		PreparedStatement pst = con.prepareStatement("DROP TABLE persons");
		pst.executeUpdate();
		System.out.println("Table Deleted");
	}
}
