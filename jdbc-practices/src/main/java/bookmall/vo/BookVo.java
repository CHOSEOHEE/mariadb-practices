package bookmall.vo;

public class BookVo {
	private Long no;
	private String title;
	private int price;
	private Long order_book_no;
	private Long category_no;
	public Long getNo() {
		return no;
	}
	public void setNo(Long No) {
		this.no = no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public Long getOrder_book_no() {
		return order_book_no;
	}
	public void setOrder_book_no(Long order_book_no) {
		this.order_book_no = order_book_no;
	}
	public Long getCategory_no() {
		return category_no;
	}
	public void setCategory_no(Long category_no) {
		this.category_no = category_no;
	}
	
	@Override
	public String toString() {
		return "BookVo [no=" + no + ", title=" + title + ", price=" + price + ", order_book_no=" + order_book_no
				+ ", category_no=" + category_no + "]";
	}
	
	 
	
}
