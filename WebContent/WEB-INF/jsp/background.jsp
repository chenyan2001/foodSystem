<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="baseUri" value="${pageContext.request.contextPath }" scope="request"></c:set> 
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>后台管理系统</title>
<style>  
.bottfont{
        		color: white;
        		text-align: center;
        		line-height: 50px;
        		margin-top:0px;
        	}
.bott{
        		width: 100%;
        		height: 50px;
        		background-color: grey;
        		
        	}
        	ul{
				list-style: none;		
}
			a{
				text-decoration: none;
}
			.bigdiv{
				width: 100%;
				height: auto;
				position: absolute;
				top: 0px;
				left: 0px;	
			}
        	.titlenav{
				width: 100%;
				height: 60px;
				background-color: lightskyblue;									
}
			.title{
					font-size: 30px;
					color: white;
					line-height: 60px;
					margin-left: 50px;
			}
			.adminout{				
				position: absolute;
				line-height: 60px;
				top: 0px;
				right: 3%;
}
			.nava{
				font-size: 20px;
				color: white;
			}
			.manage{
				width: 100%;
				height: 487px;
				display: flex;
				}
			.leftmanage{
				width: 20%;
				height: 100%;
				background-color: powderblue;
				}
			.leftmanage ul{
				margin: 0px;
				padding: 0px;
			}
			.leftmanage ul li{				
				border: 1px white solid;			
			}
			.rightmanage{
				width: 80%;
				height: 100%;
				
				}
			.managenav{
				color: #000000;
				font-size: 26px;
				line-height: 60px;
				margin-left: 50px;
				
			}
			.hidd{
				height:0;
				overflow: hidden;
				transition:all linear 0.5s;
				}
			.hidd li{text-align: center;}
			.hiddnav{
				color: white;
				font-size: 22px;
				line-height: 50px;
				
			}
			.manfood:hover .hidd{
				height: 100px;
				transition:all linear 0.5s;
			}
        </style>
</head>
<body>
<div class="bigdiv">
    	<div class="titlenav">
			<div class="title">美食网站后台管理系统</div>
			<div class="adminout">
			<a href="javascript:;" class="nava" style="margin-right:20px">${us.adName}</a>
			<a href="aduser" class="nava" onclick="return confirm('确认退出管理员${us.adName }？')" >安全退出</a>
			</div>
		</div>
    	<div class="manage">
    		<div class="leftmanage">
    			<ul>
    				<li><a href="manageuser" class="managenav" target="maninf">管理用户</a></li>
    				<li class="manfood">
    				<a  class="managenav">管理美食</a>
    				<ul class="hidd">
    					<li><a class="hiddnav" href="managefood" target="maninf">美食列表</a></li>
    					<li><a class="hiddnav" href="manaddfood" target="maninf">添加美食</a></li>
    				</ul>
    				</li>
    				<li class="manfood">
    				<a  class="managenav" href="selectclass" target="maninf">管理类别</a>
    				</li>
    				
    			</ul>
    		</div>
    		<div class="rightmanage">
    			<iframe src="manageuser" name="maninf" width="100%" height="100%" frameborder="0"></iframe>
    		</div>
    	</div>
    	<div class="bott">
    		<p class="bottfont">美食网站  版权所有 @foodSystem 2020</p>
   		</div>
</div>
	      
</body>
</html>