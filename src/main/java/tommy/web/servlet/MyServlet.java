package tommy.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	 // servlet ���鋚 GenericServlet, HttpServlet ���� �ϳ��� ���
	   // �������� lifecycle : ������ > init() > service() get ��� ��û doGet, post ����̸� doPost  > ����� destroy

	   public void doGet(HttpServletRequest request, HttpServletResponse response)
	      throws IOException, ServletException{
	      PrintWriter out = response.getWriter();
	      response.setContentType("text/html; charset=UTF=8");
	      try{
	         out.println("<html><head><title> My first Serclet</title></head><body>");
	         out.println("<h1 color = 'red'><br><center><font size='30'>������ ");
	         out.println(new java.util.Date());
	         out.println("�Դϴ�.</font></center></body></html>");
	         	
	      }finally{
	         out.close();
	      }
	   }
}
