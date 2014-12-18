<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/layout/header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>マスタ画面</title>
</head>
<body>
	<h1>マスタ画面</h1>
	<form:form method="post" action="search">
	商品名検索
	<input type="text" name="itemName" />
		<input type="submit" value="検索">
		<a href="create">商品登録</a>
		<c:if test="${itemList != null }">
			<table border="1">
				<tr>
					<th>商品ID</th>
					<th>商品名</th>
					<th>価格</th>
					<th>編集</th>
					<th>削除</th>
				</tr>
				<c:forEach var="item" items="${itemList }" varStatus="status">
					<tr>
						<td><c:out value="${item.itemId }"></c:out></td>
						<td><c:out value="${item.itemName }"></c:out></td>
						<td><c:out value="${item.price }"></c:out></td>
						<td><a href="update?itemId=${item.itemId }">アイテム編集</a>
						<td><a href="delete?itemId=${item.itemId }">アイテム削除</a>
					</tr>
				</c:forEach>
			</table>
		</c:if>
	</form:form>
</body>
</html>