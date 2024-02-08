package com.rkb.preparedStatement;
import java.util.Scanner;
import java.sql.*;
public class Insert01 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","802215");
		String sqlQuery = "insert into employees values(?,?,?,?)";
		PreparedStatement pst = con.prepareStatement(sqlQuery);
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("Enter Employee Number : ");
			int eno = sc.nextInt();
			System.out.println("Enter Employee Name : ");
			String ename = sc.next();
			System.out.println("Enter Employee salary : ");
			double esal = sc.nextDouble();
			System.out.println("Enter Employee Address : ");
			String eaddr = sc.next();
			
			pst.setInt(1, eno);
			pst.setString(2, ename);
			pst.setDouble(3, esal);
			pst.setString(4, eaddr);
			
			pst.executeUpdate();
			
			System.out.println("Record Inserted successfully");
			
			System.out.println("Do you to insert more Records [yes/no] : ");
			String option = sc.next();
			if(option.equalsIgnoreCase("no")) {
				break;
			}
		}
		System.out.println("Completed!");
		con.close();
		pst.close();
	}

}
