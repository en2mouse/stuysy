package view;

import java.awt.EventQueue;


import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.ResultSet;

import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import Util.DbUtil;
import Util.StringUtil;
import dao.DepartmentDao;
import dao.StudentDao;
import model.Department;
import model.Student;

import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StudentAddInterFrame extends JInternalFrame {
	private JTextField stu_nameTxt;
	private JTextField stu_idTxt;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField stu_birthTxt;
	private JTextField faceTxt;
	private JTextField dormitoryTxt;
	private JTextField phoneTxt;

	private DbUtil dbUtil=new DbUtil();
	private DepartmentDao departmentDao=new DepartmentDao();
	private StudentDao studentDao=new StudentDao();
	private JComboBox departJCB;
	private JRadioButton man;
	private JRadioButton woman;
	private JTextArea addressTxt;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentAddInterFrame frame = new StudentAddInterFrame();
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
	public StudentAddInterFrame() {
		setIconifiable(true);
		setClosable(true);
		setTitle("\u4FE1\u606F\u5F55\u5165");
		setBounds(100, 100, 681, 481);
		
		JLabel lblNewLabel = new JLabel("\u59D3\u540D");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		
		stu_nameTxt = new JTextField();
		stu_nameTxt.setFont(new Font("宋体", Font.PLAIN, 20));
		stu_nameTxt.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\u5B66\u53F7");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 20));
		
		stu_idTxt = new JTextField();
		stu_idTxt.setFont(new Font("宋体", Font.PLAIN, 20));
		stu_idTxt.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("\u6027\u522B");
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 20));
		
		 man = new JRadioButton("\u7537");
		buttonGroup.add(man);
		man.setFont(new Font("宋体", Font.PLAIN, 20));
		
		 woman = new JRadioButton("\u5973");
		buttonGroup.add(woman);
		woman.setFont(new Font("宋体", Font.PLAIN, 20));
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 20));
		
		JLabel lblNewLabel_2_1 = new JLabel("\u51FA\u751F\u65E5\u671F");
		lblNewLabel_2_1.setFont(new Font("宋体", Font.PLAIN, 20));
		
		stu_birthTxt = new JTextField();
		stu_birthTxt.setFont(new Font("宋体", Font.PLAIN, 20));
		stu_birthTxt.setColumns(10);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("\u653F\u6CBB\u9762\u8C8C");
		lblNewLabel_2_1_1.setFont(new Font("宋体", Font.PLAIN, 20));
		
		faceTxt = new JTextField();
		faceTxt.setFont(new Font("宋体", Font.PLAIN, 20));
		faceTxt.setColumns(10);
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("\u5BBF\u820D\u53F7");
		lblNewLabel_2_1_1_1.setFont(new Font("宋体", Font.PLAIN, 20));
		
		dormitoryTxt = new JTextField();
		dormitoryTxt.setFont(new Font("宋体", Font.PLAIN, 20));
		dormitoryTxt.setColumns(10);
		
		JLabel lblNewLabel_2_1_1_2 = new JLabel("\u5B66\u9662");
		lblNewLabel_2_1_1_2.setFont(new Font("宋体", Font.PLAIN, 20));
		
		 departJCB = new JComboBox();
		departJCB.setFont(new Font("宋体", Font.PLAIN, 20));
		
		JLabel lblNewLabel_2_1_1_1_1 = new JLabel("\u7535\u8BDD");
		lblNewLabel_2_1_1_1_1.setFont(new Font("宋体", Font.PLAIN, 20));
		
		phoneTxt = new JTextField();
		phoneTxt.setFont(new Font("宋体", Font.PLAIN, 20));
		phoneTxt.setColumns(10);
		
		JLabel lblNewLabel_2_1_1_2_1 = new JLabel("\u5BB6\u5EAD\u5730\u5740");
		lblNewLabel_2_1_1_2_1.setFont(new Font("宋体", Font.PLAIN, 20));
		
		 addressTxt = new JTextArea();
		addressTxt.setFont(new Font("Monospaced", Font.PLAIN, 20));
		
		JButton btnNewButton = new JButton("\u6DFB\u52A0");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				studentAddAactionPerformed(e);
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 20));
		
		JButton btnNewButton_1 = new JButton("\u91CD\u7F6E");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetValues();
			}
		});
		btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 20));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(40)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(man)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(woman, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addGroup(groupLayout.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(stu_nameTxt, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)))
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(26)
									.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(stu_idTxt, GroupLayout.PREFERRED_SIZE, 326, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(18)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
											.addGap(10)
											.addComponent(lblNewLabel_2_1)
											.addGap(18)
											.addComponent(stu_birthTxt, GroupLayout.DEFAULT_SIZE, 287, Short.MAX_VALUE))
										.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)))))
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(lblNewLabel_2_1_1_2, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
											.addGap(18)
											.addComponent(departJCB, 0, 170, Short.MAX_VALUE))
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(lblNewLabel_2_1_1, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(faceTxt, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE))
										.addComponent(lblNewLabel_2_1_1_2_1, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE))
									.addGap(32)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(lblNewLabel_2_1_1_1, GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(dormitoryTxt, GroupLayout.PREFERRED_SIZE, 212, GroupLayout.PREFERRED_SIZE))
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(lblNewLabel_2_1_1_1_1, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(phoneTxt, GroupLayout.DEFAULT_SIZE, 247, Short.MAX_VALUE))))
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
											.addGap(45)
											.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE))
										.addComponent(addressTxt, GroupLayout.PREFERRED_SIZE, 576, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(ComponentPlacement.RELATED)))))
					.addGap(53))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(22)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(stu_nameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1)
						.addComponent(stu_idTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblNewLabel_2)
							.addComponent(man)
							.addComponent(woman)
							.addComponent(lblNewLabel_3)
							.addComponent(lblNewLabel_2_1, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
						.addComponent(stu_birthTxt, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_2_1_1, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addComponent(faceTxt, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(dormitoryTxt, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblNewLabel_2_1_1_1, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_2_1_1_2, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
								.addComponent(departJCB, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(phoneTxt, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_2_1_1_1_1, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))))
					.addGap(18)
					.addComponent(lblNewLabel_2_1_1_2_1, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(addressTxt, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
					.addGap(38)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(25, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);
		this.fillJCB();
	}

	/*
	 * 信息添加事件
	 */
	private void studentAddAactionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String stuName=this.stu_nameTxt.getText();
		String stuId=this.stu_idTxt.getText();
		String birth=this.stu_birthTxt.getText();
		String face=this.faceTxt.getText();
		String adress=this.addressTxt.getText();
		String phone=this.phoneTxt.getText();
		String dormitory=this.dormitoryTxt.getText();
		if (StringUtil.isEmpty(stuName)) {
			JOptionPane.showMessageDialog (null, "姓名不能为空! ");
			return; 
			} if (StringUtil.isEmpty(stuId)) {
			JOptionPane.showMessageDialog(null,"学号不能为空! ");
			return;
			}
		if (StringUtil.isEmpty(birth)) {
			JOptionPane.showMessageDialog (null, "生日不能为空! ");
			return; 
			} if (StringUtil.isEmpty(face)) {
			JOptionPane.showMessageDialog(null,"政治面貌不能为空! ");
			return;
			}
		if (StringUtil.isEmpty(adress)) {
			JOptionPane.showMessageDialog (null, "家庭地址不能为空! ");
			return; 
			} if (StringUtil.isEmpty(phone)) {
			JOptionPane.showMessageDialog(null,"电话不能为空! ");
			return;
			}
			if (StringUtil.isEmpty(dormitory)) {
				JOptionPane.showMessageDialog(null,"宿舍号不能为空! ");
				return;
				}
			String sex="";
			if (this.man.isSelected()) {
				sex="男";
			}else {
				sex="女";
			}
			Department department=(Department) this.departJCB.getSelectedItem();
			int departmentId=department.getId();
			
			Student student=new Student( stuName,  stuId,  sex,  birth, face, adress, phone, dormitory,departmentId);
			Connection con=null;
			try {
				con=dbUtil.getCon();
				int addnum= studentDao.add(con,student);
				if (addnum==1) {
				JOptionPane.showMessageDialog(null, "添加成功!") ;
				resetValues();
				}else {
					JOptionPane.showMessageDialog(null, "添加失败!") ;
				}
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				JOptionPane.showMessageDialog(null, "添加失败!") ;
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
	 * 重置表单
	 * 
	 */
	private void resetValues() {
		// TODO Auto-generated method stub
		this.stu_nameTxt.setText("");
		this.stu_idTxt.setText("");
		this.stu_birthTxt.setText("");
		this.phoneTxt.setText("");
		this.dormitoryTxt.setText("");
		this.man.setSelected(true);
		this.faceTxt.setText("");
		this.addressTxt.setText("");
		if (this.departJCB.getItemCount()>0) {
			this.departJCB.setSelectedIndex(0);
			
		}
	}

	/*
	 * 初始化下拉数据
	 */
	private void fillJCB() {
		Connection con=null;
		Department department=null;
		try {
			con=dbUtil.getCon();
			ResultSet rs=departmentDao.list(con,new Department());
			while (rs.next()) {
				department=new Department();
				department.setId(rs.getInt("id"));
				department.setDepart_name(rs.getString("depart_name"));
				this.departJCB.addItem(department);
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
	
}
