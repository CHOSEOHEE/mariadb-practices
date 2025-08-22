package bookmall.vo;

public class OrderVo {
	private Long no;
	private String shipping;
	private int payment;
	private String status;
	
	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public String getShipping() {
		return shipping;
	}
	public void setShipping(String shipping) {
		this.shipping = shipping;
	}
	public int getPayment() {
		return payment;
	}
	public void setPayment(int payment) {
		this.payment = payment;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		return "OrderVo [no=" + no + ", shipping=" + shipping + ", payment=" + payment + ", status=" + status + "]";
	}
	
	
	
}