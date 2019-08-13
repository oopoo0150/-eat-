<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
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
<head>
<meta charset="UTF-8">
<title>great closet login</title>
<script>
	window.onload = function() {
		var chk=${check};
		if (chk==2) {
			alert("로그인 성공.")
		}
		if (chk==3) {
			alert("비밀번호가 다릅니다.")
		}
		if (chk==4) {
			alert("가입돤 아이디가 아닙니다.")
		}
		
	}
</script>
</head>
 	<center>
	<div style="width: 1000px; height: 600px; border: solid; margin-top: 50px;">
	
	<div style="margin-top: 210px;">
	<form action="./login_Access"  method="post" name="home" onsubmit="return logincheck()">
		<table border="1" style="align-content: center;">
				<tr>	
					<th colspan="2" style="text-align: center;"><h1>로그인</h1></th>
				</tr>
				<tr>
					<td>아이디</td>
					<td><input type="text" name="s_id" id="s_id" placeholder="아이디 입력"></td>
				</tr>
				<tr>
					<td>비밀번호</td>
					<td><input type="password" name="s_pass" id="s_pass" placeholder="비밀번호 입력 "></td>
				</tr>
			</table>
			<a href="./findid">아이디/비밀번호 찾기</a><br>
				    <div class="checkbox icheck">
                        <label>
                            <input type="checkbox" name="useCookie"> 로그인유지
                        </label>
                    </div>
			<input type="submit" value="로그인">
			<button>
				<a href="./signup2">회원가입</a>
			</button>
	</form>
	</div>
	
	</div>
	</center>
	
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
	function logincheck() {
		var login = document.home;
		var length = home.length - 2;
		for (var i = 0; i < length; i++) {
			if (home[i].value == "" || home[i].value == null) {
				alert(home[i].placeholder + "란을 입력하세요!!")
				home[i].focus();
				return false;
			}
		}
		
		
		return true;
	}
	
//	 $(function () {
//	        $('input').iCheck({
//	            checkboxClass: 'icheckbox_square-blue',
//	            radioClass: 'iradio_square-blue',
//	            increaseArea: '20%' // optional
//	        });
//	    });
	 
</script>
</html>