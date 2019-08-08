<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>info add</title>
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
						<li><a href="#" title="Mypage">My page</a></li>
					</ul>
				</nav>
			</div>
		</center>
	</header>
	<section>
		<h1 align="center">글쓰기</h1>
		<br> <br>
		<div align="center">
			<form action="spBoardInsert" name="mp_support_write" method="post">
			<!-- enctype="multipart/form-data">  -->
				<table>
					<tr height="35">
						<td width="100">카테고리</td>
						<td width="700">
						<select name="spcate">
								<option value="공지사항">공지사항</option>
								<option value="콘테스트">콘테스트</option>
						</select></td> 
					</tr>
					<tr height="35">
						<td>제목</td>
						<td><input type="text" name="sptitle" placeholder="제목 입력"
							required="required"></td>
					</tr>

					<tr>
						<td>내용</td>
						<td><textarea id="in_content" name="spcontent" rows="15"
								cols="80" required="required"></textarea> <!-- 해당 에디터 적용 --> <script>
									CKEDITOR.replace('in_content');
								</script></td>
					</tr>

				</table>
				
				<input type="submit" value="저장">
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
</html>


