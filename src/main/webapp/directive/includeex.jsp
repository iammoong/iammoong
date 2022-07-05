<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <h2>include 지시어를 활용한 예제</h2>
    <%
    	String name = "MoonKi Jang";
    %>
    <%@ include file="top.jsp" %>
    포함하는 페이지 지시어(include) 예제의 내용입니다.
    <%@ include file="bottom.jsp" %>
