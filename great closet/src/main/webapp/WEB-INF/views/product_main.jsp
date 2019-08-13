<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>중고 거래 메인</title>

<script>
window.onload=function(){
	var chk=${param.check};
	
	if(chk==1){
		alert("삭제 성공!");
	}
	else if(chk==2){
		alert("삭제 실패!");
	}
}
</script>

<link type="text/css" rel="stylesheet" href="resources/css/common.css">
<link type="text/css" rel="stylesheet" href="resources/css/product/product_main.css">
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
		<!-- 전체 공간 -->
		<div>
			<div class="add_btn">
				<form action="./product_registGo">
					<button>상품 등록</button>
				</form>
			</div>
			<center>
			<div class="product_list">
				<!-- 상품 게시글 목록 나타내는 공간 -->
				<c:forEach var="product" items="${productList}">
					<div id="list_place">
						<table>
							<tr>
								<img alt="상품사진" src=""
								 id="product_img">								
							</tr>
							<tr>
								<td id="head">${product.db_cate}</td>
								<td><a
							href="./product_detailGo?db_num=${product.db_num}">${product.db_title}</a></td>
							</tr>
							<tr>
								<td id="head">가격 : </td>
								<td>${product.db_price}</td>
							</tr>
						</table>					
					</div>
				</c:forEach>
			</div>
			<br><br><br>
			<div align="center">${pagingP}</div>
			</center>
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