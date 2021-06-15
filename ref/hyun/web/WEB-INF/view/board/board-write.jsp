<!-- 필터를 적용해도 한글 깨짐이 있을 경우
charset과 pageEncoding을 utf-8로 변경 --> 

<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/shop/front/board/write" method="post">
		<label for="uname"><b>작성자</b></label>
		<input type="text" placeholder="Enter writer" name="writer">
		
		<label for="uname"><b>제목</b></label>
		<input type="text" placeholder="Enter title" name="title">

		<label for="uname"><b>내용</b></label>
		<input type="text" placeholder="Enter contents" name="contents">
		<button type="submit">글쓰기</button>

	</form>
</body>
</html>