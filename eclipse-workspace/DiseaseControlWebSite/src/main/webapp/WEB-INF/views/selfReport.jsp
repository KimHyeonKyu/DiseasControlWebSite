<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>자기기입식 조사서</title>

</head>
<body>
<div style="text-align:right">
&nbsp;&nbsp;<input type="button" value="로그아웃" onclick="location='logOut'"> 
&nbsp;<input type="button" value="회원가입" onclick="location='joinform.jsp'">&nbsp;
</div>
　<img src="/resources/static/images/국문_가로형.png" width="270" height="85" align="left" alt="질병관리청로고" onclick="location='home'"/>
<h2 style="color:#696969;"><SUP>　코로나 19 정보 관리</SUP></h2>
<span style="line-height:50%"><br></span>
<hr color="C0C0C0">
<br><br>

<form action="submitSelfReport" method="post">	<!-- action값 변경 -->

<table border="1" bordercolor="C0C0C0">
<th colspan="2">개인 정보 작성</th>
<tr><td align="center" width="100" height="40">이름</<td>
<td width="510" height="40"><p style="width:800px;height:40px;border:none;background:transparent;">${name}</p></td>	<!-- 태그 변경 -->
</tr>
<tr><td align="center" width="100" height="40">성별</td> 
<td width="510" height="40">
	<p>${gender}</p>	<!-- 태그 변경 -->
</td></tr>
<tr><td align="center" width="100" height="40">핸드폰 번호</<td>
<td width="510" height="40"><p type="text" style="width:800px;height:40px;border:none;background:transparent;" name="phoneNumber">${phoneNumber}</p></td>	<!-- 태그 변경 -->
</tr>
<tr><td align="center" width="100" height="40">주소</<td>
<td width="510" height="40"><p type="text" style="width:800px;height:40px;border:none;background:transparent;" name="phoneNumber">${address}</p></td>	<!-- 태그 변경 -->
</tr>
</table>

<p><br>
<ol>
<li>예방접종 최종차수를 선택하세요.</li>
<span style="line-height:50%"><br>
	<select name="vaccine" style="width:100px">
	<option value="vaccine">　</option>
	<option value="1차">1차</option>
	<option value="2차">2차</option>
	<option value="3차">3차</option>
	</select>&nbsp;&nbsp;${vaccineCheck}
</span>
<p><br>
<li>확진 14일 전부터 현재까지 증상여부를 선택하세요.</li>
<span style="line-height:50%"><br>
<input type="radio" name="symptom_check" value="withSymptom" >있음	<!-- name, value값 변경 -->
<input type="radio" name="symptom_check"  value="noSymptom" >없음	<!-- name, value값 변경 -->
</span>&nbsp;&nbsp;${symtomChCheck}
<p><br>
<li>증상 발생일은 언제인가요?</li>
<span style="line-height:50%"><br>
<input type="Date" name="symptom_date">
</span>&nbsp;&nbsp;${symtomDateCheck}
<p><br>
<li>이번 양성 판정 검사일(검체채취일)은 언제인가요?</li>
<font size="2.8em" color="blue">*PCR검사, 신속항원검사(전문가용), 응급선별검사 중 가장 최근 검사일</font><br>
<span style="line-height:50%"><br>
<input type="Date" name="test_date">
</span>	&nbsp;&nbsp;${testDateCheck}
<p><br>
<li>기저질환이 있나요?</li>
<span style="line-height:50%"><br>
<input type="radio" name="condition_check" value="withSymptom" >있음 <!-- name, value값 변경 -->
<input type="radio" name="condition_check" value="noSymptom" >없음	<!-- name, value값 변경 -->
</span>&nbsp;&nbsp;${conditionChCheck}
<p><br>
<li>국민비서 알림 방법을 선택하세요.</li>
<font size="2.8em" color="blue">*감염병 치료(입원, 재택, 시설 등)및 격리 시 필요한 절차와 주의사항들을 휴대전화로 안내드립니다.</font><br>
<span style="line-height:50%"><br>	
	<select name="contact" style="width:100px">	<!-- name값 변경 -->
	<option value="blank">　</option>
	<option value="문자">문자</option>
	<option value="이메일">이메일</option>
	<option value="카카오톡">카카오톡</option>
	</select>
</span>&nbsp;&nbsp;${contactCheck}
</ol>
<p><br>
<table border="1" bordercolor="white" align="center">
<th>
위 내용을 잘 읽어보신 후 내용이 맞으면 '제출' 버튼을 눌러주세요. 틀린 내용이 있으면 '수정' 버튼을 눌러 수정하세요.
<span style="line-height:100%"><br>	<br>
<font size="2.8em" color="red">* 보건소 담당자 또는 역학조사반이 제출하신 정보의 확인을 위하여 다시 연락드릴 수 있습니다. 감사드립니다.</font>
</span></th>
</table>

<p><br>
	<div style="text-align:center">
	<input type="reset" value="수정" onclick="location='selfReport'">&nbsp;&nbsp;
	<input type="submit" size="40" value="제출하기">&nbsp;&nbsp;

	</div>
</form>

<br><br>
<hr color="C0C0C0">
<br>
<img src="/resources/static/images/국영문혼합_세로형_2.png" style="display: block; margin: 0 auto; width:188px; height:88px;" alt="질병관리청로고2" onclick="location='home'"/>
<br>
</body>
</html>