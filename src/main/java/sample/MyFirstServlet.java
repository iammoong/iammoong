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

		// POST ������� ���� ���� �� ��� �ѱ��� ���� �� �ֱ� ������ ����ϴ� ��.
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		Date date = new Date();

		out.println("<html>"); // html �±�
		out.println("<body>"); // �ۼ��� ����
		out.println("<h2>My First Servlet Program!</h2>");
		out.println("<hr color=\"red\"><br>");
		out.println("<center>");
		out.println("<font size = '5'>");
		out.println("����ð��� " + date.toString() + "�Դϴ�.");
		out.println("</font>");
		out.println("</center>");
		out.println("</body>");
		out.println("</html>");

	}

}
