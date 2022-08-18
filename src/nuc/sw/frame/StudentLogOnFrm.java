package nuc.sw.frame;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import nuc.sw.util.LoginUser;
import nuc.sw.util.Myjdbc;
import nuc.sw.dao.StudentDao;
import nuc.sw.entity.Student;
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
import java.awt.Window;

import javax.swing.JComboBox;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.awt.event.ActionEvent;

public class StudentLogOnFrm extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	
	private Myjdbc myjdbc = new Myjdbc();
	private StudentDao studentDao = new StudentDao();

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					StudentLogOnFrm frame = new StudentLogOnFrm();
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
	public StudentLogOnFrm() {
		setResizable(false);
		
		setBounds(100, 100, 616, 399);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("\u5B66\u751F\u767B\u5F55\u754C\u9762");
		lblNewLabel.setBounds(161, 53, 285, 57);
		lblNewLabel.setFont(new Font("华文隶书", Font.BOLD, 35));
		lblNewLabel.setIcon(new ImageIcon(StudentLogOnFrm.class.getResource("/images/graphic_design_47.826714801444px_1302710_easyicon.net.png")));
		
		JLabel lblNewLabel_1 = new JLabel("\u5B66\u751F\u8D26\u53F7\uFF1A");
		lblNewLabel_1.setBounds(107, 152, 132, 24);
		lblNewLabel_1.setFont(new Font("宋体", Font.BOLD, 20));
		lblNewLabel_1.setIcon(new ImageIcon(StudentLogOnFrm.class.getResource("/images/user_24px_1299007_easyicon.net.png")));
		
		JLabel lblNewLabel_2 = new JLabel("\u767B\u5F55\u5BC6\u7801\uFF1A");
		lblNewLabel_2.setBounds(107, 200, 132, 24);
		lblNewLabel_2.setFont(new Font("宋体", Font.BOLD, 20));
		lblNewLabel_2.setIcon(new ImageIcon(StudentLogOnFrm.class.getResource("/images/key_24px_1300544_easyicon.net.png")));
		
		textField = new JTextField();
		textField.setBounds(249, 156, 244, 21);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("\u6CE8\u518C");
		btnNewButton.setIcon(new ImageIcon(StudentLogOnFrm.class.getResource("/images/login.png")));
		btnNewButton.setBounds(46, 280, 125, 55);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ZhuceStudentFrm().setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.BOLD, 20));
		
		JButton btnNewButton_1 = new JButton("\u767B\u5F55");
		btnNewButton_1.setIcon(new ImageIcon(StudentLogOnFrm.class.getResource("/images/reset.png")));
		btnNewButton_1.setBounds(237, 280, 128, 54);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loginActionPerformed(e);
			}
		});
		btnNewButton_1.setFont(new Font("宋体", Font.BOLD, 20));
		
		JButton btnNewButton_2 = new JButton("\u91CD\u7F6E");
		btnNewButton_2.setIcon(new ImageIcon(StudentLogOnFrm.class.getResource("/images/exit.png")));
		btnNewButton_2.setBounds(436, 280, 129, 55);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetValueActionPerformed(e);
			}
		});
		btnNewButton_2.setFont(new Font("宋体", Font.BOLD, 20));
		
		passwordField = new JPasswordField();
		passwordField.setBounds(249, 204, 244, 21);
		contentPane.setLayout(null);
		contentPane.add(lblNewLabel);
		contentPane.add(lblNewLabel_2);
		contentPane.add(btnNewButton);
		contentPane.add(lblNewLabel_1);
		contentPane.add(textField);
		contentPane.add(passwordField);
		contentPane.add(btnNewButton_1);
		contentPane.add(btnNewButton_2);
		this.setLocationRelativeTo(null);
	}
	/**
	 * 登陆事件处理
	 * @param e
	 */
	private void loginActionPerformed(ActionEvent evt) {
		String studentUserName = this.textField.getText();
		String studentPassword = new String(this.passwordField.getPassword());
		if(StringUtil.isEmpty(studentUserName)) {
			JOptionPane.showMessageDialog(null, "学生账号不能为空！");
			return;
		}
		if(StringUtil.isEmpty(studentPassword)) {
			JOptionPane.showMessageDialog(null, "登录密码不能为空！");
			return;
		}
		Student student =new Student(studentUserName, studentPassword);
		Connection con = null;
		try {
			con = myjdbc.getCon();
			Student currentStudent = studentDao.login(con, student);
			if(currentStudent!=null) {
//				JOptionPane.showMessageDialog(null, "登陆成功!");
				 LoginUser.student=currentStudent;
	             LoginUser.studentId=currentStudent.getId();
				dispose();
				new StudentFrm().setVisible(true);
			}else {
				JOptionPane.showMessageDialog(null, "学生账号或登录密码错误！");
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
