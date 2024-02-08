package com.rkb.execute_method;
import java.util.Scanner;
import java.sql.*;
public class ExecuteMethod {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost/employee","root","802215");
		Statement st = con.createStatement();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Query : ");
		String sqlQuery = sc.nextLine();
		boolean b = st.execute(sqlQuery);
		if(b==true) {   //Select query   <----------------------------
			ResultSet rs = st.getResultSet();
			while(rs.next()) {
				System.out.println(rs.getInt(1)+" "+rs.getNString(2)+" "+rs.getDouble(3)+" "+rs.getNString(4));
			}
		}else {         //Non Select query  <-----------------------------
			int rowCount = st.getUpdateCount();
			System.out.println("No. of row affected : "+rowCount);
		}
		con.close();
		st.close();
	}

}
