<%@ page language="java" contentType="text/html; charset=utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script type="text/javascript">
function change(){
	
	//换一张图片，其本质就是再次请求/randomcode//没提示，为装逼
	var imgEl=document.getElementById("randomCodeImg");
	/* alert(imgEl.src); */
	//在资源后使用随机数。目的：告诉服务端，请求不一样，解决缓存问题
	imgEl.src="/randomcode?"+new Date().getTime();//参数一样的时候就把缓存给我们，所以没变化，这里时间毫秒数都是不一样的
}
</script>
</head>
<body>
<h3>登录界面</h3>
<span style="color:red;">${errorMsg}</span>
<br>
<form action="/login" method="post">
账&nbsp;&nbsp;&nbsp;号：<input type="text" name="username" placeholder="账号"/><br/>
密&nbsp;&nbsp;&nbsp;码：<input type="text" name="passwprd"  placeholder="密码"/><br/>
验证码：<input type="text" name="randomCOde" size="5" maxlength="5" placeholder="验证码" placeholder="验证码"/>
<img alt=""  id="randomCodeImg"  src="/randomcode" title="看不清换一张" style="cursor:pointer; " onclick="change()"/><br>
<input type="submit" value="登录" />
</form>
</body>
</html>