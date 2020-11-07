<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="baseUri" value="${pageContext.request.contextPath }" scope="request"></c:set>    
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>修改密码</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js"></script>
<style>
        	.foodbigdiv{
    			width:100%;
    			height:auto;
    			background-color: antiquewhite;
    		}
        	.content{
        		width: 500px;
        		height: 500px;
        		margin: 0 auto;
        	}
        	h1{
        		text-align: center;
        	}
        	form{
        		margin-left: 100px;
        	}
        	.upda{
        		width: 200px;
        		height: 50px;
        		margin-top: 20px;
        	}
        	.buttpawd{
        		width: 100px;
        		height: 50px;
        		margin-top: 20px;
        		margin-left: 100px;
        	}
        </style>
</head>
<body>
<div class="foodbigdiv">
<c:import url="nav/titlenav.jsp"></c:import>
	<div class="content">
 			<h1>修改密码</h1>
 			<form action="updatepsw" method="post">
 				用 &nbsp;&nbsp;&nbsp;户&nbsp;&nbsp;&nbsp;名：<input type="text" name="uName" readonly="readonly" value="${u.uName }" class="upda"/><br />
 				账&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;号：<input type="text" readonly="readonly" value="${u.uNumber }" name="uNumber" class="upda"/><br />
 				旧&nbsp;&nbsp;&nbsp;密&nbsp;&nbsp;&nbsp;码：<input type="password" name="uOldPassword" required="required" class="upda"/><br />
 				新&nbsp;&nbsp;&nbsp;密&nbsp;&nbsp;&nbsp;码：<input type="password" name="uPassword" required="required" class="upda" id="newpwd"/><br />
 				确定新密码：<input type="password" required="required" class="upda" id="yesnewpwd"/><br />
 				<label style="display: block;margin-left: 20%;color:red"> 
					<c:if test="${update_error !=null}">
						提示：<span class="login_msg">${update_error}</span>
					</c:if>
				</label>
 				
 				<button onclick="return yespwd()" type="submit" class="buttpawd" >提交</button>
 			</form>
 		</div>
<c:import url="nav/bottomnav.jsp"></c:import>
</div>
</body>
</html>
<script>
	function yespwd() {
		var newpwd = $("#newpwd").val();
		var yesnewpwd = $("#yesnewpwd").val();
		if (newpwd == yesnewpwd) {
			confirm('确定修改密码？修改成功跳转到首页');
			return true;
		}else {
			alert("两次输入密码不一致，请重新输入");
			return false;
		}
	}
</script>