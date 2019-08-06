<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Home</title>
<link type="text/css" rel="stylesheet" href="resources/css/common.css">
<link type="text/css" rel="stylesheet" href="resources/css/closet.css">
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
			<li  class="parent"><a href="#" title= "Mypage">My page</a>
				<ul class="child">
					<li><a href="#" title="Contest">Closet</a></li>
				</ul>
				</li>
	</nav>
</div>
</center>
</header>
<section>

<div class = "add">
<button onclick="closetAdd(${Closet.c_sid})">
	<img src = "resources/image/icon/plus.png" alt= 추가 width = "50" height = "50" />
	</button>
</div>

<div class = "div">

<c:forEach var="Closet" items="${cList}">

<div class = "div2">

	<div>
	<input type = "checkbox" class = "check"/>
	</div>	
	<form action="#">
	<button name = "del" value = ${Closet.c_num}>
	<img src = "resources/image/icon/closet.png" alt= {Closet.c_name} width = "100" height = "100" />
	</button>
	</form>
	
	<div>
	<center>
	<a href="#">${Closet.c_name}</a>
	</center>
	</div>
	</div>

</c:forEach>


</div>

<div>
<input type = "button" value = "삭제" class = "btn"/>
</div>

</section>
<footer>
<!-- 풋터로고 -->
	<div id="f_top">
<h1><a href="index.html" title="메인페이지 바로가기"><img src="resources/image/common/panda.png" alt="로고" /></a></h1>
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


</script>
function insertAdd(user){

	$.ajax({
		type:'post',
		url: 'insertAdd',
		data: user,
		dataType:'json',
		success: function(data, status, xhr){


}



</html>
