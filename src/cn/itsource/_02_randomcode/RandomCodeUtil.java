package cn.itsource._02_randomcode;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

//验证码的工具类
public class RandomCodeUtil {
	
	
	
private RandomCodeUtil(){
	
}
public static final String RANDOM_IN_SESSION="RANDOM_IN_SESSION";
public static void reset(HttpServletRequest req){
	//清除session中存储的验证码
	req.getSession().removeAttribute(RANDOM_IN_SESSION);
}

//校验验证码是否正确
public static boolean validate(HttpServletRequest req,String inputCode){
	//取出Session中存储的随机数
	String randomCodeSession=(String) req.getSession().getAttribute(RANDOM_IN_SESSION);
	if(StringUtil.hasLegth(inputCode)&&StringUtil.hasLegth(randomCodeSession)){
		//忽略大小写作比较
		if(inputCode.equalsIgnoreCase(randomCodeSession)){
			reset(req);
			return true;
			}
		}
	return false;
}

//创建验证码图片
public static BufferedImage createImage(HttpServletRequest req){
	//生成随机数
	String randomCode=UUID.randomUUID().toString().substring(0,5);
	//把随机数放进Session中
	req.getSession().setAttribute(RANDOM_IN_SESSION, randomCode);
	//创建图片对象
	int width=80;
	int height=40;
	int imageType=BufferedImage.TYPE_INT_RGB;
	BufferedImage image=new BufferedImage(width, height, imageType);
	//画板
	Graphics g=image.getGraphics();
	g.setColor(Color.YELLOW);
	//绘制一个实心的矩形
	g.fillRect(1, 1, width-2, height-2);
	
	//把随机数画进图片中
	g.setColor(Color.BLACK);//设置随机数的颜色
	Font font=new Font("宋体", Font.BOLD, 20);//斜体
	g.setFont(font);//设置随机数的字体和大小
	g.drawString(randomCode, 10, 28);
	//干扰线
	g.setColor(Color.GRAY);
	Random r=new Random();
	for(int i=0;i<100;i++){
		g.fillRect(r.nextInt(width), r.nextInt(height), 2, 2);//值越高点越大
		
	}
	//关闭
	g.dispose();
	return image;
	
}
}
