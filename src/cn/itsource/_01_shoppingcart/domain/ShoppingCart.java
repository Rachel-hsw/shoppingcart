package cn.itsource._01_shoppingcart.domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

//购物车对象
public class ShoppingCart {
//多个商品选项
	private List<CartItem> items=new ArrayList<CartItem>();
	
	//购物车总价
	
	public List<CartItem> getItems() {
		return items;
	}

	//购物车总价
	public Double getTotalPrice(){
		 Double totalPrice=0D;
			for (CartItem item : items) {
				totalPrice+=item.getPrice()*item.getNum();
			
				} 
		 return totalPrice;
	}
	//存储商品选项进入购物车
	public void save(CartItem newItem){
		items.add(newItem);
		for (CartItem item : items) {
		if(item.getId().equals(newItem.getId())){
			item.setNum(item.getNum()+newItem.getNum());
			/*break;//结束循环*/			
			return;//结束方法
		}	
		}
		items.add(newItem);
	} 
	//从购物车中移除指定的商品选项
	public void delete(String id){
		/*for (CartItem item : items) {
			if(item.getId().equals(id)){
				//items.remove(item);//报错，线程并发修改异常，增强for循环，高级进阶
				//迭代的时候不能在里面添加或移除子项，因为是单线程的
				
			}	
			}*/
		
		for (Iterator<CartItem> it = items.iterator(); it.hasNext();) {
			CartItem item=it.next();
			if(item.getId().equals(id)){
				it.remove();//删除当前被迭代的对象
				
			}	
		}
	}
	
}
