<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Đăng nhập</title>
</head>
<body>
	<form name="LoginForm" action="Login" method="post">
		<p>
			<input type="text" name="txtUN" placeholder="Tên đăng nhập">
		</p>
		<p>
			<input type="password" name="txtPW" placeholder="Mật khẩu">
		</p>
		<p>
			<input type="submit" name="btnLogin" value="Đăng nhập">
			<input type="reset" name="btnReset" value="Huỷ">
		</p>
	</form>
</body>
</html>