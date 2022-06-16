package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.table.DefaultTableModel;

import Util.DbUtil;
import Util.StringUtil;
import dao.DepartmentDao;
import dao.StudentDao;
import model.Department;
import model.Student;

import javax.swing.border.TitledBorder;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class StudentManagerInterFrame extends JInternalFrame {
    private JTable stutable;
    private DbUtil dbUtil = new DbUtil();
    private DepartmentDao departmentDao = new DepartmentDao();
    private StudentDao studentDao = new StudentDao();
    private JTextField s_stu_nameTxt;
    private JTextField s_stu_idTxt;
    private JComboBox s_departjcb;
    private JTextField xg_idTxt;
    private JTextField xg_nameTxt;
    private JTextField xg_stuidTxt;
    private final ButtonGroup buttonGroup = new ButtonGroup();
    private JTextField xg_birthTxt;
    private JTextField xg_faceTxt;
    private JTextField xg_dormitoryTxt;
    private JTextField xg_phoneTxt;
    private JTextArea xg_addressTxt;
    private JRadioButton xg_man;
    private JRadioButton xg_woman;
    private JComboBox xg_departjcb;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    StudentManagerInterFrame frame = new StudentManagerInterFrame();
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
    public StudentManagerInterFrame() {
        setTitle("\u5B66\u751F\u4FE1\u606F\u4FEE\u6539\u4E0E\u67E5\u8BE2");
        setIconifiable(true);
        setClosable(true);
        setBounds(100, 100, 920, 531);

        JScrollPane scrollPane = new JScrollPane();

        JPanel panel = new JPanel();
        panel.setBorder(new TitledBorder(null, "\u641C\u7D22", TitledBorder.LEADING, TitledBorder.TOP, null, null));

        JPanel panel_1 = new JPanel();
        panel_1.setBorder(new TitledBorder(null, "\u4FEE\u6539", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        GroupLayout groupLayout = new GroupLayout(getContentPane());
        groupLayout.setHorizontalGroup(
                groupLayout.createParallelGroup(Alignment.LEADING)
                        .addGroup(groupLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                                        .addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 860, Short.MAX_VALUE)
                                        .addComponent(panel, GroupLayout.PREFERRED_SIZE, 859, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 888, Short.MAX_VALUE))
                                .addContainerGap())
        );
        groupLayout.setVerticalGroup(
                groupLayout.createParallelGroup(Alignment.LEADING)
                        .addGroup(groupLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(panel, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
                                .addGap(1)
                                .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 214, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(12, Short.MAX_VALUE))
        );

        JLabel lblNewLabel_3 = new JLabel("\u7F16\u53F7");
        lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 20));

        xg_idTxt = new JTextField();
        xg_idTxt.setEditable(false);
        xg_idTxt.setFont(new Font("宋体", Font.PLAIN, 20));
        xg_idTxt.setColumns(10);

        JLabel lblNewLabel_3_1 = new JLabel("\u59D3\u540D");
        lblNewLabel_3_1.setFont(new Font("宋体", Font.PLAIN, 20));

        xg_nameTxt = new JTextField();
        xg_nameTxt.setFont(new Font("宋体", Font.PLAIN, 20));
        xg_nameTxt.setColumns(10);

        JLabel lblNewLabel_1_1 = new JLabel("\u5B66\u53F7");
        lblNewLabel_1_1.setFont(new Font("宋体", Font.PLAIN, 20));

        xg_stuidTxt = new JTextField();
        xg_stuidTxt.setFont(new Font("宋体", Font.PLAIN, 20));
        xg_stuidTxt.setColumns(10);

        JLabel lblNewLabel_2_1 = new JLabel("\u5B66\u9662");
        lblNewLabel_2_1.setFont(new Font("宋体", Font.PLAIN, 20));

        xg_departjcb = new JComboBox();
        xg_departjcb.setFont(new Font("宋体", Font.PLAIN, 20));

        JLabel lblNewLabel_2_1_1 = new JLabel("\u6027\u522B");
        lblNewLabel_2_1_1.setFont(new Font("宋体", Font.PLAIN, 20));

        xg_man = new JRadioButton("\u7537");
        buttonGroup.add(xg_man);
        xg_man.setFont(new Font("宋体", Font.PLAIN, 20));

        xg_woman = new JRadioButton("\u5973");
        buttonGroup.add(xg_woman);
        xg_woman.setFont(new Font("宋体", Font.PLAIN, 20));

        JLabel lblNewLabel_3_1_1 = new JLabel("\u751F\u65E5");
        lblNewLabel_3_1_1.setFont(new Font("宋体", Font.PLAIN, 20));

        xg_birthTxt = new JTextField();
        xg_birthTxt.setFont(new Font("宋体", Font.PLAIN, 20));
        xg_birthTxt.setColumns(10);

        JLabel lblNewLabel_1_1_1 = new JLabel("\u653F\u6CBB\u9762\u8C8C");
        lblNewLabel_1_1_1.setFont(new Font("宋体", Font.PLAIN, 20));

        xg_faceTxt = new JTextField();
        xg_faceTxt.setFont(new Font("宋体", Font.PLAIN, 20));
        xg_faceTxt.setColumns(10);

        JLabel lblNewLabel_1_1_1_1 = new JLabel("\u5BBF\u820D\u53F7");
        lblNewLabel_1_1_1_1.setFont(new Font("宋体", Font.PLAIN, 20));

        xg_dormitoryTxt = new JTextField();
        xg_dormitoryTxt.setFont(new Font("宋体", Font.PLAIN, 20));
        xg_dormitoryTxt.setColumns(10);

        JLabel lblNewLabel_3_1_1_1 = new JLabel("\u7535\u8BDD");
        lblNewLabel_3_1_1_1.setFont(new Font("宋体", Font.PLAIN, 20));

        xg_phoneTxt = new JTextField();
        xg_phoneTxt.setFont(new Font("宋体", Font.PLAIN, 20));
        xg_phoneTxt.setColumns(10);

        JLabel lblNewLabel_1_1_1_2 = new JLabel("\u5BB6\u5EAD\u4F4F\u5740");
        lblNewLabel_1_1_1_2.setFont(new Font("宋体", Font.PLAIN, 20));

        xg_addressTxt = new JTextArea();
        xg_addressTxt.setFont(new Font("Monospaced", Font.PLAIN, 20));

        JButton btnNewButton_1 = new JButton("\u4FEE\u6539");
        btnNewButton_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateStu(e);
            }
        });
        btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 20));

        JButton btnNewButton_1_1 = new JButton("\u5220\u9664");
        btnNewButton_1_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteStu(e);
            }
        });
        btnNewButton_1_1.setFont(new Font("宋体", Font.PLAIN, 20));
        GroupLayout gl_panel_1 = new GroupLayout(panel_1);
        gl_panel_1.setHorizontalGroup(
                gl_panel_1.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_panel_1.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_panel_1.createSequentialGroup()
                                                .addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING, false)
                                                        .addComponent(lblNewLabel_2_1_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(lblNewLabel_3, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                                .addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false)
                                                        .addGroup(gl_panel_1.createSequentialGroup()
                                                                .addComponent(xg_idTxt, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18)
                                                                .addComponent(lblNewLabel_3_1, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                                                .addComponent(xg_nameTxt, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18)
                                                                .addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18)
                                                                .addComponent(xg_stuidTxt, GroupLayout.PREFERRED_SIZE, 187, GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18)
                                                                .addComponent(lblNewLabel_2_1, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(gl_panel_1.createSequentialGroup()
                                                                .addComponent(xg_man)
                                                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                                                .addComponent(xg_woman, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                                                .addComponent(lblNewLabel_3_1_1, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                                .addComponent(xg_birthTxt, GroupLayout.PREFERRED_SIZE, 163, GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18)
                                                                .addComponent(lblNewLabel_1_1_1, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                                .addComponent(xg_faceTxt, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18)
                                                                .addComponent(lblNewLabel_1_1_1_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                .addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false)
                                                        .addComponent(xg_departjcb, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(xg_dormitoryTxt, GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)))
                                        .addGroup(gl_panel_1.createSequentialGroup()
                                                .addComponent(lblNewLabel_3_1_1_1, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                                .addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false)
                                                        .addGroup(gl_panel_1.createSequentialGroup()
                                                                .addComponent(xg_phoneTxt, GroupLayout.PREFERRED_SIZE, 205, GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18)
                                                                .addComponent(lblNewLabel_1_1_1_2, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(ComponentPlacement.RELATED))
                                                        .addGroup(gl_panel_1.createSequentialGroup()
                                                                .addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(btnNewButton_1_1, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
                                                                .addGap(53)))
                                                .addComponent(xg_addressTxt, GroupLayout.PREFERRED_SIZE, 456, GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        gl_panel_1.setVerticalGroup(
                gl_panel_1.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_panel_1.createSequentialGroup()
                                .addGap(16)
                                .addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(xg_idTxt, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblNewLabel_3_1, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(xg_nameTxt, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(xg_stuidTxt, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblNewLabel_2_1, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(xg_departjcb, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
                                .addGap(18)
                                .addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
                                                .addComponent(lblNewLabel_2_1_1, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(xg_man))
                                        .addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
                                                .addComponent(xg_birthTxt, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(lblNewLabel_1_1_1, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(lblNewLabel_3_1_1, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
                                                .addComponent(xg_faceTxt, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(lblNewLabel_1_1_1_1, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(xg_dormitoryTxt, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                                        .addComponent(xg_woman, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                .addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false)
                                        .addGroup(gl_panel_1.createSequentialGroup()
                                                .addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
                                                        .addComponent(lblNewLabel_3_1_1_1, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(xg_phoneTxt, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(lblNewLabel_1_1_1_2, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
                                                        .addComponent(btnNewButton_1)
                                                        .addComponent(btnNewButton_1_1, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)))
                                        .addComponent(xg_addressTxt, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(21, Short.MAX_VALUE))
        );
        panel_1.setLayout(gl_panel_1);

        JLabel lblNewLabel = new JLabel("\u59D3\u540D");
        lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 20));

        s_stu_nameTxt = new JTextField();
        s_stu_nameTxt.setFont(new Font("宋体", Font.PLAIN, 20));
        s_stu_nameTxt.setColumns(10);

        JLabel lblNewLabel_1 = new JLabel("\u5B66\u53F7");
        lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 20));

        s_stu_idTxt = new JTextField();
        s_stu_idTxt.setFont(new Font("宋体", Font.PLAIN, 20));
        s_stu_idTxt.setColumns(10);

        JLabel lblNewLabel_2 = new JLabel("\u5B66\u9662");
        lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 20));

        s_departjcb = new JComboBox();
        s_departjcb.setFont(new Font("宋体", Font.PLAIN, 20));

        JButton btnNewButton = new JButton("\u67E5\u8BE2");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                StudentSearchActionPerformed(e);
            }
        });
        btnNewButton.setFont(new Font("宋体", Font.PLAIN, 20));
        GroupLayout gl_panel = new GroupLayout(panel);
        gl_panel.setHorizontalGroup(
                gl_panel.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_panel.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addComponent(s_stu_nameTxt, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)
                                .addGap(32)
                                .addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addComponent(s_stu_idTxt, GroupLayout.PREFERRED_SIZE, 187, GroupLayout.PREFERRED_SIZE)
                                .addGap(18)
                                .addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addComponent(s_departjcb, GroupLayout.PREFERRED_SIZE, 163, GroupLayout.PREFERRED_SIZE)
                                .addGap(18)
                                .addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        gl_panel.setVerticalGroup(
                gl_panel.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_panel.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
                                                .addComponent(s_stu_idTxt, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(s_departjcb, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(btnNewButton))
                                        .addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
                                                .addComponent(lblNewLabel)
                                                .addComponent(s_stu_nameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(26, Short.MAX_VALUE))
        );
        panel.setLayout(gl_panel);

        stutable = new JTable();
        stutable.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                stuTableMousePressed(e);
            }
        });
        stutable.setModel(new DefaultTableModel(
                new Object[][]{
                },
                new String[]{
                        "\u7F16\u53F7", "\u59D3\u540D", "\u5B66\u53F7", "\u6027\u522B", "\u751F\u65E5", "\u653F\u6CBB\u9762\u8C8C", "\u5BB6\u5EAD\u5730\u5740", "\u7535\u8BDD", "\u5BBF\u820D\u53F7", "\u5B66\u9662"
                }
        ) {
            boolean[] columnEditables = new boolean[]{
                    false, true, true, true, true, true, true, true, true, true
            };

            public boolean isCellEditable(int row, int column) {
                return columnEditables[column];
            }
        });
        scrollPane.setViewportView(stutable);
        getContentPane().setLayout(groupLayout);

        this.fillTable(new Student());
        this.filljcb("search");
    }

    /**
     * 删除事件
     * @param e
     */
    private void deleteStu(ActionEvent e) {
        String id = this.xg_idTxt.getText() ;
        if (StringUtil. isEmpty(id)) {
            JOptionPane.showMessageDialog (null, "请选择要删除的记录! ");
            return;
        }
        int n = JOptionPane. showConfirmDialog (null, "确定要删除该条记录吗? ");
        if (n==0) {
            Connection con=null;
            try {
                con=dbUtil .getCon() ;
                int num=studentDao. delete (con, id) ;
                if (num==1) {
                    JOptionPane. showMessageDialog(null, "删除成功! ") ;
                    this. resetNull () ;
                    this. fillTable(new Student()) ;
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

    /**
     * 修改事件处理
     * @param e
     */
    private void updateStu(ActionEvent e) {
        String xg_id = this. xg_idTxt.getText() ;
        String xg_name=this.xg_nameTxt . getText() ;
        String xg_stuid=this. xg_stuidTxt.getText() ;
        String xg_birth=this. xg_birthTxt.getText() ;
        String xg_face=this. xg_faceTxt.getText() ;
        String xg_address=this. xg_addressTxt.getText() ;
        String xg_phone=this. xg_phoneTxt.getText() ;
        String xg_dormitory=this.xg_dormitoryTxt.getText() ;
        String sex = "";
        if (this.xg_man.isSelected()) {
            sex = "男";
        } else {
            sex = "女";
        }
        Department department = (Department) this.xg_departjcb.getSelectedItem();
        int departmentId = department.getId();


        if (StringUtil. isEmpty(xg_id)) {
            JOptionPane.showMessageDialog(null,"请选择要修改的记录! ");
            return;
        }
        if (StringUtil. isEmpty(xg_name)) {
            JOptionPane . showMessageDialog(null,"名字不能为空! ");
            return;
        }
        if (StringUtil. isEmpty(xg_stuid)) {
            JOptionPane. showMessageDialog(null, "学号不能为空! ");
            return;
        }
        if (StringUtil. isEmpty(xg_birth)) {
            JOptionPane. showMessageDialog(null, "生日不能为空! ");
            return;
        }
        if (StringUtil. isEmpty(xg_face)) {
            JOptionPane. showMessageDialog(null, "政治面貌不能为空! ");
            return;
        }
        if (StringUtil. isEmpty(xg_address)) {
            JOptionPane. showMessageDialog(null, "家庭地址不能为空! ");
            return;
        }
        if (StringUtil. isEmpty(xg_phone)) {
            JOptionPane. showMessageDialog(null, "电话不能为空! ");
            return;
        }
        if (StringUtil. isEmpty(xg_dormitory)) {
            JOptionPane. showMessageDialog(null, "宿舍号不能为空! ");
            return;
        }
        if(xg_departjcb.getSelectedIndex()==0){
            JOptionPane.showMessageDialog(null, "请选择所在学院!");
            return;
        }


        Student student = new Student( Integer.parseInt(xg_id),xg_name, xg_stuid,sex,xg_birth,xg_face,xg_address,xg_phone,xg_dormitory,departmentId);
        Connection con=null;
        try {
            con=dbUtil.getCon() ;
            int num=studentDao.update(con, student ) ;
            if (num==1) {
                JOptionPane. showMessageDialog(null,"修改成功! ");
                this.resetNull();
                this.fillTable(new Student());
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

    /**
     * 表格点击事件
     *
     * @param e
     */
    private void stuTableMousePressed(MouseEvent e) {

        // TODO Auto-generated method stub
        int row = this.stutable.getSelectedRow();
        this.xg_idTxt.setText((String) this.stutable.getValueAt(row, 0));
        this.xg_nameTxt.setText((String) this.stutable.getValueAt(row, 1));
        this.xg_stuidTxt.setText((String) this.stutable.getValueAt(row, 2));
        this.xg_birthTxt.setText((String) this.stutable.getValueAt(row, 4));
        this.xg_faceTxt.setText((String) this.stutable.getValueAt(row, 5));
        this.xg_addressTxt.setText((String) this.stutable.getValueAt(row, 6));
        this.xg_phoneTxt.setText((String) this.stutable.getValueAt(row, 7));
        this.xg_dormitoryTxt.setText((String) this.stutable.getValueAt(row, 8));
        if (this.stutable.getValueAt(row, 3).equals("男")) {
            this.xg_man.setSelected(true);
        } else {
            this.xg_woman.setSelected(true);
        }

        Connection con = null;
        try {
            con = dbUtil.getCon();
            Student student = new Student((String) this.stutable.getValueAt(row, 1),(String) this.stutable.getValueAt(row, 2));
            ResultSet rs1 = studentDao.list(con, student);
            String departmentId = null;
            while(rs1.next()){
                departmentId = rs1.getString("departmentId");
            }
            ResultSet rs = departmentDao.list(con, new Department());
            int departmentIndex = 1;
            while (rs.next()) {
                if (rs.getString("id").equals(departmentId)) {
                    break;
                }
                departmentIndex++;
            }
            this.xg_departjcb.setSelectedIndex(departmentIndex);
        } catch (Exception e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        } finally {

            try {
                dbUtil.closeCon(con);
            } catch (Exception e2) {
                // TODO Auto-generated catch block
                e2.printStackTrace();
            }
        }

    }

    /**
     * 查询事件处理
     */
    private void StudentSearchActionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        String stuName = this.s_stu_nameTxt.getText();
        String stuId = this.s_stu_idTxt.getText();
        Department department = (Department) this.s_departjcb.getSelectedItem();
        int departmentId = department.getId();
        Student student = new Student(stuName, stuId, departmentId);
        this.fillTable(student);
    }

    /**
     * 初始化下拉框
     */
    private void filljcb(String type) {
        Connection con = null;
        Department department = null;
        try {
            con = dbUtil.getCon();
            ResultSet rs = departmentDao.list(con, new Department());
            if ("search".equals(type)) {
                department = new Department();
                department.setDepart_name("请选择...");
                department.setId(-1);
                this.s_departjcb.addItem(department);
                this.xg_departjcb.addItem(department);
            }
            while (rs.next()) {
                department = new Department();
                department.setDepart_name(rs.getString("depart_name"));
                department.setId(rs.getInt("id"));

                if ("search".equals(type)) {
                    this.s_departjcb.addItem(department);
                    this.xg_departjcb.addItem(department);
                } else if ("modify".equals(type)) {

                }
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                dbUtil.closeCon(con);
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    /*
     * 初始化表格
     */
    private void fillTable(Student student) {
        DefaultTableModel dtm = (DefaultTableModel) stutable.getModel();
        dtm.setRowCount(0);
        Connection con = null;
        try {
            con = dbUtil.getCon();
            ResultSet rs = studentDao.list(con, student);
            while (rs.next()) {
                Vector v = new Vector();
                v.add(rs.getString("id"));
                v.add(rs.getString("stuName"));
                v.add(rs.getString("stuId"));
                v.add(rs.getString("sex"));
                v.add(rs.getString("birth"));
                v.add(rs.getString("face"));
                v.add(rs.getString("address"));
                v.add(rs.getString("phone"));
                v.add(rs.getString("dormitory"));
                v.add(rs.getString("depart_name"));
                dtm.addRow(v);

            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
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
        this.xg_idTxt.setText ("") ;
        this.xg_nameTxt.setText ("") ;
        this.xg_addressTxt.setText ("") ;
        this.xg_birthTxt.setText ("") ;
        this.xg_dormitoryTxt.setText ("") ;
        this.xg_phoneTxt.setText ("") ;
        this.xg_stuidTxt.setText ("") ;
        this.xg_faceTxt.setText ("") ;
        this.xg_departjcb.setSelectedItem (null);
        this.xg_man.setSelected(false);
        this.xg_woman.setSelected(false);

    }
}
