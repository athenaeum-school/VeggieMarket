<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="/WEB-INF/layout/header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品削除</title>
</head>
<body>
	<h1>商品削除</h1>
	<form:form modelAttribute="item" action="delete" method="post">
		<table>
		<form:hidden path="itemId"/>
			<tr>
				<td>商品名</td>
				<td><form:input path="itemName" disabled="true"/></td>
			</tr>
			<tr>
				<td>価格</td>
				<td><form:input path="price" disabled="true"/></td>
			</tr>
		</table>
		<br>
		<input type="submit" value="削除" />
		<input type="reset" value="リセット" />
		<br>
		<br>
		<a href="index">HOME</a>
	</form:form>
</body>
</html>