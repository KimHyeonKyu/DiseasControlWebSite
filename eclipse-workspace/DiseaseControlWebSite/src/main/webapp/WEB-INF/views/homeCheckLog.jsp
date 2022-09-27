<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>질병관리청</title>
</head>
<body>

<div style="text-align:right">
&nbsp;&nbsp; ${id}<input type="button" value="로그인" onclick="location='loginForm'"> 
&nbsp;<input type="button" value="회원가입" onclick="location='signUpForm'">&nbsp;
</div>
　<img src="/resources/static/images/국문_가로형.png" width="270" height="85" align="left" alt="질병관리청로고" onclick="location='home'"/>
<h2 style="color:#696969;"><SUP>　코로나 19 정보 관리</SUP></h2>
<span style="line-height:50%"><br></span>
<hr color="C0C0C0">

<script>
	function checkLogIn(){
		alert("로그인 후 이용가능합니다.");
	}
</script>

　<input type="button" style="background-color:white; border-color:white; border-radius:10px; color:#5F9EA0; font-weight:bold; font-size:15px; padding:10px 7px;" 
	value="자기기입식 조사서" onclick="checkLogIn();">
　<input type="button" style="background-color:white; border-color:white; border-radius:10px; color:#5F9EA0; font-weight:bold; font-size:15px; padding:10px 7px;" 
	value="게시판" onclick="checkLogIn();">
<br><br>
<img src="/resources/static/images/홈이미지.jpg" width="1900" height="562" align="middle" alt="홈"/>

<br><br>
<hr color="C0C0C0">
<br>
<img src="/resources/static/images/국영문혼합_세로형_2.png" style="display: block; margin: 0 auto; width:188px; height:88px;" alt="질병관리청로고2" onclick="location='home'"/>
<br>
</body>
</html>