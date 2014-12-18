<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/layout/header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ユーザー登録</title>
</head>
<body>
<%@ include file="/WEB-INF/layout/nav.jsp" %>
	<h2>ユーザー登録</h2>
	<form:form modelAttribute="customer" method="post" action="register">
		<label>ユーザー名</label>
		<form:input path="customerName" />
		<label>パスワード</label>
		<form:password path="password" />
		<input type="submit" value="登録">
	</form:form>
</body>
</html>