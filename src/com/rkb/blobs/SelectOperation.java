package com.rkb.blobs;
import java.sql.*;
import java.io.*;
public class SelectOperation {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","802215");
		PreparedStatement pst = con.prepareStatement("SELECT * FROM persons");
		ResultSet rs = pst.executeQuery();
		FileOutputStream fos = new FileOutputStream("roushan_db.jpeg");
		while(rs.next()) {
			String name = rs.getString(1);
			InputStream is = rs.getBinaryStream(2);
			byte[] buffer = new byte[2048];
			while(is.read(buffer)>0) {
				fos.write(buffer);
			}
			fos.flush();
			System.out.println("image is available in : roushan_db.jpeg");
		}
		con.close();
	}
}
