<%@ page import="tommy.web.memberone.StudentDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
    	StudentDAO dao = StudentDAO.getInstance();
    	String id = request.getParameter("id");
    	String pass = request.getParameter("pass");
    	int check = dao.loginCheck(id, pass);
    %>
<%
    	if(check == 1){
    		session.setAttribute("loginID", id);
    		response.sendRedirect("login.jsp");
    	}else if(check==0){
    %>
<script>
    	alert("비밀번호가 틀렸습니다.")
    	history.go(-1);
    </script>

<%} else {
    %>
<script>
    	alert("아이디가 존재하지 않습니다.");
    	history.go(-1);
    </script>

<%} %>