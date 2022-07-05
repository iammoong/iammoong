package tommy.web.sample;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InitParam extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String company;
	private String manager;
	private String tel;
	private String email;

	@Override
	public void init() throws ServletException {
		System.out.println("초기화 메소드 수행됨");
		company = getServletContext().getInitParameter("company");
		manager = getServletContext().getInitParameter("manager");
		tel = getServletConfig().getInitParameter("tel");
		email = getServletConfig().getInitParameter("email");
	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
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

	@Override
	protected void doGet(HttpServletRequest requset, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(requset, response);
	}

	@Override
	protected void doPost(HttpServletRequest requset, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(requset, response);
	}
}
