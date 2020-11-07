<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="baseUri" value="${pageContext.request.contextPath }" scope="request"></c:set>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title></title>
<style>
a{
				text-decoration: none;	
}
        	.allfood{
        			
        			width: 100%;
        			height: 100%;
        	} 
        	hr{
        		background-color: powderblue;
        		border: none;
        		height: 2px;
        	}
        	.foodlist{
        			text-align: center;
        	}
        	.foodlist table{
        		border-color:powderblue;
        	}
        	.foodlist tr{
        			height: 50px;
        	}
        	.foodlist td{
        		width: 90px;
        	}
        	.delete{
        		width: 60px;
        		height: 40px;
        		background-color: lightskyblue;
        		border-radius: 10px;
        		color:white;
        	}
        	.pageshow{
        		position: absolute;
        		bottom: 20px;
        		left:350px;
        	}
        	.buttfood{
        		width:60px;
        		height:40px;
        		margin:0 auto;
        		display: inline-block;
        	}
        </style>
</head>
<body>
<div class="allfood">
    		<h3>美食列表</h3>
    		<hr/>
    		<div class="foodlist">
    		<table  border="1" cellspacing="0" align="center"> 
    			<tr>
    				<td style="width:50px">美食ID</td>
    				<td>美食名字</td>
    				<td>美食图片</td>
    				<td>美食原料</td>
    				<td>类别</td>
    				<td>上传时间</td>
    				<td>上传者</td>
    				<td>点击次数</td>
    				<td style="width:140px">操作</td>
    			</tr>
    			<c:forEach items="${requestScope.page.list}" var="food">
    				<tr>
	    				<td style="width:50px">${food.fID}</td>
	    				<td>${food.fName}</td>
	    				<td><img src="${baseUri}/static/images/${food.fImage}" style="width:80px;height:80px"></td>
	    				<td>${food.fMainIngredient}</td>
	    				<td>${food.fCategories[0].cName}</td>
	    				<td><fmt:formatDate value="${food.fTime}" pattern="yyyy-MM-dd HH:mm:ss"/>  </td>
	    				<td>${food.fCreateName}</td>
	    				<td>${food.fOnclick}</td>
	    				<td style="width:140px"><div class="buttfood">
	    					<a href="delmanfood?id=${food.fID }" style="line-height: 40px;width:60px;" onclick="return confirm('确定删除美食${food.fName}？')">
	    					<div class="delete">删除</div>
	    					</a></div>
	    					<div class="buttfood">
	    					<a href="updmanfood?id=${food.fID }" style="line-height: 40px;width:60px;">
	    					<div class="delete">修改</div>
	    					</a></div>
	    				</td>
    				</tr>
    			</c:forEach>
    			
    		</table>
    		</div>
    		<div class="pageshow">
				<span>第${requestScope.page.currpage }/${requestScope.page.totalPage}页</span>&nbsp;&nbsp;
				<c:if test="${requestScope.page.currpage != 1}">
					<a href="${baseUri}/managefood?currentPage=1">[首页]</a>&nbsp;&nbsp;
		           	<a href="${baseUri}/managefood?currentPage=${requestScope.page.currpage-1}">[上一页]</a>&nbsp;&nbsp;
		       	</c:if> 
		       	<c:if test="${requestScope.page.currpage != requestScope.page.totalPage}">
					<a href="${baseUri}/managefood?currentPage=${requestScope.page.currpage+1}">[下一页]</a>&nbsp;&nbsp;
		           	<a href="${baseUri}/managefood?currentPage=${requestScope.page.totalPage}">[尾页]</a>&nbsp;&nbsp;
		       	</c:if>
	</div>
    	</div>
</body>
</html>
