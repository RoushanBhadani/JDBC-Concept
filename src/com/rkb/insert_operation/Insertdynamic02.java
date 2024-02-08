package com.rkb.insert_operation;

import java.sql.DriverManager;
import java.util.Scanner;
import java.sql.*;
public class Insertdynamic02 {

	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","802215");
		Statement st = con.createStatement();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Student Number : ");
		int sno = sc.nextInt();
		System.out.println("Enter Student Name : ");
		String sname = sc.next();
		System.out.println("Enter Student City : ");
		String scity = sc.next();
		System.out.println("Enter Student State : ");
		String sstate = sc.next();
		String sqlQuery = "INSERT INTO university (`sno`, `sname`, `scity`, `sstate`) VALUES ("+sno+", '"+ sname+"', '"+scity+"', '"+sstate+"')";
		int rowAffected = st.executeUpdate(sqlQuery);
		System.out.println("No. of row affected : "+rowAffected);
		System.out.println(sqlQuery);
		
		con.close();
		st.close();
	}

}
