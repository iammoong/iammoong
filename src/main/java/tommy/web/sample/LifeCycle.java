package tommy.web.sample;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LifeCycle extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private String company;
	private String manager;
	private String tel;
	private String email;

	public LifeCycle() {
		super();
	}

	@Override
	public void init() throws ServletException {
		System.out.println("init() 호출됨...");
		System.out.println("초기화 메소드 수행됨");
		company = getServletContext().getInitParameter("company");
		manager = getServletContext().getInitParameter("manager");
		tel = getServletConfig().getInitParameter("tel");
		email = getServletConfig().getInitParameter("email");
	}

	@Override
	public void destroy() {
		System.out.println("destroy() 호출됨...");
	}

	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		System.out.println("secvice() 호출됨...");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		try {
			out.print("<html>");
			out.print("<body>");
			out.print("<li>회사명 : " + company + "</li>");
			out.print("<li>담당자 : " + manager + "</li>");
			out.print("<li>전화번호 : " + tel + "</li>");
			out.print("<li>이메일 : " + email + "</li>");
			out.print("</body>");
			out.print("</html>");
			
		} finally {
			out.close();
		}
	}

}
