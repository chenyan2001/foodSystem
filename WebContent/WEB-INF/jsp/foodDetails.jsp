<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="baseUri" value="${pageContext.request.contextPath }" scope="request"></c:set> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js"></script>
<title>美食详情</title>
<link href="${baseUri}/static/css/foodDetails.css" rel="stylesheet">
</head>
<body onload="selecollect()">
<div class="foodbigdiv">
<c:import url="nav/titlenav.jsp"></c:import>
	<div class="foodDet">
			<p class="contenttitle">${requestScope.food.fName}</p>
 			<button onclick="showcollect()" class="collection" id="colle">收藏</button>
 			<button onclick="hiddcollect()" class="collection" id="collec">已收藏</button>
 			<img src="${baseUri }/static/images/${requestScope.food.fImage}" class="foodimg"/>
 			<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${requestScope.food.fIntroduction}</p>
 			<div class="ingredient">
 				<p class="ingretiele">食材明细</p>
 				<p class="mainingre">主料：${requestScope.food.fMainIngredient}</p>
 				<p class="mainingre">辅料：${requestScope.food.fBurdening}</p>
 			</div>
 			<div class="foodstep">
 				<p class="ingretiele">${requestScope.food.fName}主要步骤</p>
 				<p class="mainstep">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${requestScope.food.fStep}</p>
 			</div>
 			<div class="foodstep">
 				<p class="ingretiele">美食评论</p>
 				<input type="text" placeholder="快来评论吧~" class="sendcomm" id="sendcomm"/>
 				<button type="submit" id="sendbut" class="sendbut">发送</button>
 				<c:forEach items="${comments}" var="comment">
 				<div style="margin-bottom: 20px;">
 					<span class="uname">
 					<c:forEach items="${users }" var="user">
 						<c:if test="${user.uID== comment.uID}">
 							${user.uName}
 						</c:if>
 					</c:forEach>
 					</span>
 					<span class="ctime"><fmt:formatDate value="${comment.cmTime}" pattern="yyyy-MM-dd HH:mm:ss"/></span>
 					<p class="comment">${comment.cmContent }</p>
 				</div>
 				</c:forEach>
 			</div>
 			<c:if test="${sessionScope.u.uName==requestScope.food.fCreateName }">
 			<a href="editfood?id=${requestScope.food.fID}"><button class="foodbutt">编辑</button></a>
 			<a href="deletefood?id=${requestScope.food.fID}" onclick="return confirm('确认删除${requestScope.food.fName}这道美食？')"><button class="foodbutt">删除</button></a>
 			</c:if>
 		</div>
 		<c:import url="nav/bottomnav.jsp"></c:import>
</div>
</body>
</html>
<script language="JavaScript">

	$("#sendbut").on("click",function(){
		var uID = ${sessionScope.u.uID};
		var fID = ${requestScope.food.fID};
		var cmContent = $("#sendcomm").val();
		$.ajax({
			type:"post",
			url:"${baseUri}/sendcomment",
			data:JSON.stringify({uID:uID,fID:fID,cmContent:cmContent}),
			contentType:"application/json;charset=UTF-8",
			success:function(data){
				location.reload();
				
			}
		})
	});

	function showcollect(){
		
		var uID = ${sessionScope.u.uID};
		var fID = ${requestScope.food.fID};
		
		$.ajax({
			url:"${baseUri}/addCollect",
			type:"post",
			data:JSON.stringify({uID:uID,fID:fID}),
			contentType:"application/json;charset=UTF-8",
			dataType:"json",
			success : function(data) {
				alert("收藏成功");
				document.getElementById("colle").style.display = 'none';
				document.getElementById("collec").style.display = 'block';
			}
		});
		
	}
	
	function hiddcollect(){
		var uID = ${sessionScope.u.uID};
		var fID = ${requestScope.food.fID};
		
		$.ajax({
			url:"${baseUri}/delCollect",
			type:"post",
			data:JSON.stringify({uID:uID,fID:fID}),
			contentType:"application/json;charset=UTF-8",
			dataType:"json",
			success : function(data) {
				alert("已取消收藏");
				document.getElementById("collec").style.display = 'none';
				document.getElementById("colle").style.display = 'block';
			}
		});
		
		
	}
	
	function selecollect(){
		var uID = ${sessionScope.u.uID};
		var fID = ${requestScope.food.fID};
		$.ajax({
			url:"${baseUri}/seleCollect",
			type:"post",
			data:JSON.stringify({uID:uID,fID:fID}),
			contentType:"application/json;charset=UTF-8",
			dataType:"json",
			success : function(data) {
				if(data!=null){
					document.getElementById("collec").style.display = 'block';
					document.getElementById("colle").style.display = 'none';
				}
			}
		});
		
		
	}
</script>