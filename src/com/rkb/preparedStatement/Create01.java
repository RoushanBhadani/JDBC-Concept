package com.rkb.preparedStatement;
import java.util.*;
import java.sql.*;
public class Create01 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","802215");
		String sqlQuery = "CREATE TABLE logindata(username varchar(10),password varchar(10))";
		PreparedStatement pst = con.prepareStatement(sqlQuery);
		pst.executeLargeUpdate();
		System.out.println("Table created successfully");
	}

}
