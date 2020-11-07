<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="baseUri" value="${pageContext.request.contextPath }" scope="request"></c:set>    
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>注册</title>
<link href="${baseUri}/static/css/enroll.css" rel="stylesheet">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js"></script>
</head>
<body>
	<div class="enrollcontain">
    	<h1 class="title">欢迎来到美食网站</h1>
    	<div class="enroll">
    		<h3 class="enrolltitle">注册</h3>
    		
    		<form action="adminEnroll" method="post">
				用户名：<input type="text" id="uname" onblur="una()" class="enroll_input" required="required" placeholder="请输入用户名(6-20个字母)" name="uName" /><br />
				
				账&nbsp;&nbsp;&nbsp;号：<input type="text" readonly="readonly" class="enroll_input" id="number" required="required" placeholder="请选择账号" name="uNumber"/>
										<button type="button" class="numauto" onclick="show()">选择账号</button>					
				密&nbsp;&nbsp;&nbsp;码：<input type="password" onblur="psw()" id="pwd" class="enroll_input" required="required"  placeholder="请输入密码(6-20个数字)" name="uPassword" />
				
				<label style="display: block;margin-left: 10%;color:red"> 
					<c:if test="${enroll_error !=null}">
						提示：<span class="login_msg">${enroll_error}</span>
					</c:if>
				</label>
				
				<button onclick="return enbttn()" type="submit"  class="enroll_btn" id="enbtn">注 册</button>
			</form>
    	</div>
    </div>   
</div>
</body>
</html>
<script>
	
	function enbttn(){
		var number = $("#number").val();
		if (number==null||number == '') {
			alert("请选择账号");
			return false;
		}
	}
	
	function una(){
	var uname = document.getElementById("uname").value;
	uname = uname.trim();
	var reg = /^[a-zA-Z]{6,20}$/;
	if(reg.test(uname)==false){
		confirm("用户名格式错误");
		return false;
		}
	}
	function show(){
		var num = '';
        for(var i=0;i<3;i++)
        {
            num+=Math.floor(Math.random()*10);
        }
        document.getElementById("number").value=num;
	}
 	function psw(){
	var psw = document.getElementById("pwd").value;
	psw = psw.trim();
	var reg = /^[0-9]{6,20}$/;
	if(reg.test(psw)==false){
		confirm("密码格式错误");
		return false;
		}
	}
</script>