<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/layout/header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ログイン</title>
</head>
<body>
<%@ include file="/WEB-INF/layout/nav.jsp" %>
	<h2>ログイン</h2>
	<form method="post" action="j_spring_security_check">
		<label>ユーザー名</label>
		<input name="j_username" />
		<label>パスワード</label>
		<input name="j_password" />
		<input type="submit" value="ログイン">
	</form>
</body>
</html>