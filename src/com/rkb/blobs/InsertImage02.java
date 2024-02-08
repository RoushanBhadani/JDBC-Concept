package com.rkb.blobs;
import java.sql.*;
import java.io.*;
public class InsertImage02 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","802215");
		PreparedStatement pst = con.prepareStatement("INSERT INTO persons VALUES(?,?)");
		pst.setString(1, "Komal");
		File f = new File("komal_picture.jpeg");
		FileInputStream fis = new FileInputStream(f);
		pst.setBinaryStream(2, fis);
		System.out.println("Image Path is : "+ f.getAbsolutePath());
		int updateCount = pst.executeUpdate();
		if(updateCount == 0) {
			System.out.println("Image Not Inserted");
		}else {
			System.out.println("Image Inserted");
		}
		con.close();
	}

}
