<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="baseUri" value="${pageContext.request.contextPath }" scope="request"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title></title>
<style>
a{
				text-decoration: none;	
}
        	.alluser{
        			
        			width: 100%;
        			height: 100%;
        	} 
        	hr{
        		background-color: powderblue;
        		border: none;
        		height: 2px;
        	}
        	.userlist{
        			text-align: center;
        	}
        	.userlist table{
        		border-color:powderblue;
        	}
        	.userlist tr{
        			height: 50px;
        	}
        	.userlist td{
        		width: 120px;
        	}
        	.delete{
        		width: 60px;
        		height: 40px;
        		background-color: lightskyblue;
        		border-radius: 10px;
        		color:white;
        	}
        </style>
</head>
<body>
<div class="alluser">
    		<h3>用户列表</h3>
    		<hr/>
    		<div class="userlist">
    		<table  border="1" cellspacing="0" align="center" width="600"> 
    			<tr>
    				<td >用户ID</td>
    				<td>用户账号</td>
    				<td>用户名字</td>
    				<td>用户密码</td>
    				<td>操作</td>
    			</tr>
    			<c:forEach items="${requestScope.users }" var="user">
    				<tr>
	    				<td>${user.uID }</td>
	    				<td>${user.uNumber }</td>
	    				<td>${user.uName }</td>
	    				<td>${user.uPassword }</td>
	    				<td><div style="width:60px;height:40px;margin:0 auto;"><a href="delmanuser?id=${user.uID }" style="line-height: 40px;width:60px;" onclick="return confirm('确定注销账号为${user.uNumber }的用户，注销后该用户所发布的美食将同被删除？')"><div class="delete">注销</div></a></div></td>
    				</tr>
    			</c:forEach>
    			
    		</table>
    		</div>
    		
    	</div>
</body>
</html>