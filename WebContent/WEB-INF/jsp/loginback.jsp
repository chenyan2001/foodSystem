<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="baseUri" value="${pageContext.request.contextPath }" scope="request"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>后台登录</title>
<link href="${baseUri}/static/css/login.css" type="text/css" rel="stylesheet"/>
<link href="${baseUri}/static/css/backlogin.css" type="text/css" rel="stylesheet">
</head>
<body>
<div class="logincontain">
    	<h1 class="title">欢迎来到美食网站后台管理系统</h1>
    	<div class="login">
    		<h3 class="logintitle">后台登录</h3>
    		
    		<form action="toback" method="post">
				账&nbsp;&nbsp;&nbsp;号：<input type="text"	class="login_input" required="required" placeholder="请输入账号" name="adNumber" /><br>
				密&nbsp;&nbsp;&nbsp;码：<input type="password" class="login_input" required="required"   placeholder="请输入密码" name="adPassword" />
				<!-- <label> 
						<input type="checkbox" />记住我的登录信息
					</label> -->
				<label style="display: block;text-align:center;color:red"> 
					<c:if test="${Login_error !=null}">
						提示：<span class="login_msg">${Login_error}</span>
					</c:if>
				</label>
				<button style="" class="login_btn">登 录</button>
			</form>
			
    	</div>
    </div>
</body>
</html>