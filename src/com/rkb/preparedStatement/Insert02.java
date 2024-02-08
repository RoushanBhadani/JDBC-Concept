package com.rkb.preparedStatement;
import java.util.Scanner;
import java.sql.*;
public class Insert02 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","802215");
		String sqlQuery = "INSERT INTO logindata VALUES(?,?)";
		PreparedStatement pst = con.prepareStatement(sqlQuery);
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("Enter Username : ");
			String un = sc.next();
			System.out.println("Enter Password : ");
			String pass = sc.next();
			
			pst.setString(1, un);
			pst.setString(2, pass);
			
			pst.executeUpdate();
			
			System.out.println("Record Inserted Successfully");
			
			System.out.println("Do you want to insert more record[yes/no] : ");
			String option = sc.next();
			if(option.equalsIgnoreCase("no")) {
				break;
			}
		}
		System.out.println("completed");
	}
}