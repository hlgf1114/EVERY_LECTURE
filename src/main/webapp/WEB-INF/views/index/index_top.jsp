<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!-- 오버레이 부분 -->
<div id="overlay_wrapper">
	<section id="overlay_window">
		<div id="window_context">
			<form id="loginForm" method="post" action="<%= context %>/login/userLoginCheck">
				<input id="userID" name="userID" class="eInput" type="text" placeholder="ID">
				<br>
				<br>
				<input id="userPW" name="userPW" class="eInput" type="password" placeholder="Password">
				<br>
				<br>
				<input id="loginSubmit" class="eBtn" type="submit" value="Login">
			</form>
		</div>
	</section>
</div>
<div id="index_overlay"></div>
<!-- 오버레이 부분 끝 -->
<body>
	<div id="navi">
		<div id="top_left">
			<a href="#none">
				<img id="logoImg" alt="이미지를 불러오는 것을 실패했습니다." 
				src="<%= context %>/resources/image/logo-white.png">
				<a id="logoWord">EVERY-LECTURE</a>
			</a>
		</div>
		<div id="top_right">
		<!-- 세션이 없다면 -->
			<c:if test="${empty sessionScope.sid}">
				<div id="login" class="index_top">
					<a href="#none">로그인</a>
				</div>
				<div class="index_top">
					<a href="#none">회원 가입</a>
				</div>
			</c:if>
			<c:if test="${not empty sessionScope.sid}">
				<div>
				
				</div>
			</c:if>
			<div class="index_top">
				<a href="#none">강의 보러가기</a>
			</div>
		</div>
	</div>
</body>