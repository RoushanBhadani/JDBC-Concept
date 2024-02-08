package com.rkb.assignment;
import java.sql.*;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Scanner;
public class FetchData {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","802215");
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter name to fetch the Info : ");
		String n = sc.next();
		String sqlQuery = "Select * from userinfo where name='"+n+"'";
		PreparedStatement pst = con.prepareStatement(sqlQuery);
		ResultSet rs = pst.executeQuery();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		FileOutputStream fos = new FileOutputStream("rkb_db.jpeg");
		PrintWriter pw = new PrintWriter("rkb_res.pdf");
		while(rs.next()) {
			String name = rs.getString(1);
			
			java.sql.Date sdate = rs.getDate(2);
			String s = sdf.format(sdate);
			
			String city = rs.getString(3);
			
			//image
			InputStream is = rs.getBinaryStream(4);
			byte[] buffer = new byte[2048];
			while(is.read(buffer)>0) {
				fos.write(buffer);
			}
			fos.flush();
			
			//text file
			Reader r = rs.getCharacterStream(5);
			char[] ch = new char[1024];
			while(r.read(ch)>0) {
				pw.write(ch);
			}
			pw.flush();
			
			System.out.println(name +" "+s+" "+city+" "+"image saved in : rkb_db.jpeg"+" "+"file saved in : rkb_res.pdf");
		}
		con.close();
		
	}

}
