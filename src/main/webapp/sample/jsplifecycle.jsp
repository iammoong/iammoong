<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%!
    	private int numOne = 0;
    	public void jspInit(){
    		System.out.println("jspInit() 호출됨");
    	}
    	public void jspDestroy(){
    		System.out.println("jspDestroy() 호출죔");
    	}
    
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP Life Cycle</title>
</head>
<body>
	<%
		int numTwo = 0;
		numOne++;
		numTwo++;
		System.out.println("세션 아이디 : " + session.getId());
	%>
	
	<ul>
		<li> Number One : <%= numOne %></li>
		<li> Number Two : <%= numTwo %></li>
	</ul>


</body>
</html>















