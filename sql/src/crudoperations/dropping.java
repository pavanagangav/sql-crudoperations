package crudoperations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class dropping {
 
	 public static final String Driver="com.mysql.cj.jdbc.Driver";
	 public static final String Username="root";
	 public static final String Password="root";
	 public static final String Url="jdbc:mysql://localhost:3306/";
	 public static Connection conn;
	 public static PreparedStatement pmst;
	 public static void main(String args[]) {
	 Scanner src=new Scanner(System.in);
 try
 {
	 Class.forName(Driver);
	 conn=DriverManager.getConnection(Url, Username, Password);
	 System.out.println("enter database name:");
	
	
	 
	 String sql="drop database "+src.next();
	  pmst=conn.prepareStatement(sql);
	 int i=pmst.executeUpdate(); 
	 if(i==0) {
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
