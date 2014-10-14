<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<script src="/share/js/jquery-1.11.1.min.js"></script>
	<script src="/share/js/handlebars-v2.0.0.js"></script>
	<title>BoardWeb</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<!-- Bootstrap -->
    <link href="/share/css/bootstrap.min.css" rel="stylesheet" media="screen">
</head>
<body>
	<h1><a href="/">BoardWeb</a></h1>

	<table border="1">
		<thead>
			<tr>
				<td width="10%">번호</td>
				<td width="30%">제목</td>
				<td width="20%">작성자</td>
				<td width="30%">작성일시</td>
				<td width="10%">조회</td>
			</tr>
		</thead>
		<tbody id="tbd">
			<tr>
				<td><c:out value='${article.seq}'/></td>
				<td><a href="/article/${article.seq}"><c:out value='${article.title}'/></a></td>
				<td><c:out value='${article.writerId}'/></td>
				<td><c:out value='${article.createdDate}'/></td>
				<td><c:out value='${article.readCount}'/></td>
			</tr>
		</tbody>
	</table>
	
	<br>
	
	<p>
		<span class="label label-default">글번호</span>
		<input type="text" id="seq" onKeyPress="if(event.keyCode == 13) search();" value="${searchKey}"/>
		<button class="btn btn-default" onclick="search();">검색</button>
	</p>
	
	<button class="btn btn-primary" onclick="location.href = '/writeForm'">글쓰기</button>
	
</body>

</html>




