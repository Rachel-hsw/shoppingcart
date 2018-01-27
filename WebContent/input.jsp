<%@page import="java.util.UUID"%>
<%@ page language="java" contentType="text/html; charset=utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<h3>转账</h3>
<!-- //错误讯息 -->
<span style="color:red;">${errorMsg}</span>
<br>
<form action="/trans" method="post">
<input type="hidden" name="token" value="${token}">
<input type="number" name="money" placeholder="转账金额"/><br/>
<input type="submit" value="朕要转账" />
</form>
</body>
</html>