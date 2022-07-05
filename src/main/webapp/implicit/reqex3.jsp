<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>헤더 목록 출력</title>
</head>
<body>
<%
	Enumeration enumDate = request.getHeaderNames();
	while(enumDate.hasMoreElements()){
		String headerName = (String)enumDate.nextElement();
		String headerValue = request.getHeader(headerName);
	
%>
<%= headerName %> = <%=headerValue %><br><br>
<% }%>

</body>
</html>