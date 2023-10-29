package tw.com.lccnet.window;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;
import tw.com.lccnet.bean.Employee;
import tw.com.lccnet.dao.EmployeeDao;
import tw.com.lccnet.dao.impl.EmployeeDaoImpl;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class WindowMain extends JFrame {

	private JPanel contentPane;
	private JTextField e_id;
	private JTextField e_name;
	private JTextField e_email;
	private JTextField e_address;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private static JTable table;
	private JTextField e_search;
	private String name;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WindowMain frame = new WindowMain();
					frame.setVisible(true);
					get_load();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public WindowMain() {
		setResizable(false);
		setTitle("人員管理系統");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 821, 401);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("編號:");
		lblNewLabel.setBounds(31, 42, 35, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("姓名:");
		lblNewLabel_1.setBounds(31, 79, 35, 15);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("郵件:");
		lblNewLabel_2.setBounds(31, 119, 35, 15);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("地址:");
		lblNewLabel_3.setBounds(31, 159, 35, 15);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("性別:");
		lblNewLabel_4.setBounds(31, 202, 46, 15);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("部門:");
		lblNewLabel_5.setBounds(31, 244, 35, 15);
		contentPane.add(lblNewLabel_5);
		
		e_id = new JTextField();
		e_id.setBounds(66, 39, 213, 21);
		contentPane.add(e_id);
		e_id.setColumns(10);
		
		e_name = new JTextField();
		e_name.setBounds(66, 76, 213, 21);
		contentPane.add(e_name);
		e_name.setColumns(10);
		
		e_email = new JTextField();
		e_email.setBounds(66, 116, 213, 21);
		contentPane.add(e_email);
		e_email.setColumns(10);
		
		e_address = new JTextField();
		e_address.setBounds(66, 156, 213, 21);
		contentPane.add(e_address);
		e_address.setColumns(10);
		
		JRadioButton e_rdM = new JRadioButton("男");
		e_rdM.setSelected(true);
		buttonGroup.add(e_rdM);
		e_rdM.setBounds(66, 198, 51, 23);
		contentPane.add(e_rdM);
		
		JRadioButton e_rdF = new JRadioButton("女");
		buttonGroup.add(e_rdF);
		e_rdF.setBounds(116, 198, 46, 23);
		contentPane.add(e_rdF);
		
		JComboBox e_manager = new JComboBox();
		e_manager.setModel(new DefaultComboBoxModel(new String[] {"請選擇部門", "管理部", "財務部", "研發部", "業務部", "製作部"}));
		e_manager.setBounds(66, 240, 213, 23);
		contentPane.add(e_manager);
		
		JButton e_btn = new JButton("新增");
		e_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				EmployeeDao dao=new EmployeeDaoImpl();
				
				Employee emp=new Employee();
				emp.setE_name(e_name.getText());
				emp.setE_email(e_email.getText());
				
				String sex_button=null; 
				if(e_rdM.isSelected()==true) {
					sex_button="男性";
				}else {
					sex_button="女性";
				}
				
				emp.setE_rd(sex_button);
				emp.setE_address(e_address.getText());
				emp.setE_manager(e_manager.getSelectedItem().toString());
				
				dao.create(emp);
				get_load();
				
				
			}
		});
		e_btn.setBounds(88, 292, 87, 23);
		contentPane.add(e_btn);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(301, 76, 471, 251);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel_6 = new JLabel("搜尋:");
		lblNewLabel_6.setBounds(306, 42, 46, 15);
		contentPane.add(lblNewLabel_6);
		
		e_search = new JTextField();
		e_search.setBounds(346, 39, 132, 21);
		contentPane.add(e_search);
		e_search.setColumns(10);
		
		JButton e_search_btn = new JButton("搜尋");
		e_search_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				name=e_search.getText();
				
				if(name.length()==0) {
					get_load();
				}else {
				
					EmployeeDao dao=new EmployeeDaoImpl();
					ResultSet rs=dao.findByName(e_search.getText());
					table.setModel(DbUtils.resultSetToTableModel(rs));
				}
				e_search.setText("");
			}	
		});
		e_search_btn.setBounds(486, 38, 87, 23);
		contentPane.add(e_search_btn);
		
		JButton e_update_btn = new JButton("更新");
		e_update_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				name=e_search.getText();
				EmployeeDao dao=new EmployeeDaoImpl();
				//dao.update(Integer.parseInt(name));
				
				Employee emp=new Employee();
				
				e_name.setText("sss");
			}
		});
		e_update_btn.setBounds(583, 38, 87, 23);
		contentPane.add(e_update_btn);
		
		JButton e_delete_btn = new JButton("刪除");
		e_delete_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id=Integer.parseInt(e_search.getText());
				EmployeeDao dao=new EmployeeDaoImpl();
				dao.delete(id);
				get_load();
				
			}
		});
		e_delete_btn.setBounds(680, 38, 87, 23);
		contentPane.add(e_delete_btn);
	}
	
	public static void get_load() {
		EmployeeDao dao=new EmployeeDaoImpl();
		ResultSet rs=dao.serach();
		
		table.setModel(DbUtils.resultSetToTableModel(rs));
	}
	
}
