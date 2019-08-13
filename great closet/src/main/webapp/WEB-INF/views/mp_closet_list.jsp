<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<title>Home</title>
<link type="text/css" rel="stylesheet" href="resources/css/common.css">
<<<<<<< HEAD
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
옷장을 만들자!




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
=======
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

		<div class="add">
			<a href="#closetAdd" data-toggle="modal"> <img
				src="resources/image/icon/plus.png" alt=추가 width="50" height="50" />
			</a>
		</div>

		<div class="div">

			<c:forEach var="Closet" items="${cList}">

				<div class="div2">

					<div>
						<input type="checkbox" class="check" name="check"
							value="${Closet.c_num}" />
					</div>
					<a href="./closetClothes?c_num=${Closet.c_num}"> <img
						src="resources/image/icon/closet.png" alt="${Closet.c_name}"
						width="100" height="100" />

					</a>
					<div>
						<a href="#closetUpdate" data-toggle="modal" class = "closetUpdate"
						data-c_num="${Closet.c_num}" data-c_name="${Closet.c_name}" data-c_open = "${Closet.c_open}"title="옷장 수정">
							<center>${Closet.c_name}</center>
						</a>
					</div>
				</div>

			</c:forEach>

		</div>

		<form action="closetAdd" method="post">
			<div class="modal fade" id="closetAdd">
				<div class="modal-dialog">
					<div class="modal-content">
						<!-- header -->
						<div class="modal-header">
							<!-- 닫기(x) 버튼 -->
							<button type="button" class="close" data-dismiss="modal">×</button>
							<!-- header title -->
							<h4 class="modal-title">옷장 추가</h4>
						</div>
						<!-- body -->
						<center>

							<div class="modal-body">


								옷장명을 입력해주세요. <input type="text" name="c_name" required></br>
								옷장의 공개여부를 선택해주세요. 
								<input type="radio" name="c_open" value="true" checked>Yes 
									<input type="radio" name="c_open" value="false">No 
									<input type="hidden" name="c_sid" value="${c_sid}">

							</div>
						</center>
						<!-- Footer -->
						<div class="modal-footer">

							<input type="submit" value="저장">
							<button type="button" data-dismiss="modal">닫기</button>
		</form>

		</div>
		</div>
		</div>
		</div>


		<form action="closetUpdate" method="post">
			<div class="modal fade" id="closetUpdate">
				<div class="modal-dialog">
					<div class="modal-content">
						<!-- header -->
						<div class="modal-header">
							<!-- 닫기(x) 버튼 -->
							<button type="button" class="close" data-dismiss="modal">×</button>
							<!-- header title -->
							<h4 class="modal-title">옷장 수정</h4>
						</div>
						<!-- body -->
						<center>

							<div class="modal-body">

								옷장명을 입력해주세요. <input type="text" name="c_name" id="c_name" required value= ""></br>
								옷장의 공개여부를 선택해주세요. 
								
								
								<input type="radio" name="c_open" value="true" id="true">Yes 
								<input type="radio" name="c_open" value="false" id = "false">No
									<input type="hidden" name="c_num" id="c_num" value="">

							</div>
						</center>
						<!-- Footer -->
						<div class="modal-footer">

							<input type="submit" value="수정">
							<button type="button" data-dismiss="modal">닫기</button>
		</form>


		</div>
		</div>
		</div>
		</div>



		<div>
			<button class="btn" name="ClosetDel" onclick="ClosetDel()" />
			삭제
			</button>
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


<script type="text/javascript">

	function ClosetDel() {
		var check = document.getElementsByName("check");
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

		//var jsonList = JSON.stringify(list);
		var jsonList = {
			"ls" : list
		};
		console.log(jsonList);

		if (chk_check) {
			var con = confirm("선택한 값을 삭제하시겠습니까?");
			if (con) {

				$.ajax({
					type : 'post',
					url : 'closetDel',
					data : jsonList,
					dataType : 'json',
					success : function(data, status, xhr) {
						location.href = "./closetList?user=${c_sid}";
						alert("선택한값을 삭제하였습니다.");
					},
					error : function(xhr, status) {
						alert("옷장 안 옷이 있으면 삭제가 불가합니다.");
						console.log(status);
						console.log(xhr);
					}
				});
			}
		} else {
			alert("하나 이상 선택해주세요.");
		}
	}

	function clothes() {

		var closet = document.getElementsByName("closetClothes");
		location.href = "./closetClothes?cNum=" + closet.value;
	}

	$(document).on("click", ".closetUpdate", function() {
		var c_name = $(this).data('c_name');
		var c_num = $(this).data('c_num');
		var c_open = $(this).data('c_open');
		console.log(c_open);
		console.log(c_name);
		console.log(c_num);

		$(".modal-body #c_name").val(c_name);
		$(".modal-body #c_num").val(c_num);

		if(c_open == true){
			$(".modal-body #true").attr("checked", "checked");
		} else {
			$(".modal-body #false").attr("checked", "checked");
		}
	});
</script>



>>>>>>> 2b73898a3833355ae14398257d1e9e42829b1d5e
</html>



