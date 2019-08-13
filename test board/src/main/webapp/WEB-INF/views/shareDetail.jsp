<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Home</title>
<link type="text/css" rel="stylesheet" href="resources/css/common.css">
<script>
	window.onload = function() {
		var chk = ${param.check};

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
	
	${compare} <br> <a href="./share">목록으로</a>
	
	<table id="table">
			<tr height="30">
				<td width="100" bgcolor="black" align="center">number</td>
				<td width="300" bgcolor="white">${share.sb_num}</td>
			</tr>

			<tr height="30">
				<td width="100" bgcolor="black" align="center">date</td>
				<td width="300" bgcolor="white">${share.sb_date}</td>
			</tr>
			<tr height="30">
				<td width="100" bgcolor="black" align="center">views</td>
				<td width="300" bgcolor="white">${share.sb_views}</td>
			</tr>
			<tr height="30">
				<td width="100" bgcolor="black" align="center">id</td>
				<td width="300" bgcolor="white">${share.sb_sid}</td>
			</tr>
		</table>

		<table>
			<tr height="50">
				<th width="100" bgcolor="black" align="center">title</th>
				<td width="300" bgcolor="white">${share.sb_title}</td>
			</tr>
			<tr height="200">
				<td width="100" bgcolor="black" align="center">사진</td>
				<td width="300" bgcolor="white"><img  src="./resources/files/${share.sb_sysname}" width="500"></td>
			</tr>
		</table>

		<table>
			<tr height="300">
				<th width="100" bgcolor="black" align="center">contents</th>
				<td width="300" bgcolor="white">${share.sb_content}</td>
			</tr>
		</table>
		
		
		
		<!-- 댓글 입력-->
		<form name="rFrm" id="rFrm">
			<table>
				<tr height="30">
					<td width="100" bgcolor="black" align="center">댓글</td>
					<td><textarea type="text" name="sbr_content" rows="2"
							cols="70" required="required">
				</textarea><br></td>
				</tr>
			</table>

			<br> <input id="log" type="button"
				onclick="replyInsert(${share.sb_num})" value="write"><br>
			<br> <br> <br>


		</form>
		<br>
		
		
		<!-- 댓글 출력 -->

		<div align="center">
			<table>
				<tr align="center" height="30" bgcolor="black">
					<th width="100">글쓴이</th>
					<th width="500">내용</th>
					<th width="200">날짜</th>
					<th width="200"></th>
				</tr>
			</table>
			<table class="mediatext-muted pt-3" id="rTable">
				<c:forEach var="r" items="${rList}">
					<!-- ---------------------------------------------------------------------------- -->
					<div id="up" , name="up">
						<tr height="40" align="center">
							<td width="100">${r.sbr_sid}</td>
							<td width="500">${r.sbr_content}</td>
							<td width="200">${r.sbr_date}</td>
							<td width="100">${compare}<br>
							</td>
						</tr>
					</div>
				</c:forEach>
			</table>
		</div>
		
		
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
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="resources/js/jquery.serializeObject.js"></script>
<script>


function replyInsert(num){
	// form의 데이터를 javascript 객체화.
	// -> json 객체
	var obj=$("#rFrm").serializeObject();
	obj.sbr_sbnum=num;
	console.log(obj);
	
	$.ajax({
		type: 'post',
		url: 'shareReplyInsert',
		data: obj,
		dataType: 'json',
		success: function(data, status, xhr){
			console.log(status)
			console.log(xhr); // XMLHttpRequest(객체의 폼형식 관련 API)
			console.log(data);
			
			var rlist ='';
		
			for(var i=0; i < data.rList.length ; i++){
				rlist += '<tr height="40" align="center">'
				+ '<td width="100">' + data.rList[i].sbr_sid + '</td>'
				+ '<td width="500">' + data.rList[i].sbr_content + '</td>'
				+ '<td width="200">' + data.rList[i].sbr_date + '</td>'
				+ '<td width="100">' + data.rList[i].compare + '</td></tr>';
				
			}
			$('#rTable').html(rlist);
			alert("success!");
		},
		error: function(xhr, status){
			alert("fail");
			console.log(xhr);
			console.log(status);
		}
	});
}

</script>
</html>
