package sample;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyFirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// POST 방식으로 값을 전송 할 경우 한글이 깨질 수 있기 때문에 사용하는 것.
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		Date date = new Date();

		out.println("<html>"); // html 태그
		out.println("<body>"); // 작성할 내용
		out.println("<h2>My First Servlet Program!</h2>");
		out.println("<hr color=\"red\"><br>");
		out.println("<center>");
		out.println("<font size = '5'>");
		out.println("현재시간은 " + date.toString() + "입니다.");
		out.println("</font>");
		out.println("</center>");
		out.println("</body>");
		out.println("</html>");

	}

}
