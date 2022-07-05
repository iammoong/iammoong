<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL fmt 예제 = formatNumber, formatDate</title>
</head>
<body>
number : 
<fmt:formatNumber value="12345.678" type="number"/><br><br>
currency : 
<fmt:formatNumber value="12345.678" type="currency" currencySymbol="￦"/><br><br>
percent : 
<fmt:formatNumber value="12345.678" type="percent"/><br><br>
pattern=".0" : 
<fmt:formatNumber value="12345.678" pattern=".0"/><br><br>

<c:set var ="now" value="<%= new java.util.Date() %>" />
<c:out value="${now}"/><br><br>
date : <fmt:formatDate value="${now}" type="date"/><br><br>
time : <fmt:formatDate value="${now}" type="time"/><br><br>
both : <fmt:formatDate value="${now}" type="both"/><br><br>








</body>
</html>