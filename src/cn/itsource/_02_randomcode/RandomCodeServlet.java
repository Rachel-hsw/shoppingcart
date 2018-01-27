package cn.itsource._02_randomcode;

import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/randomcode")
public class RandomCodeServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

@Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	//把图片对象以流的方式保存出去
	ImageIO.write(RandomCodeUtil.createImage(req), "jpg", resp.getOutputStream());
	
}
}
