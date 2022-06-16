package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Util.DbUtil;
import Util.StringUtil;
import dao.UserDao;
import model.User;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.awt.event.ActionEvent;

public class LoginFrame extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordField;
	//private JPanel contentPane;
	private JTextField userNameTxt;

	private JComboBox powerJCB;
	private DbUtil dbUtil=new DbUtil () ;
	private UserDao userDao=new UserDao() ;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrame frame = new LoginFrame();
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
	public LoginFrame() {
		setTitle("\u5B66\u751F\u4FE1\u606F\u7BA1\u7406\u7CFB\u7EDF");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1013, 541);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		/*JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(LoginFrame.class.getResource("/image/ketang.png")));
		lblNewLabel.setBounds(0, 0, 1013, 541);
		contentPane.add(lblNewLabel);*/
		
		JLabel lblNewLabel_1 = new JLabel("\u8D26\u53F7");
		lblNewLabel_1.setIcon(new ImageIcon(LoginFrame.class.getResource("/image/\u7528\u6237\u540D.png")));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("华文中宋", Font.PLAIN, 22));
		lblNewLabel_1.setBounds(382, 106, 78, 36);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("\u5BC6\u7801");
		lblNewLabel_1_1.setIcon(new ImageIcon(LoginFrame.class.getResource("/image/\u5BC6\u7801.png")));
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("华文中宋", Font.PLAIN, 22));
		lblNewLabel_1_1.setBounds(382, 186, 78, 36);
		contentPane.add(lblNewLabel_1_1);
		
		userNameTxt = new JTextField();
		userNameTxt.setBounds(462, 104, 184, 36);
		contentPane.add(userNameTxt);
		userNameTxt.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(462, 186, 184, 36);
		contentPane.add(passwordField);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("\u6743\u9650");
		lblNewLabel_1_1_1.setIcon(new ImageIcon(LoginFrame.class.getResource("/image/\u7528\u6237\u7C7B\u578B.png")));
		lblNewLabel_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1.setFont(new Font("华文中宋", Font.PLAIN, 22));
		lblNewLabel_1_1_1.setBounds(382, 272, 78, 36);
		contentPane.add(lblNewLabel_1_1_1);
		
		 powerJCB = new JComboBox();
		powerJCB.setModel(new DefaultComboBoxModel(new String[] {"\u7BA1\u7406\u5458", "\u5B66\u751F"}));
		powerJCB.setBounds(462, 272, 184, 33);
		contentPane.add(powerJCB);
		
		JButton btnNewButton = new JButton("\u6CE8\u518C");
		btnNewButton.setIcon(new ImageIcon(LoginFrame.class.getResource("/image/\u6CE8\u518C.png")));
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 22));
		btnNewButton.setBounds(382, 345, 107, 36);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u767B\u5F55");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loginActionPerformed(e);
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(LoginFrame.class.getResource("/image/\u767B\u5F55.png")));
		btnNewButton_1.setForeground(Color.BLACK);
		btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 22));
		btnNewButton_1.setBounds(539, 345, 107, 36);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(LoginFrame.class.getResource("/image/ketang.png")));
		lblNewLabel.setBounds(0, 0, 1013, 541);
		contentPane.add(lblNewLabel);
	}
/*
 * 登陆事件处理
 * */
	private  void loginActionPerformed(ActionEvent e) {
		String userName=this . userNameTxt. getText() ;
		String password=new String (this . passwordField. getPassword()) ;
		if (StringUtil. isEmpty(userName) ) {
				JOptionPane.showMessageDialog(null, "用户名不能为空! ");
		return;
		}if (StringUtil. isEmpty (password)) {
				JOptionPane.showMessageDialog(null, "密码不能为空! ");
		return;
		}
		String power=null;
		String juris= (String) this. powerJCB . getSelectedItem() ;
		User user=new User( userName, password, power);
		Connection con=null;
		if (juris.equals("管理员")) {
		user. setPower("管理员") ;
		try {
			con = dbUtil.getCon();
			User currentUser = userDao.login(con, user);
			if (currentUser!=null) {
				dispose();
				new AdminMainFrame().setVisible(true);
				//JOptionPane.showMessageDialog(null, "登录成功! ");
				
			}
			else {
				JOptionPane.showMessageDialog(null, "用户名或密码错误! ");
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			//JOptionPane.showMessageDialog(null, "登录失败! ");
		}
		 finally {
			try {
				dbUtil.closeCon(con);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		}else if (juris.equals("学生")) {
		user. setPower("学生") ;
		try {
			con = dbUtil.getCon();
			User currentUser = userDao.login(con, user);
			if (currentUser!=null) {
				dispose();
				new UserMainFrame().setVisible(true);
				//JOptionPane.showMessageDialog(null, "登录成功! ");
				
			}
			else {
				JOptionPane.showMessageDialog(null, "用户名或密码错误! ");
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			//JOptionPane.showMessageDialog(null, "登录失败! ");
		}
		 finally {
			try {
				dbUtil.closeCon(con);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		
		}
		
		
	
	}
}
