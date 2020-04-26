<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${ pageContext.request.contextPath }" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서 등록 페이지</title>
</head>
<script type="text/javascript">
	function insert(){
		document.getElementById("insertform").action = "${ root }/book.do";
		document.getElementById("insertform").submit();
	}
	function cancel(){
		location.href="${ root }/";
	}
</script>
<body>
	<div align="center">
		<h2>도서 등록 화면</h2>
		<hr>
		<c:if test="${ userinfo.id == null }">
			<h3>로그인이 필요한 페이지 입니다.</h3>
			<br>
			<a href="${ root }">로그인 하러가기</a>
		</c:if>
		<c:if test="${ userinfo.id != null }">
		<br><br>
		<strong>${ userinfo.id }</strong> 님 환영합니다. <a href="${ root }/user.do?act=logout">로그아웃</a>
		<br><br>
		<form id="insertform" method="post" action="">
			<input type="hidden" name="act" id="act" value="insertbook">
			<table border="1">
				<tr>
					<td>도서 번호</td>
					<td><input type="text" id="isbn1" name="isbn1" value="">-<input type="text" id="isbn2" name="isbn2" value="">-<input type="text" id="isbn3" name="isbn3" value=""></td>
				</tr>
				<tr>
					<td>출판사</td>
					<td>
						<select name="publisher">
							<c:forEach var="publisher" items="${ publishers }">
								<option value="${ publisher.pno }">${ publisher.publisher }</option>
							</c:forEach>
						</select>
					</td>
				</tr>
				<tr>
					<td>제목</td>
					<td><input type="text" id="title" name="title" value=""></td>
				</tr>
				<tr>
					<td>저자</td>
					<td><input type="text" id="author" name="author" value=""></td>
				</tr>
				<tr>
					<td>설명</td>
					<td><input type="text" id="description" name="description" value=""></td>
				</tr>
				<tr>
					<td>가격</td>
					<td><input type="text" id="price" name="price" value=""></td>
				</tr>
				<tr>
					<td>출판일</td>
					<td><input type="text" id="date" name="date" value=""></td>
				</tr>
			</table>
			<br>
			<div align="center">
				<button type="button" onclick="insert();">도서 등록</button>
				<button type="button" onclick="cancel();">취소</button>
			</div>
		</form>
		</c:if>
	</div>
</body>
</html>