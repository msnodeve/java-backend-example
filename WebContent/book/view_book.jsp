<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${ pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상세 화면</title>
</head>
<script type="text/javascript">
	function insert(){
		document.getElementById("form").action = "${ root }/book.do";
		document.getElementById("form").submit();
	}
	function list(){
		location.href="${ root }/book.do?act=booklist";
	}
</script>
<body>
	<div align="center">
		<hr>
		<c:if test="${ userinfo.id == null }">
			<h3>로그인이 필요한 페이지 입니다.</h3>
			<br>
			<a href="${ root }">로그인 하러가기</a>
		</c:if>
		<c:if test="${ userinfo.id != null }">
			<br><br>
			<strong>${ userinfo.id }</strong> 님 환영합니다. <a href="${ root }/user.do?act=logout">로그아웃</a>
			<h1>${ book.isbn } 번호 도서를 가져왔습니다.</h1>
			<hr>
			<br>
			<table border="1">
				<tr>
					<td>제목 : </td>
					<td>${ book.title }</td>
				</tr>
				<tr>
					<td>저자 : </td>
					<td>${ book.author }</td>
				</tr>
				<tr>
					<td>설명 : </td>
					<td>${ book.description }</td>
				</tr>
				<tr>
					<td>가격 : </td>
					<td>${ book.price }</td>
				</tr>
				<tr>
					<td>출판일 : </td>
					<td>${ book.date }</td>
				</tr>
				<tr>
					<td>출판사 : </td>
					<td>${ book.publisher }</td>
				</tr>
				<tr>
					<td>주소 : </td>
					<td>${ book.address }</td>
				</tr>
			</table>
		</c:if>
	</div>
</body>
</html>