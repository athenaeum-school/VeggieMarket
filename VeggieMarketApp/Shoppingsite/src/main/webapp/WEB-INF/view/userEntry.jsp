<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/jsp_header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ユーザー登録画面</title>
</head>
<body>
	<h2>ユーザー登録画面</h2>
	<form:form modelAttribute="user" method="post" action="userEntry">
		<table>
			<tr>
				<td>名前</td>
				<td><form:input path="userName" /><form:errors
							path="userName" cssClass="error"></form:errors></td>
			</tr>
			<tr>
				<td>パスワード</td>
				<td><form:password path="password" /><form:errors
							path="password" cssClass="error"></form:errors></td>
			</tr>
		</table>
		<table>
			<tr>
				<td><input type="submit" value="登録"></td>
				<td><input type="reset" value="リセット"></td>
			</tr>
		</table>
	</form:form>
</body>
</html>