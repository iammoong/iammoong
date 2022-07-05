<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>초기화 파라미터 읽어오기</title>
</head>
<body>
<ul>
	<%
		Enumeration enumData = application.getInitParameterNames();
		while(enumData.hasMoreElements()){
			String initParamName = (String)enumData.nextElement();
		
	%>
	<li><%= initParamName %> = <%= application.getInitParameter(initParamName) %>
	</li>
	<%
		}
	%>
</ul>

</body>
</html>