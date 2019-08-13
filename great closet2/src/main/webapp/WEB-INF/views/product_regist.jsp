<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>중고거래 상품 등록</title>
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
		<h1 align="center">글쓰기</h1>
		<br> <br>
		<div align="center">
			<form action="product_regist" method="post" name="product_regist">
				<!-- enctype="multipart/form-data"> -->
				<table>
					<tr height="35">
						<td>제목</td>
						<td><input type="text" name="db_title" placeholder="제목 입력"
							required="requred"></td>
					</tr>
					<tr height="35">
						<td>가격</td>
						<td><input type="number" name="db_price" placeholder="숫자만 입력하세요"
							required="requred"></td>
					</tr>
					<tr>
						<td>내용</td>
						<td><textarea id="db_content" name="db_content" rows="15"
								cols="80" required="required"></textarea> <!-- 해당 에디터 적용 --> <script>
									CKEDITOR.replace('db_content');
								</script></td>
					</tr>

				</table>
				
				<div class="btn">
					<div><a href="./product_mainGo"><input type="button" value="취소"></a></div>
					<div><a href="./product_regist?db_num=${db_num}"><input type="submit" value="저장"></a></div>
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
<!-- 
<script>
	function fileChk(elem) {
		console.dir(elem.value);
		if(elem.value ==""){
			console.log("empty");
			$("#fileCheck").val(0); //파일첨부 안한 글
		}
		else{
			console.log("not empty");
			$("#fileCheck").val(1); //파일첨부 한 글
		}
	}
	
	function formData(){
		var $obj = $("#files"); //파일 배열
		
		var fData = new FormData();
		fData.append("db_title", $("#db_title").val());
		fData.append("db_content", $("#db_content").val());
		fData.append("db_cate", $("#db_cate").val());
		fData.append("db_price", $("#db_price").val());
		
		var files = $obj[0].files;
		for(var i = 0; i < files.length; i++){
			fData.append("files" + i, files[i]);
		}
		
		$.ajax({
			type: "post", //multipart 전송은 post로
			url: "product_regist?cnt="+files.length,
			data: fData,
			processData: false, //application/x-www-form-urlencoded(쿼리 스트링)형식으로 처리되지 않도록 막는 속성.
			contentType: false, //multipart일 경우 false로 지정
			dataType: "html", //생략가능
			success: function(data){
				alert("성공");
				location.href="./product_main";
				console.log(data);
			},
			error: function(error){
				alert("실패");
				console.log(error);
			}			
		});
	}
</script>
 -->

</html>