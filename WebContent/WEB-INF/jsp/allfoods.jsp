<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="baseUri" value="${pageContext.request.contextPath }" scope="request"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>所有美食</title>
<link href="${baseUri }/static/css/allfoods.css" rel="stylesheet">
</head>
<body>
<div class="foodbigdiv">
<c:import url="nav/titlenav.jsp"></c:import>
<div class="content">
	<div class="topimg">
		<img  src="${baseUri }/static/images/19.jpg" />
	</div>
	<h2 class="contenttitle">所有美食</h2>
		
	<c:forEach items="${requestScope.page.list}" var="food">
	<div style="width:800px;height:200px;margin: 0 auto;margin-bottom: 20px;">
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
		</div>
	</c:forEach>
	
	
	<div class="pageshow">
		<span>第${requestScope.page.currpage }/${requestScope.page.totalPage}页</span>&nbsp;&nbsp;
		<span>总记录数:${requestScope.page.totalCount }</span>&nbsp;&nbsp;
		<span>每页显示:${requestScope.page.pageSize}</span>&nbsp;&nbsp;
		<c:if test="${requestScope.page.currpage != 1}">
			<a href="${baseUri}/showFood?currentPage=1">[首页]</a>&nbsp;&nbsp;
           	<a href="${baseUri}/showFood?currentPage=${requestScope.page.currpage-1}">[上一页]</a>&nbsp;&nbsp;
       	</c:if> 
       	<c:if test="${requestScope.page.currpage != requestScope.page.totalPage}">
			<a href="${baseUri}/showFood?currentPage=${requestScope.page.currpage+1}">[下一页]</a>&nbsp;&nbsp;
           	<a href="${baseUri}/showFood?currentPage=${requestScope.page.totalPage}">[尾页]</a>&nbsp;&nbsp;
       	</c:if>
	</div>
</div>
<c:import url="nav/bottomnav.jsp"></c:import>
</div>
</body>
</html>