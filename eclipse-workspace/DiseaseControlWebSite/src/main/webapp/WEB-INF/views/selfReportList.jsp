<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>코로나19 조사 현황</title>
</head>
<body>
<body>
<div style="text-align:right">
&nbsp;&nbsp;<input type="button" value="로그아웃" onclick="location='logOut'"> 
&nbsp;<input type="button" value="회원가입" onclick="location='signUpForm'">&nbsp;
</div>
　<img src="/resources/static/images/국문_가로형.png" width="270" height="85" align="left" alt="질병관리청로고" onclick="location='home'"/>
<h2 style="color:#696969;"><SUP>　코로나 19 정보 관리</SUP></h2>
<span style="line-height:50%"><br></span>
<hr color="C0C0C0">
<br><br>

<img src="/resources/static/images/방역체계.jpg" width="1680" height="350" alt="방역체계"/><br><br>
<table bordercolor="C0C0C0" border="1" align="center"> 
<tr><td align="center" width="1000"><h4 style="color:#4682B4;">2022년 8월 기준</h4></td></tr>
</table>
<img src="/resources/static/images/발생동향.jpg" width="1680" height="580" alt="발생동향"/>
<br><br>

<table bordercolor="C0C0C0" border="1" align="center">
<tr><th align="center" width="500" height="30">자기기입식 조사서 작성 현황</th></tr>
</table>
<br>

<table bordercolor="C0C0C0" border="1" align="center">
<th>글 번호</th>
<th>작성자</th>
<th>연락처</th>
<th>주소</th>
<c:forEach items="${list}" var="selfReport">
<tr>
	<td align="center" width="70" height="30">${selfReport.report_id}</td>
	<td align="center" width="200" height="30">${selfReport.name}</td>
	<td align="center" width="200" height="30">${selfReport.phoneNumber}</td>
	<td align="center" width="400" height="30">${selfReport.address}</td>
</tr>
</c:forEach>
</table>


<br><br>
<hr color="C0C0C0">
<br>
<img src="/resources/static/images/국영문혼합_세로형_2.png" style="display: block; margin: 0 auto; width:188px; height:88px;" alt="질병관리청로고2" onclick="location='home'"/>
</body>
</html>