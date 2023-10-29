package tw.com.lccnet.dao;

import java.sql.ResultSet;
import java.util.List;

import tw.com.lccnet.base.EmployeeBase;
import tw.com.lccnet.bean.Employee;

public abstract class EmployeeDao  implements EmployeeBase {
	//單獨搜尋姓名
	public ResultSet findByName(String e_name) {
	
		return null;
	}
	//單獨搜尋郵件
	public Employee findByemail(String e_email){
		return null;
	}
	
	//單獨搜尋地址
	public List<Employee> findByaddress(String e_address){
		return null;
	}
	//單獨搜尋性別
	public List<Employee> findBYrd(String e_rd){
		return null;
	}
	
	//單獨搜尋部門
	public List<Employee> findByManager(String e_manager){
		return null;
	}
}
