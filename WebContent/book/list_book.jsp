<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${ pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>결과화면</title>
</head>
<script type="text/javascript">
	function search(){
		document.getElementById("form").action = "${ root }/book.do";
		document.getElementById("form").submit();
	}
	function back(){
		document.location.href = "${ root }/";
	}
	function insert(){
		document.location.href = "${ root }/book.do?act=mvinsertbook";
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
			<h1>도서 목록 화면</h1>
			<strong>${ userinfo.id }</strong> 님 환영합니다. <a href="${ root }/user.do?act=logout">로그아웃</a>
			<br>
			<form id="form" method="post" action="">
				<input type="hidden" name="act" id="act" value="searchitem">
				<div align="right" style="width: 50%">
					<select name="searchoption">
						<option value="all">전체</option>
						<option value="title">도서명</option>
						<option value="publisher">출판사</option>
						<option value="price">가격</option>
					</select>
					<input type="text" id="searchitem" name="searchitem" value="">
					<button type="button" onclick="search();">검색</button>
				</div>
			</form>
			<table border="1" style="width: 50%">
				<tr>
					<td>도서번호</td>
					<td>도서명</td>
					<td>출판사</td>
				</tr>
				<c:forEach var="book" items="${ books }">
					<tr>
						<td><a href="${ root }/book.do?act=view&book=${ book.isbn }">${ book.isbn }</a></td>
						<td>${ book.title }</td>
						<td>${ book.publisher }</td>
					</tr>
				</c:forEach>
			</table>
			<div align="center">
				<button type="button" onclick="insert();">추가 등록</button>
				<button type="button" onclick="back();">메인 페이지</button>
			</div>
		</c:if>
	</div>
</body>
</html>