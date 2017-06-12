package action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.json.simple.JSONObject;

import action.Action;
import dao.MemberDAO;
import dto.Member;

public class LoginAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		System.out.println(id +" "+ password);
		
		MemberDAO dao = MemberDAO.getMemberDAO();
		 response.setCharacterEncoding("utf8");
	     response.setContentType("application/json");
	     
	     
	    JSONObject obj = new JSONObject();
	    
		if (dao.login(id, password)==0) {
			System.out.println("fail");
		     obj.put("login", "fail");
		     response.getWriter().write(obj.toString());
		} 
		else {
			HttpSession session = request.getSession();
			session.setAttribute("id", id);
			obj.put("login", "success");
		    response.getWriter().write(obj.toString());
			
		}

	
	}

}
