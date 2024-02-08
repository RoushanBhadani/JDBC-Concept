package com.rkb.update_operation;
import java.util.*;
import java.sql.*;
public class Update03 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		String sqlQuery = null;
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","802215");
		Statement st = con.createStatement();
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("Enter student id number : ");
			int id = sc.nextInt();
			System.out.println("Select the category you want to update : \nsname\nscity\nsstate");
			System.out.println("Enter categories : ");
			String categ = sc.next();
			if(categ.equalsIgnoreCase("sname")) {
				System.out.println("Enter name to update : ");
				String upname = sc.next();
				sqlQuery = "UPDATE university SET sname='"+upname+"' where sno="+id+""; 
			}else if(categ.equalsIgnoreCase("scity")) {
				System.out.println("Enter city to update : ");
				String upcity = sc.next();
				sqlQuery = "UPDATE university SET scity='"+upcity+"' where sno="+id+"";
			}else if(categ.equalsIgnoreCase("sstate")) {
				System.out.println("Enter state to update : ");
				String upstate = sc.next();
				sqlQuery = "UPDATE university SET sstate='"+upstate+"' where sno="+id+"";
			}
			int updateRow = st.executeUpdate(sqlQuery);
			System.out.println("No. of row updated : "+updateRow);
			System.out.println("Do you want to update more records[yes/no] : ");
			String option = sc.next();
			if(option.equalsIgnoreCase("no")) {
				break;
			}
		}
		System.out.println("update successfully");
		con.close();
		st.close();
	}

}
