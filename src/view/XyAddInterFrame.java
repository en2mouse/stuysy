package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

import Util.DbUtil;
import Util.StringUtil;
import dao.DepartmentDao;
import model.Department;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.awt.event.ActionEvent;

public class XyAddInterFrame extends JInternalFrame {
	private JTextField depart_nameTxt;
	private JTextArea depart_descTxt;
	private DbUtil dbUtil=new DbUtil() ;
	private DepartmentDao departmentDao=new DepartmentDao() ;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					XyAddInterFrame frame = new XyAddInterFrame();
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
	public XyAddInterFrame() {
		setClosable(true);
		setIconifiable(true);
		setTitle("\u5B66\u9662\u6DFB\u52A0");
		setBounds(100, 100, 625, 447);
		
		JLabel lblNewLabel = new JLabel("\u5B66\u9662\u540D\u79F0");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		
		depart_nameTxt = new JTextField();
		depart_nameTxt.setFont(new Font("宋体", Font.PLAIN, 20));
		depart_nameTxt.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\u5B66\u9662\u63CF\u8FF0");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 20));
		
		 depart_descTxt = new JTextArea();
		depart_descTxt.setFont(new Font("Monospaced", Font.PLAIN, 20));
		
		JButton btnNewButton = new JButton("\u6DFB\u52A0");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				departmentAddActionPerformed();
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 20));
		
		JButton btnNewButton_1 = new JButton("\u91CD\u7F6E");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetActionPerformed(e);
			}
		});
		btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 20));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addGap(58)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(lblNewLabel_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblNewLabel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 98, Short.MAX_VALUE)
							.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE))
						.addComponent(depart_descTxt, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE)
						.addComponent(depart_nameTxt, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE))
					.addGap(137))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(106)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(depart_nameTxt, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
						.addComponent(depart_descTxt, GroupLayout.PREFERRED_SIZE, 173, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
					.addGap(21))
		);
		getContentPane().setLayout(groupLayout);

	}
private void departmentAddActionPerformed() {
		// TODO Auto-generated method stub
	String depart_name=this. depart_nameTxt .getText() ;
	String depart_desc=this. depart_descTxt .getText() ;
	if (StringUtil.isEmpty(depart_name)) {
	JOptionPane.showMessageDialog (null, "名称不能为空! ");
	return; 
	} if (StringUtil.isEmpty(depart_desc)) {
	JOptionPane.showMessageDialog(null,"描述不能为空! ");
	return;
	}
	Department department=new Department (depart_name, depart_desc);
	Connection con=null;
	try {
	con=dbUtil.getCon();
	int addnum=departmentDao.add(con,department) ;
	if (addnum==1) {
	JOptionPane.showMessageDialog(null, "添加成功!") ;
	resetNull();
	}else {
		JOptionPane.showMessageDialog(null, "添加失败!") ;
	}
	} catch (Exception e) {
	// TODO 自动生成的catch块
	e. printStackTrace();
	}finally {
		try {
			dbUtil.closeCon(con);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
/**
 *
 * 重置功能实现
 */
	private void resetActionPerformed(ActionEvent e) {
		resetNull();
		// TODO Auto-generated method stub
		
	}
	public void resetNull() {
		this.depart_nameTxt.setText("");
		this.depart_descTxt.setText("");
	}
}
