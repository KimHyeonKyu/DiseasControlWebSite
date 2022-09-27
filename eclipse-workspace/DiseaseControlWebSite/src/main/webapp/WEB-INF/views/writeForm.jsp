<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 글 작성하기</title>
</head>
<body>

	<div style="text-align: right">
		&nbsp;&nbsp;<input type="button" value="로그아웃"
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

	<form action="write" method="post">
		<li>제목 : <input type="text" name="title" width="50px"></li> <br>
		<li>내용</li> <br>
		<textarea name="content" id="content" rows="15" cols="50"></textarea>
		<br>
		<li>공개 <input type="radio" name="privacy" value="open"> &nbsp; &nbsp; 비공개
			<input type="radio" name="privacy" value="close"></li> <br>
		<li>비밀번호 : <input type="password" name="password"></li> <br>
		<input type="submit" value="제출">
	</form>

	<br>
	<br>
	<hr color="C0C0C0">
	<br>
	<img src="/resources/static/images/국영문혼합_세로형_2.png"
		style="display: block; margin: 0 auto; width: 188px; height: 88px;"
		alt="질병관리청로고2" onclick="location='home'" />
	<br>
</body>
</html>