package tommy.mvc.action;

import java.io.IOException;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import tommy.mvc.control.ActionForward;

public interface Action {
		
		public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException;

		

		

	}