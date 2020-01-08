<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>강의 페이지</title>
<link rel="stylesheet" href='<c:url value='/resources/css/lecture/lecture_index.css'/>'>
</head>
<body>
	<%@ include file="../index/index_top.jsp" %>
	<div id="lecture_page">
		<section id="wrapper">
			<c:forEach items="${lectureList}" var="lectureList">
				
				<div class="lectureTable">
					<div class="lectureLeft">
						<img alt="강의 이미지" class="lectureImg" src="${lectureList.lectureImgPath}">
					</div>
					<div class="lectureRight">
						<div class="right_wrapper">
							<div class="lectureName">
								<div>
									<c:out value="${lectureList.lectureName}"/>
								</div>
							</div>
							<div class="lectureExplain">
								<div>
									<c:out value="${lectureList.lectureExplain }"/>
								</div>
								<div>
									<button class="eBtn">강의 등록하기</button>
								</div>
							</div>
						</div>
					</div>		
				</div>
			</c:forEach>
		</section>
		
		<footer id="footer">
			<div id="joinSession">
				<div>이제 시작할 준비가 되셨나요?</div>
				<button id="joinButtonFooter" class="eBtn">회원 가입 하기</button>
			</div>
			<div id="last">
				<div id="last_left">
					<h2>The flat icon belongs to www.flaticon.com</h2>
					<br>
					<h2>This site is made by Golden Brothers.Inc</h2>
				</div>
				<div id="last_right">
				</div>
			</div>
		</footer>
	</div>
</body>
</html>