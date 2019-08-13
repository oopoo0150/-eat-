<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>아이디 찾기</title>
<script>
	window.onload = function() {
		var chk=${ch};
		if (chk==1) {
			alert("아이디 찾기 성공.")
		}
		if (chk==2) {
			alert("결과에 맞는 아이디를 찾지 못함.")
		}
		
		
	}
</script>
</head>
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
			<li class="parent"><a href="./mypage" title= "Mypage">My page</a>
			<ul class="child">
					<li><a href="./closetList" title="Contest">Closet</a></li>
			</ul>
			</li>
		</ul>
	</nav>
</div>
</center>
</header>
	<input type="button" value="아이디 찾기" onclick="location.href='./findid'">
	<input type="button" value="비밀번호 찾기" onclick="location.href='./findpass'">
	<form action="./findedID" method="post">
		<input type="text" id="s_name" name="s_name" placeholder="이름 입력" required="required"><br>
		<input type="email" id="s_mail" name="s_mail" placeholder="가입 이메일 입력" required="required"><br>
		<input type="submit" value="아이디 찾기">
	</form>
	
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