<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page isErrorPage = "true" %>
    <% response.setStatus(HttpServletResponse.SC_OK); %> <!-- 페이지가 정상이라고 착각하게 만든다. -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>예외 발생</title>
</head>
<body>

	요청 처리 과정에서 예외가 발생하였습니다.<br><br>
	빠른 시간애에 문제를 해결하도록 하겠습니다.
	<br></br>
	에러타입 : <%= exception.getClass().getName() %> <br><br>
	에러 메시지 : <b><%= exception.getMessage() %></b>
</body>
</html>