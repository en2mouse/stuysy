package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
//import javax.swing.text.html.AccessibleHTML.TableElementInfo.TableAccessibleContext;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminMainFrame extends JFrame {

	private JPanel contentPane;
	private JDesktopPane table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminMainFrame frame = new AdminMainFrame();
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
	public AdminMainFrame() {
		setTitle("\u4FE1\u606F\u7BA1\u7406\u7CFB\u7EDF");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 700);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("\u5B66\u9662\u7BA1\u7406");
		mnNewMenu.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 25));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("\u5B66\u9662\u6DFB\u52A0");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				XyAddInterFrame xyAddInterFrame=new XyAddInterFrame() ;
				xyAddInterFrame.setVisible(true) ;
				table.add(xyAddInterFrame);
			}
		});
		mntmNewMenuItem.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("\u5B66\u9662\u4FEE\u6539");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DepartmentManagerInterFrame departmentManagerInterFrame=new DepartmentManagerInterFrame() ;
				departmentManagerInterFrame.setVisible(true) ;
				table.add(departmentManagerInterFrame);
			}
		});
			
		mntmNewMenuItem_1.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenu mnNewMenu_2 = new JMenu("\u5B66\u751F\u7BA1\u7406");
		mnNewMenu_2.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 25));
		menuBar.add(mnNewMenu_2);
		
		JMenuItem mntmNewMenuItem_7 = new JMenuItem("\u5B66\u751F\u6DFB\u52A0");
		mntmNewMenuItem_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StudentAddInterFrame studentAddInterFrame=new StudentAddInterFrame() ;
				studentAddInterFrame.setVisible(true) ;
				table.add(studentAddInterFrame);
			}
		});
		mntmNewMenuItem_7.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
		mnNewMenu_2.add(mntmNewMenuItem_7);
		
		JMenuItem mntmNewMenuItem_8 = new JMenuItem("\u5B66\u751F\u4FEE\u6539");
		mntmNewMenuItem_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StudentManagerInterFrame studentManagerInterFrame=new StudentManagerInterFrame() ;
				studentManagerInterFrame.setVisible(true) ;
				table.add(studentManagerInterFrame);
			}
		});
		mntmNewMenuItem_8.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
		mnNewMenu_2.add(mntmNewMenuItem_8);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		 table = new JDesktopPane();
		table.setBackground(Color.GRAY);
		contentPane.add(table, BorderLayout.CENTER);

//
//		mntmNewMenuItem.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				XyAddInterFrame xyAddInterFrame=new XyAddInterFrame() ;
//				xyAddInterFrame.setVisible(true) ;
//				table.add(xyAddInterFrame);
//			}
//		});
//	
//	
//	mntmNewMenuItem_7.addActionListener(new ActionListener() {
//		public void actionPerformed(ActionEvent e) {
//			StudentAddInterFrame studentAddInterFrame=new StudentAddInterFrame() ;
//			studentAddInterFrame.setVisible(true) ;
//			table.add(studentAddInterFrame);
//		}
//	});

}
	}

