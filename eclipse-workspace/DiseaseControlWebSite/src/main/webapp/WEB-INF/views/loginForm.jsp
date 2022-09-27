<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<html>
<head><title>로그인</title></head>

<div style="text-align:right">
&nbsp;&nbsp;<input type="button" value="로그인" onclick="location='loginForm'"> 
&nbsp;<input type="button" value="회원가입" onclick="location='signUpForm'">&nbsp;
</div>
　<img src="resources/static/images/국문_가로형.png" width="270" height="85" align="left" alt="질병관리청로고" onclick="location='homeCheckLog'"/>
<h2 style="color:#696969;"><SUP>　코로나 19 정보 관리</SUP></h2>
<span style="line-height:50%"><br></span>
<hr color="C0C0C0">
<form action="joinSuccess" method="post" >
<br><br><br>
<div style="text-align:center">
아이디　　 <input type="text" name="memberId" size="15"><br>
비밀번호 　<input type="password" name="memberPw" size="15"><br><br>
${idCheck}<br>
${passwordCheck}
<br><br>
&nbsp;&nbsp;<input type="submit" value="로그인"> 
&nbsp;&nbsp;<input type="button" value="회원가입" onclick="location='signUpForm'"> 
</div>
</form>

<br><br>
<hr color="C0C0C0">
<br>
<img src="resources/static/images/국영문혼합_세로형_2.png" style="display: block; margin: 0 auto; width:188px; height:88px;" alt="질병관리청로고2" onclick="location='homeCheckLog'"/>
<br>
</body>
</html>
