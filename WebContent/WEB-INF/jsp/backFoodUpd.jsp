<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="baseUri" value="${pageContext.request.contextPath }" scope="request"></c:set>    
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>编辑美食</title>
<link href="${baseUri}/static/css/addFood.css" rel="stylesheet">
<style>
        	.foodform{
        		width: 500px;
        		height: 650px;
        		
        	}
        	.oldimg{
        		width: 100px;
        		height: 100px;
        	}
        	.addcontent{
        		height:750px;
        	}
        </style>
</head>
<body>
<div class="foodbigdiv" style="background-color:white">
	<div class="addcontent">
			<h2 class="contenttitle">编辑美食</h2>
			<form action="backupdatefood" method="post" class="foodform" enctype="multipart/form-data">
								<input type="hidden" name="fID" value="${requestScope.bafouupd.fID}"/>
				<label>美食名称：<input type="text" class="fname" value="${requestScope.bafouupd.fName}" name="fName" placeholder="请输入内容"/></label><br />
				<label>美食简介：<textarea placeholder="请输入内容" class="fintro" name="fIntroduction">${requestScope.bafouupd.fIntroduction}</textarea></label><br />
				<label>美食主料：<input type="text" placeholder="请输入内容" value="${requestScope.bafouupd.fMainIngredient}" class="fname" name="fMainIngredient"/></label><br />
				<label>美食配料：<textarea placeholder="请输入内容" class="fintro" name="fBurdening">${requestScope.bafouupd.fBurdening}</textarea></label><br />
				<label>主要步骤：<textarea placeholder="请输入内容" class="fstep" name="fStep">${requestScope.bafouupd.fStep}</textarea></label><br />
				
				<label>美食图片：<img src="${baseUri }/static/images/${requestScope.bafouupd.fImage}" class="oldimg" id="oldimg"/> 
								<input type="hidden" name="fImage" value="${requestScope.bafouupd.fImage}">
								<input type="file" name="file" onchange="readFoodImg(this)" class="fimg" id="fImg"/></label><br />
				<label>美食分类：<select name="fCategory" class="fcate">
					<option value="${bafouupd.fCategories[0].cID}">${bafouupd.fCategories[0].cName}</option>
					<option value="1">湘菜</option>
					<option value="2">川菜</option>
					<option value="3">闽菜</option>
					<option value="4">粤菜</option>
					<option value="5">鲁菜</option>
					<option value="6">徽菜</option>
					<option value="7">浙菜</option>
					<option value="8">苏菜</option>
				</select></label><br /> 
				
				<button type="submit" class="butt">提交</button>
				<button type="reset" class="butt">重置</button>
	</form>
</div>
</div>
</body>
</html>
<script>
	function readFoodImg() {
		var rf = new FileReader();
		f = document.getElementById("fImg").files[0];
		rf.readAsDataURL(f);
		rf.onload = function (e){
			document.getElementById("oldimg").src=this.result;
		}
	}
	
</script>