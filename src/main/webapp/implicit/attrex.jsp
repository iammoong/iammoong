<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
    pageContext.setAttribute("pageAttribute", "이승재");
    
    request.setAttribute("requestAttribite", "010-9531-0114");
    
    session.setAttribute("sessionAttribute", "stdio@hanmail.net");
    
    application.setAttribute("applicationAttribute", "KG information");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Scope Example</title>
</head>
<body>
	<ul>
		<% String value = (String)pageContext.getAttribute("pageAttribute");%>
		<li>이름 : <%=value %></li>
		<li>전화 : <%=request.getAttribute("requestAttribite") %></li>
		<li>메일 : <%=session.getAttribute("sessionAttribute") %></li>
		<li>회사 : <%=application.getAttribute("applicationAttribute") %></li>

	</ul>

</body>
</html>