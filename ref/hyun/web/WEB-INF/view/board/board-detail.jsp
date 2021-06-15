<%@page import="java.util.List"%>
<%@taglib prefix= "c" uri= "http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>


	<table width="700" border="3" bordercolor="lightgray" align="center">

		<tr>
			<td>no</td>
			<td>${post.id}</td>
		</tr>

		<tr>
			<td>작성일</td>
			<td>${post.regdate}</td>
		</tr>

		<tr>
			<td>조회수</td>
			<td>${post.hit}</td>
		</tr>

		<tr>
			<td>글쓴이</td>
			<td>${post.writer}</td>

		</tr>

		<tr>
			<td>제 목</td>
			<td>${post.title}</td>
		</tr>

		<tr>
			<td>내용</td>
			<td>${post.contents}</td>
		</tr>

	</table>

	<div class="button">
		<button type="button" onclick="location.href='/shop/front/board/update?id=${post.id}'" >수정</button>
	</div>

	<div class="button">
		<button type="button" onclick="location.href='/shop/front/board/delete?id=${post.id}'" >삭제</button>
	</div>


	<br>

	<jsp:include page= "../layout/footer.jsp"/>
</body>

<style>
	div.button{
		margin: auto;
		width: 50px;
	}
</style>


</html>