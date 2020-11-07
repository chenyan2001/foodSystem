<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="baseUri" value="${pageContext.request.contextPath }" scope="request"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户登录</title>
<link href="${baseUri}/static/css/login.css" type="text/css" rel="stylesheet"/>
</head>
<body>
    <div class="logincontain">
    	<h1 class="title">欢迎来到美食网站</h1>
    	<div class="login">
    		<h3 class="logintitle">用户登录</h3>
    		
    		<form action="adminLogin" method="post">
				账&nbsp;&nbsp;&nbsp;号：<input type="text"	class="login_input" required="required" placeholder="请输入账号" name="uNumber" />
				密&nbsp;&nbsp;&nbsp;码：<input type="password" class="login_input" required="required"   placeholder="请输入密码" name="uPassword" />
				
				<label style="display: block;margin-left: 10%;color:red"> 
					<c:if test="${Login_error !=null}">
						提示：<span class="login_msg">${Login_error}</span>
					</c:if>
				</label>
				<button type="submit" class="login_btn">登 录</button>
			</form>
			<p style="text-align: center;">
				<a href="enroll">注册</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<a href="tobacklogin">登录后台管理员</a>
			</p>
    	</div>
    </div>
</body>
</html>