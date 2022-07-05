<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="org.apache.commons.fileupload.FileUpload"%>
<%@ page import="org.apache.commons.fileupload.DiskFileUpload"%>
<%@ page import="org.apache.commons.fileupload.FileItem"%>
<%@ page import="java.io.File"%>
<%@ page import="java.io.BufferedInputStream"%>
<%@ page import="java.io.BufferedOutputStream"%>
<%@ page import="java.io.FileOutputStream"%>
<%@ page import="java.io.IOException"%>
<%  request.setCharacterEncoding("utf-8");%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파일 업로드 처리</title>
</head>
<body>
	<%
			
		if(FileUpload.isMultipartContent(request)){
			String temporaryDir = "C:\\temp";
			DiskFileUpload fileUpload = new DiskFileUpload();
			fileUpload.setRepositoryPath(temporaryDir);
			fileUpload.setSizeMax(1024*1024);
			
			fileUpload.setSizeThreshold(1024*200);
			java.util.List fileItemList = fileUpload.parseRequest(request);
			for(int i = 0; i <fileItemList.size(); i++){
				FileItem fileItem = (FileItem)fileItemList.get(i);
				if(fileItem.isFormField()){// 파일 이외의 파라미터
	%>
					폼 파라미터 : <%=fileItem.getFieldName() %> = 
						<%=fileItem.getString() %><br>
					<%
				}else {
					%>
					파일: <%= fileItem.getFieldName() %> = <%=fileItem.getName() %> (<%=fileItem.getSize() %> bytes)<br>
			<% if(fileItem.isInMemory()) {%>
					"메모리에 저장"<br>
					<%}else{ %>
					"디스크에 저장"<br>
					<%} %>
					<%
						String filepath = application.getRealPath("upload");
					
					if(fileItem.getSize() > 0) {
						int idx = fileItem.getName().lastIndexOf("\\");
						if(idx == -1){
							idx = fileItem.getName().lastIndexOf("/");
						}
						String fileName = fileItem.getName().substring(idx + 1);
						try {
							File uploadedFile = new File(filepath, fileName);
							fileItem.write(uploadedFile);
						} catch (IOException ex) {
							
						}
					}
					}
				}
			} else {
		
					%>
					인코딩 타입이 multipart/form-data가 아님.
					<%
					}
					%>
</body>					
</html>















