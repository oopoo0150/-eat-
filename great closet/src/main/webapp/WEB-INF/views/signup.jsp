<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>great closet signup</title>
<!-- Bootstrap -->
<link href='<c:url value="/css/bootstrap.min.css" />' rel="stylesheet">
<link href='<c:url value="/css/kfonts2.css" />' rel="stylesheet">
 
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src='<c:url value="/jquery/jquery-1.11.3.min.js" />'></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src='<c:url value="/js/bootstrap.min.js"  />'></script>
</head>
<body>

    <div class="center">
        <form action="UserInsert" method="post" onsubmit="return check()" name="signup">
        
                        <label for="u_name">이름</label>
                        <input type="text" id="u_name" name="u_name" placeholder="이름을 입력해 주세요..." required="이름"><br>
                        
                    <div class="form-group">     
                           <label for="u_nick">닉네임</label> 
                        <input type="text" id="u_nick" name="u_nick" placeholder="닉네임을 입력해 주세요..." required="닉네임"><button type="button"  onclick="nickcheck()">중복확인</button><br>
                        <div class="check_font" id="nick_check"></div>
                    </div> 
                        	
                    <div class="form-group">
                           <label for="u_id">아이디</label> 
                           <input type="text" id="u_id" name="u_id" placeholder="아이디를 입력해 주세요..." required="아이디"><button type="button" onclick="idcheck()">중복확인</button><br>
                           <div class="check_font" id="id_check"></div>
                    </div>
                    
                         <label for="u_pass">비밀번호</label> 
                          <input type="password" id="u_pass" name="u_pass" placeholder="비밀번호를 입력해 주세요..." required="비밀번호"><br>
                        <label for="spassCh">비밀번호 확인</label> 
                           <input type="password" name="spassCh" placeholder="비밀번호를 확인해 주세요..." required="비밀번호 확인"><br>
                           
                     <div class="form-group">     
                        <label for="u_mail">이메일</label> 
                        <input type="email" id="u_mail" name="u_mail" placeholder="이메일을 입력해 주세요..." required="이메일"><button type="button" onclick="mailcheck()">중복확인</button><br>
                        <div class="check_font" id="mail_check"></div>
                    </div>    
                        
                        <label for="u_birth">생년월일</label> 
                        <input type="text" id="u_birth" name="u_birth" placeholder="ex)20190101" required="생년월일"><br>
                     
                         
                         <input type="submit" id="reg_submit" value="가입하기">

        </form>
    </div> 
</body>


<script src="/resources/js/jQuery-2.1.4.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script>
//입력 처리 

	var String = null;
	var String2 = null;
	var String3 = null;
function check() {
	var sig = document.signup;
		if(nick_check != String){
			alert("닉네임 중복 확인을 해주세요!")
			console.log(String);
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
	
	return true;//입력이 잘되었음
}


//아이디 유효성 검사(1 = 중복 / 0 != 중복)
//$("#s_id").blur(function() {
    // id = "id_reg" / name = "userId"
//    var user_id = $('#s_id').val();
    
//    });
    
function idcheck(){
    var u_id = $('#u_id').val();
    console.log(u_id);
    var param = "u_id=" + u_id;
    
   	if(u_id == "" || u_id == null){
   		alert("아이디를 입력해주세요!")
   		return false;
   	}else{
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
    var u_nick = $('#u_nick').val();
    console.log(u_nick);
    var param = "u_nick=" + u_nick;
    
    if(u_nick == "" || u_nick == null){
   		alert("닉네임을 입력해주세요!")
   		return false;
   	}else{
    $.ajax({
        url : 'signup/nickCheck',
        type : 'get',
        data : param,
        success : function(data) {
            console.log("1 = 중복o / 0 = 중복x : "+ data);                            
            
            if (data == 1) {
                    // 1 : 아이디가 중복되는 문구
                    $("#nick_check").text("사용중인 닉네임입니다 :p");
                    $("#nick_check").css("color", "red");
            } else {
                    $('#nick_check').text("사용가능한 닉네임입니다.");
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
    var u_mail = $('#u_mail').val();
    console.log(u_mail);
    var param = "u_mail=" + u_mail;
    
    if(u_mail == "" || u_mail == null){
   		alert("메일을 입력해주세요!")
   		return false;
   	}else{
    $.ajax({
        url : 'signup/mailCheck',
        type : 'get',
        data : param,
        success : function(data) {
            console.log("1 = 중복o / 0 = 중복x : "+ data);                            
            
            
            if (data == 1) {
                    // 1 : 아이디가 중복되는 문구
                    $("#mail_check").text("사용중인 메일입니다 :p");
                    $("#mail_check").css("color", "red");
            } else {
                    $('#mail_check').text("사용가능한 메일입니다.");
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