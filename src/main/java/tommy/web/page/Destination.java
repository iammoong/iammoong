package tommy.web.page;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Source")
public class Destination extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	  protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  response.setContentType("text/html;charset=utf-8");
		  PrintWriter out = response.getWriter();
		  
		  try {
			  out.println("<html>");
			  out.println("<head>");
			  out.println("<title>Destination</title>");
			  out.println("</head>");
			  out.println("<body>");
			  out.println("<h1>Destination Servlet입니다</h1>");
			  out.println("이름 : "+request.getAttribute("myName"));
			  out.println("나이 : "+request.getAttribute("myAge"));
			  out.println("</body>");
			  out.println("</html>");
			  
			  
		  }finally {
			  out.close();
		  }
	  }

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
		
	}

	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
}
