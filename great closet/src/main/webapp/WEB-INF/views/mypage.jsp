<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="resources/css/common.css">
<link type="text/css" rel="stylesheet"
	href="resources/css/mypage/mypage.css">
</head>
<body>
	<header>
		<!-- 헤더로고 -->
		<div id="h_top">
			<h1><a href="./">
				<img src="resources/image/common/panda.png" /></a>
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
						<li class="parent"><a href="./mypage" title="Mypage">My page</a>
							<ul class="child">
								<li><a href="./adminpage" title="관리자페이지">관리자 페이지</a></li>
							</ul>
						</li>
					</ul>
				</nav>
			</div>
		</center>
	</header>
	<section>
		<center>
			<div id="mypage_total">
				<!-- mypage profile -->
				<div id="mypage_top">
					<!-- 이미지 편집 -->
					<div class="edit_profile">
						<img src="resources/image/mypage/yoon.jpg">
						<form>
							<botton>이미지 입력버튼</botton>
						</form>
					</div>
					<div id="uinfo">
						<div id="uinfo_top">
							<div class="access_id">
								<p>아이디</p>
							</div>
							<div class="move_editprofile">
								<form action="./mEditProfile">
									<button>프로필 수정</button>
								</form>
							</div>
							<div class="setting">
								<form action="./mSetting">
									<button>설정</button>
								</form>
							</div>
						</div>
						<div id="uinfo_bottom">
							<a href="./mSelction"><div class="sel_count">
								<p>채택</p>
								<p>count</p>
							</div></a>
							<a href="./mFollower"><div class="follwer_count">
								<p>팔로워</p>
								<p>count</p>
							</div></a>
							<a href="./mFollowing"><div class="following_count">
								<p>팔로잉</p>
								<p>count</p>
							</div></a>
						</div>
					</div>
				</div>
				<div id="mypage_bottom">
					<div class="s_box1">
						<a href="./mCloset"><img src="resources/image/mypage/s_box1.png"></a>
					</div>
					<div class="s_box2">
						<a href="./mCal"><img src="resources/image/mypage/s_box1.png"></a>
					</div>
					<div class="s_box3">
						<a href="./mBoard"><img src="resources/image/mypage/s_box1.png"></a>
					</div>
					<div class="s_box4">
						<a href="./mLookbook"><img src="resources/image/mypage/s_box1.png"></a>
					</div>
					<div class="s_box5">
						<a href="./mlog"><img src="resources/image/mypage/s_box1.png"></a>
					</div>
					<div class="s_box6">
						<a href="./mStatistics"><img src="resources/image/mypage/s_box1.png"></a>
					</div>
					<div class="s_box7">
						<a href="./mSale"><img src="resources/image/mypage/s_box1.png"></a>
					</div>
					<div class="s_box8">
						<a href="./mSupport"><img src="resources/image/mypage/s_box1.png"></a>
					</div>
				</div>
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