package kr.trappan.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.trappan.dto.Member;
import kr.trappan.util.DBManager;



public class MemberDAO {
	
	static MemberDAO dao = new MemberDAO();
	
	private MemberDAO(){
		System.out.println("MemberDAO");
	}
	
	public static MemberDAO getMemberDAO(){
		return dao;
	}
	
	public int login(String id, String password){
		String sql = "select * from member_table where id=? and password=? ";
		Connection con = DBManager.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
	
		
		try {
			pstmt = con.prepareStatement(sql);	
			pstmt.setString(1, id);
			pstmt.setString(2, password);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {  
				System.out.println(rs.getString("id"));
				return 1;
			}
	
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBManager.close(con, pstmt);
			
		}
		
		return 0;
	}
	
	public int signUp(Member m){
		
		String sql = "insert into member_table values(?, ?, ?, ?, default, default, default, default)";
		Connection con = DBManager.getConnection();
		PreparedStatement pstmt = null;
		int result = 0;
		try {

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, m.getId());
			pstmt.setString(2, m.getEmail());
			pstmt.setString(3, m.getPassword());
			pstmt.setString(4, m.getName());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			DBManager.close(con,pstmt);
		}
		return result;
	}
	
	public int check(String id){
		String sql = "select * from member_table where id=?";
		Connection con = DBManager.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
	
		
		try {
			pstmt = con.prepareStatement(sql);	
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {  
				System.out.println(rs.getString("id"));
				return 1;
			}
	
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBManager.close(con, pstmt);
			
		}
		
		return 0;
	}
	
	public int EditBackImg(String id, String path) {

		String sql = "update member_table set back_img = ? where id= ?";
		Connection con = DBManager.getConnection();
		PreparedStatement pstmt = null;
		int result = 0;
		try {

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, path);
			pstmt.setString(2, id);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt);
		}
		return result;
	}
	
	public int EditProfileImg(String id, String path) {

		String sql = "update member_table set pro_img = ? where id= ?";
		Connection con = DBManager.getConnection();
		PreparedStatement pstmt = null;
		int result = 0;
		try {

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, path);
			pstmt.setString(2, id);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt);
		}
		return result;
	}





}
