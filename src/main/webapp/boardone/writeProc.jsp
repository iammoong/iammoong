<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import = "tommy.web.boardone.BoardDAO" %>
    <%@ page import = "java.sql.Timestamp" %>
    <% request.setCharacterEncoding("utf-8"); %>
    <jsp:useBean id ="article" scope="page" class="tommy.web.boardone.BoardVO">
    	<jsp:setProperty name="article" property="*"/>
    </jsp:useBean>
    <%
    	
    	article.setRegdate(new Timestamp(System.currentTimeMillis()));
    	article.setIp(request.getRemoteAddr());
    	BoardDAO dbPro = BoardDAO.getInstance();
    	
    	//dbPro.insertContent(article);
    	dbPro.insertArticle(article);
    	//dbPro.replyForm(article);
    	response.sendRedirect("list.jsp");
    %>
