package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Connexion {

	private static Connection conn;
	private ResultSet rs = null;
	private PreparedStatement pvst;
	private int valide;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		getConnection();
	}
	public static Connection getConnection() {
		
		String url  = "jdbc:mysql://localhost:3306/SENTECH";
		String user = "root";
		String password = "12345678";
		try {
			Class.forName("com.mysql.jdbc.Driver");  
			conn = DriverManager.getConnection(url+"/?autoReconnect=true&useSSL=false",user,password);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return conn;
	}
	
	public void initPrepare(String sql) {
		try {
			getConnection();
			pvst = conn.prepareStatement(sql);
		} catch (Exception e) {
			// TODO: handle exception
			System.exit(0);
			e.printStackTrace();
		}
	}
	
	public ResultSet executeSelect() {
		try {
			getConnection();
			rs = pvst.executeQuery();
		} catch (Exception e) {
			// TODO: handle exception
			System.exit(0);
			e.printStackTrace();
		}
		return rs;
	}
	
	public int executeMaj() {
		try {
			valide = pvst.executeUpdate();
			System.out.println("Requete bien executer !!!");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return valide;
	}
	
	public void closeConnection() {
		try {
			if (conn != null) {
				conn.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public PreparedStatement getPvst() {
		return pvst;
	}
	public void setPvst(PreparedStatement pvst) {
		this.pvst  = pvst;
	}
}
