package action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.*;

public interface Action {
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
//	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}
