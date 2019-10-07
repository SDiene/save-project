package model;

import java.sql.*;

public class ConnectionClass {
	
	public static void main (String [] args) {
		System.out.println (ConnectionClass.get_connection ());
		}
		public static Connection get_connection(){
		 Connection conn=null;
		try {
		  Class.forName("com.mysql.jdbc.Driver");              
		  conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/SENTECH?autoReconnect=true&useSSL=false","root", "12345678");
		  System.out.println("connexion successuf !!!");
		} catch (Exception e) {
		  System.out.println(e);
		  System.out.println("failed to connect");
		}
		  return conn;
		}
		
}


