package com.rkb.update_operation;
import java.util.*;
import java.sql.*;
public class Update01 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","802215");
		Statement st = con.createStatement();
		String sqlQuery = "UPDATE university set scity='agra' where sno=1521";
		int updateRow = st.executeUpdate(sqlQuery);
		System.out.println("No. of row updated : "+updateRow);
		con.close();
		st.close();
	}

}
