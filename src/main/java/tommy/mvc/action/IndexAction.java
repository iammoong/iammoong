package tommy.mvc.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tommy.mvc.control.ActionForward;


public class IndexAction implements Action {
	private static final long serialVersionUID = 1L;

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println("IndexActionÀÇ execute() ¼öÇàµÊ!");
		return new ActionForward("index.jsp", false);
	}
       
   

}
