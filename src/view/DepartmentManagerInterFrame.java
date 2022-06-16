package view;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Util.DbUtil;
import Util.StringUtil;
import dao.DepartmentDao;
import model.Department;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DepartmentManagerInterFrame extends JInternalFrame {
	private JTable depart_table;
	private DbUtil dbUtil=new DbUtil() ;
	private DepartmentDao departmentDao=new DepartmentDao() ;
	private JTextField s_depart_nameTxt;
	private JTextField idTxt;
	private JTextField depart_nameTxt;
	private JTextArea depart_descTxt;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DepartmentManagerInterFrame frame = new DepartmentManagerInterFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public DepartmentManagerInterFrame() {
		setClosable(true);
		setIconifiable(true);
		setTitle("\u5B66\u9662\u7EF4\u62A4");
		setBounds(100, 100, 600, 496);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "\u641C\u7D22\u6761\u4EF6", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "\u64CD\u4F5C", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(56)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 462, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 461, GroupLayout.PREFERRED_SIZE)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 461, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(70, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
					.addGap(2)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 187, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(25, Short.MAX_VALUE))
		);
		
		JLabel lblNewLabel_1 = new JLabel("\u7F16\u53F7");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 20));
		
		idTxt = new JTextField();
		idTxt.setEditable(false);
		idTxt.setFont(new Font("宋体", Font.PLAIN, 20));
		idTxt.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("\u5B66\u9662\u540D\u79F0");
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 20));
		
		depart_nameTxt = new JTextField();
		depart_nameTxt.setFont(new Font("宋体", Font.PLAIN, 20));
		depart_nameTxt.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("\u5B66\u9662\u63CF\u8FF0");
		lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 20));
		
		 depart_descTxt = new JTextArea();
		depart_descTxt.setFont(new Font("Monospaced", Font.PLAIN, 20));
		
		JButton btnNewButton_1 = new JButton("\u4FEE\u6539");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				departmentUpdateActionPerformed(e);
			}
		});
		btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 20));
		
		JButton btnNewButton_2 = new JButton("\u5220\u9664");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				departmentDeleteActionPerformed(e);
			}
		});
		btnNewButton_2.setFont(new Font("宋体", Font.PLAIN, 20));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(idTxt, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(lblNewLabel_2)
							.addGap(18)
							.addComponent(depart_nameTxt, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(lblNewLabel_3)
							.addGap(18)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_panel_1.createSequentialGroup()
									.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(btnNewButton_2, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE))
								.addComponent(depart_descTxt, GroupLayout.PREFERRED_SIZE, 326, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(idTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_2)
						.addComponent(depart_nameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3)
						.addComponent(depart_descTxt, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNewButton_1)
						.addComponent(btnNewButton_2))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
		
		JLabel lblNewLabel = new JLabel("\u540D\u79F0");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		
		s_depart_nameTxt = new JTextField();
		s_depart_nameTxt.setFont(new Font("宋体", Font.PLAIN, 20));
		s_depart_nameTxt.setColumns(10);
		
		JButton btnNewButton = new JButton("\u67E5\u8BE2");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				departmentSeearchActionPerformed(e);
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 20));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
					.addGap(27)
					.addComponent(s_depart_nameTxt, GroupLayout.PREFERRED_SIZE, 240, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(s_depart_nameTxt, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel)
						.addComponent(btnNewButton))
					.addContainerGap(1, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		depart_table = new JTable();
		depart_table.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				departTableMousePressed(e);
			}
		});
		depart_table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u7F16\u53F7", "\u5B66\u9662\u540D\u79F0", "\u5B66\u9662\u63CF\u8FF0"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(depart_table);
		getContentPane().setLayout(groupLayout);
		this.fillTable(new Department());

	}
	/*
	 * 删除事件处理
	 */
	private void departmentDeleteActionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String id = this.idTxt.getText() ;
		if (StringUtil. isEmpty(id)) {
		JOptionPane.showMessageDialog (null, "请选择要删除的记录! ");
		return;
		}
		int n = JOptionPane. showConfirmDialog (null, "确定要删除该条记录吗? ");
		if (n==0) {
		Connection con=null; 
		try {
		con=dbUtil .getCon() ;
		int num=departmentDao. delete (con, id) ;
		if (num==1) {
		JOptionPane. showMessageDialog(null, "删除成功! ") ;
		this. resetNull () ;
		this. fillTable(new Department()) ;
		}else{
		JOptionPane. showMessageDialog(null, "删除失败! ");
		}
		} catch (Exception e1) {
			
			e1.printStackTrace () ;
			JOptionPane. showMessageDialog (null,"删除失败! ");
			} finally {
				try {
					dbUtil.closeCon(con);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			}
	}

	/*
	 * 修改事件处理
	 */
	private void departmentUpdateActionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String id = this. idTxt.getText() ;
		String depart_name=this. depart_nameTxt . getText() ;
		String depart_desc=this. depart_descTxt.getText() ;
		if (StringUtil. isEmpty(id)) {
		JOptionPane.showMessageDialog(null,"请选择要修改的记录! ");
		return;
		}
		if (StringUtil. isEmpty(depart_name)) {
		JOptionPane . showMessageDialog(null,"名称不能为空! ");
		return;
		}
		if (StringUtil. isEmpty(depart_desc)) {
		JOptionPane. showMessageDialog(null, "描述不能为空! ");
		return;
		}
		Department department = new Department(Integer.parseInt(id), depart_name, depart_desc);
		Connection con=null;
		try {
		con=dbUtil.getCon() ;
		int num=departmentDao.update (con, department) ;
		if (num==1) {
		JOptionPane. showMessageDialog(null,"修改成功! ");
		this.resetNull();
		this.fillTable(new Department());
		}else {
			JOptionPane.showMessageDialog(null,"修改失败! ");
		}
		} catch (Exception e1) {
		// TODO 自动生成的catch块
		e1. printStackTrace() ;
		}finally {
			try {
				dbUtil.closeCon(con);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	/*
	 * 表格点击事件
	 */
	private void departTableMousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		int row = this.depart_table.getSelectedRow();
		this.idTxt.setText((String) this.depart_table.getValueAt(row, 0));
		this.depart_nameTxt.setText((String) this.depart_table.getValueAt(row, 1));
		this.depart_descTxt.setText((String) this.depart_table.getValueAt(row, 2));
	}

	/*
	 * 查询事件处理
	 */
	private void departmentSeearchActionPerformed(ActionEvent e) {
		String s_depart_name=this.s_depart_nameTxt.getText() ;
		Department department = new Department();
		department.setDepart_name(s_depart_name);
		this. fillTable(department);
	}
/*
 * 初始化表格
 */
	private void fillTable(Department department) {
		DefaultTableModel dtm = (DefaultTableModel) this.depart_table.getModel();
		dtm.setRowCount(0);
		Connection con = null;
		try {
			con = dbUtil.getCon();
			ResultSet rs = departmentDao.list(con, department);
			while(rs.next()) {
				Vector v = new Vector<>() ;
				v.add(rs.getString("id")) ;
				v.add(rs.getString ("depart_name")) ;
				v.add(rs.getString ("depart_desc")) ;
				dtm. addRow(v) ;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				dbUtil.closeCon(con);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	/*
	 * 置空表单
	 */
	private void resetNull() {
	this.idTxt.setText ("") ;
	this.depart_nameTxt.setText ("") ;
	this.depart_descTxt.setText ("") ;
	}
}
