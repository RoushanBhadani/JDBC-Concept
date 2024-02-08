package com.rkb.transaction;
import java.sql.*;
public class IsolationLevels {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee?user=root&password=802215");
		System.out.println(con.getTransactionIsolation()); // get Default transaction isolation levels
		//default is 4.  the result of sql query will be locked for only one transaction. prevent dirty read and non repeatable problem
		// Now we set the transaction isolation levels
		con.setTransactionIsolation(2);  //prevent only Dirty read problem. ensure only committed data can be read by other transaction.
		System.out.println(con.getTransactionIsolation());
		con.setTransactionIsolation(8); //prevent all the problem. highest level but not recommended because of table lock
		System.out.println(con.getTransactionIsolation()); 
		con.setTransactionIsolation(1); //before committing the transaction its intermediate result can be use by other transaction.
		//it doesn't prevent any problem. lowest level of isolation.
		System.out.println(con.getTransactionIsolation());
		con.close();
	}

}
