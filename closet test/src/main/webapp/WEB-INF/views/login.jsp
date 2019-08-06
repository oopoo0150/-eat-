<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>great closet login</title>
</head>
<body>
	<form action="/login_Access"  method="post" name="home" onsubmit="return logincheck()">
		<table border="1" style="align-content: center;">
				<tr>	
					<th colspan="2" style="text-align: center;"><h1>로그인</h1></th>
				</tr>
				<tr>
					<td>아이디</td>
					<td><input type="text" name="m_id" placeholder="아이디 입력"></td>
				</tr>
				<tr>
					<td>비밀번호</td>
					<td><input type="password" name="m_pwd" placeholder="비밀번호 입력 "></td>
				</tr>
			</table>
			<input type="submit" value="로그인">
			<button>
				<a href="./signup">회원가입</a>
			</button>
	</form>
</body>

<script>
	function logincheck() {
		var login = document.home;
		var length = home.length - 2;
		for (var i = 0; i < length; i++) {
			if (home[i].value == "" || home[i].value == null) {
				alert(home[i].placeholder + "란을 입력하세요!!")
				home[i].focus();
				return false;
			}
		}
		return true;
	}
</script>
</html>