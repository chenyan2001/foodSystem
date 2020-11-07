<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="baseUri" value="${pageContext.request.contextPath }" scope="request"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>分类</title>
<link href="${baseUri }/static/css/classify.css" rel="stylesheet">
<style type="text/css">
.bottfont{
	margin-top:0px
}
</style>
</head>
<body>
<div class="foodbigdiv">
<c:import url="nav/titlenav.jsp"></c:import>
<div class="content">
		<c:forEach var="categor" items="${requestScope.categorys}">
			<div class="classdiv">
			<a href="catename?id=${categor.cID }" target="classfood"><p class="classtitle" style="margin-top:0px">${categor.cName }</p></a>
			</div>
		</c:forEach>
	
</div>
<c:import url="nav/bottomnav.jsp"></c:import>
</div>
</body>
</html>