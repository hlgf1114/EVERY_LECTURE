<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>board view</title>
<script src='<c:url value='/resources/js/board/boardView.js'/>'></script>
<link rel="stylesheet" href='<c:url value='/resources/css/board/boardView.css'/>'>
</head>
<body>
	<%@ include file="../index/index_top.jsp" %>
	<section>
		<div id="board_top">
			<img src='<c:url value='/resources/image/board.PNG' />' id="board_image">
		</div>
		<div id="view_area">
			<hr><br>
			<h3>게시글 보기</h3><br><br>
			<div id="view_content">	
				<table id="view_table">
					<tr class="view_context" id="tr1">
						<th>번 호</th><th><div id="boardID">${board.boardID}</div></th>
					</tr>
					<tr class="view_context" id="tr2">
						<th>조회수</th><th>${board.showed}</th>
					</tr>
					<tr class="view_context" id="tr3">
						<th>작성자</th><th>${board.userID}</th>
					</tr>
					<tr class="view_context" id="tr4">
						<th>제 목</th><th>${board.boardName}</th>
					</tr>
					<tr class="view_context" id="tr5">
						<th>내 용</th>
						<th><textarea rows="15" cols="63" name="" readonly="readonly">${board.boardText}</textarea></th>
					</tr>
					<tr class="view_context" id="tr6">
						<th colspan="2" align="center">
							<a href='<c:url value='/board/boardRevise/${board.boardID}'/>'><button id="revise" type="button" class="eBtn">수 정</button></a>
							<button id="delete" type="button" class="eBtn">삭 제</button>
							<button id="boardForm" type="button" class="eBtn">게시판 보기</button>
						</th>
					</tr>
				</table>
			</div>	
		</div>
		<div id="comment_wrapper">
<%-- 			<c:forEach items="" var="com"> --%>
				<div class="comment_box">
					<div class="com_left">
						<div>
							dssdsdsd
						</div>
					</div>
					<div class="com_right">
						<div>
							dssdsdsd
						</div>
					</div>
				</div>
<%-- 			</c:forEach> --%>
		</div>
	</section>
</body>
</html>