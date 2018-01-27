package cn.itsource._02_randomcode;

import java.io.IOException;
//软件是测试出来的，代码是优化出来的
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/login")
public class LoginServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//1、接受请求参数
		req.setCharacterEncoding("utf-8");
		String username=req.getParameter("username");
		String passwprd=req.getParameter("passwprd");
		String randomCOde=req.getParameter("randomCOde");
	
		if(RandomCodeUtil.validate(req, randomCOde)){
			//验证码正确
			//正常的业务逻辑操作
			System.out.println("登陆检查");
			return;
		}
			//验证码错误
			req.setAttribute("errorMsg", "亲，验证码错误或已失效");
			req.getRequestDispatcher("/login.jsp").forward(req, resp);		
	}
}
