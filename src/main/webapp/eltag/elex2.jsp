<%@page import="tommy.web.actiontag.Customer"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	ArrayList<String> singer = new ArrayList<String>();
    	singer.add("아이브");
    	singer.add("르세라핌");
    	request.setAttribute("singer", singer);
    	
    	Customer[] customers = new Customer[2];
    	customers[0] = new Customer();
    	customers[0].setName("손오공");
    	customers[0].setEmail("son@naver.com");
    	customers[0].setPhone("010-1234-5678");
    	
    	customers[1] = new Customer();
    	customers[1].setName("아이유");
    	customers[1].setEmail("IU@naver.com");
    	customers[1].setPhone("010-9876-5432");
    	request.setAttribute("customer", customers);
    
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>El Example</title>
</head>
<body>

	<ul>
		<li>${singer[0]}, ${singer[1]} </li>
	</ul>
	
	<ul>
		<li>이름 : ${customer[0].name}</li>
		<li>메일 : ${customer[0].email}</li>
		<li>전화 : ${customer[0].phone}</li>
	</ul>
	
	<ul>
		<li>이름 : ${customer[1].name}</li>
		<li>메일 : ${customer[1].email}</li>
		<li>전화 : ${customer[1].phone}</li>
	</ul>

</body>
</html>