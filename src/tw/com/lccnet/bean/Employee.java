package tw.com.lccnet.bean;
// 物件
public class Employee {
	//屬性(全域變數)
	private Integer e_id;
	private String e_name;
	private String e_email;
	private String e_address;
	private String e_rd; //性別
	private String e_manager; //部門
	
	public Integer getE_id() {
		return e_id;
	}
	public void setE_id(Integer e_id) {
		this.e_id = e_id;
	}
	public String getE_name() {
		return e_name;
	}
	public void setE_name(String e_name) {
		System.out.println(e_name);
		this.e_name = e_name;
	}
	public String getE_email() {
		return e_email;
	}
	public void setE_email(String e_email) {
		this.e_email = e_email;
	}
	public String getE_address() {
		return e_address;
	}
	public void setE_address(String e_address) {
		this.e_address = e_address;
	}
	public String getE_rd() {
		return e_rd;
	}
	public void setE_rd(String e_rd) {
		this.e_rd = e_rd;
	}
	public String getE_manager() {
		return e_manager;
	}
	public void setE_manager(String e_manager) {
		this.e_manager = e_manager;
	}
	
	@Override
	public String toString() {
		return "Employee [e_id=" + e_id + ", e_name=" + e_name + ", e_email=" + e_email + ", e_address=" + e_address
				+ ", e_rd=" + e_rd + ", e_manager=" + e_manager + "]";
	}
	
	
}
