package cn.itsource._01_shoppingcart.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itsource._01_shoppingcart.domain.CartItem;
import cn.itsource._01_shoppingcart.domain.ShoppingCart;
import cn.itsource._01_shoppingcart.web.util.Global;

//购物车请求
@WebServlet("/shoppingcart")
public class ShoppingCartServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		  System.out.println("----------------------");  
		req.setCharacterEncoding("utf-8");
		String cmd=req.getParameter("cmd");
		if ("save".equals(cmd)) {
			this.save(req, resp);
			
		}else if("delete".equals(cmd)){
			this.delete(req, resp);
		}
	}
protected void save(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	//1
	String name=req.getParameter("name");
	Integer num=Integer.valueOf(req.getParameter("num"));
	CartItem item=new CartItem();
	item.setName(name);
	item.setNum(num);
	if ("笔记本".equals(name)) {
		item.setId("123");
		item.setPrice(1000.0);
	}else if ("笔记本".equals(name)) {
		item.setId("345");
		item.setPrice(100.0);
	}else if ("鼠标".equals(name)) {
		item.setId("789");
		item.setPrice(50.0);
	}
	//2
	ShoppingCart cart=(ShoppingCart) req.getSession().getAttribute(Global.SHOPPINGCART_IN_SESSION);
	if(cart==null){
		//没有购物车
		cart=new ShoppingCart();
		//存入session中，供下次使用
		req.getSession().setAttribute(Global.SHOPPINGCART_IN_SESSION, cart);
	}
	cart.save(item);
	//3
	resp.sendRedirect(req.getContextPath()+"/cart/shoppingcart_list.jsp");
	
}

protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String id=req.getParameter("id");
	ShoppingCart cart=(ShoppingCart) req.getSession().getAttribute(Global.SHOPPINGCART_IN_SESSION);
	cart.delete(id);
	resp.sendRedirect(req.getContextPath()+"/cart/shoppingcart_list.jsp");
}


}
