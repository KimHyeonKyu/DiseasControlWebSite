<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원가입</title>
<style>
fieldset {
	width: 600px;
	margin: 0 auto;
}
</style>
</head>

<body bgcolor='FFFFFF'>

	<div style="text-align: right">
		&nbsp;&nbsp;<input type="button" value="로그인"
			onclick="location='loginForm'"> &nbsp;<input type="button"
			value="회원가입" onclick="location='signUpForm'">&nbsp;
	</div>
	<img src="resources/static/images/국문_가로형.png" width="270" height="85"
		align="left" alt="질병관리청로고" onclick="location='homeCheckLog'" />
	<h2 style="color: #696969;">
		<SUP> 코로나 19 정보 관리</SUP>
	</h2>
	<span style="line-height: 50%"><br></span>
	<hr color="C0C0C0">
		<br>
	<fieldset>
		<table bordercolor="C0C0C0" border="2" align="center">
			<tr>
				<td align="center" width="500"><h2>회원가입</h2></td>
			</tr>
		</table>
			<br>
		<form action="signUp" method="post" >
			<h3>ID</h3>
			<input type="text" name="id" size="20">
			${idCheck}
			${checkNum}
			${size}
			<br/>
			<h3>비밀번호</h3>
			<input type="password" name="password" size="20" placeholder="비밀번호  8자리 이상 " minlength="8">
			${passwordCheck}
			<br>
			<h3>비밀번호 확인</h3>
			<input type="password" name="confirmPassword" size="20" placeholder="비밀번호  확인" minlength="8">
			${passwordCheck}
			<br/>
		
			<h3>이름</h3>
			<input type="text" name="name" size="20">
			${nameCheck}
			<br/>
			<h3>주민등록번호</h3>
			<input type="text" name="registerNumber" size="20">
			${registerNumberCheck}
			<br/>

			<h3>전화번호</h3>
			<select name="phone">
				<option value="010">010</option>
				<option value="02">02</option>
				<option value="031">031</option>
				<option value="041">041</option>
			</select> <input type="text" name="phoneNumber" size="20">
			${phoneNumberCheck}
			<br/>

			<h3>성별</h3>
			<input type="radio" name="gender" value="male">남자 
			<input type="radio" name="gender" value="female">여자
			${genderCheck}

			<h3>주소</h3>
			<input type="text" name="address" size="25" placeholder="주소">
			${addressCheck}

			<br/>
			<br/>
			<br/>
			<div style="text-align: center">
				<input type="submit" value="가입" >&nbsp;&nbsp;
				<input type="reset" value="초기화">
			</div>
			<br>
		</form>

	</fieldset>


	<br/>
	<br/>
	<hr color="C0C0C0">
	<br/>
	<img src="resources/static/images/국영문혼합_세로형_2.png"
		style="display: block; margin: 0 auto; width: 188px; height: 88px;"
		alt="질병관리청로고2" onclick="location='homeCheckLog'" />
	<br/>
</body>
</html>