package com.rkb.transaction;
import java.sql.*;
import java.util.*;
public class SavePoints {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee?user=root&password=802215");
		Statement st = con.createStatement();
		con.setAutoCommit(false);
		st.executeUpdate("INSERT INTO usertransaction VALUES('Saurabh',115000)");
		st.executeUpdate("INSERT INTO usertransaction VALUES('Anik',220000)");
		Savepoint sp = con.setSavepoint();
		st.executeUpdate("INSERT INTO usertransaction VALUES('Ajay',132000)");
		st.executeUpdate("INSERT INTO usertransaction VALUES('Ankit',210000)");
//		System.out.println("Oops something went wrong...........");
//		con.rollback(sp);
		con.releaseSavepoint(sp);
//		System.out.println("operation are rollback from savepoint");
		con.commit();
		con.close();
	}
}
