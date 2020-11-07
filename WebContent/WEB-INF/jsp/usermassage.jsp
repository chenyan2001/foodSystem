<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="baseUri" value="${pageContext.request.contextPath }" scope="request"></c:set>        
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>基本信息</title>
 <style>
        	.foodbigdiv{
    			width:100%;
    			height:100%;
    			background-color: antiquewhite;
    			position:absolute;
				top: 0px;
				left: 0px;
    		}
        	.content{
        		width: 800px;
        		height: auto;
        		margin: 0 auto;
        	}
        	.usertitle{
        		font-size: 30px;
        	}
        	.username{
        		font-size: 26px;
        		margin-left: 100px;
        	}
        	.usernum{
        		font-size: 26px;
        		margin-left: 100px;
        	}
        </style>
</head>
<body>
<div class="foodbigdiv">
<c:import url="nav/titlenav.jsp"></c:import>
	<div class="content">
 			<p class="usertitle">用户基本信息</p>
 			<p class="username">用户名：${u.uName }</p>
 			<p class="usernum">账&nbsp;&nbsp;户：${u.uNumber }</p>
 	</div>
<c:import url="nav/bottomnav.jsp"></c:import>
</div>
</body>
</html>