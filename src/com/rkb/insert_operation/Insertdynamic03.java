package com.rkb.insert_operation;

import java.sql.*;
import java.util.Scanner;

public class Insertdynamic03 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost/employee","root","802215");
		Statement st = con.createStatement();
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("Enter employee number : ");
			int eno = sc.nextInt();
			System.out.println("Enter employee name : ");
			String ename = sc.next();
			System.out.println("Enter employee salary : ");
			double esal = sc.nextDouble();
			System.out.println("Enter employee address : ");
			String eaddr = sc.next();
			
			String sqlQuery = String.format("Insert INTO employees VALUES(%d,'%s',%f,'%s')",eno,ename,esal,eaddr);
			st.executeUpdate(sqlQuery);
			
			System.out.println("Record inseted");
			
			System.out.println("Do you want to insert more record[yes/no]");
			String option = sc.next();
			if(option.equalsIgnoreCase("No")) {
				break;
			}
		}
		System.out.println("All row inserted successfully");
		con.close();
		st.close();
	}
}
