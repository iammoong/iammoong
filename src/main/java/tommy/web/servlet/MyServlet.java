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
       
	 // servlet 만들떄 GenericServlet, HttpServlet 둘중 하나를 상속
	   // 서블릿의 lifecycle : 생성자 > init() > service() get 방식 요청 doGet, post 방식이면 doPost  > 종료시 destroy

	   public void doGet(HttpServletRequest request, HttpServletResponse response)
	      throws IOException, ServletException{
	      PrintWriter out = response.getWriter();
	      response.setContentType("text/html; charset=UTF=8");
	      try{
	         out.println("<html><head><title> My first Serclet</title></head><body>");
	         out.println("<h1 color = 'red'><br><center><font size='30'>지금은 ");
	         out.println(new java.util.Date());
	         out.println("입니다.</font></center></body></html>");
	         	
	      }finally{
	         out.close();
	      }
	   }
}
