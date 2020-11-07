<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="baseUri" value="${pageContext.request.contextPath }" scope="request"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>添加美食</title>
<link href="${baseUri}/static/css/addFood.css" rel="stylesheet">
</head>
<body>
<div class="foodbigdiv" style="background-color:white">
<div class="addcontent">
	<h2 class="contenttitle">添加新美食</h2>
	<form action="addbackfood" method="post" class="foodform" enctype="multipart/form-data">
		<label>美食名称：<input type="text" class="fname" name="fName" placeholder="请输入内容"/></label><br />
		<label>美食简介：<textarea placeholder="请输入内容" class="fintro" name="fIntroduction"></textarea></label><br />
		<label>美食主料：<input type="text" placeholder="请输入内容" class="fname" name="fMainIngredient"/></label><br />
		<label>美食配料：<textarea placeholder="请输入内容" class="fintro" name="fBurdening"></textarea></label><br />
		<label>主要步骤：<textarea placeholder="请输入内容" class="fstep" name="fStep"></textarea></label><br />
		<label>美食图片：<input type="file" name="file" class="fimg"/></label><br />
		<label>美食分类：<select name="fCategory" class="fcate">
			<option value="">请选择</option>
			<option value="1">湘菜</option>
			<option value="2">川菜</option>
			<option value="3">闽菜</option>
			<option value="4">粤菜</option>
			<option value="5">鲁菜</option>
			<option value="6">徽菜</option>
			<option value="7">浙菜</option>
			<option value="8">苏菜</option>
		</select></label><br /> 
		<button type="submit" class="butt">提交</button>
		<button type="reset" class="butt">重置</button>
	</form>
</div>
</div>
</body>
</html>