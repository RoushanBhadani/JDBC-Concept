package com.rkb.date;
import java.sql.*;
import java.text.SimpleDateFormat;
public class Create01 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","802215");
		PreparedStatement pst = con.prepareStatement("CREATE TABLE user(name varchar(10),dob date)");
		pst.executeUpdate();
		System.out.println("Table created");
		con.close();
	}

}
