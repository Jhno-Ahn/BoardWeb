<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
						"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>새글등록</title>
</head>
<body>
<center>
<h1>글 등록</h1>
<a href ="logout.do">Log-out</a>
<hr>
<form action="insertBoard.do" method="post" enctype="multipart/form-data">
<table border="1" cellpadding="0" cellspacing="0">
	<tr>
		<td bgcolor="orange" width="70">제목</td><td align="left"> 
		<input type ="text" name="title"/></td>
	</tr>
	<tr>
		<td bgcolor="yellow">작성자</td><td align="left">
		<input type="text" name="writer"/></td>
	</tr>
	<tr>
		<td bgcolor="blue"> 내용</td><td align="left">
		<textarea name="content" rows="10" cols="40"></textarea></td> 
	</tr>
	<tr>
		<td bgcolor="red" width="70">업로드</td><td align="left">
		<input type ="file" name="uploadFile"/></td>
	</tr>
	<tr>
		<td colspan="2" align="left">
		<input type="submit" value="새글 등록"></td>
	</tr>
</table>
</form>
</center>
</body>
</html>