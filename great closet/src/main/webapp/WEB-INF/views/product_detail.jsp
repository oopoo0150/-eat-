<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>중고거래 상세보기</title>

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
			<div>
				<div class="top">
					<table class="toptable">
						<tr>
							<a href="#" />
							<td class="productR_img" width="60px;"><img
								src="resources/image/product/cebu.jpg" /></td>
							<td width="500px;">${product.db_sid}</td>
							<td width="35px;"><a><input type="button" value="신고"></a></td>
							<td width="35px;"><a href="./product_UpdateGo?db_num=${product.db_num}">
									<input type="button" value="수정"></a></td>
							<td width="35px;"><a href="productDelete?db_num=${product.db_num}"> <input
									type="submit" value="게시글 삭제"></a></td>
						</tr>
					</table>
					<!-- 
					<a href="#">					
						<div class="productR_img">
							<img src="resources/image/product/cebu.jpg" />
						</div>
						<div>${product.db_sid}</div>
						<div>
							<div>${product.db_date}</div>
							<div>
								
								<a><input type="button" value="신고"></a>
							</div>
							<div id="up">
								<a href="./product_UpdateGo?db_num=${product.db_num}"> <input
									type="button" value="수정"></a>
							</div>
							<div id="delete">
								<a href="productDelete?db_num=${product.db_num}"> <input
									type="submit" value="게시글 삭제"></a>
							</div>
						</div>
				</div>
				 -->
					<hr>

					<!-- 중간 -->

					<table class="middle">
						<tr>
							<td>${product.db_cate}</td>
							<td id="title_font"><h1>제목 : ${product.db_title}</h1></td>
						</tr>
						<tr>
							<td></td>
							<td><img src="resources/image/product/of.jpg" /></td>
						</tr>
						<tr>
							<td>이미지 보여주는 공간</td>
						</tr>
						<tr>
							<td><img src="./resources/files/${productImg.dbi_sysname}"></td>
						</tr>
						<tr>
							<td>가격 : </td>
							<td>${product.db_price}</td>
						</tr>
						<tr>
							<td>내용 : </td>
							<td>${product.db_content}</td>
						</tr>
						<tr>
							<td>조회수 : </td>
							<td>${product.db_views}</td>
						</tr>
						<!-- <tr>
						<td>첨부파일 : </td>
						<td><c:set var="dealboard_img" value="${pfList}"/><c:if test="${empty file}">첨부파일 없음</c:if><c:if
						test="${!empty file}"> 
						<c:forEach var="pf" items="${pfList}">
							<a href="./downloadP?dbi_oriName=${productImg.dbi_oriName}&dbi_sysName=${productImg.dbi_sysName}">
							${dealboard_img.dbi_oriName}</a>
						</c:forEach></c:if>
						</td>
						</tr> -->
					</table>
					<br>

					<!-- 하단 -->
					<hr>
					<br>
					<div class="replyWrite">
						<div>
							
						</div>
						
						<table>
							<tr>
								<td class="productR_img">
								<img src="resources/image/product/cebu.jpg"/></td>
								<td width="500px;">session아이디 받아오기</td>
								<td><a href="./product_mainGo"><input type="button"
								value="목록으로 돌아가기" onclick="pviewsUp(${product.db_views})"></a></td>
							</tr>
						</table>
						
						<!-- 
						<div class="replyW">
							<div class="productR_img">
								<img src="resources/image/product/cebu.jpg" />
							</div>
							<div>session아이디 받아오기</div>
						</div>
						 -->
						<!-- 댓글 입력 폼 -->
						<div class="insert_reply">
							<div>
								<form name="productR_insert" id="productR_insert">
									<input type="hidden" name="dbr_dbnum" value="${product.db_num}">
									<table>
										<tr height="20">
											<td width="100" bgcolor="#f5f5f5" align="center">댓글</td>
											<td><input type="text" name="dbr_content" required="required"></td>
											<!-- <td><textarea type="text" name="dbr_content" rows="1"
													cols="100" required="required">
									</textarea></td> -->
											<td><input type="button" onclick="pReplyInsert()" width="250px;"
												value="입력"></td>
									</table>
								</form>
							</div>
						</div>

						<!-- 추가된 댓글 출력 부분 -->
						<div id="comment">
							<table>
								<tr align="center" height="30">
									<th width="300">Writer</th>
									<th width="500">Contents</th>
									<th width="400">Date</th>
									<th width="200">Etc</th>
								</tr>
							</table>
						</div>
					</div>
					<div id="comment">
						<table id="prTable">
							<c:forEach var="productReply" items="${prList}">
								<tr height="25" align="center">
									<td width="300"><img alt="쪽지 보내기" 
									src="resources/image/product/note_resize.png">
									${productReply.dbr_sid}</td>
									<td width="500">${productReply.dbr_content}</td>
									<td width="400">${productReply.dbr_date}</td>

									<form name="productR_delete" id="productR_delete">
										<input type="hidden" name="dbr_num"
											value="${productReply.dbr_num}">
										<td width="200">
											<!-- 신고는 모달창으로 할거임 -->
											<a><input type="button" value="신고"></a>
											<!-- 댓글 작성자랑 관리자만 수정 삭제 가능 
										<c:if test="${productReply.dbr_sid == sessionScope.sessionID}">
										</c:if>
										--> 
										<input type="button" value="수정">
										<input type="button" value="삭제"
											onclick="deleted(${productReply.dbr_num})">
										</td>
									</form>
								</tr>
							</c:forEach>
						</table>
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

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<!-- 종료 태그 합치면 안돌아감.. -->
<script src="resources/js/jquery.serializeObject.js"></script>

<script>
	//댓글 입력
	function pReplyInsert() {
		//form의 데이터를 javascript 객체화.
		// -> json 객체로 변환.
		var obj = $("#productR_insert").serializeObject();
		console.log(obj);

		$.ajax({
			type : 'post',
			url : 'pReplyInsert',
			data : obj,
			dataType : 'json',
			success : function(data, status, xhr) {
				console.log(status);
				console.log(xhr); //XMLHttpRequest(객체의 폼 형식 관련 API)
				console.log(data);

				var prlist = '';
				for (var i = 0; i < data.prList.length; i++) {
					//댓글 출력을 위한 html 작성
					prlist += '<tr height="25" align="center">'
							+ '<td width="300">'
							+ '<img alt="쪽지 보내기" src="resources/image/product/note_resize.png">'
							+ data.prList[i].dbr_sid
							+ '</td>' + '<td width="500">'
							+ data.prList[i].dbr_content + '</td>'
							+ '<td width="400">' + data.prList[i].dbr_date
							+ '</td>' + '<td width="200">' 
							+ '<a><input type="button" value="신고"></a>'
							+ '<a href="./product_UpdateGo?db_num=${product.db_num}">'
							+ '<input type="button" value="수정"></a>'
							+ '<a href="./productR_delete?dbr_num=${productReply.dbr_num}">'
							+ '<input type="submit" value="삭제"></a></td></tr>';
				}
				$('#prTable').html(prlist);
				alert("저장 성공");
			},
			error : function(xhr, status) {
				alert("댓글 저장에 실패했습니다");
				console.log(xhr + " 오류입니다");
				console.log(status);
			}
		});
	}
	
	//댓글 삭제
	function deleted(num){
		//form의 데이터를 javascript 객체화.
		// -> json 객체로 변환.
		//var obj = $("#productR_insert").serializeObject();
		//console.log(obj);
		var no = {'num': num};

		$.ajax({
			url : 'productR_delete',
			data : no,
			dataType : 'json',
			success : function(data, status, xhr) {
				console.log(status);
				console.log(xhr); //XMLHttpRequest(객체의 폼 형식 관련 API)
				console.log(data);

				var prlist = '';
				for (var i = 0; i < data.prList.length; i++) {
					//댓글 출력을 위한 html 작성
					prlist += '<tr height="25" align="center">'
							+ '<td width="300">' 
							+ '<img alt="쪽지 보내기" src="resources/image/product/note_resize.png">'
							+ data.prList[i].dbr_sid
							+ '</td>' + '<td width="500">'
							+ data.prList[i].dbr_content + '</td>'
							+ '<td width="400">' + data.prList[i].dbr_date
							+ '</td>' + '<td width="200">' 
							+ '<a><input type="button" value="신고"></a>'
							+ '<a href="./product_UpdateGo?db_num=${product.db_num}">'
							+ '<input type="button" value="수정"></a>'
							+ '<a href="./productR_delete?dbr_num=${productReply.dbr_num}">'
							+ '<input type="submit" value="삭제"></a></td></tr>';
				}
				$('#prTable').html(prlist);
				alert("삭제 성공");
			},
			error : function(xhr, status) {
				alert("댓글 삭제에 실패했습니다");
				console.log(xhr + " 오류입니다");
				console.log(status);
			}
		});
	}
	
	//댓글 수정 input 폼으로 변경
	function productR_update(dbr_num, dbr_content){
		var a = '';
		var contentV = dbr_content.split('<br>').join("\r\n");
		var contentW = contentV.split('</a>').join("");
		a+= '<div class=input-group>';
		a += '<textarea name="dbr_content_'+dbr_num+'" class="form-control" rows="1" cols="100"'
		+ ' required="required"' + contentW + '</textarea>';
		a += '<span class="input-group-btn"><button class="btn btn-default" type="button" onclick="productR_update('+dbr_num+');">수정</button></span>';
		a += '</div>';
		
		$('.dbr_content'+dbr_num).html(a);
	}
</script>

</html>










