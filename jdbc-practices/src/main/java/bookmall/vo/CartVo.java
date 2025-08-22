package bookmall.vo;

public class CartVo {

	private Long no;
	private int quantity;
	private int price;
	private Long user_no;
	private Long book_no;
	
	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
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
	public Long getUser_no() {
		return user_no;
	}
	public void setUser_no(Long user_no) {
		this.user_no = user_no;
	}
	public Long getBook_no() {
		return book_no;
	}
	public void setBook_no(Long book_no) {
		this.book_no = book_no;
	}
	
	@Override
	public String toString() {
		return "CartVo [no=" + no + ", quantity=" + quantity + ", price=" + price + ", user_no=" + user_no
				+ ", book_no=" + book_no + "]";
	}
	
	
	
}
