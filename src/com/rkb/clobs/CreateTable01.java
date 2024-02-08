package com.rkb.clobs;
import java.sql.*;
public class CreateTable01 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost/employee","root","802215");
		PreparedStatement pst = con.prepareStatement("CREATE TABLE jobdata(name VARCHAR(20), resume LONGTEXT)");
		pst.executeUpdate();
		System.out.println("Table Created");
		con.close();
	}

}
