<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL sql 예제 - query</title>
</head>
<body>
<sql:query var="rs" dataSource="jdbc/myOracle">
	select * from tempmember
</sql:query>
<table border ="1">
	<tr><!-- 필드명 출력 -->
		<c:forEach var="columnName" items="${rs.columnNames }">
			<th><c:out value="${columnName }"/></th>
		</c:forEach>
	</tr><!-- 레코드의 수 만큼 반복한다. -->
	<c:forEach var="row" items="${rs.rowsByIndex }">
	
	<tr><!-- 레코드의 필드 수 만큼 반복한다. -->
		<c:forEach var="column" items="${row }" varStatus="i">
		<td>
			<c:if test="${column!=null }"> <!-- 해당 필드값이 null이 아니면 -->
				<c:out value="${column }"/>
			</c:if> <!-- 해당 필드값이 null이면 -->
			<c:if test="${column==null }">
				&nbsp;
			</c:if>
		</td>
		</c:forEach>
	</tr>
	</c:forEach>
</table>

</body>
</html>