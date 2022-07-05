<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	request.setCharacterEncoding("utf-8");
    %>
    <jsp:useBean id = "msg" class="tommy.web.sample.SimpleData"/>
    <jsp:setProperty name="msg" property="message"/>

<html>
<body>
<h1>간단한 빈즈 프로그램 결과</h1>
<hr color="red"></hr><br><br>
<font size="5">
메세지 : <jsp:getProperty name="msg" property="message"/>
</font>
</body>
</html>