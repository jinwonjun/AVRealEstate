package kr.trappan.action.member;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;

import kr.trappan.action.Action;
import kr.trappan.dao.MemberDAO;
import kr.trappan.dto.Member;


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
