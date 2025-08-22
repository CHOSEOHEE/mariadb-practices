package bookmall.vo;

public class OrderBookVo {
	private Long no;
	private String title;
	private int quantity;
	private int payment;
	private Long order_no;
	private Long order_user_no;
	
	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getPayment() {
		return payment;
	}
	public void setPayment(int payment) {
		this.payment = payment;
	}
	public Long getOrder_no() {
		return order_no;
	}
	public void setOrder_no(Long order_no) {
		this.order_no = order_no;
	}
	public Long getOrder_user_no() {
		return order_user_no;
	}
	public void setOrder_user_no(Long order_user_no) {
		this.order_user_no = order_user_no;
	}
	
	@Override
	public String toString() {
		return "OrderBookVo [no=" + no + ", title=" + title + ", quantity=" + quantity + ", payment=" + payment
				+ ", order_no=" + order_no + ", order_user_no=" + order_user_no + "]";
	}
	
	
	
	
}
