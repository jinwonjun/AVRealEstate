package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.DBmanager;

public class FavoriteDAO {
	private static FavoriteDAO instance = new FavoriteDAO();

	public static FavoriteDAO getInstance() {
		return instance;
	}
	private FavoriteDAO() {}
	
	public List getFavoriteHouse(String id){
		System.out.println("start getFavoriteHouse");
		String sql = "select * from favorite_map where id=?";
		Connection con = DBmanager.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
	
		String house_id;
		List<String> house_id_arr = new ArrayList<>();
		try {
			pstmt = con.prepareStatement(sql);	
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			System.out.println(rs.toString());
			while(rs.next()) {
				house_id = rs.getString("house_id");
//				System.out.println(house_id);
				house_id_arr.add(house_id);
			}
	
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBmanager.close(con, pstmt);
		}
		return house_id_arr;
	}
	
}
