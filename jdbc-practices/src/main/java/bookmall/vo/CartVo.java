package bookmall.vo;

public class CartVo {

	private Long id;
	private int quantity;
	private int price;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "CartVo [id=" + id + ", quantity=" + quantity + ", price=" + price + "]";
	}
	
}
