package com.rkb.delete_operation;
import java.util.*;
import java.sql.*;
public class Delete02 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","802215");
		Statement st = con.createStatement();
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("Enter cutoff salary");
			double cutoff = sc.nextDouble();
			String sqlQuery = String.format("DELETE FROM employees WHERE ESAL>=%f",cutoff);
			int updateRow = st.executeUpdate(sqlQuery);
			System.out.println(updateRow + " : No. of row deleted");
			System.out.println("Do you want to delete more Records : ");
			String moreRec = sc.next();
			if(moreRec.equalsIgnoreCase("no")) {
				break;
			}
		}
		System.out.println("Selected row Deleted Successfully");
		con.close();
		st.close();
	}

}
