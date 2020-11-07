<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>后台管理分类</title>
<style type="text/css">
.content{
	width: 100%;
	height: 100%;
}
hr{
        		background-color: powderblue;
        		border: none;
        		height: 2px;
        	}
.classcont{
		text-align: center;
}
.classcont table{
        	border-color:powderblue;
        	margin-top: 20px;
    }
.classcont tr{
        height: 50px;
        	}
.classcont td{
        	width: 120px;
        	}
.classinput{
        	width: 200px;
        	height:40px;
        	border:2px solid powderblue;
        	border-radius: 10px;
        }
.classbut{
		width:50px;
		height: 50px;
		background-color:lightskyblue;
		border:2px solid lightskyblue;
		border-radius: 10px;
}
</style>
</head>
<body>
<div class="content">
	<h3>类别列表</h3>
    <hr/>
    <div class="classcont">
    <h4>添加分类</h4>
    <form action="addclass">
    	<input type="text" name="cName" class="classinput" placeholder="请输入类别名称">
    	<button type="submit" class="classbut">添加</button>
    </form>
	<table border="1" cellspacing="0" align="center">
		<tr>
			<td>类别ID</td>
			<td>类别名称</td>
		</tr>
		<c:forEach items="${cate }" var="cate">
			<tr>
				<td>${cate.cID}</td>
				<td>${cate.cName}</td>
			</tr>
		</c:forEach>
	</table>
	 </div>
</div>
</body>
</html>