package bookmall.vo;

public class UserVo {
	private Long no;
	private String phone;
	private String password;
	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "UserVo [no=" + no + ", phone=" + phone + ", password=" + password + "]";
	}
	
	
}
