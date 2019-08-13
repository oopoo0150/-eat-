<%@page import="org.springframework.web.bind.annotation.SessionAttributes"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>
<html>
<head>
<title>Home</title>
<script>
	window.onload = function() {
		var chk=${check};
		if (chk==1) {
			alert("가입 성공.")
		}

	}
</script>
<link type="text/css" rel="stylesheet" href="resources/css/common.css">
</head>
<body>

<header>
<!-- 헤더로고 -->
<div id="h_top">
	<h1><img src="resources/image/common/panda.png"/></h1>
</div>
<!-- 메인/서브네비게이션 -->
<center>
<div id="h_bottom">
	<nav class="main_nav">
		<ul>
			<li class="parent"><a href="#" title= "LookBook">LookBook</a>
				<ul class="child">
					<li><a href="./lookbook_main" title="lookbook">Look Book</a></li>
					<li><a href="./contest_main" title="Contest">Contest</a></li>
				</ul>
			</li>
			<li  class="parent"><a href="#" title= "게시판">Board</a>
				<ul class="child">
					<li><a href="./request" title="Request">요청게시판</a></li>
					<li><a href="#" title="Share">자랑게시판</a></li>
					<li><a href="#" title="info">정보게시판</a></li>
				</ul>
			</li>
			<li><a href="#" title= "팔로잉" >Following</a></li>

			<li class="parent"><a href="./product_main" title= "중고거래">Deal</a>
				<ul class="child">
					<li><a href="./product_main" title="Contest">거래공간</a></li>
					<li><a href="#" title="Contest"> 쪽지함</a></li>
				</ul>
			</li>
<<<<<<< HEAD
<<<<<<< HEAD
			<li class="parent"><a href="./mypage" title= "Mypage">My page</a></li>
		</ul>
=======
			<li  class="parent"><a href="#" title= "Mypage">My page</a>
				<ul class="child">
					<li><a href="./closetList?user=tami" title="Contest">Closet</a></li>
				</ul>
				</li>
>>>>>>> 5680ad82a28d9989aacb2db86c122a1a81957759
=======
			<li class="parent"><a href="./mypage" title= "Mypage">My page</a>
			<ul class="child">
					<li><a href="./closetList" title="Contest">Closet</a></li>
			</ul>
			</li>
		</ul>
>>>>>>> 8c7ec0dc314b1f3c39447740d509c54c813e29bf
	</nav>
</div>
</center>
</header>
	<c:set var="id" value="${id}"/>
	<c:if test="${empty id}">
		<center>
		<div class="main" style="text-align: center;">
			<table border="1" style="margin: auto;">
				<tr>
					<th>메인 페이지</th>
				</tr>
			</table>
		</div>
		<a href="./findid">아이디/비밀번호 찾기</a>
		<div class="loginbox">
			<input class="login" type="button" value="로그인" onclick="location.href='./login'">
		    <input class="signup" type="button" value="회원가입" onclick="location.href='./signup2'">	
	    </div>
	    </center>
	</c:if>
	<c:if test="${!empty id}">
		<center>
		<div>
		<img alt="" src="">
		<table border="1">
			<tr height="30">
				<td width="80" bgcolor="pink" align="center">아이디</td>
				<td>${mb.s_id},${id}</td>
			</tr>
			<tr height="30">
				<td width="80" bgcolor="pink" 
				align="center">이름</td>
				<td>${mb.s_name}</td>
			</tr>
			<tr height="30">
				<td width="80" bgcolor="pink" 
				align="center">닉네임</td>
				<td>${mb.s_nick}</td>
			</tr>
			<tr height="30">
				<td width="80" bgcolor="pink" 
				align="center">이메일</td>
				<td>${mb.s_mail}</td>
			</tr>
			<tr>
				<td colspan="2">
					<div align="center">
						<form id="logoutFrm" action="./logout" method="post">
							<a href="./logout">로그아웃</a>	
						</form>
						<button id="return checkid()">아이디 확인</button>
					</div>
				</td>
			</tr>
		</table>
		</div>
		</center>
	</c:if>
	
	

<footer>
<!-- 풋터로고 -->
	<div id="f_top">
<h1><a href="./" title="메인페이지 바로가기"><img src="resources/image/common/panda.png" alt="로고" /></a></h1>
</div>
<div id="f_mail">
	<P>문의 사항은  great@service.com 로 보내주세요</P>
</div>
<!-- 저작권 -->
<div id="f_bottom">
	<p>COPYRIGHT ⓒ 2019 Dev.Great Team ALL RIGHT RESERVED</p>
</div>
</footer>	
</body>
</html>