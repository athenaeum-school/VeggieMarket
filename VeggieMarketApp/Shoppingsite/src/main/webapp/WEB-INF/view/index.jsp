<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/jsp_header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品一覧画面</title>
</head>
<body>
<%@ include file="/WEB-INF/jsp/cart_header.jsp" %>
	<h2>商品一覧画面</h2>
	<table border="1">
		<tr>
			<th>商品ID</th>
			<th>商品名</th>
			<th>価格</th>
		</tr>
		<c:forEach items="${itemList }" var="item">
			<tr>
				<td>${item.itemId }</td>
				<td><a href="detail?itemId=${item.itemId}">${item.itemName }</a></td>
				<td>${item.price }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>