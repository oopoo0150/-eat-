<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<title>Home</title>
<link type="text/css" rel="stylesheet" href="resources/css/common.css">
<link type="text/css" rel="stylesheet" href="resources/css/closet.css">
<link type="text/css" rel="stylesheet"
	href="resources/css/bootstrap.min.css">
<link type="text/css" rel="stylesheet"
	href="resources/css/bootstrap-theme.min.css">
<script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>

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
								<li><a href="#" title="lookbook">Look Book</a></li>
								<li><a href="#" title="Contest">Contest</a></li>
							</ul></li>
						<li class="parent"><a href="#" title="게시판">Board</a>
							<ul class="child">
								<li><a href="./request" title="Request">요청게시판</a></li>
								<li><a href="#" title="Share">자랑게시판</a></li>
								<li><a href="#" title="info">정보게시판</a></li>
							</ul></li>
						<li><a href="#" title="팔로잉">Following</a></li>

						<li class="parent"><a href="#" title="중고거래">Deal</a>
							<ul class="child">
								<li><a href="#" title="Contest">거래공간</a></li>
								<li><a href="#" title="Contest"> 쪽지함</a></li>
							</ul></li>
						<li class="parent"><a href="#" title="Mypage">My page</a>
							<ul class="child">
								<li><a href="#" title="Contest">Closet</a></li>
							</ul></li>
				</nav>
			</div>
		</center>
	</header>
	<section>

		</br> </br> </br> </br> </br> </br> </br>

		<div class="div">

			<div class="div2">

				<div>

					<a href="./clothesList?cl_cnum=${c_num}&cl_style=상의"> <img
						src="resources/image/icon/clothing-hanger.png" width="80"
						height="80" />
					</a>
					</button>
				</div>

				<div>
					<center>상의</center>
				</div>

			</div>

			<div class="div2">

				<div>
					<a href="./clothesList?cl_cnum=${c_num}&cl_style=하의"> <img
						src="resources/image/icon/clothing-hanger.png" width="80"
						height="80" />
					</a>
				</div>

				<div>
					<center>하의</center>
				</div>

			</div>

			<div class="div2">

				<div>
					<a href="./clothesList?cl_cnum=${c_num}&cl_style=모자"> <img
						src="resources/image/icon/clothing-hanger.png" width="80"
						height="80" />
					</a>
				</div>

				<div>
					<center>모자</center>
				</div>

			</div>

			<div class="div2">

				<div>
					<a href="./clothesList?cl_cnum=${c_num}&cl_style=신발"> <img
						src="resources/image/icon/clothing-hanger.png" width="80"
						height="80" />
					</a>
				</div>

				<div>
					<center>신발</center>
				</div>

			</div>

			<div class="div2">

				<div>
					<a href="./clothesList?cl_cnum=${c_num}&cl_style=가방"> <img
						src="resources/image/icon/clothing-hanger.png" width="80"
						height="80" />
					</a>
				</div>

				<div>
					<center>가방</center>
				</div>

			</div>

			<div class="div2">

				<div>
					<a href="./clothesList?cl_cnum=${c_num}&cl_style=악세서리"> <img
						src="resources/image/icon/clothing-hanger.png" width="80"
						height="80" />
					</a>
				</div>

				<div>
					<center>악세서리</center>
				</div>

			</div>

			<div class="div2">

				<div>
					<a href="./clothesList?cl_cnum=${c_num}&cl_style=원피스"> <img
						src="resources/image/icon/clothing-hanger.png" width="80"
						height="80" />
					</a>
				</div>

				<div>
					<center>원피스</center>
				</div>

			</div>

		</div>




	</section>
	<footer>
		<!-- 풋터로고 -->
		<div id="f_top">
			<h1>
				<a href="index.html" title="메인페이지 바로가기"><img
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



