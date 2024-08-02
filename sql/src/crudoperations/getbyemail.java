package crudoperations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class getbyemail{
 
	 public static final String Driver="com.mysql.cj.jdbc.Driver";
	 public static final String Username="root";
	 public static final String Password="root";
	
	
	 public static Connection conn;
	 public static PreparedStatement pmst;
	 public static void main(String args[]) {
	 Scanner src=new Scanner(System.in);
 try
 {
	 Class.forName(Driver);
	 
	 System.out.println("enter the database name");
	 String url="jdbc:mysql://localhost:3306/" +src.next();
	 conn=DriverManager.getConnection(url, Username, Password);
	 System.out.println("enter table name:"); 
	 String sql="select * from  " +src.next() + " where email = ?";		 
	  pmst=conn.prepareStatement(sql);
	  System.out.println("enter the email");
	  pmst.setString(1,src.next());
	  
	  ResultSet rs=pmst.executeQuery();
	  while(rs.next()) {
		  System.out.println("id : "+rs.getInt("id"));
		  System.out.println("name : "+rs.getString("name"));
		  System.out.println("email : "+rs.getString("email"));
	  }
	
	  
	 int i=pmst.executeUpdate(); 
	 if(i>0) {
		 System.out.println("success");
	 }
	 else {
		 System.out.println("error");
	 }
	 conn.close();
	 pmst.close();
	 src.close();
	 
	 
 }
 catch(Exception e) {
	 e.printStackTrace();
	
	 
 }
 
 }
}
