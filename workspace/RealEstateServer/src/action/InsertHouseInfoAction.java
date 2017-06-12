package action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.ARhouse;
import dao.ARhouseDAO;

public class InsertHouseInfoAction implements Action {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		ARhouse house = new ARhouse();
		house.setHouse_div(request.getParameter("house_div"));
		house.setHouse_item(request.getParameter("house_item"));
		house.setHouse_addr(request.getParameter("house_addr"));
		house.setAgency(request.getParameter("agency"));
//		System.out.println(request.getParameter("area"));
		house.setArea(Integer.parseInt(request.getParameter("area")));
		house.setPrice(Integer.parseInt(request.getParameter("price")));
		house.setFloor(Integer.parseInt(request.getParameter("floor")));
		house.setItem_x(Float.parseFloat(request.getParameter("item_x")));
		house.setItem_y(Float.parseFloat(request.getParameter("item_y")));
		
		ARhouseDAO manager = ARhouseDAO.getInstance();
		try {
			manager.insertARInfo(house);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		String s = request.getParameter("ss");
		
//		response.getWriter().write(s);
	}
}
