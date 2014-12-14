<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ブログブック</title>
<link rel="stylesheet" href="<c:url value="resources/css/screen.css"/>">
</head>
<body>
	<h2>ブログブック</h2>
	<div id="blogs">
		<form id="addBlog" action="#">
			<div>
				<label for="title">タイトル: </label> <input id="title" type="text" />
				<label for="message">内容: </label> <input id="message" type="text" />
				<button id="add">追加</button>
			</div>
		</form>
		<br>
	</div>


	<script id="blogTemplate" type="text/template">
		<br>
		<div class="viewtitle">
   		 	<label>{{title}}</label>
		</div>
		<input class="edit" value="{{title}}"><br>
		<div class="viewmessage">
        	<label>{{message}}</label>
		</div>
		<input class="message" value="{{message}}"><br>
        <button class="delete">削除</button>
    </script>


	<script src="<c:url value="resources/js/lib/jquery-2.0.3.min.js" />"></script>
	<script src="<c:url value="resources/js/lib/underscore-min.js"/>"></script>
	<script src="<c:url value="resources/js/lib/backbone-min.js"/>"></script>
	<script src="<c:url value="resources/js/models/blog.js"/>"></script>
	<script src="<c:url value="resources/js/collections/library.js"/>"></script>
	<script src="<c:url value="resources/js/views/blog.js"/>"></script>
	<script src="<c:url value="resources/js/views/library.js"/>"></script>
	<script src="<c:url value="resources/js/app.js"/>"></script>

</body>
</html>