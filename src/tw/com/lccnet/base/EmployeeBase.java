package tw.com.lccnet.base;

import java.sql.ResultSet;
import java.util.List;

import tw.com.lccnet.bean.Employee;
/*
 * CRUD
 */
public interface EmployeeBase {
	//新增
	public void create(Employee emp);
	
	//刪除
	public void delete(int e_id);
	
	//更新
	public Employee update(int e_id);
	
	//搜尋
	public ResultSet serach();
}
