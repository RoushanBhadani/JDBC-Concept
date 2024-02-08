package com.rkb.assignment;
import java.sql.*;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Scanner;
public class DynamicInsertion {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","802215");
		PreparedStatement pst = con.prepareStatement("INSERT INTO userinfo VALUES(?,?,?,?,?)");
		Scanner sc = new Scanner(System.in);
		while(true) {
		System.out.println("Enter name : ");
		String name = sc.next();
		System.out.println("Enter dob(dd-mm-yyyy) : ");
		String dob = sc.next();
		System.out.println("Enter city : ");
		String city = sc.next();
		System.out.println("Upload image(abc.jpeg) : ");
		String img = sc.next();
		System.out.println("Upload resume(resume.pdf) : ");
		String resume = sc.next();
		
		//date convert into java.util.Date format
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		java.util.Date udate = sdf.parse(dob);
		//java.util.Date into java.sql.Date
		long l = udate.getTime();
		java.sql.Date sdate = new java.sql.Date(l);
		
		//insert image 
		File f1 = new File(img);
		FileInputStream fis = new FileInputStream(f1);
		
		//insert text file
		File f2 = new File(resume);
		FileReader fr = new FileReader(f2);
		
		pst.setString(1, name);
		pst.setDate(2, sdate);
		pst.setString(3, city);
		pst.setBinaryStream(4, fis);
		pst.setCharacterStream(5, fr);
		pst.executeUpdate();
		System.out.println("Record Inserted");
		System.out.println("Do you want to insert more Record[yes/no] : ");
		String option = sc.next();
		if(option.equalsIgnoreCase("no")) {
			break;
		}
		}
		System.out.println("Insertion completed");
		con.close();
	}
}
