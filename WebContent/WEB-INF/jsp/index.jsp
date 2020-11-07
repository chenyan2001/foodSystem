<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="baseUri" value="${pageContext.request.contextPath }" scope="request"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>首页</title>
<link href="${baseUri}/static/css/index.css" rel="stylesheet">
</head>
<body>
<div class="foodbigdiv">
<c:import url="nav/titlenav.jsp"></c:import>
<div class="imgplay">
	 <img src="${baseUri}/static/images/02.jpg" id="img1" class="img1" onload="setTimeout('change()',3000)"> 
</div>
<div class="content">
	<h3 class="zuixin">最新美食</h3>
	<c:forEach items="${requestScope.foods}" var="food">
	<a href="fooddetails?id=${food.fID }">
		<div class="fooditem">
			<div class="imgdiv">
				<img src="${baseUri}/static/images/${food.fImage }" class="foodimg"/>
			</div>
			<h4 class="foodaut">${food.fName }</h4>
			<p id="fID" style="display:none">${food.fID }</p>
			<p id="fOnclick" style="display:none">${food.fOnclick }</p>
		</div>
	</a>
	</c:forEach>
</div>
<div class="content">
	<h3 class="zuixin">最热美食</h3>
	<c:forEach items="${requestScope.hotFoods}" var="food">
	<a href="fooddetails?id=${food.fID }">
		<div class="fooditem">
			<div class="imgdiv">
				<img src="${baseUri}/static/images/${food.fImage }" class="foodimg"/>
			</div>
			<h4 class="foodaut">${food.fName }</h4>
			<p id="fID" style="display:none">${food.fID }</p>
			<p id="fOnclick" style="display:none">${food.fOnclick }</p>
		</div>
	</a>
	</c:forEach>

</div>
<c:import url="nav/bottomnav.jsp"></c:import>
</div>
</body>
</html>
<script>
//准备工作：缓存图片
	var arr=new Array(3);//var arr=[3]
	for(i=0;i<3;i++){
		arr[i]=new Image()//创建图片对象
		arr[i].src="${baseUri}/static/images/0"+i+".jpg";
		}
	var index=0;
function change(){
	document.getElementById("img1").src=arr[index].src;
	index++;
	if(index>2)
		index=0;
	}
	/*  function clickNum(){
	
	var fID = document.getElementById("fID").innerHTML;
	var fOnclick = document.getElementById("fOnclick").innerHTML;
	
	fOnclick++;

	$.ajax({
		url:"${baseUri}/updaClickNum",
		type:"post",
		data:JSON.stringify({fID:fID,fOnclick:fOnclick}),
		contentType:"application/json;charset=UTF-8",
		dataType:"json",
		success : function(data) {
			alert(data.fID);
		},
		
	});
	
}  */
</script>