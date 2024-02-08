package com.rkb.MetaData;
import java.sql.*;
public class ParameterMetaData {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee?user=root&password=802215");
		PreparedStatement pst = con.prepareStatement("insert into employees values(?,?,?,?)");
		java.sql.ParameterMetaData pmd = pst.getParameterMetaData();
		int count = pmd.getParameterCount();
		for(int i=1;i<=count;i++) {
//			System.out.println(pmd.getParameterClassName(i));
//			System.out.println(pmd.getParameterMode(i));
//			System.out.println(pmd.getParameterType(i));
//			System.out.println(pmd.getScale(i));
//			System.out.println(pmd.getPrecision(i));
//			System.out.println(pmd.getParameterTypeName(i));
//			not supported most of the diver
		}
		con.close();
	}

}
