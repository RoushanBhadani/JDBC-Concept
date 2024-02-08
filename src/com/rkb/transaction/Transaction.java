package com.rkb.transaction;
import java.sql.*;
import java.util.*;
public class Transaction {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Connection con =  DriverManager.getConnection("jdbc:mysql://localhost:3306/employee?user=root&password=802215");
		Statement st = con.createStatement();
		System.out.println("Data before Transaction");
		System.out.println("-----------------------");
		ResultSet rs = st.executeQuery("SELECT * FROM usertransaction");
		while(rs.next()) {
			System.out.println(rs.getNString(1)+" "+rs.getInt(2));
		}
		System.out.println("Transaction begins-----");
		con.setAutoCommit(false);
		st.executeUpdate("UPDATE usertransaction SET balance=balance-10000 WHERE name='Roushan'");
		st.executeUpdate("UPDATE usertransaction SET balance=balance+10000 WHERE name='Satyam'");
		System.out.println("Can you please confirm this transaction of 10000[yes/no] : ");
		Scanner sc = new Scanner(System.in);
		String option = sc.next();
		if(option.equalsIgnoreCase("yes")) {
			con.commit();
			System.out.println("Transaction commited");
		}else {
			con.rollback();
			System.out.println("Transaction Rolledback");
		}
		System.out.println("--------------------------");
		System.out.println("Data After Transaction");
		ResultSet rs1 = st.executeQuery("SELECT * FROM usertransaction");
		while(rs1.next()) {
			System.out.println(rs1.getString(1)+" "+rs1.getInt(2));
		}
		con.close();
	}

}
