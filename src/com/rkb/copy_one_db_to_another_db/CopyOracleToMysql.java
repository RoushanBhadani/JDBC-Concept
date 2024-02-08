package com.rkb.copy_one_db_to_another_db;
import java.sql.*;
public class CopyOracleToMysql {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Connection con1 = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","scott","tiger");
		Connection con2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","802215");
		Statement st1 = con1.createStatement();
		Statement st2 = con2.createStatement();
		ResultSet rs = st1.executeQuery("select * from employees");
		int count = 0;
		while(rs.next()) {
			count++;
			int eno = rs.getInt(1);
			String ename = rs.getNString(2);
			Double esal = rs.getDouble(3);
			String eaddr = rs.getNString(4);
			String sqlQuery = String.format("insert into employees values(%d,'%s',%f,'%s')",eno,ename,esal,eaddr);
			st2.executeUpdate(sqlQuery);
		}
		System.out.println("Total data copied & no of records : "+ count);
		con1.close();
		con2.close();
	}

}
