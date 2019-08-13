<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="resources/css/common.css">
<script type="text/javascript" src="//cdnjs.cloudflare.com/ajax/libs/jquery/1.9.0/jquery.js"></script>
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
			<li><a href="./mypage" title= "Mypage">My page</a></li>
		</ul>
	</nav>
</div>
</center>
</header>
<section>
<div id="product">
<center>
 	<div id="product">
 		<div><h1>판매내역</h1></div>
 	</div>
 	<div id="product_list">
 		<div>
 		 	<form action="saleList" name="mp_sale">
 		 		<select name="cate">
 		 			<c:if test="${product.db_cate == '전체'}">
						<option value="전체" selected>전체</option>
					</c:if>
					<c:if test="${product.db_cate != '전체'}">
						<option value="전체">전체</option>
					</c:if>
					<c:if test="${product.db_cate == '거래가능'}">
						<option value="거래가능" selected>거래가능</option>
					</c:if>
					<c:if test="${product.db_cate != '거래가능'}">
						<option value="거래가능">거래가능</option>
					</c:if>	
					<c:if test="${product.db_cate == '거래중'}">
						<option value="거래중" selected>거래중</option>
					</c:if>
					<c:if test="${product.db_cate != '거래중'}">
						<option value="거래중">거래중</option>
					</c:if>	
					<c:if test="${product.db_cate == '거래완료'}">
						<option value="거래완료" selected>거래완료</option>
					</c:if>
					<c:if test="${product.db_cate != '거래완료'}">
						<option value="거래완료">거래완료</option>
					</c:if>
					<c:if test="${product.db_cate == '기간만료'}">
						<option value="기간만료" selected>기간만료</option>
					</c:if>
					<c:if test="${product.db_cate != '기간만료'}">
						<option value="기간만료">기간만료</option>
					</c:if>		 				      				
				</select></td> 							
	 		<input type="submit" value="선택">
 		</form>		
 	</div>
 		<form action="checkedItemDel" method="post">
 		<table width="700px">
 			<tr>		
 				<th bgcolor="#C5E5D4"><input type="checkbox" id="allCheck"/></th>	
 				<th width="10%" bgcolor="#C5E5D4">번호</th>
 				<th width="15%" bgcolor="#C5E5D4">구분</th>
 				<th width="30%" bgcolor="#C5E5D4">제목</th>
 				<th width="20%" bgcolor="#C5E5D4">날짜</th>
 				<th width="15%" bgcolor="#C5E5D4">작성자</th>
 				<th width="10%" bgcolor="#C5E5D4">조회수</th>				
 			</tr>
 			<c:forEach var="product" items="${mpList}">
 				<tr>
 					<td><input type="checkbox" name="RowCheck" val="${product.db_num}"/></td>
 					<td align="center">${product.db_num}</td>
 					<td align="center">${product.db_cate}</td>
 					<td align="center"><a href="./product_detailGo?db_num=${product.db_title}">${product.db_title}</a></td>
 					<td align="center">${product.db_date}</td>
 					<td align="center">${product.db_sid}</td>
 					<td align="center">${product.db_views}</td>					
 				</tr>
 			</c:forEach>
 		</table>
 	</div>
 	<div id="product_bottom">
 		<div align="center">${mppaging}</div>	
 		<div>			
 				<input type="submit" value="삭제" name="mp_sale" onclick="checkedDel()">
 			</form>
 		</div>
 	</div>
 </center>	
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
<script type="text/javascript"> 
//1. 전체선택 체크박스 클릭 
 $(function(){
	 $("#allCheck").click(function(){ 
	 //만약 전체 선택 체크박스가 체크된상태일경우 
	 if($("#allCheck").prop("checked")) { 
		 //해당화면에 전체 checkbox들을 체크해준다
		 $("input[type=checkbox]").prop("checked",true); 
		 // 전체선택 체크박스가 해제된 경우 
		 } else { 
			 //해당화면에 모든 checkbox들의 체크를해제시킨다. 
			 $("input[type=checkbox]").prop("checked",false); } }) }) 
//2. 체크박스 선택 값 삭제
function checkedDel() {
		var check = document.getElementsByName("RowCheck");
		var checkList = "";
		var chk_check = false;
		var list = [];
		var j = 0;

		for (var i = 0; i < check.length; i++) {
			if (check[i].checked == true) {
				list[j] = check[i].value;
				j++;
				chk_check = true;
			}
		}

		var jsonList = {
			"ls" : list
		};
		console.log(jsonList);

		if (chk_check) {
			var con = confirm("선택한 값을 삭제하시겠습니까?");
			if (con) {

				$.ajax({
					type : 'post',
					url : 'checkedItemDel',
					data : jsonList,
					dataType : 'json',
					contentType : "application/json; charset=UTF-8",
					success : function(data, status, xhr) {
						location.href = "./saleList?UserId=${id}";
						alert("선택한 게시물을 삭제하였습니다.");
					},
					error : function(xhr, status) {
						alert("삭제실패");
						console.log(status);
						console.log(xhr);
					}
				});
			}
		} else {
			alert("하나 이상 선택해주세요.");
		}
	}         
</script> 
</html>