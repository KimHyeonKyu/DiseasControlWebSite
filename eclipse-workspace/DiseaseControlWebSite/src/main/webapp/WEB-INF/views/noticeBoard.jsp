<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 목록</title>
<link rel="stylesheet" href="resources/static/css/style.css"
	type="text/css">
</head>
<body>
	<div style="text-align: right">
		&nbsp;&nbsp;${id}님 환영합니다.&nbsp;<input type="button" value="로그아웃"
			onclick="location='logOut'"> &nbsp;<input type="button"
			value="회원가입" onclick="location='signUpForm'">&nbsp;
	</div>
	<img src="/resources/static/images/국문_가로형.png" width="270" height="85"
		align="left" alt="질병관리청로고" onclick="location='home'" />
	<h2 style="color: #696969;">
		<SUP> 코로나 19 정보 관리</SUP>
	</h2>
	<span style="line-height: 50%"><br></span>
	<hr color="C0C0C0">

	<p>공지 : 본 게시판은 질병관리청이 관리하는 사이트 입니다.</p>
	</br>
	<div class="board_list_wrap">
		<table class="board_list">
			<caption>게시판 목록</caption>
			<thread>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>공개여부</th>
				<th>글삭제</th>
			</tr>
			</thread>
			<tbody>
				<c:forEach items="${list}" var="board">
					<tr>
						<td class="id">${board.titleId}</td>
						<td><a class="title" href="passwordCheck?titleId=${board.titleId}">${board.title}</a></td>
						<td>${board.id}</td>
						<td>${board.privacy}</td>
						<c:if test = "${board.id == id}">
							<td class="delete"><a href="delete?titleId=${board.titleId}">삭제~~</a></td>
						</c:if>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div class="paging">
			<a href="noticeBoard?page=${backPage}" class="text">이전 페이지</a>
			<c:forEach var="pageNum" begin="1" end="${totalPageNumber}">
				<a href="noticeBoard?page=${pageNum}" class="num">${pageNum}</a>
			</c:forEach>
			<a href="noticeBoard?page=${forwardPage}" class="text">다음 페이지</a> <a
				href=writeForm class="text">글쓰기</a>
		</div>
	</div>
	<br>
	<br>
	<hr color="C0C0C0">
	<br>
	<img src="/resources/static/images/국영문혼합_세로형_2.png"
		style="display: block; margin: 0 auto; width: 188px; height: 88px;"
		alt="질병관리청로고2" onclick="location='home'" />
</body>
</html>