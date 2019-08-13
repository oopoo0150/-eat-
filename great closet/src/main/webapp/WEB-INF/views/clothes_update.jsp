<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<title>Home</title>
<link type="text/css" rel="stylesheet" href="resources/css/common.css">
<link type="text/css" rel="stylesheet" href="resources/css/closet.css">
<link type="text/css" rel="stylesheet"
	href="resources/css/bootstrap.min.css">
<link type="text/css" rel="stylesheet"
	href="resources/css/bootstrap-theme.min.css">
<script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>

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
								<li><a href="#" title="Share">자랑게시판</a></li>
								<li><a href="#" title="info">정보게시판</a></li>
							</ul></li>
						<li><a href="#" title="팔로잉">Following</a></li>

						<li class="parent"><a href="#" title="중고거래">Deal</a>
							<ul class="child">
								<li><a href="#" title="Contest">거래공간</a></li>
								<li><a href="#" title="Contest"> 쪽지함</a></li>
							</ul></li>
						<li class="parent"><a href="#" title="Mypage">My page</a>
							<ul class="child">
								<li><a href="#" title="Contest">Closet</a></li>
							</ul></li>
				</nav>
			</div>
		</center>
	</header>
	<section>

		<div>
			<br> <br> <br> <br> <br>

		</div>

	<center>
					




	<form action="imgUpdate" enctype="multipart/form-data">
		<table>
			<tr>
			
				<td width="200" ><center><div id='View_area' style='position:relative; width: 100px; height: 100px; color: black; border: 0px solid black; dispaly: inline; '>
					<div id = "img"><img src="./resources/files/${cldImg.cld_sysname}" width="100" height="100" />
					</div>
					</div>
				</center></td>

				<td width="100"><center>
				<input type="file" accept=".jpg, .gif, .png" name="cld_oriname" id="profile_pt" onchange="previewImage(this,'View_area')" required>
</center></td>
			</tr>
			
			</table>
			
			<br> <br>

			<table>
			<tr height="30">
				<td width="60">색상 : </td>

				<td><select style="width:130px" name="cld_color" id = "cld_color">
						<c:if test="${cldImg.cld_color == 'black'}">
						<option style="background-color: black; color: black;" value = "black" selected>black</option>
						</c:if>
						<c:if test="${cldImg.cld_color != 'black'}">
						<option style="background-color: black; color: black;" value = "black">black</option>
						</c:if>
						<c:if test="${cldImg.cld_color == 'white'}">
						<option style="color: white;" value = "white" selected>white</option>
						</c:if>
						<c:if test="${cldImg.cld_color != 'white'}">
						<option style="color: white;" value = "white">white</option>
						</c:if>
						<c:if test="${cldImg.cld_color == 'gray'}">
						<option style="background-color: gray; color: gray;" value = "gray" selected>gray</option>
						</c:if>
						<c:if test="${cldImg.cld_color != 'gray'}">
						<option style="background-color: gray; color: gray;" value = "gray">gray</option>
						</c:if>
						<c:if test="${cldImg.cld_color == 'red'}">
						<option style="background-color: red; color: red;" value = "red" selected>red</option>
						</c:if>
						<c:if test="${cldImg.cld_color != 'red'}">
						<option style="background-color: red; color: red;" value = "red">red</option>
						</c:if>
						<c:if test="${cldImg.cld_color == 'orange'}">
						<option style="background-color: orange; color: orange;" value = "orange" selected>orange</option>
						</c:if>
						<c:if test="${cldImg.cld_color != 'orange'}">
						<option style="background-color: orange; color: orange;" value = "orange">orange</option>
						</c:if>
						<c:if test="${cldImg.cld_color == 'yellow'}">
						<option style="background-color: yellow; color: yellow;" value = "orange" selected>yellow</option>
						</c:if>
						<c:if test="${cldImg.cld_color != 'yellow'}">
						<option style="background-color: yellow; color: yellow;" value = "orange">yellow</option>
						</c:if>
						<c:if test="${cldImg.cld_color == 'green'}">
						<option style="background-color: green; color: green;" value = "green" selected>green</option>
						</c:if>
						<c:if test="${cldImg.cld_color != 'green'}">
						<option style="background-color: green; color: green;" value = "green">green</option>
						</c:if>
						<c:if test="${cldImg.cld_color == 'blue'}">
						<option style="background-color: blue; color: blue;" value = "blue" selected>blue</option>
						</c:if>
						<c:if test="${cldImg.cld_color != 'blue'}">
						<option style="background-color: blue; color: blue;" value = "blue">blue</option>
						</c:if>
						<c:if test="${cldImg.cld_color == 'navy'}">
						<option style="background-color: navy; color: navy;" value = "navy" selected>navy</option>
						</c:if>
						<c:if test="${cldImg.cld_color != 'navy'}">
						<option style="background-color: navy; color: navy;" value = "navy">navy</option>
						</c:if>
						<c:if test="${cldImg.cld_color == 'purple'}">
						<option style="background-color: purple; color: purple;" value = "purple" selected>purple</option>
						</c:if>						
						<c:if test="${cldImg.cld_color != 'purple'}">
						<option style="background-color: purple; color: purple;" value = "purple">purple</option>
						</c:if>
				</select></td>
			</tr>

			<tr height="30">
				<td>사이즈 : </td>

				<td><input type="text" name="cld_size" id = "cld_size" value= "${cldImg.cld_size}" required /></td>
			</tr>

			<tr height="30">
				<td>시즌 : </td>

				<td><select style="width:130px" name="cld_season" id = "cld_season">
						<c:if test="${cldImg.cld_season == 'All Season'}">
						<option value = "All Season" selected>All Season</option>
						</c:if>
						<c:if test="${cldImg.cld_season != 'All Season'}">
						<option value = "All Season">All Season</option>
						</c:if>
						<c:if test="${cldImg.cld_season == 'Spring'}">
						<option value = "Spring" selected>Spring</option>
						</c:if>
						<c:if test="${cldImg.cld_season != 'Spring'}">
						<option value = "Spring">Spring</option>
						</c:if>
						<c:if test="${cldImg.cld_season == 'Summer'}">
						<option value = "Summer" selected>Summer</option>
						</c:if>
						<c:if test="${cldImg.cld_season != 'Summer'}">
						<option value = "Summer">Summer</option>
						</c:if>
						<c:if test="${cldImg.cld_season == 'Autumn'}">
						<option value = "Autumn" selected>Autumn</option>
						</c:if>
						<c:if test="${cldImg.cld_season != 'Autumn'}">
						<option value = "Autumn">Autumn</option>
						</c:if>		
						<c:if test="${cldImg.cld_season == 'Winter'}">				
						<option value = "Winter" selected>Winter</option>
						</c:if>
						<c:if test="${cldImg.cld_season != 'Winter'}">				
						<option value = "Winter">Winter</option>
						</c:if>
				</select></td>
			</tr>

			<tr height="30">
				<td>가격 : </td>

				<td><input type="text" name="cld_amount" id = "cld_amount" value= "${cldImg.cld_amount}" required/></td>
			</tr>

			<tr height="80">
				<td>메모 : </td>

				<td><textarea rows="5" style="width:130px" name="cld_content"  id = "cld_content" required>${cldImg.cld_content}</textarea></td>
			</tr>

		</table>
		
			<input type = "hidden" value = "${cldImg.cld_num}" name="cld_num" id = "cld_num"/>
			<input type="hidden" id="fileCheck" value="0" name="fileCheck" />
		
		<br>
		<br>
			<input type="button" value="수정" onclick="formData()">
			<a href= "./imgList?cl_num=${cl_num}">
			<input type="button"  value="취소"></a>
		</form>
		
		
		
		
</center>

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


<script type="text/javascript">


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
			$("#img").css("display","block");
		}
		for ( var i = 0; i < files.length; i++) {

			$("#img").css("display","none");
			
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
				})
				(img);
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

	function formData() {
		var $obj = $("#profile_pt");//배열형태로 넘어옴.
		console.log($obj[0]);
		console.log($obj[0].files);
		console.log($obj[0].files.length);
		console.log($obj[0].files[0]); 

		//form 데이터 가져오기
		var fData = new FormData();
		fData.append("cld_color", $("#cld_color").val());
		fData.append("cld_size", $("#cld_size").val());
		fData.append("cld_season", $("#cld_season").val());
		fData.append("cld_amount", $("#cld_amount").val());
		fData.append("cld_content", $("#cld_content").val());
		fData.append("cld_num", $("#cld_num").val());
		fData.append("fileCheck", $("#fileCheck").val());
		var files = $obj[0].files;
		for (var i = 0; i < files.length; i++) {
			fData.append("files" + i, files[i]);
		}

		//ajax 전송
		
		$.ajax({
			type : "post",//multipart 전송은 post로.
			url : "imgUpdate",
			data : fData,
			processData : false,
			//application/x-www-form-urlencoded 형식으로
			//처리되지 않게 막는 속성(쿼리스트링)
			contentType : false,
			//multipart일 경우 false
			dataType : "html",//생략가능
			success : function(data) {
				alert("성공");
				location.href = "./imgDetail?cld_num=${cldImg.cld_num}";
				console.log(data);
			},
			error : function(error) {
				alert("실패/이미지를 꼭 선택해주세요.");
				console.log(error);
			}
		});

	}



</script>



</html>



