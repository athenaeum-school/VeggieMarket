<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<table class="header">
	<tr>
		<td><a href="item">■一覧に戻る</a></td>
		<td><a href="checkout">■精算画面へ進む</a></td>
		<td><a href="cartConfirm">■カートを確認する</a></td>
		<td><a href="cartClear">■カートを空にする</a>
		<td><c:choose>
				<c:when test="${not empty loginUser }">
					<font color="red">ようこそ<br> <c:out
							value="${loginUser.userName }">さん</c:out></font>
				</c:when>
				<c:when test="${empty loginUser }">
					<font color="red"><a href="login">■ログインする</a></font>
				</c:when>
			</c:choose></td>
	</tr>
</table>
