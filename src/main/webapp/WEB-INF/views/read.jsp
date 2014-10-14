<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<script src="/share/js/jquery-1.11.1.min.js"></script>
	<title>BoardWeb</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<!-- Bootstrap -->
    <link href="/share/css/bootstrap.min.css" rel="stylesheet" media="screen">
</head>
<body>
	<h1><a href="/">BoardWeb</a></h1>
	<div><span class="label label-default">제목</span> ${article.title}</div>
	<div><span class="label label-default">작성자</span> ${article.writer}</div>
	<div><span class="label label-default">작성일자</span> ${article.regDate}</div>
	<div><span class="label label-default">조회 수</span> ${article.cnt}</div>
	<div><span class="label label-default">내용</span> ${article.content}</div>
	
	<br>
	<br>
	
	<button class="btn btn-primary" onclick="location.href = '/modifyForm/${article.seq}'">수정</button>
	<button class="btn btn-danger" onclick="location.href = '/removeArticle/${article.seq}'">삭제</button>
	<button class="btn btn-warning" onclick="location.href = '/list'">목록 보기</button>
</body>

<script src="/share/js/bootstrap.min.js"></script>
</html>
