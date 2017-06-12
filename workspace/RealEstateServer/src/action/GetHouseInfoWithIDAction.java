package action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import dao.ARhouseDAO;

public class GetHouseInfoWithIDAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("GetHouseInfoAction start!!");
		request.setCharacterEncoding("utf-8");

		String result = "success";
		JSONObject json = new JSONObject();
		String id = request.getParameter("house_id");
		ARhouseDAO manager = ARhouseDAO.getInstance();
		try {
			json = manager.getARInfoWithID(id);

		} catch (Exception e) {
			result = "fail - SQLException";
			e.printStackTrace();
		} finally{
			json.put("result", result);
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			//응답 스트림에 정제한 json을 쓴다.
			response.getWriter().write(json.toString());
		}

		
	}

}
