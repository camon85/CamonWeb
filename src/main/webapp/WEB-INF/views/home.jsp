<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Home</title>
</head>

<body class="login">
	<FORM name="LoginForm" method=post >
	<div id="wrap">
		<div class="login_content">
			<div class="login_layout">
				<span class="top_bg"></span>
				<fieldset>
					<legend>로그인</legend>
					<div class="login_box">
						<div class="form">
							<label for="id"><img src="${pageContext.request.contextPath}/resources/tx_login_id.png" alt="ID"></label>
							<input type="text" name="USER" id="USER" class="input_txt">
							<br>
							<label for="password"><img src="${pageContext.request.contextPath}/resources/tx_login_pw.png" alt="password"></label>
							<input type="password" name="PASSWORD" id="PASSWORD" class="input_txt">
						</div>
						<input type="image" src="${pageContext.request.contextPath}/resources/btn_login.png" alt="로그인" class="btn_login" onClick="submitLogin()">
						<div class="check" style="display:none">
							<p><input type="checkbox" name="remeber" id="remember"><label for="remember"><img src="${pageContext.request.contextPath}/resources/tx_remember_id.gif" alt="REMEBER USER ID"></label></p>
							<p><a href="#"><img src="${pageContext.request.contextPath}/resources/tx_forget_pw.gif" alt="FORGET USER PASSEORD?"></a></p>
						</div>
					</div>
				</fieldset>
				<span class="bottom_bg"></span>
			</div>
		</div>
		<hr>
		<!-- footer -->
		<div id="footer">
			<p class="info">관리자 : <a href="mailto:camon85@gmail.com">camon85@gmail.com</a></p>
			<p>Copyright ⓒ<strong>camon</strong>. All Rights Reserved.</p>
		</div>
		<!-- //footer -->
	</div>
	</FORM>
</body>
</html>
