<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <%@ include file="view/color.jspf" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
</head>
<body bgcolor="${bodyback_c }">
<center>
<b>글목록(전체 글:${count })</b>
	<table width="700">
		<tr>
			<td align="right" bgcolor="${value_c }">
				<a href = "/myWeb/board/writeForm.do">글쓰기</a>
			</td>
		</tr>
		<c:if test="${count == 0 }">
		<table width="700" border="1" cellpadding="0" cellspacing="0">
		<tr>
			<td align="center">
				게시판에 저장된 글이 없습니다.
			</td>
		</tr>
		</table>
		</c:if>
		<c:if test="${count > 0 }">
		<table width="700" border="1" cellpadding="0" cellspacing="0" align = "center">
		<tr>
			<td align="center" width="50">번 호</td>
			<td align="center" width="250">제   목</td>
			<td align="center" width="100">작성자</td>
			<td align="center" width="150">작성일</td>
			<td align="center" width="50">조 회</td>
			<td align="center" width="100">IP</td>
		</tr>
		<c:forEach var="article" items="${articleList }">
		<tr height="30">
			<td align="center" width="50">
			<c:out value="${number }"/>
			<c:set var="number" value="${number -1 }"/>
			</td>
			<td width="250"> 
			<c:if test="${article.depth > 0}">
				<img src = "images/level.gif" width="${5 * article.depth }" height="16">
				<img src = "images/re.gif">
			</c:if>
			<c:if test="${article.depth == 0 }">
				<img src ="images/level.gif" width="${5 * article.depth }" height="16">
			</c:if>
			<a href="/myWeb/board/content.do?num=${article.num }&pageNum=${currentPage}">
			${article.subject }</a>
			<c:if test="${article.readcount >= 20 }">
				<img src="images/hot.gif" border="0" height="16">
			</c:if>
			</td>
			<td align="center" width="100">
				<a href="mailto:${article.email }">${article.writer }</a></td>
			<td align="center" width="150">${article.regdate }</td>
			<td align="center" width="50">${article.readcount }</td>
			<td align="center" width="100">${article.ip }</td>
		</tr>
		</c:forEach>
	</table>
	</c:if>
	
	<c:if test="${count > 0 }">
		<c:set var="imsi" value="${count % pageSize == 0 ? 0 : 1 }"/>
		<c:set var="pageCount" value="${count / pageSize + imsi}"/>
		<c:set var="pageBlock" value="${3}"/>
		<fmt:parseNumber var ="result" value="${(currentPage - 1) / pageBlock }" integerOnly="true"/>
		<c:set var="startPage" value="${result * pageBlock + 1 }"/>
		<c:set var="endPage" value="${result + pageBlock - 1 }"/>
		<c:if test ="${endPage > pageCount }">
			<c:set var="endPage" value="${pageCount }"/>
		</c:if>
		<c:if test="${startPage > pageBlock }">
			<a href="/myWeb/board/list.do?pageNum=${startPage - pageBlock }">[이전]</a>
		</c:if>
		<c:forEach var="i" begin="${startPage }" end="${endPage }"><a href="/myWeb/board/list.do?pageNum=${i }">[${i }]</a>
		</c:forEach>
		<c:if test="${endPage < pageCount }">
			<a href="/myWeb/board/list.do?pageNum=${startPage + pageBlock }">[다음]</a>
		</c:if>
	</c:if>
	
</center>

</body>
</html>