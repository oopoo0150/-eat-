<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>중고거래 상세보기</title>

<script>
window.onload=function(){
	var chk=${check};
	
	if(chk==1){
		alert("삭제 성공!");
	}
	else if(chk==2){
		alert("삭제 실패!");
	}
}

</script>

<link type="text/css" rel="stylesheet" href="resources/css/common.css">
<link type="text/css" rel="stylesheet"
	href="resources/css/product/product_detail.css">
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
			<div class="top">
				<a href="#">
					<div class="productR_img">
						<img src="resources/image/product/cebu.jpg"/>
					</div>
					<div>${product.db_sid}</div>
					<div>
						<div>${product.db_date}</div>
						<div id="up">
							<input type="button" value="Update">
						</div>
						<div id="delete">
							<a href="productDelete?db_num=${product.db_num}">
							<input type="submit" value="Delete"></a>
						</div>
					</div>
			</div>
			<hr>

			<!-- 중간 -->
			<div class="middle">
				<div class="mtitle">
					<div>${product.db_cate}</div>
					<div>제목 : ${product.db_title}</div>
				</div>
				<div>${product.db_content}</div>
				<div>가격 : ${product.db_price}</div>
				<div>조회수</div>
			</div>

			<!-- 하단 -->
			<hr>
			<div class="replyWrite">
				<div>
					<h3>댓글 달기</h3>
				</div>
				<div>
					<a>Writer</a>
				</div>
				<div>
					<a>아이디</a>
				</div>
				<form name="pReplyInsert" id="pReplyInsert">
					<input type="text" name="dbr_content" id="pReply">
					<button type="button">댓글등록</button>
				</form>
			</div>

			<div class="bottom">
				<div class="productR_img">
					<img src="resources/image/product/cebu.jpg" />
				</div>
				<div>댓쓰니 아이디</div>
				<div>2019-08-06 17:55</div>
				<br>
				<div>댓글 내용</div>
				<br>
				<div class="note_img">
					<img src="resources/image/product/note.png" />
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