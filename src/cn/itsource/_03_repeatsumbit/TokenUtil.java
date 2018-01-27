package cn.itsource._03_repeatsumbit;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

//令牌工具类
public class TokenUtil {
private TokenUtil(){}
//创建和保存令牌
public static void saveToken(HttpServletRequest req){
	//创建和保存一个令牌
	String token=UUID.randomUUID().toString();
	System.out.println(token);
	//一份放在session中
	req.getSession().setAttribute("TOKEN_IN_SESSION", token);
	//存放在Request中，那么在Jsp的表单中可以${token}获取
	req.setAttribute("token", token);
}
//校验令牌
public static synchronized boolean validate(HttpServletRequest req,String token){
	//Session中的Token
	String tokenInSession=(String) req.getSession().getAttribute("TOKEN_IN_SESSION");
	if(token.equals(tokenInSession)){
	//删除Session中的Token	
	req.getSession().removeAttribute("TOKEN_IN_SESSION");
	return true;
	}
	return false;
}
}
