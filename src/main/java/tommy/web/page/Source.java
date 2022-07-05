package tommy.web.page;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Destination")
public class Source extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   System.out.println("Source Start");
	   RequestDispatcher view = request.getRequestDispatcher("Destination");
	   request.setAttribute("myName", "Tommy.lee");
	   request.setAttribute("myAge", "30");
	   view.forward(request, response);
	   //response.sendRedirect("Destination");
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












