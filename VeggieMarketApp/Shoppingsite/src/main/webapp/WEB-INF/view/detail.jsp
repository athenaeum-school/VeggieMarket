<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/jsp_header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品詳細画面</title>
</head>
<body>
	<h2>商品詳細画面</h2>
	<table border="1">
		<tr>
			<td>商品名</td>
			<td>${item.itemName }</td>
		</tr>
		<tr>
			<td>価格</td>
			<td>${item.price }</td>
		</tr>
		<tr>
			<td>コメント</td>
			<td>${item.description }</td>
		</tr>
		<tr>
			<td><a href="item">一覧に戻る</a></td>
		</tr>
	</table>

</body>
</html>