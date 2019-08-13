<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form"  uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<link type="text/css" rel="stylesheet" href="resources/css/common.css">
<head>
	<style type="text/css">
	div.center {
		margin: auto;
	}
	
	input.center {
		text-align: center;	
	}
	</style>
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
					<li><a href="./lookbook_main" title="lookbook">Look Book</a></li>
					<li><a href="./contest_main" title="Contest">Contest</a></li>
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

			<li class="parent"><a href="./product_main" title= "중고거래">Deal</a>
				<ul class="child">
					<li><a href="./product_main" title="Contest">거래공간</a></li>
					<li><a href="#" title="Contest"> 쪽지함</a></li>
				</ul>
			</li>
			<li class="parent"><a href="./mypage" title= "Mypage">My page</a>
			<ul class="child">
					<li><a href="./closetList" title="Contest">Closet</a></li>
			</ul>
			</li>
		</ul>
	</nav>
</div>
</center>
</header>
    <div class="center" style="width: 1000px; height: 600px; margin-top: 50px; border: solid;">
        <form action="MemberInsert" method="post" onsubmit="return check()" name="signup2">
        	<table style="margin: auto; margin-top: 160px;">
                        <tr><td><label for="s_name">이름</label></td>
                        <td><input class="center" type="text" id="s_name" name="s_name" placeholder="이름" required="이름"></td>
                        <td></td>
                        </tr>  
                        
                        <tr>
                        <td><label for="s_nick">닉네임</label></td>
                        <td><input class="center" type="text" id="s_nick" name="s_nick" placeholder="닉네임" required="닉네임"></td>
                        <td><button type="button" id="niche" onclick="nickcheck()">중복확인</button></td>
                    	</tr>
                    	
                    	<tr><td colspan="3"><div class="check_font" id="nick_check"></div></td></tr>
                       	
                       	<tr>
                        <td><label for="s_id">아이디</label></td>
                        <td><input class="center" type="text" id="s_id" name="s_id" placeholder="아이디" required="아이디"></td>
                        <td><button type="button" id="idche" onclick="idcheck()">중복확인</button></td>
                    	</tr>
                    	
                    	<tr><td colspan="3"><div class="check_font" id="id_check"></div></td></tr>
                    	
                    	<tr>
                        <td><label for="s_pass">비밀번호</label></td>
                        <td><input class="center" type="password" id="s_pass" name="s_pass" placeholder="비밀번호" required="비밀번호"></td>
                        <td></td>
                        </tr>
                        
                        <tr>
                        <td><label for="spassCh">비밀번호 확인</label></td>
                        <td><input class="center" type="password" id="spassCh" name="spassCh" placeholder="비밀번호 확인" required="비밀번호 확인"></td>
                        <td></td>
                       	</tr>
                            
                        <tr>  
                        <td><label for="s_mail">이메일</label></td>
                        <td><input class="center" type="email" id="s_mail" name="s_mail" placeholder="이메일" required="이메일"></td>
                        <td><button type="button" id="mache" onclick="mailcheck()">중복확인</button></td>
                   		</tr>
                   		
                   		<tr><td colspan="3"><div class="check_font" id="mail_check"></div></td></tr>
                   
                        <tr>
                        <td><label for="s_birth">생년월일</label></td>
                        <td><input class="center" type="text" id="s_birth" name="s_birth" placeholder="ex)20190101" required="생년월일"></td>
                        <td></td>
                     	</tr>
                     	
                        <tr>
                        <td colspan="3" style="text-align: center;"><input class="center" type="submit" id="reg_submit" value="가입하기"></td>
                        </tr>
			</table>
        </form>
    </div> 
<footer>
<!-- 풋터로고 -->
	<div id="f_top">
<h1><a href="./" title="메인페이지 바로가기"><img src="resources/image/common/panda.png" alt="로고" /></a></h1>
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


<script src="resources/js/jquery-2.1.4.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

<script>
//입력 처리 

	var String = "1";
	var String2 = "2";
	var String3 = "3";
function check() {
	var sig = document.signup2;
		if(nick_check != String){
			alert("닉네임 중복 확인을 해주세요!")
			return false;//입력을 안했을 경우
		}else if(id_check != String2){
			alert("아이디 중복 확인을 해주세요!")
			console.log(id_check);
			return false;
		}else if(mail_check != String3){
			alert("메일 중복 확인을 해주세요!")
			console.log(mail_check);
			return false;
		}
		if(s_pass.value != spassCh.value){
			alert("비밀번호가 일치하지 않습니다.");
			signup2[6].focus();
			return false;
		}
		return true;
	//입력이 잘되었음
}


//아이디 유효성 검사(1 = 중복 / 0 != 중복)
//$("#s_id").blur(function() {
    // id = "id_reg" / name = "userId"
//    var user_id = $('#s_id').val();
    
//    });
    
function idcheck(){
    var s_id = $('#s_id').val();
    console.log(s_id);
    var param = "s_id=" + s_id;
    
   	if(s_id == "" || s_id == null){
   		alert("아이디를 입력해주세요!")
   		return false;
   	}else{
    $.ajax({
        url : 'signup2/idCheck',
        type : 'get',
        data : param,
        success : function(data) {
            console.log("1 = 중복o / 0 = 중복x : "+ data);                            
            
            if (data == 1) {
                    // 1 : 아이디가 중복되는 문구
                    $("#id_check").text("사용중인 아이디입니다 :p");
                    $('#idche').text("중복확인");
                    $("#id_check").css("color", "red");
                    String2 = null;
            } else {
                    $('#id_check').text("사용가능한 아이디입니다.");
                    $('#idche').text("확인완료");
                    $("#id_check").css("color", "green");
                	String2 = id_check;
                    
            }
            
            }, error : function() {
                    console.log("실패");
            }
        });  
    	return true;
   	}

}

function nickcheck(){
    var s_nick = $('#s_nick').val();
    console.log(s_nick);
    var param = "s_nick=" + s_nick;
    
    if(s_nick == "" || s_nick == null){
   		alert("닉네임을 입력해주세요!")
   		return false;
   	}else{
    $.ajax({
        url : 'signup2/nickCheck',
        type : 'get',
        data : param,
        success : function(data) {
            console.log("1 = 중복o / 0 = 중복x : "+ data);                            
            
            if (data == 1) {
                    // 1 : 아이디가 중복되는 문구
                    $("#nick_check").text("사용중인 닉네임입니다 :p");
                    $('#niche').text("중복확인");
                    $("#nick_check").css("color", "red");
                	String = null;
            } else {
                    $('#nick_check').text("사용가능한 닉네임입니다.");
                    $('#niche').text("확인완료");
                    $("#nick_check").css("color", "green");
                	String = nick_check;
                    
            }
            
            }, error : function() {
                    console.log("실패");
            }
        });
    	return true;
   	}
}

function mailcheck(){
    var s_mail = $('#s_mail').val();
    console.log(s_mail);
    var param = "s_mail=" + s_mail;
    
    if(s_mail == "" || s_mail == null){
   		alert("메일을 입력해주세요!")
   		return false;
   	}else{
    $.ajax({
        url : 'signup2/mailCheck',
        type : 'get',
        data : param,
        success : function(data) {
            console.log("1 = 중복o / 0 = 중복x : "+ data);                            
            
            
            if (data == 1) {
                    // 1 : 아이디가 중복되는 문구
                    $("#mail_check").text("사용중인 메일입니다 :p");
                    $('#mache').text("중복확인");
                    $("#mail_check").css("color", "red");
                	String3 = null;
            } else {
                    $('#mail_check').text("사용가능한 메일입니다.");
                    $('#mache').text("확인완료");
                    $("#mail_check").css("color", "green");
                	String3 = mail_check;
                    
            }
            
            }, error : function() {
                    console.log("실패");
            }
        });
    	return true;
    }
}

</script>

</html>