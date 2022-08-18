package nuc.sw.frame;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import nuc.sw.util.LoginUser;
import nuc.sw.util.Myjdbc;
import nuc.sw.dao.TeacherDao;
import nuc.sw.entity.Teacher;
import nuc.sw.util.StringUtil;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.awt.event.ActionEvent;

public class TeacherLogOnFrm extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	
	private Myjdbc myjdbc = new Myjdbc();
	private TeacherDao teacherDao = new TeacherDao();

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					TeacherLogOnFrm frame = new TeacherLogOnFrm();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public TeacherLogOnFrm() {
		setResizable(false);
		
		setBounds(100, 100, 596, 393);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("\u6559\u5E08\u767B\u5F55\u754C\u9762");
		lblNewLabel.setBounds(147, 50, 285, 57);
		lblNewLabel.setFont(new Font("华文隶书", Font.BOLD, 35));
		lblNewLabel.setIcon(new ImageIcon(StudentLogOnFrm.class.getResource("/images/graphic_design_47.826714801444px_1302710_easyicon.net.png")));
		
		JLabel lblNewLabel_1 = new JLabel("\u6559\u5E08\u8D26\u53F7\uFF1A");
		lblNewLabel_1.setBounds(102, 159, 132, 24);
		lblNewLabel_1.setFont(new Font("宋体", Font.BOLD, 20));
		lblNewLabel_1.setIcon(new ImageIcon(StudentLogOnFrm.class.getResource("/images/user_24px_1299007_easyicon.net.png")));
		
		JLabel lblNewLabel_2 = new JLabel("\u767B\u5F55\u5BC6\u7801\uFF1A");
		lblNewLabel_2.setBounds(102, 203, 132, 24);
		lblNewLabel_2.setFont(new Font("宋体", Font.BOLD, 20));
		lblNewLabel_2.setIcon(new ImageIcon(StudentLogOnFrm.class.getResource("/images/key_24px_1300544_easyicon.net.png")));
		
		textField = new JTextField();
		textField.setBounds(244, 163, 225, 21);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("\u6CE8\u518C");
		btnNewButton.setIcon(new ImageIcon(TeacherLogOnFrm.class.getResource("/images/reset.png")));
		btnNewButton.setBounds(40, 287, 125, 55);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TeacherZhuceActionPreformed(e);
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.BOLD, 20));
		
		JButton btnNewButton_1 = new JButton("\u767B\u5F55");
		btnNewButton_1.setIcon(new ImageIcon(TeacherLogOnFrm.class.getResource("/images/login.png")));
		btnNewButton_1.setBounds(233, 287, 128, 54);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loginActionPerformed(e);
			}
		});
		btnNewButton_1.setFont(new Font("宋体", Font.BOLD, 20));
		
		JButton btnNewButton_2 = new JButton("\u91CD\u7F6E");
		btnNewButton_2.setIcon(new ImageIcon(TeacherLogOnFrm.class.getResource("/images/exit.png")));
		btnNewButton_2.setBounds(427, 287, 129, 55);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetValueActionPerformed(e);
			}
		});
		btnNewButton_2.setFont(new Font("宋体", Font.BOLD, 20));
		
		passwordField = new JPasswordField();
		passwordField.setBounds(244, 207, 225, 21);
		contentPane.setLayout(null);
		contentPane.add(lblNewLabel_1);
		contentPane.add(lblNewLabel_2);
		contentPane.add(textField);
		contentPane.add(passwordField);
		contentPane.add(btnNewButton);
		contentPane.add(btnNewButton_1);
		contentPane.add(btnNewButton_2);
		contentPane.add(lblNewLabel);
		this.setLocationRelativeTo(null);
	}
	private void TeacherZhuceActionPreformed(ActionEvent e) {
		new ZhuceTeacherFrm().setVisible(true);
		
	}
	/**
	 * 登陆事件处理
	 * @param e
	 */
	private void loginActionPerformed(ActionEvent evt) {
		String teacherUserName = this.textField.getText();
		String teacherPassword = new String(this.passwordField.getPassword());
		if(StringUtil.isEmpty(teacherUserName)) {
			JOptionPane.showMessageDialog(null, "教师账号不能为空！");
			return;
		}
		if(StringUtil.isEmpty(teacherPassword)) {
			JOptionPane.showMessageDialog(null, "登录密码不能为空！");
			return;
		}
		Teacher teacher = new Teacher(teacherUserName, teacherPassword);
		Connection con = null;
		try {
			con = myjdbc.getCon();
			Teacher currentTeacher = teacherDao.login(con, teacher);
			if(currentTeacher!=null) {
//				JOptionPane.showMessageDialog(null,"登录成功！");
				LoginUser.teacherId=currentTeacher.getId();
                LoginUser.teacher=currentTeacher;
				dispose();
				new TeacherFrm().setVisible(true);
			}else {
				JOptionPane.showMessageDialog(null, "教师账号或登录密码错误！");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * 重置事件处理
	 * @param e
	 */
	private void resetValueActionPerformed(ActionEvent evt) {
		this.textField.setText("");
		this.passwordField.setText("");
		
	}
}
