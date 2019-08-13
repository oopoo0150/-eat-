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
<!-- 
<script src="<c:url value="/resources/js/jquery-1.11.3.min.js"/>"></script>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script> -->

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

			<form action="product_regist" method="post" enctype="multipart/form-data">
				<table>
					<tr height="35">
						<td>제목</td>
						<td><input type="text" id="db_title" name="db_title"
							placeholder="제목 입력" required="requred" width="5008""></td>
					</tr>
					<tr height="35">
						<td>가격</td>
						<td><input type="number" id="db_price" name="db_price"
							placeholder="숫자만 입력하세요" required="requred"></td>
					</tr>
					<tr>
						<td>내용</td>
						<td><textarea id="db_content" name="db_content" rows="15"
								cols="80" required="required"></textarea> <!-- 해당 에디터 적용 --> <script>
									CKEDITOR.replace('db_content');
								</script></td>
					</tr>
					<tr height="35">
						<td>파일추가</td>
						<td><a><input type="file" name="files" id="files" onchange="fileChk(this)" multiple></a></td>
						<input type="hidden" id="fileCheck" value="0" name="fileCheck">
					</tr>
				</table>
				<div>
					<div class="btn">
						<a href="./product_mainGo"><input type="button" value="취소"></a>
					</div>

					<div>
						<!-- 파일까지 저장 버튼
						<input id="log" type="submit" value="파일저장" onclick="formData()">
						<input type="button" value="저장" onclick="formData()">-->
						<input id="log" type="button" value="저장" onclick="formData()">
					</div>
					
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

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<!-- 이미지 프리뷰 -->
<script>
<!-- 
	//이미지 프리뷰
	function previewImage(targetObj, View_area) {
	var preview = document.getElementById(View_area); //div id
	var ua = window.navigator.userAgent;

  //ie일때(IE8 이하에서만 작동)
	if (ua.indexOf("MSIE") > -1) {
		targetObj.select();
		try {
			var src = document.selection.createRange().text; // get file full path(IE9, IE10에서 사용 불가)
			var ie_preview_error = document.getElementById("ie_preview_error_" + View_area);


			if (ie_preview_error) {
				preview.removeChild(ie_preview_error); //error가 있으면 delete
			}

			var img = document.getElementById(View_area); //이미지가 뿌려질 곳

			//이미지 로딩, sizingMethod는 div에 맞춰서 사이즈를 자동조절 하는 역할
			img.style.filter = "progid:DXImageTransform.Microsoft.AlphaImageLoader(src='"+src+"', sizingMethod='scale')";
		} catch (e) {
			if (!document.getElementById("ie_preview_error_" + View_area)) {
				var info = document.createElement("<p>");
				info.id = "ie_preview_error_" + View_area;
				info.innerHTML = e.name;
				preview.insertBefore(info, null);
			}
		}
  //ie가 아닐때(크롬, 사파리, FF)
	} else {
		var filess = targetObj.files;
		for ( var i = 0; i < filess.length; i++) {
			var filep = filess[i];
			var imageType = /image.*/; //이미지 파일일경우만.. 뿌려준다.
			if (!file.type.match(imageType))
				continue;
			var prevImg = document.getElementById("prev_" + View_area); //이전에 미리보기가 있다면 삭제
			if (prevImg) {
				preview.removeChild(prevImg);
			}
			var img = document.createElement("img"); 
			img.id = "prev_" + View_area;
			img.classList.add("obj");
			img.file = filep;
			img.style.width = '100px'; 
			img.style.height = '100px';
			preview.appendChild(img);
			if (window.FileReader) { // FireFox, Chrome, Opera 확인.
				var reader = new FileReader();
				reader.onloadend = (function(aImg) {
					return function(e) {
						aImg.src = e.target.result;
					};
				})(img);
				reader.readAsDataURL(file);
			} else { // safari is not supported FileReader
				//alert('not supported FileReader');
				if (!document.getElementById("sfr_preview_error_"
						+ View_area)) {
					var info = document.createElement("p");
					info.id = "sfr_preview_error_" + View_area;
					info.innerHTML = "not supported FileReader";
					preview.insertBefore(info, null);
				}
			}
		}
	}
}
-->	
</script>
 
 
 
<!-- 파일저장 -->
<script>
	function fileChk(elem) {
		console.dir(elem.value);
		if(elem.value == "") {
			console.log("파일없음");
			$("#fileCheck").val(0);
		}
		else {
			console.log("파일있음");
			$("#fileCheck").val(1);
		}
	}
	
	function formData() {
		var $obj = $("#files");
		
		console.log(CKEDITOR.instances.db_content.getData());
		//form data 가져오기
		var fData = new FormData();
		fData.append("db_title", $("#db_title").val());
		fData.append("db_content", CKEDITOR.instances.db_content.getData());
		//fData.append("db_cate", $("#db_cate").val());
		fData.append("db_price", $("#db_price").val());
		fData.append("fileCheck", $("#fileCheck").val());
		
		var files = $obj[0].files;
		for(var i = 0; i < files.length; i++) {
			fData.append("files" + i, files[i]);
		}
		
		//ajax전송
		$.ajax({
			type: "post",
			url: "writeInsertProduct?cnt="+files.length,
			data: fData,
			processData:false,
			contentType: false,
			dataType: "html",
			success: function(data){
				alert("상품 등록 완료");
				location.href="./product_mainGo";
				console.log(data);
			},
			error: function(error){
				alert(error);
				console.log("이게 나라냐 : " + error);
			}
		});
	}
</script>

<!-- multiple 이미지 미리보기 -->


</html>




