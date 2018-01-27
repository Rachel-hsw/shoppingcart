<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<form action="${pageContext.request.contextPath }/shoppingcart?cmd=save" method="post">
商品名称：<select name="name">
         <option>笔记本</option>
          <option>键盘</option>
           <option>鼠标</option>
        </select><br>
        否买数量：<input type="number" name="num"/><br>
           <input type="submit" value="朕要购物"/>
        
</form>
</body>