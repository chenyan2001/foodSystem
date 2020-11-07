<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="baseUri" value="${pageContext.request.contextPath }" scope="request"></c:set>    
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>分类美食展示</title>
<link href="${baseUri }/static/css/catename.css" rel="stylesheet">
</head>
<body>
<div class="foodbigdiv">
<c:import url="nav/titlenav.jsp"></c:import>
	<div class="content">
 			<div class="topimg">
				<img  src="${baseUri }/static/images/19.jpg" />
			</div>
			<div class="foodcate">
				<div class="catetop">
					<p class="catena">${requestScope.cName}</p>
					<p class="classsum">共有<span class="foodsum">${requestScope.num }</span>道美食&nbsp;&nbsp;</p>
				</div>
				<c:forEach items="${requestScope.classfood}" var="food">
				<a href="fooddetails?id=${food.fID }">
					<div class="fooditem">
						<div class="fooditemimg">
							<img src="${baseUri }/static/images/${food.fImage}"/>
						</div>
						<div class="fooditemmass">
							<p class="foottitle">${food.fName }</p>
							<p>主要食材：${food.fMainIngredient }</p>
							<p>辅料、调料：${food.fBurdening }</p>
						</div>
					</div>
					</a>
				</c:forEach>
			</div>
 		</div> 
 		<c:import url="nav/bottomnav.jsp"></c:import>
</div>		
</body>
</html>