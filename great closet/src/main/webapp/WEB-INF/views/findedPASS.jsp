<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
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
<meta charset="UTF-8">
<title>비밀번호 재설정</title>
<script>
	window.onload = function() {
		var chk=${passche};
		if (chk==2) {
			alert("비밀번호 변경 성공.")
		}
		
	}
</script>
</head>
	${id }
	<form action="./updatepass" method="post" onsubmit="return passcheck()" name="updatepass">
		<label for="s_pass">비밀번호</label> 
        <input type="password" id="s_pass" name="s_pass" placeholder="비밀번호" required="비밀번호"><br>
        <label for="spassCh">비밀번호 확인</label> 
        <input type="password" id="spassCh" name="spassCh" placeholder="비밀번호 확인" required="비밀번호 확인"><br>
        <input type="submit" value="변경하기">            
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
<script>
function passcheck() {
	var sig = document.updatepass;
		
		if(s_pass.value != spassCh.value){
			alert("변경 비밀번호가 일치하지 않습니다.");
			updatepass[2].focus();
			return false;
		}
		return true;
	//입력이 잘되었음
}
</script>

</html>