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
	<form id="writeForm" method="post" action="">
		<input type="hidden" name="seq" id="seq" value="${article.seq}"/>
		<div>
			<span class="label label-default">제목</span>
			<input type="text" name="title" id="title" value="${article.title}"/>
		</div>
		<div>
			<span class="label label-default">작성자</span>
			<input type="text" name="writerId" id="writerId" value="${article.writerId}" <c:if test="${not empty article}">disabled="disabled"</c:if> />
		</div>
		<div>
			<span class="label label-default">내용</span>
			<textarea rows="4" cols="50" name="content" id="content" >${article.content}</textarea>
		</div>
	</form>
	
	<button class="btn btn-primary" id="writeBtn">작성 완료</button>
	<button class="btn btn-danger" onclick="location.href = '/list'">취소</button>
</body>

<script src="/share/js/bootstrap.min.js"></script>
<script>
$(document).ready(function () {
	// 작성완료 버튼 한번만 작동하게 함
    $('#writeBtn').one('click', function () {
    	fnWrite();
    });
});

// 작성 완료
function fnWrite() {
	var ids = new Array();
	ids.push('title');
	ids.push('writerId');
	ids.push('content');
	
	if (!checkInputForm(ids)) {
		return;
	}

	var seq = $('#seq').val();
	if (seq == "") { // seq가 없으면 insert
		$('#writeForm').attr("action", "/write");
		$('#writeForm').submit();
	} else { // seq가 있으면 update
		$('#writeForm').attr("action", "/modify");
		$('#writeForm').submit();
	}
}

// 필수 입력 항목 체크
function checkInputForm(ids) {
	for (var i = 0; i < ids.length; i++) {
		var id = ids[i];
		var value = $('#' + id).val();
		if(value.length < 1) {
			alert(id + " 항목을 입력해주세요.");
			$('#' + id).focus();
			
			return false;
		}
	}
	
	return true;
}

</script>
</html>
