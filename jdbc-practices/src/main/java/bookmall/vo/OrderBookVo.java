package bookmall.vo;

public class OrderBookVo {
	private Long id;
	private String title;
	private int quantity;
	private int payment;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	
	@Override
	public String toString() {
		return "OrderBookVo [id=" + id + ", title=" + title + ", quantity=" + quantity + ", payment=" + payment + "]";
	}
	
	
}
