<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${ pageContext.request.contextPath }" />

<script type="text/javascript">
function login() {
	if(document.getElementById("userid").value == "") {
		alert("아이디 입력!!!");
		return;
	} else if(document.getElementById("userpwd").value == "") {
		alert("비밀번호 입력!!!");
		return;
	} else {
		document.getElementById("loginform").action = "${root}/user.do";
		document.getElementById("loginform").submit();
	}
}
	 
function moveJoin() {
	document.location.href = "${ root }/user.do?act=mvjoin";
}
</script>

</head>
<body>
<div align="center">
	<form id="loginform" method="post" action="">
	<input type="hidden" name="act" value="login">
		<table border="1">
			<tr>
				<td>아이디</td>
				<td><input type="text" id="userid" name="userid" placeholder="" value=""></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" id="userpwd" name="userpwd" placeholder="" onkeydown="javascript:if(event.keyCode == 13) {login();}"></td>
			</tr>
		</table>
		<br>
		<div align="center">
			<button type="button" onclick="javascript:login();">로그인</button>
			<button type="button" onclick="javascript:moveJoin();">회원가입</button>
		</div>
	</form>
</div>