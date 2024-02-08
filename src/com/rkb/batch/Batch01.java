package com.rkb.batch;
import java.sql.*;
public class Batch01 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","802215");
		Statement st = con.createStatement();
		st.addBatch("INSERT INTO employees VALUES('1008','Durga','30000','Hydrabad')");
		st.addBatch("INSERT INTO university VALUES('2124','shivam','Varanasi','Up')");
		int[] val = st.executeBatch();
		for(int i=0;i<val.length;i++) {
			System.out.println("Query inserted : "+val[i]);
		}
	}
}
