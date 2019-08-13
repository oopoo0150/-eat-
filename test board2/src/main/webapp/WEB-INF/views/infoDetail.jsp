<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>

<!-- JQuery CDN -->
<script src="https://ajax.googleapis.com/ajax/libs/jQuery/3.2.1/jquery.min.js"></script>
<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<!-- 부가적인 테마 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">


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

		<h1>요청 게시판 상세</h1>
		
		${compare}
		<br><a href="./info">목록으로</a>


		<!-- Modal -->
		<form action="#">
<div class="modal fade" id="replyUpdate" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="myModalLabel"> 리플 수정 </h5>
      </div>
      <div class="modal-body">
        <input type = "text" id = "id" value = ""> 
        
        
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>
        <button type="button" class="btn btn-primary" onclick="insertBlack();">확인</button>
      </div>
    </div>
  </div></div>
  </form>



		<table id="table">
			<tr height="30">
				<td width="100" bgcolor="black" align="center">number</td>
				<td width="300" bgcolor="white">${info.in_num}</td>
			</tr>
			<tr height="30">
				<td width="100" bgcolor="black" align="center">cate</td>
				<td width="300" bgcolor="white">${info.in_cate}</td>
			</tr>
			
			<tr height="30">
				<td width="100" bgcolor="black" align="center">date</td>
				<td width="300" bgcolor="white">${info.in_date}</td>
			</tr>
			<tr height="30">
				<td width="100" bgcolor="black" align="center">views</td>
				<td width="300" bgcolor="white">${info.in_views}</td>
			</tr>
			<tr height="30">
				<td width="100" bgcolor="black" align="center">id</td>
				<td width="300" bgcolor="white">${info.in_sid}</td>
			</tr>
		</table>
		
		<table>
		<tr height="50">
				<th width="100" bgcolor="black" align="center">title</th>
				<td width="300" bgcolor="white">${info.in_title}</td>
			</tr>
		</table>
		
		<table>
		<tr height="300">
				<th width="100" bgcolor="black" align="center">contents</th>
				<td width="300" bgcolor="white">${info.in_content}</td>
			</tr>
		</table>
		
		<!-- 댓글 -->
		<h2>댓글</h2>
		<!-- 
		<table>
			<tr>
				<td width="100" bgcolor=#e0ddd7 align="center">writer</td>
				<td width="100" bgcolor="white">${reply.inr_sid}</td>
			<tr>
		</table>
		 -->
		
		 
		
		<!-- 댓글 입력-->
		<form name="rFrm" id="rFrm">
			<table>
				<tr height="30">
					<td width="100" bgcolor="black" align="center">댓글</td>
					<td><textarea type="text" name="inr_content"
							rows="2" cols="70" required="required">
				</textarea><br></td>
				</tr>
			</table>
			
			<br> <input id="log" type="button"
				onclick="replyInsert(${info.in_num})" value="write"><br>
			<br><br><br>
			
			 
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
				<div id="up", name="up">
				<tr height="40" align="center">
					<td width="100">${r.inr_sid}</td>
					<td width="500">${r.inr_content}</td>
					<td width="200">${r.inr_date}</td>
					<td width="100">
					${r.compare}<br>
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
$(document).on("click", ".replyUpdate", 
		function () {
		var id = $(this).data('num'); 
		$(".modal-body #id").val( id ); 
});



function replyInsert(num){
	// form의 데이터를 javascript 객체화.
	// -> json 객체
	var obj=$("#rFrm").serializeObject();
	obj.inr_innum=num;
	console.log(obj);
	
	$.ajax({
		type: 'post',
		url: 'replyInsert',
		data: obj,
		dataType: 'json',
		success: function(data, status, xhr){
			console.log(status)
			console.log(xhr); // XMLHttpRequest(객체의 폼형식 관련 API)
			console.log(data);
			
			var rlist ='';
		
			for(var i=0; i < data.rList.length ; i++){
				rlist += '<tr height="40" align="center">'
				+ '<td width="100">' + data.rList[i].inr_sid + '</td>'
				+ '<td width="500">' + data.rList[i].inr_content + '</td>'
				+ '<td width="200">' + data.rList[i].inr_date + '</td>'
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

function replyDelete(num){
	// form의 데이터를 javascript 객체화.
	// -> json 객체
	/*
	var obj=$("#rrFrm").serializeObject();
	obj.inr_num=num;
	console.log(obj);
	*/
	
	var no = {'num':num};
	
	
	$.ajax({
		url: 'replyDelete',
		data: no,
		dataType: 'json',
		success: function(data, status, xhr){
			console.log(status)
			console.log(xhr); // XMLHttpRequest(객체의 폼형식 관련 API)
			console.log(data);
			
			var rlist ='';
		
			for(var i=0; i < data.rList.length ; i++){
				rlist += '<tr height="40" align="center">'
				+ '<td width="100">' + data.rList[i].inr_sid + '</td>'
				+ '<td width="500">' + data.rList[i].inr_content + '</td>'
				+ '<td width="200">' + data.rList[i].inr_date + '</td>'
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



function editReply(id){

	var htmls = "";
	
	

	//htmls += '<div class="media text-muted pt-3" id="rTable">';

	//htmls += '<svg class="bd-placeholder-img mr-2 rounded" width="32" height="32" xmlns="http://www.w3.org/2000/svg" preserveAspectRatio="xMidYMid slice" focusable="false" role="img" aria-label="Placeholder:32x32">';

	//htmls += '<title>Placeholder</title>';

	//htmls += '<rect width="100%" height="100%" fill="#007bff"></rect>';

	//htmls += '<text x="50%" fill="#007bff" dy=".3em">32x32</text>';

	//htmls += '</svg>';

	//htmls += '<p class="media-body pb-3 mb-0 small lh-125 border-bottom horder-gray">';

	//htmls += '<span class="d-block">';

	//htmls += '<strong class="text-gray-dark">' + writer + '</strong>';

	//htmls += '<span style="padding-left: 7px; font-size: 9pt">';

	//htmls += '<a href="javascript:void(0)" onclick="fn_updateReply(' + num + ', \'' + writer + '\')" style="padding-right:5px">저장</a>';

	//htmls += '<a href="javascript:void(0)" onClick="showReplyList()">취소<a>';

	//htmls += '</span>';

	//htmls += '</span>';		

	htmls += '<textarea name="editContent" id="editContent" class="form-control" rows="3">';

	htmls += id;

	htmls += '</textarea>';

	

	//htmls += '</p>';

	//htmls += '</div>';

	

	$('#up').replaceWith(htmls);

	$('#up').focus();
	

}

/*

function updateChangeReply(reply_num,reply_content){

 $('#replyUpdate_content').replaceWith('<input type="text" id="reply_text" value='+reply_content+'>');

 $('#updateReply').replaceWith('<input type="button" id="reply_reply" value="댓글 수정">');

 $('#reply_reply').on('click',function(){

  $.ajax({

   url:"updateReply",

   method:"post",

   data:{

    "reply_num":reply_num,

    "reply_content":$("#reply_text").val(),

    "board_num":${board.board_num}

   },

   success:function(board_num){

    alert('댓글이 성공적으로 수정되었습니다.');

    //location.href = "${pageContext.request.contextPath}/boards/get?board_num="+board_num;

   }

  });

  

 });

}

*/

</script>
</html>
