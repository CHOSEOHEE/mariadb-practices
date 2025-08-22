package bookmall.vo;

public class CategoryVo {

	  private String name;
	  private Long no;
	  
	  public String getName() {
		  return name;
	  }
	  public void setName(String name) {
		  this.name = name;
	  }
	  public Long getNo() {
		  return no;
	  }
	  public void setNo(Long no) {
		  this.no = no;
	  }
	  
	  @Override
	  public String toString() {
		return "CategoryVo [name=" + name + ", no=" + no + "]";
	  }
	  
	  
}
