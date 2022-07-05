package tommy.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface CommandProcess {

	public String requestPro(HttpServletRequest request, HttpServletResponse respoese) throws Throwable;
}
