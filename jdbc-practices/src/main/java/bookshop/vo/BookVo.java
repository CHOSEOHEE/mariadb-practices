package bookshop.vo;

public class BookVo {
	private Long id;
	private String title;
	private String status = "재고있음";
	private Long AuthorId;
	private String authorName;
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Long getAuthorId() {
		return AuthorId;
	}
	public void setAuthorId(Long authorId) {
		AuthorId = authorId;
	}
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	
	@Override
	public String toString() {
		return "BookVo [id=" + id + ", title=" + title + ", status=" + status + ", AuthorId=" + AuthorId
				+ ", authorName=" + authorName + "]";
	}
	
	
}
