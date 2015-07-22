package cn.microvideo.domain;
/** 
  * @author  作者：Kw
  * @date 创建时间：2015年7月22日 下午9:43:46 
  * @version 1.0 
  * @parameter  
  * @since  
  * @return  
  */
public class Order {
	private int id;
	private String orderNo;
	private float price;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public Order(int id, String orderNo, float price) {
		super();
		this.id = id;
		this.orderNo = orderNo;
		this.price = price;
	}
	public Order() {
		
	}
	@Override
	public String toString() {
		return "Order [id=" + id + ", orderNo=" + orderNo + ", price=" + price + "]";
	}
	
}

