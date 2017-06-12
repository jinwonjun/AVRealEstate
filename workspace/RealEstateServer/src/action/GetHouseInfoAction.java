package action;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import com.google.gson.Gson;

import dao.ARhouseDAO;
import dto.ARhouse;

public class GetHouseInfoAction implements Action {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("GetHouseInfoAction start!!");
		request.setCharacterEncoding("utf-8");

		String result = "success";
		JSONObject json = new JSONObject();
		String x = request.getParameter("item_x");
		String y = request.getParameter("item_y");
		System.out.println(x+", "+y);
		ARhouseDAO manager = ARhouseDAO.getInstance();
		try {

			json = manager.getARInfo(x, y);

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




/*		String id = request.getParameter("house_id");
ARhouseDAO manager = ARhouseDAO.getInstance();
try {
//	ARhouseDto house = manager.getARInfo(id);
//	List<Map<String, String>> houseList = manager.getARInfo(id);
//	request.setAttribute("house", house);

	json = manager.getARInfo(x, y);
//	json = manager.getARInfo(id);


//	json.put("houseData", houseList);

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

/*String s = request.getParameter("ss");

response.getWriter().write(s);*/
