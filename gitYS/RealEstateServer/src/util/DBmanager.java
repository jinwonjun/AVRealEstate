package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBmanager {
	
	private DBmanager(){
		System.out.println("Connection");
	}
	
	public static Connection getConnection(){
		//jdbc ����̹� �θ���, connection ��ü ���ؼ� �ҷ�����
		Connection con=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			con=DriverManager.getConnection("jdbc:mysql://52.43.75.43:3306/pmDB","root","password");
//			con=DriverManager.getConnection("jdbc:mysql://192.168.5.41:3306/pmDB","root","password");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		return con;
	}
	
	public static void close(Connection con, PreparedStatement pstmt){
		
		try{
			if(pstmt!=null){
			pstmt.close();
			}
			if(con!=null){
				con.close();
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
	
		System.out.println("close");
	}
	
	public static void close(Connection con, PreparedStatement pstmt, ResultSet rs){
		try{
			if(rs!=null){
				rs.close();
			}
			if(pstmt!=null){
				pstmt.close();
				}
				if(con!=null){
					con.close();
				}
			}catch(SQLException e){
				e.printStackTrace();
			}
		System.out.println("close");
	}

}
