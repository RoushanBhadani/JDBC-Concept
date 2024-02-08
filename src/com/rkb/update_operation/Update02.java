package com.rkb.update_operation;
import java.util.*;
import java.sql.*;
public class Update02 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","802215");
		Statement st = con.createStatement();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter student number : ");
		int id = sc.nextInt();
		System.out.println("Enter name : ");
		String upname = sc.next();
		String sqlQuery = "UPDATE university SET sname='"+upname+"' where sno="+id+"";
		int updateRow = st.executeUpdate(sqlQuery);
		System.out.println("No. of row Updated : "+updateRow);
		con.close();
		st.close();
	}

}
