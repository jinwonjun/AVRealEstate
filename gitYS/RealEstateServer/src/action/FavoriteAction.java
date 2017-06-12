package action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;

import dao.FavoriteDAO;

public class FavoriteAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("stasrt favorite action : "+ request);
		String id=request.getParameter("id");
		FavoriteDAO dao = FavoriteDAO.getInstance();
		response.setCharacterEncoding("utf8");
		response.setContentType("application/json");


		JSONObject obj = new JSONObject();

		List<String> house_id_arr = dao.getFavoriteHouse(id);
//		if(!house_id.equals("fail")) {
			obj.put("house_id", house_id_arr);
			System.out.println(obj.toJSONString());
			response.getWriter().write(obj.toString());
//		}

	}

}
