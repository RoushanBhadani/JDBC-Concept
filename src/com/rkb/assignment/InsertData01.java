package com.rkb.assignment;
import java.sql.*;
import java.io.*;
import java.text.SimpleDateFormat;
public class InsertData01 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","802215");
		PreparedStatement pst = con.prepareStatement("INSERT INTO userinfo VALUES(?,?,?,?,?)");
		//insert name 
		String name = "Roushan";
		
		//insert date
		String dob = "02-09-2002";
		//convert dob into java.util.Date format
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		java.util.Date udate = sdf.parse(dob);
		//convert java.util.Date into java.sql.Date
		long l = udate.getTime();
		java.sql.Date sdate = new java.sql.Date(l);
		
		//insert city
		String city = "Gaya";
		
		//insert image
		File f1 = new File("roushan.jpeg");
		FileInputStream fis = new FileInputStream(f1);
		
		//insert text file
		File f2 = new File("roushan.pdf");
		FileReader fr = new FileReader(f2);
		
		pst.setString(1, name);
		pst.setDate(2, sdate);
		pst.setString(3, city);
		pst.setBinaryStream(4, fis);
		pst.setCharacterStream(5, fr);
		
		int updateCount = pst.executeUpdate();
		if(updateCount==0) {
			System.out.println("No Record Inserted");
		}else {
			System.out.println("Record Inserted");
		}
		con.close();
	}
}
