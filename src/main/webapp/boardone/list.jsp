<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "tommy.web.boardone.BoardDAO"%>
<%@ page import = "tommy.web.boardone.BoardVO"%>
<%@ page import = "java.util.List" %>
<%@ page import = "java.text.SimpleDateFormat" %>
<%@ include file="view/color.jsp"%>
<%!
//수정<1>
int pageSize = 5; //한 페이지에 출력될 글 수 (행)
SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm"); %>
<%
   // 현 페이지 정보 설정
   String pageNum = request.getParameter("pageNum");  //최초 선언(pageNum) 
   if(pageNum == null){        //처음에 값이 없으니 null
      pageNum = "1";           // 1번으로 설정
   }
   //pageNum  지금 내가 몇 페이지에 있는지 확인하기 위함
   //crruntPage 현재 화면에 띄워진 페이지
   //startRow 현재 화면에서의 가장 첫번째 행
   //endRow 현재 화면에서의 가장 마지막 행
   //count 전체 게시글 수
   //number 현재 페이지 첫번째 행의 게시글 번호
   int currentPage = Integer.parseInt(pageNum); 
   int startRow = (currentPage - 1) * pageSize + 1; 
   
   int endRow = currentPage * pageSize;
   int count = 0;
   int number = 0;
   List<BoardVO> articleList = null;
   BoardDAO dbPro = BoardDAO.getInstance();
   count = dbPro.getArticleCount(); //전체 글 수
   if (count >0){
         articleList = dbPro.getArticles(startRow, endRow); //수정(3)
   }
   number = count-(currentPage-1)*pageSize; //수정(4)

%>                    

<html>
<head>
<title>게시판</title>
<link href = "style.css" rel="stylehseet" type="text/css">
</head>
<body bgcolor="<%=bodyback_c%>">
<center><b>글목록(전체 글:<%=count%>)</b>
<table width="700">
<tr>
   <td align="right" bgcolor="<%=value_c%>">
   <a href="writeForm.jsp">글쓰기</a>
   </td>
</tr>
</table>
<%
   if(count == 0){
%>
<table width="700" border="1" cellpadding="0" cellspacing="0">
<tr>
   <td align="center">
   게시판에 저장된 글이 없습니다.
   </td>
</tr>
</table>
<% } else { %>
<table border="1" width="700" cellpadiing="0"
                     cellspacing="0" align="center">
   <tr height="30" bgcolor="<%=value_c%>">
      <td align="center" width="50"  > 번 호 </td>
      <td align="center" width="250" > 제 목 </td>
      <td align="center" width="100" > 작성자  </td>
      <td align="center" width="150" > 작성일 </td>
      <td align="center" width="50" > 조회</td>
      <td align="center" width="100" > IP </td>
   </tr>
<%
   for (int i = 0; i < articleList.size(); i++){
      BoardVO article = (BoardVO)articleList.get(i);
%>
   <tr height="30">
   <td align ="center" width="50"> <%=number-- %></td>
   <td width ="250">
   <!-- 수정 <5> -->
   <%
      int wid = 0;
      if(article.getDepth()>0){
         wid=5*(article.getDepth());
   %>
      <img src="/myWeb/images/level.gif" width="<%=wid %>" height="16">
      <img src="/myWeb/images/re.gif">
   <% }else{ %>
      <img src="/myWeb/images/level.gif" width="<%=wid %>" height="16">
   <% } %>
   <a href ="content.jsp?num=<%=article.getNum()%>&pageNum=<%=currentPage%>"><%=article.getSubject()%></a>
   
      <% if(article.getReadcount()>=20){ %>
      <img src="/myWeb/images/hot.gjf" border="0" height="16"><% } %></td>
   <td align="center" width="100"><a href ="mailto:<%=article.getEmail()%>"><%=article.getWriter() %></a></td>
   <td align="center" width="150"><%= sdf.format(article.getRegdate())%></td>
   <td align="center" width="50"><%=article.getReadcount() %></td>
   <td align="center" width="100"><%=article.getIp()%></td>
   </tr>
      <% } %>
</table>
<% } %>
<!-- 수정(7) -->
<%
 if(count > 0){
       int pageBlock = 5; //화면 하단에 보여지는 페이지 수 
       int imsi = count % pageSize == 0 ? 0 : 1;  //전체 계시물을 pageSize로 나눴을때 나머지를 대비한 + 1
       int pageCount = count / pageSize + imsi;  //전체 페이지 수
       int startPage = (int)((currentPage-1)/pageBlock)*pageBlock +1; // 화면에서 아래 목록 첫번째 page [1]
       int endPage = startPage + pageBlock -1;   //현재화면 아래 목록 마지막page [5]
       if (endPage > pageCount) endPage = pageCount;
       if(startPage > pageBlock){ %>
       <a href ="list.jsp"?pageNum=<%=startPage-pageBlock %>">이전</a>
<%
       }
       for(int i = startPage; i<= endPage; i++){ %>
       <a href="list.jsp?pageNum=<%= i %>">[<%=i %>]</a>
<% 
       }
       if(endPage < pageCount){ %>
      <a href="list.jsp?pageNum=<%=startPage+pageBlock %>">[다음]</a>
<%
       }
 }
%>
</center>
</body>
</html>