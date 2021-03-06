<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src='<c:url value='/resources/js/login/login.js'/>'></script>
<link rel="stylesheet" href='<c:url value='/resources/css/login/login.css'/>'>
</head>
<body>
	<section id="window">
		<div id="context">
			<img id="logoFull" alt="<EVERY-LECTURE>" src='<c:url value='/resources/image/logo-full-clear.png'/>'>
			<br>
			<br>
			<br>
			<div id="yesNo">관리자 로그인</div>
			<form id="loginForm" method="post" action='<c:url value='/admin/goLogin' />'>
				<input id="userID" name="adminID" class="eInput" type="text" placeholder="ID">
				<br>
				<br>
				<input id="userPW" name="adminPW" class="eInput" type="password" placeholder="Password">
				<br>
				<br>
				<button id="loginSubmit" class="eBtn" type="submit">Login</button>
			</form>
			<br>
			<br>
			<hr>
			<div id="indicator">
				<a href='<c:url value="/login/joinForm"/>'><div class="index_top">회원 가입</div></a> 
				<a href='<c:url value="/"/>'><div class="index_top">홈페이지로 가기</div></a>
			</div>
		</div>
	</section>
</body>
</html>