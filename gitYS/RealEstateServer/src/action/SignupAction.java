package action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import action.Action;
import dao.MemberDAO;
import dto.Member;


public class SignupAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		String id=request.getParameter("id");
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		String name=request.getParameter("name");
	
		MemberDAO dao = MemberDAO.getMemberDAO();
		Member m=new Member();
	
		m.setId(id);
		m.setEmail(email);
		m.setPassword(password);
		m.setName(name);
	
		JSONObject obj = new JSONObject();
		if(dao.check(id) == 0){
			if (dao.signUp(m)==0) {
				obj.put("signup", "fail");
			     response.getWriter().write(obj.toString());
			    
			} 
			else {
				obj.put("signup", "success");
			    response.getWriter().write(obj.toString());
		}
		}else{
			obj.put("signup", "fail");
		     response.getWriter().write(obj.toString());
		}
	
	
	}

}
