package com.rkb.date;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Scanner;
public class Insert1 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","802215");
		PreparedStatement pst = con.prepareStatement("insert into user values(?,?)");
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Name : ");
		String name = sc.next();
		System.out.println("Enter Date of Birth(dd-mm-yyyy) : ");
		String dob = sc.next();
		
		//String dob convert in java.util.Date format
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		java.util.Date udate = sdf.parse(dob);
		
		//java.util.Date converts into java.sql.Date format
		long l = udate.getTime();
		java.sql.Date sdate = new java.sql.Date(l);
		
		//
		pst.setString(1, name);
		pst.setDate(2, sdate);
		
		pst.executeUpdate();
		System.out.println("Record Inserted");
		
	}

}
