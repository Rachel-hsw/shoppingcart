package cn.itsource._01_shoppingcart.domain;
//购物车中的商品选项
public class CartItem {
private String id;//唯一编号
private String name;//商品的名称
private Double price;//商品的单价
private Integer num=1;//购买数量
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public Double getPrice() {
	return price;
}
public void setPrice(Double price) {
	this.price = price;
}
public Integer getNum() {
	return num;
}
public void setNum(Integer num) {
	this.num = num;
}

}
