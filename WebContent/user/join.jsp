<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${ pageContext.request.contextPath }" />
<!DOCTYPE html>
<html lang="ko">
<head>
<title>회원가입</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	$("#registerBtn").click(function() {
		if($("#username").val() == "") {
			alert("이름 입력!!!");
			return;
		} else if($("#userid").val() == "") {
			alert("아이디 입력!!!");
			return;
		} else if($("#userpwd").val() == "") {
			alert("비밀번호 입력!!!");
			return;
		} else if($("#userpwd").val() != $("#pwdcheck").val()) {
			alert("비밀번호 확인!!!");
			return;
		} else {
			$("#memberform").attr("action", "${ root }/user.do").submit();
		}
	});
});
</script>
</head>
<body>
<div align="center">
	<h2>회원가입</h2>
	<form id="memberform" method="post" action="">
		<input type="hidden" name="act" id="act" value="join">
		<table border="1">
			<tr>
				<td>아이디</td>
				<td><input type="text" id="userid" name="userid" placeholder=""></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" id="userpwd" name="userpwd" placeholder=""></td>
			</tr>
			<tr>
				<td>비밀번호재입력</td>
				<td><input type="password" id="pwdcheck" name="pwdcheck" placeholder=""></td>
			</tr>
			<tr>
				<td>이메일</td>
				<td><input type="text" id="username" name="username" placeholder=""></td>
			</tr>
			<tr>
				<td>주소</td>
				<td><input type="text" id="address" name="address" placeholder=""></td>
			</tr>
			<tr>
				<td>전화번호</td>
				<td><input type="text" id="phone" name="phone" placeholder=""></td>
			</tr>
			<tr>
				<td>아이디</td>
				<td><input type="text" id="userid" name="userid" placeholder=""></td>
			</tr>
		</table>
		<br>
		<div>
			<button type="button" class="btn btn-primary" id="registerBtn">회원가입</button>
			<button type="reset" class="btn btn-warning">초기화</button>
		</div>
	</form>
</div>
</body>
</html>