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

<script id="allArticles-template" type="text/x-handlebars-template">
{{#articleList}}
<tr>
	<td>{{seq}}</td>
	<td><a href="/article/{{seq}}">{{title}}</a></td>
	<td>{{writerId}}</td>
	<td>{{createdDate}}</td>
	<td>{{readCount}}</td>
</tr>
{{/articleList}}
</script>
<script id="article-template" type="text/x-handlebars-template">
<tr>
	<td>{{seq}}</td>
	<td><a href="/article/{{seq}}">{{title}}</a></td>
	<td>{{writerId}}</td>
	<td>{{createdDate}}</td>
	<td>{{readCount}}</td>
</tr>
</script>

<script src="/share/js/bootstrap.min.js"></script>
<script>
$(document).ready(function() {
	searchAllArticle();
});

function search() {
	var seq = $('#seq').val();
	
	if (seq == "") {
		searchAllArticle();
	} else {
		searchArticle(seq);
	}
	 
}

function searchAllArticle() {
	$.ajax({
		url : "/search/allArticles/",
		dataType : "json",
		contentType : "application/x-www-form-urlencoded; charset=UTF-8",
		success : function(data) {
			// 숫자 이외의 입력 시 재입력 받도록 함
			if(data == "WRONG_ARTICLE_NO") {
				alert("숫자만 입력해 주세요.");
				$('#seq').val('');
				$('#seq').focus();
				return;
			}
			
			$('#tbd').empty();
			
			if (data == null) {
				$('#tbd').html("<tr><td colspan='5'>검색 결과가 없습니다.</td></tr>");
			} else {
				var source = $("#allArticles-template").html();
				var template = Handlebars.compile(source);
				$("#tbd").html(template(data));
			}
			

		},
		error : function(request, status, error) {
			console.log(request);
			console.log(status);
			console.log(error);
			alert("잠시 후 다시 시도해 주세요.");
		}
	});
}

function searchArticle(seq) {
	$.ajax({
		url : "/search/article/" + seq,
		dataType : "json",
		contentType : "application/x-www-form-urlencoded; charset=UTF-8",
		success : function(data) {
			// 숫자 이외의 입력 시 재입력 받도록 함
			if(data == "WRONG_ARTICLE_NO") {
				alert("숫자만 입력해 주세요.");
				$('#seq').val('');
				$('#seq').focus();
				return;
			}
			
			$('#tbd').empty();
			
			if (data == null) {
				$('#tbd').html("<tr><td colspan='5'>검색 결과가 없습니다.</td></tr>");
			} else {
				var source = $("#article-template").html();
				var template = Handlebars.compile(source);
				$("#tbd").html(template(data));
			}
			

		},
		error : function(request, status, error) {
			console.log(request);
			console.log(status);
			console.log(error);
			alert("잠시 후 다시 시도해 주세요.");
		}
	});
}
</script>

</html>

