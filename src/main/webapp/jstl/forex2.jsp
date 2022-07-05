<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ page import="java.util.ArrayList, jstl.MemberVO" %>
    <%
    	MemberVO vo1 = new MemberVO("아이유", "IU@naver.com", 30);
   	 	MemberVO vo2 = new MemberVO("장원영", "IVE@daum.net", 19);
    	MemberVO vo3 = new MemberVO("김채원", "KCW@naver.com", 22);
    	
    	ArrayList<MemberVO> memberList = new ArrayList<>();
    	memberList.add(vo1);
    	memberList.add(vo2);
    	memberList.add(vo3);
    	request.setAttribute("memberList", memberList);
    
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL Example</title>
</head>
<body>
<h3>회원 정보</h3>
<table border="1" width="450">
	<tr>
		<th width="50">번호</th>
		<th width="100">이름</th>
		<th width="200">메일</th>
		<th width="100">나이</th>
	</tr>
	<c:forEach var="member" items="${memberList}" varStatus="num">
		<tr>
			<td align="center">${num.count}</td>
			<td align="center">${member.name}</td>
			<td align="center">${member.email}</td>
			<td align="center">${member.age}</td>
		</tr>
	</c:forEach>



</table>

</body>
</html>