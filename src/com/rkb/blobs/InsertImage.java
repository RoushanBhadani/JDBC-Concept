package com.rkb.blobs;
import java.sql.*;
import java.io.*;
public class InsertImage {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","802215");
		PreparedStatement pst = con.prepareStatement("INSERT INTO persons VALUES(?,?)");
		pst.setString(1, "Roushan");
		File f = new File("roushan.jpeg");
		FileInputStream fis = new FileInputStream(f);
		pst.setBinaryStream(2, fis);
		System.out.println("inserting image from : "+f.getAbsolutePath());
		int updateCount = pst.executeUpdate();
		if(updateCount == 0) {
			System.out.println("Record not Inserted");
		}else {
			System.out.println("Record Inserted");
		}
		con.close();
	}
}
