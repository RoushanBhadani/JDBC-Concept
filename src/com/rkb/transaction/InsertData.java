package com.rkb.transaction;
import java.sql.*;
import java.util.Scanner;
public class InsertData {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee?user=root&password=802215");
		PreparedStatement pst = con.prepareStatement("INSERT INTO usertransaction VALUES(?,?)");
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("Enter Name : ");
			String name = sc.next();
			System.out.println("Enter Balance : ");
			int bal = sc.nextInt();
			pst.setString(1, name);
			pst.setInt(2, bal);
			int updateCount = pst.executeUpdate();
			if(updateCount == 0) {
				System.out.println("No record Inserted");
			}else {
				System.out.println("Row inserted");
			}
			System.out.println("Do you want to insert more Record[yes/no] : ");
			String opt = sc.next();
			if(opt.equalsIgnoreCase("no")) {
				break;
			}
		}
		System.out.println("Insertion successfully");
		con.close();
	}

}
