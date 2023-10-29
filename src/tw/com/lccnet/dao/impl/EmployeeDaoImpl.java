package tw.com.lccnet.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;

import tw.com.lccnet.bean.Employee;
import tw.com.lccnet.dao.EmployeeDao;
import tw.com.lccnet.db.DBUtils;

public class EmployeeDaoImpl extends EmployeeDao {
	
	@Override
	public void create(Employee emp) {
		Connection  conn=null;
		PreparedStatement ps=null;
		try {
			//連接JDBC
			conn=DBUtils.getDB().getConn();
			//新增的sql語法
			String addSQL="insert into employee(e_name,e_email,e_address,e_rd,e_manager)values(?,?,?,?,?);";
			//將SQL語法透過JDBS傳入資料庫進行新增動作
			ps=conn.prepareStatement(addSQL);
			ps.setString(1, emp.getE_name());
			ps.setString(2, emp.getE_email());
			ps.setString(3, emp.getE_address());
			ps.setString(4, emp.getE_rd());
			ps.setString(5, emp.getE_manager());
			
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			//先開後關
			DBUtils.getDB().close(ps);
			DBUtils.getDB().close(conn);
		}
	}

	@Override
	public void delete(int e_id) {
		Connection  conn=null;
		PreparedStatement ps=null;
		conn=DBUtils.getDB().getConn();
		try {
			
			String addSQL="delete from employee where e_id=?;";
			ps=conn.prepareStatement(addSQL);
			ps.setInt(1,e_id);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Employee update(int e_id) {
		Connection  conn=null;
		PreparedStatement ps=null;
		conn=DBUtils.getDB().getConn();
		//新增的sql語法
		try {
			Employee emp=new Employee();
			String addSQL="update employee set e_name=?,e_email=?,e_address=?,e_manager=? where e_id=?;";
			ps=conn.prepareStatement(addSQL);
			
			ps.setString(1, emp.getE_name());
			ps.setString(2, emp.getE_email());
			ps.setString(3,emp.getE_address());
			ps.setString(4, emp.getE_manager());
			ps.setInt(5, e_id);
			ps.executeUpdate();
			return emp;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ResultSet serach() {
		Connection  conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			conn=DBUtils.getDB().getConn();
			String addSQL="select e_id as 編號,e_name as 姓名,e_email as 信箱,e_address as 地址,e_rd as 性別,e_manager as 部門 from employee;";
			ps=conn.prepareStatement(addSQL);
			rs=ps.executeQuery();
			return rs;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public ResultSet findByName(String e_name) {
		Connection  conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			conn=DBUtils.getDB().getConn();
			String addSQL="select e_id as 編號,e_name as 姓名,e_email as 信箱,e_address as 地址,e_rd as 性別,e_manager as 部門 from employee where e_name=?;";
			ps=conn.prepareStatement(addSQL);
			ps.setString(1, e_name);
			
			rs=ps.executeQuery();
			return rs;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return  null;
	}
	
	

}
