package com.rkb.transaction;
import java.sql.*;
import java.util.Scanner;
public class Transaction02 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee?user=root&password=802215");
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("SELECT * FROM usertransaction");
		Scanner sc = new Scanner(System.in);
		while(rs.next()) {
			System.out.println(rs.getString(1)+" "+rs.getInt(2));
		}
		System.out.println("----------------------------------");
		System.out.println("Transaction Begins----------------");
		con.setAutoCommit(false);
		System.out.println("Send from : ");
		String uname = sc.next();
		System.out.println("Send to : ");
		String name = sc.next();
		System.out.println("Enter balance : ");
		int bal = sc.nextInt();
		st.executeUpdate("UPDATE usertransaction SET balance=balance-"+bal+" where name='"+uname+"'");
		st.executeUpdate("UPDATE usertransaction SET balance=balance+"+bal+" where name='"+name+"'");
		System.out.println("Can you confirm the transaction[yes/no] : ");
		String opt = sc.next();
		if(opt.equalsIgnoreCase("yes")) {
			con.commit();
			System.out.println("Transaction successful");
		}else {
			con.rollback();
			System.out.println("Transaction failed");
		}
		System.out.println("Transaction end--------------------");
		System.out.println("-----------------------------------");
		ResultSet rs1 = st.executeQuery("SELECT * FROM usertransaction");
		while(rs1.next()) {
			System.out.println(rs1.getString(1)+" "+rs1.getInt(2));
		}
		con.close();
	}
}