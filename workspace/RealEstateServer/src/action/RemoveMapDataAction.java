package action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import dao.ARhouseDAO;

public class RemoveMapDataAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("RemoveMapDataAction start!!");
		request.setCharacterEncoding("utf-8");

		String result = "success";
		JSONObject json = new JSONObject();
		String house_id = request.getParameter("house_id");
		String user_id = request.getParameter("user_id");
		ARhouseDAO manager = ARhouseDAO.getInstance();
		try {
			System.out.println(user_id + ", " + house_id);	
			manager.removeMappingData(house_id, user_id);

		} catch (Exception e) {
			result = "fail - SQLException";
			e.printStackTrace();
		} finally{
			json.put("result", result);
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			//응답 스트림에 정제한 json을 쓴다.
			response.getWriter().write(result);
		}
		
	}
	
}
