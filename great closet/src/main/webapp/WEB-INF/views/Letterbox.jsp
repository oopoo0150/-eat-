<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>
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
	<h1><img src="resources/image/common/panda.png"/></h1>
</div>
<!-- 메인/서브네비게이션 -->
<center>
<div id="h_bottom">
	<nav class="main_nav">
		<ul>
			<li class="parent"><a href="#" title= "LookBook">LookBook</a>
				<ul class="child">
					<li><a href="./lookbook_main" title="lookbook">Look Book</a></li>
					<li><a href="./contest_main" title="Contest">Contest</a></li>
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

			<li class="parent"><a href="./product_main" title= "중고거래">Deal</a>
				<ul class="child">
					<li><a href="./product_main" title="Contest">거래공간</a></li>
					<li><a href="#" title="Contest"> 쪽지함</a></li>
				</ul>
			</li>
			<li class="parent"><a href="./mypage" title= "Mypage">My page</a>
			<ul class="child">
					<li><a href="./closetList" title="Contest">Closet</a></li>
			</ul>
			</li>
		</ul>
	</nav>
</div>
</center>
</header>
	<c:set var="id" value="${id}"></c:set>
	<c:if test="${!empty id}">
	<center>
		<div style="border: solid; width: 1000px; height: 600px; margin-top: 50px;" >
		
		<table border="1" style="margin-top: 50px;">
			<tr>
			<th width="360" height="40">제목</th>
			<th width="180">가격</th>
			<th colspan="2" width="362">대화상대</th>
			</tr>
		</table>
		<c:forEach var="Letterbox" items="${LBList}">
			<table border="1" style="text-align: center;">
				<tr>
				<td width="360">${Letterbox.BOX_TITLE}</td>
				<td width="180">${Letterbox.BOX_PRICE}</td>
				<td width="180">${Letterbox.BOX_BUYER}</td>
				<td width="180"><input type="button" value="쪽지보기" onclick="location.href='./'"></input></td>
				<tr>
			</table>
		</c:forEach>
		
		</div>
	</center>
	</c:if>
	<c:if test="${empty id}">
		<center>
		<div style="border: solid; width: 1000px; height: 600px; margin-top: 50px;">
			<div style="margin-top: 255px;">
			로그인 하시겠습니까?<br>
			<input type="button" style="width: 60px;" value="예" onclick="location.href='./login'">
			<input type="button" style="width: 60px;" value="아니요" onclick="location.href='./'">
			</div>
		</center>
		</div>
	</c:if>
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
<script>
	
</script>
</html>