<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP File</title>
</head>
<body>

	<h2>JSP Script 예제</h2>
	<%
		String scriptlet = "스크립트릿 입니다.";
		String comment = "주석문 입니다.";
		out.print("내장객체를 이용한 출력 : " + declation +"<br><br>");
	%>
	선언문 출력하기(변수) : <%=declation %><br><br>
	선언문 출력하기(메소드) : <%=declationMethod() %>
	스크립트릿  출력하기 :  <%=scriptlet %>
	<!--  JSP에서 사용하는 HTML 주석 부분 -->
	<%--jsp 주석 <%= comment%> --%>
	
	<%! // declation 멤버변수 선언
	String declation = "선언문 입니다."; %>
	<%! //declation 메소드 선언
	
	public String declationMethod() {
				return declation;
				
	}
	%>
</body>
</html>