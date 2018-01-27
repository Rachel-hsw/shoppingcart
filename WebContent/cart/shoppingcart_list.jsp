<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<h3>购物车列表界面</h3>
${sessionScope.SHOPPINGCART_IN_SESSION.items}
<table cellpadding="0" cellspacing="0" border="1" width="80%">
<tr>
<th>序号</th>
<th>名称</th>
<th>数量</th>
<th>单价</th>
<th>操作</th>
</tr>
<c:if test="${not empty sessionScope.SHOPPINGCART_IN_SESSION.items}">
<c:forEach items="${sessionScope.SHOPPINGCART_IN_SESSION.items}" var="item" varStatus="vs">
<tr>
<td>${vs.count}</td>
<td>${item.name}</td>
<td>${item.num}</td>
<td>${item.price}</td>
<td><a href="${pageContext.request.contextPath }/shoppingcart?cmd=delete&id=${item.id}">删除</a></td>
</tr>
</c:forEach>
<tr>
<td colspan="5">购物车总价：${sessionScope.SHOPPINGCART_IN_SESSION.totalPrice}</td>
</tr>
</c:if>
<c:if test="${empty sessionScope.SHOPPINGCART_IN_SESSION.items}">
<tr><td colspan="5">亲，购物车为空，快去购物</td></tr>
</c:if>

</table>
<a href="${pageContext.request.contextPath }/cart/product_list.jsp">继续购物</a>
<a href="#">朕要打白条</a>
</body>
</html>