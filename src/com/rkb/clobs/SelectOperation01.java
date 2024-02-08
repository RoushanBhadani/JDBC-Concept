package com.rkb.clobs;
import java.sql.*;
import java.io.*;
public class SelectOperation01 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","802215");
		PreparedStatement pst = con.prepareStatement("SELECT * FROM jobdata");
		ResultSet rs = pst.executeQuery();
		FileWriter fw = new FileWriter("resume.pdf");
		if(rs.next()) {
			String name = rs.getNString(1);
			Reader r = rs.getCharacterStream(2);

			char[] buffer = new char[1024];
			while(r.read(buffer)>0) {
				fw.write(buffer);
			}
			
			int i = r.read();
			while(i != -1) {
				fw.write(i);
				i=r.read();
			}
			fw.flush();
			System.out.println(name+"------"+"Data retrived");
		}
		con.close();
	}

}
