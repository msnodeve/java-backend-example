<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${ pageContext.request.contextPath }" />

<html lang="ko">
<head>
<title>Book Index page</title>
<meta charset="utf-8">
</head>
<body>
	<div align="center">
		<h3>도서 관리 페이지</h3>
		<hr>
		<c:if test="${ userinfo == null }">
			<h3>${ msg }</h3>
			<%@ include file="/user/login.jsp"%>
		</c:if>
		<c:if test="${ userinfo != null }">
			<div>
				<br>
				<strong>${ userinfo.id }</strong>님 환영합니다.
				<br>정상적으로 로그인 되었습니다.<br><br>
				<div>
					<a href="${ root }/">도서 등록</a>
					<a href="${ root }/">도서 목록</a>
				</div>
			</div>
		</c:if>
	</div>
</body>
</html>