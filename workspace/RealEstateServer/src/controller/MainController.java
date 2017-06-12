package controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;

/**
 * Servlet implementation class Controller
 */
@WebServlet(urlPatterns="/Test",initParams={@WebInitParam
		(name="urlpattern",value="/conf/urlPatterns.properties")})

public class MainController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Map<String,Action> map=new HashMap<String,Action>();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainController() {
        super();
        // TODO Auto-generated constructor stub
    }
    @Override
    public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		
		super.init(config);
		String urlpattern=config.getInitParameter("urlpattern");
		InputStream is=getClass().getResourceAsStream(urlpattern);
		//
		Properties prop=new Properties();
		
		//config
		
		try{
			prop.load(is);
			
		}catch(IOException e){
			e.printStackTrace();
		}
		Iterator it=prop.keySet().iterator();
		
		while(it.hasNext()){
			String cmd=(String)it.next();
			
			String action=prop.getProperty(cmd);
//			System.out.println(cmd+":"+action);//String
			
			Action actionObject=null;
			
			try {
				Class actionClass= Class.forName(action);
			    actionObject=(Action) actionClass.newInstance();
				
				
			} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			map.put(cmd,actionObject);
		}
		
		System.out.println("init");
	}


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//request를 이용해 웹 브라우저 요청 정보를 읽어옴, response 이용해 응답 전송
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("doGet");
		System.out.println(request.getRequestURL());
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
	
		String cmd=request.getParameter("cmd");
		Action action=map.get(cmd);
		
		action.execute(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		System.out.println("doPost");
	}

	@Override
	public void destroy() {
		super.destroy();
		System.out.println("destroy");
	}

}