<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Request</title>
<link type="text/css" rel="stylesheet" href="resources/css/common.css">
<link type="text/css" rel="stylesheet" href="resources/css/board/board.css">
<script>
	window.onload = function() {
		var chk = $
		{
			param.check
		}
		;

		if (chk == 1) {
			alert("저장되었습니다.");
		}
		if (chk == 2) {
			alert("수정되었습니다");
		}
		if (chk == 3) {
			alert("삭제되었습니다");
		}
		if (chk == 4) {
			alert("실패했습니다");
		}
		//url에서 파라미터를 제거
		history.replaceState({}, null, location.pathname);
	}
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
								<li><a href="#" title="lookbook">Look Book</a></li>
								<li><a href="#" title="Contest">Contest</a></li>
							</ul></li>
						<li class="parent"><a href="#" title="게시판">Board</a>
							<ul class="child">
								<li><a href="./request" title="Request">요청게시판</a></li>
								<li><a href="./share" title="Share">자랑게시판</a></li>
								<li><a href="./info" title="info">정보게시판</a></li>
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
	<!-- 
		<div align="center">
			<br><h1>정보 게시판</h1><br>
		</div>
		<div align="center">
			<table>
				<tr  bgcolor="black" height="35">
					<th width="200"></th>
					<th width="100">No</th>
					<th width="300">title</th>
					<th width="200">name</th>
					<th width="250">date</th>
					<th width="150">view</th>
				</tr>
				<c:forEach var="info" items="${info}">
					<tr bgcolor="white" height="40">
						<td align="center">${info.in_cate}</td>
						<td align="center">${info.in_num}</td>
						<td align="center"><a href="./infoDetail?bnum=${info.in_num}">${info.in_title}</a></td>
						<td align="center">${info.in_sid}</td>
						<td align="center">${info.in_date}</td>
						<td align="center">${info.in_views}</td>
					</tr>
				</c:forEach>
			</table>
			
				<br><a href="./iWrite">글쓰기</a>

		</div>
 -->
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
