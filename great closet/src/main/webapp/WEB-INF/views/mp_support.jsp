<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>고객지원</title>
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
 <div id="support_total">
 	<div id="suport_top">
 		<div><h1>고객지원</h1></div>
 		<div class="notice_img">이미지</div>
 		<div><p>사이트 이용 및 App이용 관련 문의사항은 아래 메일로 요청해주세요<br>
 		great@service.com</p></div>
 	</div>
 	<div id="support_lisg">
 		<div>
 		 	<form action="supportList" name="mp_support">
 		 	<select name="spcate">
 		 		           <c:if test="${support.spcate == '전체'}">
								<option value="전체" selected>전체</option>
							</c:if>
							<c:if test="${support.spcate != '전체'}">
								<option value="전체">전체</option>
							</c:if>	 	
 							<c:if test="${support.spcate == '공지사항'}">
								<option value="공지사항" selected>공지사항</option>
							</c:if>
							<c:if test="${support.spcate != '공지사항'}">
								<option value="공지사항">공지사항</option>
							</c:if>
							
							<c:if test="${support.spcate == '콘테스트'}">
								<option value="콘테스트" selected>콘테스트</option>
							</c:if>
							<c:if test="${support.spcate != '콘테스트'}">
								<option value="콘테스트">콘테스트</option>
							</c:if>					
				</select></td> 							
	 		<input type="submit" value="선택">
 		</form>
 		
 		</div>
 		<table>
 			<tr>
 				<ht>구분</th>
 				<ht>번호</th>
 				<ht>제목</th>
 				<ht>날짜</th>
 				<ht>조회수</th>				
 			</tr>
 			<c:forEach var="support" items="${spList}">
 				<tr>
 					<td align="center">${support.spnum}</td>
 					<td align="center">${support.sptitle}</td>
 					<td align="center"><a href="./spcontents?spnum=${support.spnum}">${support.spcontent}</a></td>
 					<td align="center">${support.spdate}</td>
 					<td align="center">${support.spviews}</td>
 					<td align="center">${support.spcate}</td>
 					<td align="center">${support.spsid}</td>					
 				</tr>
 			</c:forEach>
 		</table>
 	</div>
 	<div id="support_bottom">
 		<div align="center">${paging}</div>	
 		<div>
 		
 		<% 
 			String id = session.getAttribute("id").toString();
 			if(id.equals("ADMIN")){			
 		%>
 			 <form action="spWrite">
  				<input type="button" value="글쓰기">
  			</form>
  		<%
 			}
  		%>	
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