<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>great closet signup</title>
</head>
<body>
	<div class="center">
		<form action="MemberInsert" method="post" onsubmit="return check()" name="signup">
		
						<label for="s_name">이름</label>
						<input type="text" id="s_name" name="s_name" placeholder="이름을 입력해 주세요..." required="이름"><br>
					<div class="foem-group">	 
					   	<label for="s_nick">닉네임</label> 
					    <input type="text" id="s_nick" name="s_nick" placeholder="닉네임을 입력해 주세요..." required="닉네임"><button type="button" onclick="nickcheck()">중복확인</button><br>
					    <div class="check_font" id="nick_check"></div>
					</div> 
					    
					<div class="foem-group">
					   	<label for="s_id">아이디</label> 
					   	<input type="text" id="s_id" name="s_id" placeholder="아이디를 입력해 주세요..." required="아이디"><button type="button" onclick="idcheck()">중복확인</button><br>
					   	<div class="check_font" id="id_check"></div>
					</div>
					
					 	<label for="s_pass">비밀번호</label> 
					  	<input type="password" id="s_pass" name="s_pass" placeholder="비밀번호를 입력해 주세요..." required="비밀번호"><br>
						<label for="spassCh">비밀번호 확인</label> 
				 	  	<input type="password" name="spassCh" placeholder="비밀번호를 확인해 주세요..." required="비밀번호 확인"><br>
				 	  	
				 	<div class="foem-group"> 	
						<label for="s_mail">이메일</label> 
					    <input type="text" id="s_mail" name="s_mail" placeholder="이메일을 입력해 주세요..." required="이메일"><button type="button" onclick="idcheck()">중복확인</button><br>
					    <div class="check_font" id="mail_check"></div>
					</div>    
					    
						<label for="s_birth">생년월일</label> 
						<input type="text" id="s_birth" name="s_birth" placeholder="ex)20190101"><br>
					 
					 	
						 <input type="submit" id="reg_submit" value="가입하기">

		</form>
	</div> 
</body>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script>
//입력 처리 
function check() {
	var sig = document.signup;
	var length = sig.length - 2;//submit 제외
	for(var i = 0; i < length; i++){
		if(sig[i].value == "" || sig[i].value == null){
			alert(sig[i].required + "란을 입력하세요!!")
			sig[i].focus();
			return false;//입력을 안했을 경우
		}
	}
	return true;//입력이 잘되었음
}


//아이디 유효성 검사(1 = 중복 / 0 != 중복)
//$("#s_id").blur(function() {
	// id = "id_reg" / name = "userId"
//	var user_id = $('#s_id').val();
	
//	});
	
function idcheck(){
	var u_id = $('#s_id').val();
	console.log(u_id);
	var param = "s_id=" + u_id;
	
	$.ajax({
		url : 'signup/idCheck',
		type : 'get',
		data : param,
		success : function(data) {
			console.log("1 = 중복o / 0 = 중복x : "+ data);							
			
			if (data == 1) {
					// 1 : 아이디가 중복되는 문구
					$("#id_check").text("사용중인 아이디입니다 :p");
					$("#id_check").css("color", "red");
			} else {
					$('#id_check').text("사용가능한 아이디입니다.");
					$("#id_check").css("color", "green");
					
			}
			
			}, error : function() {
					console.log("실패");
			}
		});
}

function nickcheck(){
	var u_nick = $('#s_nick').val();
	console.log(u_nick);
	var param = "s_nick=" + u_nick;
	
	$.ajax({
		url : 'signup/nickCheck',
		type : 'get',
		data : param,
		success : function(data) {
			console.log("1 = 중복o / 0 = 중복x : "+ data);							
			
			if (data == 1) {
					// 1 : 아이디가 중복되는 문구
					$("#nick_check").text("사용중인 닉네임입니다.  :p");
					$("#nick_check").css("color", "red");
			} else {
					$('#nick_check').text("사용가능한 닉네임입니다. XD");
					$("#nick_check").css("color", "green");
					
			}
			
			}, error : function() {
					console.log("실패");
			}
		});
}

function mailcheck(){
	var u_mail = $('#s_mail').val();
	console.log(u_mail);
	var param = "s_mail=" + u_mail;
	
	$.ajax({
		url : 'signup/mailCheck',
		type : 'get',
		data : param,
		success : function(data) {
			console.log("1 = 중복o / 0 = 중복x : "+ data);							
			
			if (data == 1) {
					// 1 : 아이디가 중복되는 문구
					$("#mail_check").text("사용중인 메일입니다.  :p");
					$("#mail_check").css("color", "red");
			} else {
					$('#mail_check').text("사용가능한 메일입니다. XD");
					$("#mail_check").css("color", "green");
			}
			
			}, error : function() {
					console.log("실패");
			}
		});
}
</script>
</html>