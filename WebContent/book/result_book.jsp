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
	function insert(){
		document.location.href = "${ root }/book.do?act=mvinsertbook";
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
			<h1>결과 페이지</h1>
			<h3>정상적으로 저장 되었습니다.</h3>
			<br>
			<form id="form" method="post" action="">
				<input type="hidden" name="act" id="act" value="insertbook">
				<div align="center">
					<button type="button" onclick="insert();">추가 등록</button>
					<button type="button" onclick="list();">도서 목록</button>
				</div>
			</form>
		</c:if>
	</div>
</body>
</html>