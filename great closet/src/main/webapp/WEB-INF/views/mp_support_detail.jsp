<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="resources/css/common.css">

</head>
<body>
<header>
<!-- 헤더로고 -->
<div id="h_top">
	<h1><a href="./"><img src="resources/image/common/panda.png"/></a></h1>
</div>
<!-- 메인/서브네비게이션 -->
<center>
<div id="h_bottom">
	<nav class="main_nav">
		<ul>
			<li class="parent"><a href="#" title= "LookBook">LookBook</a>
				<ul class="child">
					<li><a href="#" title="lookbook">Look Book</a></li>
					<li><a href="#" title="Contest">Contest</a></li>
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
			<li class="parent"><a href="#" title= "중고거래">Deal</a>
				<ul class="child">
					<li><a href="#" title="Contest">거래공간</a></li>
					<li><a href="#" title="Contest"> 쪽지함</a></li>
				</ul>
			</li>
			<li><a href="./mypage" title= "Mypage">My page</a></li>
		</ul>
	</nav>
</div>
</center>
</header>
<section>
	<div><h1>내용 출력</h1></div>
	<div id="sp_contents">
		<div>
			<div><h2>번호</h2> <p>${support.spnum}</p></div>
			<div><h2>분류</h2> <p>${support.spcate}</p></div>
			<div><h2>제목</h2> <p>${support.sptitle}</p></div>
			<div><h2>내용</h2> <p>${support.spcontent}</p></div>
			<div><h2>날짜</h2> <p>${support.spdate}</p></div>
			<div><h2>조회수</h2> <p>${support.spviews}</p></div>			
			<div><h2>작성자</h2> <p>${support.spsid}</p></div>		
		</div>	
	</div>
			
	</div>
			
</section>
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