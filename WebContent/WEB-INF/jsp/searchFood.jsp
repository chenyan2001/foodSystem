<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="baseUri" value="${pageContext.request.contextPath }" scope="request"></c:set>    
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>搜索美食</title>
<link href="${baseUri }/static/css/search.css" rel="stylesheet">
</head>
<body>
<div class="foodbigdiv">
<c:import url="nav/titlenav.jsp"></c:import>
	<div class="searchcontent">
    		<div class="searchform">
    			<form method="post" action="searchname">
    				<input type="text" class="searchtext" name="fName"/>
    				<button type="submit" class="searchbutt">搜索名字</button>
    			</form> 
    			<form method="post" action="searchmain">
    				<input type="text" class="searchtext" name="fMainIngredient"/>
    				<button type="submit" class="searchbutt">搜索食材</button>
    			</form> 
    		</div>
    		<div class="searchcont">
    		<c:forEach items="${foodsname}" var="foodsname">
    		<a href="fooddetails?id=${foodsname.fID }">
    			<div class="fooditem">
					<div class="fooditemimg">
						<img src="${baseUri }/static/images/${foodsname.fImage}"/>
					</div>
					<div class="fooditemmass">
						<p class="foottitle">${foodsname.fName}</p>
						<p>主要食材：${foodsname.fMainIngredient}</p>
						<p>辅料、调料：${foodsname.fBurdening}</p>
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