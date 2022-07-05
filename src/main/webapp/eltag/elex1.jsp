<%@page import="java.util.HashMap"%>
<%@page import="tommy.web.actiontag.Customer"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    	Customer customer = new Customer();
    	customer.setName("손오공");
    	customer.setEmail("son@hanmail.net");
    	customer.setPhone("010-1234-5678");
    	request.setAttribute("customer", customer);
    	
    	HashMap<String, String> map = new HashMap<String, String>();
    	map.put("name", "소나타");
    	map.put("maker", "현대자동차");
    	request.setAttribute("car", map);
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>El Example</title>
</head>
<body>
	<ul>
		<li>이름 : ${customer.name}</li>
		<li>이름 : ${customer.email}</li>
		<li>이름 : ${customer.phone}</li>
	</ul>
	<br><br>
	<ul>
		<li>자동차 : ${car.name}</li>
		<li>제조사 : ${car.maker}</li>
	</ul>
	
	

</body>
</html>