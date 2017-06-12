package dao;

import util.DBmanager;

import java.io.File;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONObject;

import dto.ARhouse;

public class ARhouseDAO {
	private static ARhouseDAO instance = new ARhouseDAO();
	
	public static ARhouseDAO getInstance() {
		return instance;
	}
	private ARhouseDAO() {}
	/*private Connection con = null;
	private ARhouseDao(Connection con){
		this.con = con;
	}*/
	
	public void insertARInfo(ARhouse house) throws Exception{
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql="";
		int cnt = 0;
		
		try {
			con = DBmanager.getConnection();
			sql = "insert into ar_info(house_id, house_div, house_item, house_addr, agency, area, price, floor, item_x, item_y) values(default,?,?,?,?,?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(++cnt, house.getHouse_div());
			pstmt.setString(++cnt, house.getHouse_item());
			pstmt.setString(++cnt, house.getHouse_addr());
			pstmt.setString(++cnt, house.getAgency());
			pstmt.setInt(++cnt, house.getArea());
			pstmt.setInt(++cnt, house.getPrice());
			pstmt.setInt(++cnt, house.getFloor());
			pstmt.setFloat(++cnt, house.getItem_x());
			pstmt.setFloat(++cnt, house.getItem_y());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			pstmt.close();
			con.close();
		}
	}
	
	public JSONObject getARInfoWithID(String house_id) throws Exception{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "";
		
		JSONObject jsonHouse = null;
		try{
			con = DBmanager.getConnection();
			sql = "select * from ar_info where house_id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, house_id);
			
			rs = pstmt.executeQuery();
			System.out.println("executeQuery success!");
			jsonHouse = new JSONObject();
            while(rs.next()){
            	jsonHouse.put("house_id", rs.getString("house_id"));
            	jsonHouse.put("house_div", rs.getString("house_div"));
                jsonHouse.put("house_item", rs.getString("house_item"));
                jsonHouse.put("house_name", rs.getString("house_name"));
                jsonHouse.put("house_addr", rs.getString("house_addr"));
                jsonHouse.put("area", rs.getString("area"));
                jsonHouse.put("price", rs.getString("price"));
                jsonHouse.put("floor", rs.getString("floor"));
            }
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			pstmt.close();
			con.close();
		}
		return jsonHouse;
	}
	
	public JSONObject getARInfo(String item_x, String item_y) throws Exception {
		System.out.println("start getARInfo");
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "";
		
		JSONObject jsonHouse = null;
		
		try{
			con = DBmanager.getConnection();
			sql = "select * from ar_info where item_x = ? and item_y = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, item_x);
			pstmt.setString(2, item_y);
			
			rs = pstmt.executeQuery();
			jsonHouse = new JSONObject();
            while(rs.next()){
            	jsonHouse.put("house_id", rs.getString("house_id"));
            	jsonHouse.put("house_div", rs.getString("house_div"));
                jsonHouse.put("house_item", rs.getString("house_item"));
                jsonHouse.put("house_name", rs.getString("house_name"));
                jsonHouse.put("house_addr", rs.getString("house_addr"));
                jsonHouse.put("agency", rs.getString("agency"));
                jsonHouse.put("area", rs.getString("area"));
                jsonHouse.put("price", rs.getString("price"));
                jsonHouse.put("floor", rs.getString("floor"));
                jsonHouse.put("item_x", rs.getString("item_x"));
                jsonHouse.put("item_y", rs.getString("item_y"));
                jsonHouse.put("agency_phoneNum", rs.getString("agency_phoneNum"));
            }
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			pstmt.close();
			con.close();
		}
		return jsonHouse;
	}
	
	public void removeMappingData(String house_id, String id) throws Exception{
		System.out.println("start removeMappingData!!");
		Connection con = null;
		PreparedStatement pstmt = null;
		int rs = 0;
		String sql = "";
		
		JSONObject jsonHouse = null;
		try{
			con = DBmanager.getConnection();
			sql = "delete from favorite_map where id = ? and house_id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, house_id);
			
			rs = pstmt.executeUpdate();
			System.out.println("executeQuery success!");
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			pstmt.close();
			con.close();
		}
	}
	
	public JSONObject getVRPath(String house_id) throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "";
		
		JSONObject jsonPath = null;
		try{
			con = DBmanager.getConnection();
			sql = "select * from vr_info where house_id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, house_id);
			
			rs = pstmt.executeQuery();
			System.out.println("executeQuery success!");
			
			
			jsonPath = new JSONObject();
            while(rs.next()){
//            	vr_path = rs.getString("path");
            	jsonPath.put("path", rs.getString("path"));
            	System.out.println(jsonPath);
            }
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			pstmt.close();
			con.close();
		}
		return jsonPath;
	}
}
