<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>중고 거래 메인</title>
<!-- 헤더 풋터 관련 -->
<link type="text/css" rel="stylesheet" href="resources/css/common.css">

<!-- 메인 css -->
<link type="text/css" rel="stylesheet"
	href="resources/css/contest/contest_main.css">

<!--   jquery 기본 -->
<script src="js/jquery-1.11.3.min.js"></script>

<!-- 슬라이더 관련 -->
<link type="text/css" rel="stylesheet"
	href="resources/css/contest/flexslider.css" />

<!-- 이미지슬라이더 관련 -->
<script src="js/jquery.flexslider.js"></script>
<script src="js/f_slider.js"></script>

<!-- Place in the <head>, after the three links -->
<!-- 이미지 슬라이더 관련
<script type="text/javascript" charset="UTF-8">
  $(window).load(function() {
    $('.flexslider').flexslider();
  });
  
  
  ----
  $('.flexslider').flexslider({
 		animation: 'slide'
 	});
</script>
 -->

<script type="text/javascript" charset="UTF-8">
 	$(window).load(function() {
 		$('.flexslider').flexslider();
 	});
 </script>

</head>

<body>
	<header>
		<!-- 헤더로고 -->
		<div id="h_top">
			<h1>
				<img src="resources/image/common/panda.png" />
			</h1>
		</div>
		<!-- 메인/서브네비게이션 -->
		<center>
			<div id="h_bottom">
				<nav class="main_nav">
					<ul>
						<li class="parent"><a href="#" title="LookBook">LookBook</a>
							<ul class="child">
								<li><a href="./lookbook_mainGo" title="lookbook">Look
										Book</a></li>
								<li><a href="./contest_mainGo" title="Contest">Contest</a></li>
							</ul></li>
						<li class="parent"><a href="#" title="게시판">Board</a>
							<ul class="child">
								<li><a href="#" title="Request">요청게시판</a></li>
								<li><a href="#" title="Share">자랑게시판</a></li>
								<li><a href="#" title="info">정보게시판</a></li>
							</ul></li>
						<li><a href="#" title="팔로잉">Following</a></li>
						<li class="parent"><a href="./product_mainGo" title="중고거래">Deal</a>
							<ul class="child">
								<li><a href="./product_mainGo" title="Contest">거래공간</a></li>
								<li><a href="#" title="Contest"> 쪽지함</a></li>
							</ul></li>
						<li><a href="#" title="Mypage">My page</a></li>
					</ul>
				</nav>
			</div>
		</center>
	</header>
	<section>
		<!-- 배너 슬라이드 -->
		<div class="flexslider">
			<ul class="slides">
				<li><img src="resources/image/contest/conImg1.jpg"
					alt="이미지슬라이더1" /></li>
				<li><img src="resources/image/contest/conImg2.jpg"
					alt="이미지슬라이더2" /></li>
			</ul>
		</div>

		<!-- <div class="cmain_img">
			<a href="./contest_infoGo" title="콘테스트 참가 안내 바로가기"><img
				src="resources/image/contest/banner.png" alt="배너" />
		</div> -->

		<div class="add_btn">
			<a href="./contest_infoGo"><button>참가 안내</button></a>
		</div>

		<div class="one_content">
			<!-- 여기는 콘테스트에 참여한 룩북이 하나가 보이는 거(반복) -->
			<table>
				<tr>
					<td  class="contestP_img"><img src="resources/image/contest/k.jpg"></td>
					<td>hyeon</td>
				</tr>
			</table>
			<hr>
			<img alt="콘테스트 참여 이미지" src="resources/image/product/one.jpg">
			<hr>
			<table>
				<tr>
					<td class="contest_heart"><img src="resources/image/contest/heart.png"></td>
					<td width="150px;">Like 12</td>
					<td><input type="button" value="신고"></td>
				</tr>
				<tr>#해시태그들</tr>
			</table>
		</div>

	</section>

	<footer>
		<!-- 풋터로고 -->
		<div id="f_top">
			<h1>
				<a href="./" title="메인페이지 바로가기"><img
					src="resources/image/common/panda.png" alt="로고" /></a>
			</h1>
		</div>
		<div id="f_mail">
			<P>문의 사항은 great@service.com 로 보내주세요</P>
		</div>
		<!-- 저작권 -->
		<div id="f_bottom">
			<p>COPYRIGHT ⓒ 2019 Dev.Great Team ALL RIGHT RESERVED</p>
		</div>
	</footer>
</body>

</html>