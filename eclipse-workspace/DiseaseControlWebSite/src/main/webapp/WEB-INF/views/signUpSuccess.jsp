<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	String id = request.getParameter("id");	
	String password = request.getParameter("password"); 
	if(id == "") { %>
<script>
	alert("아이디를 입력하세요.");
	history.go(-1);
</script>
<% } else if(password == "") { %>
<script>
	alert("비밀번호를 입력하세요.");
	history.go(-1);
</script>
<% } else { %>	

<html>
<head><title>회원가입 완료</title></head>

<body bgcolor='FFFFFF'>
<div style="text-align:right">
&nbsp;&nbsp;<input type="button" value="로그인" onclick="location='loginForm'"> 
&nbsp;<input type="button" value="회원가입" onclick="location='signUpForm'">&nbsp;
</div>
　<img src="resources/static/images/국문_가로형.png" width="270" height="85" align="left" alt="질병관리청로고" onclick="location='homeCheckLog'"/>
<h2 style="color:#696969;"><SUP>　코로나 19 정보 관리</SUP></h2>
<span style="line-height:50%"><br></span>
<hr color="C0C0C0">
<br><br><br><br><br>
<div style="text-align:center">

	<%=request.getParameter("id") %>님, 반갑습니다. 회원 가입에 성공하였습니다.<br>

<br>
<input type="button" value="로그인 화면으로 이동하기"  onclick="location='loginForm'"> 
</div>
</form>
<br><br><br><br><br>
<hr color="C0C0C0">
<br>
<img src="resources/static/images/국영문혼합_세로형_2.png" style="display: block; margin: 0 auto; width:188px; height:88px;" alt="질병관리청로고2" onclick="location='homeCheckLog'"/>
<br>
</body>
</html>
<% } %>