<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>


<style type="text/css">
div {
	text-align: center;
}

.noresize {
	resize: none; /* 사용자 임의 변경 불가 */
}
</style>
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
		<SUP> &nbsp; &nbsp; 코로나 19 정보 관리</SUP>
	</h2>
	<span style="line-height: 50%"><br></span>
	<hr color="C0C0C0">

	<p style="width: 464px;">제목 : ${title}</p>
	<hr color="C0C0C0">
	<p style="width: 464px; height: 287px;">내용 : ${content}</p>





	<form action="commentWrite" method="post">
		댓글:
		<textarea style="resize: none;" name="comment" rows="2" cols="80"
			placeholder="댓글을 작성해주세요"></textarea>
		<input type="submit" name="submit" value="입력">
	</form>
	<hr>
	<h3>댓글</h3>
	<hr>
	<c:forEach var="commentlist" items="${commentlist}">
		<c:choose>
			<c:when test="${flag =='u' && rid==commentlist.commentId }">
				<form action="commentUpdateDo?commentId=${commentlist.commentId}"
					method="post">
					수정 댓글: <input name="comment" size=100
						value="${commentlist.comment}" /> <input type="submit"
						name="submit" value="입력">
				</form>
			</c:when>

			<c:otherwise>
				<pre>댓글번호:${commentlist.commentId}</pre>
				<pre>작성자:${commentlist.id}</pre>
				<pre>댓글:${commentlist.comment}</pre>
				<a href="inputChildComment?commentId=${commentlist.commentId}">대댓글</a>
				<c:if test="${commentlist.id == id}">
					<a href="updateCommentShow?commentId=${commentlist.commentId}">수정</a>
					<a href="deleteComment?commentId=${commentlist.commentId}">삭제</a>
				</c:if>

				<c:forEach var="list" items="${childCommentList}">
					<c:if test="${commentShow == 'u' && showId==commentlist.commentId}">
						<pre>&nbsp; ${list.id}님의 댓글</pre>
						<pre>&nbsp;&nbsp;--> ${list.childComment}</pre>
					</c:if>
				</c:forEach>

				<c:if test="${commentFlag == 'u'&& inputId==commentlist.commentId}">
					<form action=childCommentShow?commentId=${commentlist.commentId}
						method="post">
						<pre>&nbsp; -> 대댓글 입력 : <input type="text"
								name="childComment">
						</pre>
						<c:forEach var="list" items="${childCommentList}">
							<pre>&nbsp; ${list.id}님의 댓글</pre>
							<pre>&nbsp;&nbsp;--> ${list.childComment}</pre>
						</c:forEach>
						<input type="submit" value="입력">
					</form>
				</c:if>

			</c:otherwise>
		</c:choose>
		<hr>
	</c:forEach>



	<br>
	<br>
	<hr color="C0C0C0">
	<br>
	<img src="/resources/static/images/국영문혼합_세로형_2.png"
		style="display: block; margin: 0 auto; width: 188px; height: 88px;"
		alt="질병관리청로고2" onclick="location='home'" />
</body>
</html>