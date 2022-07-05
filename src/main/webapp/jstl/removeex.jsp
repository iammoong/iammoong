<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL core 예제 - set, out, remove</title>
</head>
<body>
brower 변수값 설정
<c:set var="brower" value="${header['User-Agent']}"/><br>
<c:out value="${brower}"/><p>
brower 변수값 제거 후
<c:remove var="brower"/>
<c:out value="${brower}"/>

</body>
</html>