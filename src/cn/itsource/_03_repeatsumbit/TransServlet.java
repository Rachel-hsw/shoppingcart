package cn.itsource._03_repeatsumbit;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//处理转账请求
@WebServlet("/trans")
public class TransServlet extends HttpServlet{

	
	private static final long serialVersionUID = 1L;
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	resp.setContentType("text/html;charset=utf-8");
	String money=req.getParameter("money");
	//------------------------------------------------
	//隐藏域中的Token
	String token=req.getParameter("token");
	if(TokenUtil.validate(req, token)){
	System.out.println("转出"+money);
	resp.getWriter().print("转出"+money+"钱钱");
	}else{
		System.out.println("手贱");
	}
	}
}
/*	try {
 * 测试：睡眠1秒钟，表单重复提交现象
		Thread.sleep(1000);
	} catch (InterruptedException e) {
		e.printStackTrace();
	}*/
