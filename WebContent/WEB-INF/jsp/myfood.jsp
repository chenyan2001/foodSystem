<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="baseUri" value="${pageContext.request.contextPath }" scope="request"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>我的美食</title>
<link href="${baseUri }/static/css/allfoods.css" rel="stylesheet">
<style type="text/css">
.content{
height:auto;
}
.mylook{
        width: 195px;
		height: 50px;
		background-color:white;
		opacity: 0.8;
		text-align: center;
		display: block;
		margin-top: -54px;
		position: absolute;
		line-height: 50px;
        	}
.havefood{
	width:800px;
	height:200px;
	margin: 0 auto;
}
.hafood{
text-align: center;
line-height:200px;
}
</style>
</head>
<body>
<div class="foodbigdiv">
<c:import url="nav/titlenav.jsp"></c:import>
<div class="content">
	<div class="topimg">
		<img  src="${baseUri }/static/images/19.jpg" />
	</div>
	<h2 class="contenttitle">我的美食</h2>
	<c:if test="${empty requestScope.foods}">
		<div class="havefood">
			<p class="hafood">这个人很懒，什么都没发布~</p>
		</div>
	</c:if>
	<c:forEach items="${requestScope.foods}" var="food">
	<div style="width:800px;height:200px;margin: 0 auto;margin-bottom: 20px;">
	<a href="fooddetails?id=${food.fID }">
		<div class="fooditem">
			<div class="fooditemimg">
				<img src="${baseUri }/static/images/${food.fImage}"/>
				<c:if test="${food.fSign==0}">
					<span class="mylook">仅自己可见</span>
				</c:if>
				
			</div>
			<div class="fooditemmass">
				<p class="foottitle">${food.fName }</p>
				<p>主要食材：${food.fMainIngredient }</p>
				<p>辅料、调料：${food.fBurdening }</p>
			</div>
		</div>
		</a>
		</div>
	</c:forEach>
</div>
<c:import url="nav/bottomnav.jsp"></c:import>
</div>
</body>
</html>