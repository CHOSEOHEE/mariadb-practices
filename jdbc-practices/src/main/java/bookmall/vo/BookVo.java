package bookmall.vo;

public class BookVo {
	private Long id;
	private String title;
	private int price;
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
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "BookVo [id=" + id + ", title=" + title + ", price=" + price + "]";
	}
	public void setPrice() {
	}
	
	
}
