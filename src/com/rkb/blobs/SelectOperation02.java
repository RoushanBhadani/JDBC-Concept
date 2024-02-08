package com.rkb.blobs;
import java.sql.*;
import java.io.*;
public class SelectOperation02 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost/employee","root","802215");
		PreparedStatement pst = con.prepareStatement("select * from persons where name='Komal'");
		ResultSet rs = pst.executeQuery();
		FileOutputStream fos = new FileOutputStream("komal_db.jpeg");
		while(rs.next()) {
			String name = rs.getNString(1);
			InputStream is = rs.getBinaryStream(2);
			byte[] buffer = new byte[2048];
			while(is.read(buffer)>0) {
				fos.write(buffer);
			}
			fos.flush();
			System.out.println(name+"------"+"image is available in : komal_db.jpeg");
		}
		con.close();
	}

}
