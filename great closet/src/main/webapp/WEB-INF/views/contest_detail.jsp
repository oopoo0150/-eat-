<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>중고 거래 메인</title>
<link type="text/css" rel="stylesheet" href="resources/css/common.css">
<link type="text/css" rel="stylesheet"
	href="resources/css/contest/contest_detail.css">
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
								<li><a href="./lookbook_main" title="lookbook">Look
										Book</a></li>
								<li><a href="./contest_mian" title="Contest">Contest</a></li>
							</ul></li>
						<li class="parent"><a href="#" title="게시판">Board</a>
							<ul class="child">
								<li><a href="#" title="Request">요청게시판</a></li>
								<li><a href="#" title="Share">자랑게시판</a></li>
								<li><a href="#" title="info">정보게시판</a></li>
							</ul></li>
						<li><a href="#" title="팔로잉">Following</a></li>
						<li class="parent"><a href="./product_main" title="중고거래">Deal</a>
							<ul class="child">
								<li><a href="#" title="Contest">거래공간</a></li>
								<li><a href="#" title="Contest"> 쪽지함</a></li>
							</ul></li>
						<li><a href="#" title="Mypage">My page</a></li>
					</ul>
				</nav>
			</div>
		</center>
	</header>
	<section>
		<center>
		<!-- 제일 큰 통째 -->
			<div>
				<div class="proId">
					프로필 사진이랑 아이디랑 날짜
					<div class="contestD_img">
						<img src="resources/image/contest/p.png" />
					</div>
					<div>작성자 아이디</div>
					<div>2019-11-05</div>
				</div>
				<hr>
				<div>상세 이미지</div>
				<hr>
				<div class="click">
					<div id="heart">
						<img src="resources/image/contest/heart.png" alt="좋아요" />
					</div>
					<div id="likeCnt">Like 96</div>
					<div id="notify">
						<img src="resources/image/contest/bell.png" alt="신고" />
					</div>
				</div>
<br>
				<div>#집에가는룩#집으로가는룩#버스가안온다#버스</div>
			</div>
		</center>
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