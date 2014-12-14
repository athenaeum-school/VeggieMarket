<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/jsp_header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ユーザー登録完了画面</title>
</head>
<body>
	<h2>ユーザー登録完了画面</h2>
	<b>ユーザー登録が完了しました。</b>
	<br>
	<table>
		<tr>
			<td>名前</td>
			<td><c:out value="${user.userName }"></c:out></td>
		</tr>
		<tr>
			<td>パスワード</td>
			<td><c:out value="${user.password }"></c:out></td>
		</tr>
	</table>
</body>
</html>