<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="baseUri" value="${pageContext.request.contextPath }" scope="request"></c:set>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>头部</title>
<link href="${baseUri}/static/css/titlenav.css" rel="stylesheet"/>
</head>
<body>
	<div class="titlenav">
	<div class="title">美食网站</div>
	<ul class="nav">
		<li class="navitem">
			<a href="index" class="nava">首页</a>
		</li>
		<li class="navitem">
			<a href="showFood" class="nava">所有美食</a>
		</li>
		<li class="navitem">
			<a class="nava" href="showClassify">分类</a>
			<ul class="classul">
				<c:forEach var="categor" items="${categorys}">
					<li class="classli"><a href="catename?id=${categor.cID }" style="color:gray;">${categor.cName }</a></li>
				</c:forEach>
			</ul>
		</li>
		<li class="navitem">
			<a href="showMyfood" class="nava" onclick="mylogin()">我的美食</a>
		</li>
		<li class="navitem">
			<a href="collect" class="nava" onclick="mylogin()">收藏</a>
		</li>
		<li class="navitem">
			<a href="addFood" class="nava">发布</a>
		</li>
		<li class="navitem">
			<a href="searchFood" class="nava">搜索</a>
		</li>
	</ul>
	<c:if test="${u!=null}">
		<ul class="adminnav">
			<li class="navitem" style="width:100px">
				<a href="javascript:;" style="color: white;">${u.uName}</a>
			
				<dl class="navdl">
					<dd class="navdd"><a href="usermassage" style="color:gray;">基本资料</a></dd>
					<dd class="navdd"><a href="updatepwd" style="color:gray;">修改密码</a></dd>
				</dl>
			</li>
			<li class="navitem"><a href="adminout" onclick="return confirm('确认退出用户${u.uName }？')" style="color: white;">安全退出</a></li>
		</ul>
	</c:if>
	<c:if test="${u==null}">
		<ul class="adminnav">
			<li class="navitem"><a href="enroll" class="nava">注册</a></li>
			<li class="navitem"><a href="login" class="nava">登录</a></li>
		</ul>
	</c:if>
	
</div>
</body>
</html>
<script>
function mylogin(){
	if (${u==null}) {
		alert("请先登录");
	}
}
	
</script>