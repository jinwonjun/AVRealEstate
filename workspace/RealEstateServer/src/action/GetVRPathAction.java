package action;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import dao.ARhouseDAO;

public class GetVRPathAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("GetVRPathAction start!!");
		request.setCharacterEncoding("utf-8");

		String result = "success";
//		String vr_path = "";
		JSONObject json = new JSONObject();
		String house_id = request.getParameter("house_id");
		System.out.println("##Receiving House_id = " + house_id);
		ARhouseDAO manager = ARhouseDAO.getInstance();
		try {

			json = manager.getVRPath(house_id);

		} catch (Exception e) {
			result = "fail - SQLException";
			e.printStackTrace();
		} finally{
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			//���� ��Ʈ���� ������ json�� ����.
			response.getWriter().write(json.toString());
		}

		
	}
	
	/* VR File �������� Code */
	/*@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		System.out.println("get vr file start");
//		ServletContext context = request.getServletContext();
//		String uploadFilePath = context.getRealPath("/VRDIR");
		String fileName = request.getParameter("fileName");
		String uploadFilePath = "c:\\UI_Panel.prefab";
//		String uploadFilePath = request.getRealPath(""); 
		System.out.println("relative path = "+uploadFilePath);
		
		File file = new File(uploadFilePath);

		if(file.exists() && file.isFile()){	//file check
			try{
				long fileSize = file.length();
				response.setContentType("application/octet-stream");	//page�� byteŸ������ �ٿ�ε� ���������� ���
				response.setContentLength((int)fileSize);
				
				String strClient = request.getHeader("user-agent");
				//.getHeader() : Ŭ���̾�Ʈ ������ ���� ��������
				//�ٿ�ε� �� ���ͳ� ������ ���� �°� �ѱ�ó��
				if(strClient.indexOf("MSIE 5.5")!= -1){	//�ͽ� ���� 5.5
					response.setHeader("Content-Disposition", "fileName="+fileName+";");
				} else {	//�� �� ��� ������
					fileName = URLEncoder.encode(fileName, "UTF-8").replaceAll("\\+", "%20");
					response.setHeader("Content-Disposition", "attachment;filename="+fileName+";");
				}
				//���� ��� ����
				response.setHeader("Content-Length", String.valueOf(fileSize));
				response.setHeader("Content-Transfer-Encoding", "binary");
				response.setHeader("Pragma", "no-cache");
				response.setHeader("Cache-Control", "private");
				
				byte[] b = new byte[(int)fileSize];
				BufferedInputStream ins = new BufferedInputStream(new FileInputStream(file));
				BufferedOutputStream outs = new BufferedOutputStream(response.getOutputStream());
				int read=0;
				while((read = ins.read(b)) != -1){
					outs.write(b, 0, read);
				}
				outs.flush();
				outs.close();
				ins.close();
			} catch(Exception e){
				System.out.println("Exception err");
			}
		} else {
			System.out.println("file download err");
		}

		//		ARhouseDao manager = ARhouseDao.getInstance();
		//		manager.downloadPrefab(uploadFilePath);
	}*/

}
