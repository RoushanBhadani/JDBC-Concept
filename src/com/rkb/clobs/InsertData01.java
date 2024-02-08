package com.rkb.clobs;
import java.sql.*;
import java.io.*;
public class InsertData01 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","802215");
		PreparedStatement pst = con.prepareStatement("INSERT INTO jobdata VALUES(?,?)");
		pst.setNString(1, "Roushan");
		File f = new File("roushan.pdf");
		FileReader fr = new FileReader(f);
		pst.setCharacterStream(2, fr);
		System.out.println("File is in : "+f.getAbsolutePath());
		int updateCount = pst.executeUpdate();
		if(updateCount == 0) {
			System.out.println("No record inserted");
		}else {
			System.out.println("Record Inserted");
		}
		con.close();
	}

}
