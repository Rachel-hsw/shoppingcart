package cn.itsource._02_randomcode;

import java.util.UUID;

public class UUIDDemo {
public static void main(String[] args) {
	//随机生成五位字符
	String uuid=UUID.randomUUID().toString().substring(0,5);//区间前闭后开
	System.out.println(uuid);
}
}
