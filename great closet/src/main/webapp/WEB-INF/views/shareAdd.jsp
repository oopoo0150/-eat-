<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Home</title>
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
		<div align="center">
			<form action="swriteInsert" method="post" name="shareAdd" enctype="multipart/form-data">
				<table>
					<tr height="35">
						<td width="100">사진 추가하기(필수잉데어또카지)</td>
						<td width="700">
							<!-- 
						<input type="file" name="files" id="files" onchange="fileChk(this)" />
						<input type="hidden" id="fileCheck" value="0" name="fileCheck" /></td>
						 --> 
						 <div id='View_area'
								style='position: relative; width: 100px; height: 100px; color: black; border: 0px solid black; dispaly: inline;'>
						</div>
							
						 <a href="./editImg"> <input type="file"
								accept=".jpg, .gif, .png" name="oriname" id="profile_pt"
								onchange="previewImage(this,'View_area')" required="requred">
						</a> 
						
					</tr>
					<tr height="35">
						<td>제목</td>
						<td><input type="text" id="sb_title" name="sb_title" placeholder="제목 입력"
							required="requred"></td>
					</tr>

					<tr>
						<td>내용</td>
						<td><textarea id="sb_content" name="sb_content" rows="15" cols="80"
								required="required"></textarea> <!-- 해당 에디터 적용 --> <script>
									CKEDITOR.replace('in_content');
								</script></td>
					</tr>


					<tr height="35">
						<td>해시태그</td>
						<td><input type="text" name="" placeholder="해시태그 입력"></td>
					</tr>

				</table>

				<input type="button" value="저장" onclick="formdata()">
			</form>
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
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script>

	function previewImage(targetObj, View_area) {
	var preview = document.getElementById(View_area); //div id
	var ua = window.navigator.userAgent;
	
	if(targetObj.value == ""){
		console.log("empty");
		$("#fileCheck").val(0);//파일첨부 안함.
	} else {
		console.log("not empty");
		$("#fileCheck").val(1);//파일첨부 함.
	}

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
		var files = targetObj.files;
		
		if(files.length == 0){
			console.log("선택안함");
			prevImg = document.getElementById("prev_" + View_area);
			preview.removeChild(prevImg);
		}
		
		for ( var i = 0; i < files.length; i++) {
			var file = files[i];
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
			img.file = file;
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
	
	function formdata() {
		var $obj = $("#profile_pt");
		console.log($obj[0]);
		console.log($obj[0].files);
		console.log($obj[0].files.length);
		console.log($obj[0].files[0]);
		
		var fData = new FormData();
		
		fData.append("sb_title", $("#sb_title").val());
		fData.append("sb_content", $("#sb_content").val());
		var files = $obj[0].files;
		for(var i = 0; i < files.length; i++){
			fData.append("files" + i, files[i]);
		}
		
		// ajax 전송
		$.ajax({
			type: "post", // multipart 전송은 post로.
			url: "swriteInsert",
			data: fData,
			processData: false, // application/x-www.form-urlencoded 형식으로 처리되지 않게 막는 속성(쿼리스트링)
			contentType: false, // multipart일 경우 false
			dataType: "html", // 생략 가능
			success: function(data){
				alert("성공");
				location.href="./share";
				console.log(data);
			},
			error: function(error){
				alert("실패");
				console.log(error);
			}
		}); // ajax 끝
		
	}
	
	</script>
</html>

