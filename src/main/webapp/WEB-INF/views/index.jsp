<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
<meta charset="UTF-8">
<title>당신의 프로그래밍 - EVERY-LECTURE</title>
<script src="<%= context %>/resources/js/index/index.js"></script>
<link rel="stylesheet" href="<%= context %>/resources/css/index/index.css">
</head>
<body>
	<!-- 오버레이 부분 -->
	<div id="overlay_wrapper">
		<jsp:include page="login/login_overlay.jsp"></jsp:include>
	</div>
	<div id="index_overlay"></div>
	<!-- 오버레이 부분 끝 -->
	<jsp:include page="index/index_top.jsp"></jsp:include>
	<section id="header">
		<div id="head">
			<div id="head_left_wrap">
				<div id="head_left">
					<div id="intro">
						모두를 위한 강의.<br>모두를 위한 프로그래밍.
					</div>
					<br>
					<div id="left_sub">Java부터 데이터베이스까지 전부 무료!</div>
				</div>
			</div>
			<div id="head_right_wrap">
				
			</div>
		</div>
	</section>
	<footer id="footer">
		
	</footer>
	<button id="testBtn" class="eBtn">테스트 페이지 이동</button>
</body>
</html>