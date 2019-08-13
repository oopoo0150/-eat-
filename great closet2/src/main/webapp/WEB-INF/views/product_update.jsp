<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 게시글 수정</title>
<!-- ckediter -->
<script src="resources/ckeditor/ckeditor.js"></script>

<link type="text/css" rel="stylesheet" href="resources/css/common.css">
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
		<h1 align="center">글 수정</h1>
		<br> <br>
		<div align="center">
			<form action="product_update" method="post" name="product_update">
				<!-- enctype="multipart/form-data"> -->
				<table>
					<tr height="35">
						<td>제목</td>
						<td><input type="text" name="db_title"
							value="${product.db_title}" required="requred"></td>
					</tr>
					<tr height="35">
						<td>가격</td>
						<td><input type="number" name="db_price"
							value="${product.db_price}" required="requred"></td>
					</tr>
					<tr>
						<td>내용</td>
						<td><textarea id="db_content" name="db_content" rows="15"
								cols="80" required="required">${product.db_content}</textarea> 
							<script>
								CKEDITOR.replace('db_content');
							</script></td>
					</tr>

				</table>
				<div class="btn">
					<div>
						<a href="./product_detailGo?db_num=${product.db_num}"><input type="button" value="취소"></a>
					</div>
					<div>
						<input type="hidden" name="db_num" value="${product.db_num}">
						<input type="submit" value="수정하기">
					</div>
				</div>
			</form>
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

<script>
CKEDITOR.replace( 'editor', {
    extraPlugins: 'easyimage',
    cloudServices_tokenUrl: 'https://example.com/cs-token-endpoint',
    cloudServices_uploadUrl: 'https://your-organization-id.cke-cs.com/easyimage/upload/'
} );
</script> 
</html>