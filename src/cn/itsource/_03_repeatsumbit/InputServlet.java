package cn.itsource._03_repeatsumbit;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//进入转账界面
@WebServlet("/input")
public class InputServlet extends HttpServlet{


	private static final long serialVersionUID = 1L;
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//创建和保存一个令牌
	    TokenUtil.saveToken(req);
		req.getRequestDispatcher("/input.jsp").forward(req, resp);
	}

}
