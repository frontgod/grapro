package nuc.sw.frame;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import nuc.sw.dao.StudentDao;
import nuc.sw.entity.Student;
import nuc.sw.util.LoginUser;
import nuc.sw.util.Myjdbc;

import javax.swing.JButton;
import java.awt.Font;
import java.sql.Connection;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class StudentLookFrm extends JFrame {

	private JPanel contentPane;
	private JTextField userNameTxt;
	private JTextField pwdTxt;
	private JTextField studentNoTxt;
	private JTextField studentNameTxt;
	private JTextField sexTxt;
	
	private Myjdbc myjdbc = new Myjdbc();
	private StudentDao studentDao = new StudentDao();
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					StudentUpdateFrm frame = new StudentUpdateFrm();
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
	public StudentLookFrm() {
		setTitle("\u4E2A\u4EBA\u4FE1\u606F\u67E5\u770B");
		System.out.println(LoginUser.student);


		setBounds(100, 100, 341, 344);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u8D26\u53F7\uFF1A");
		lblNewLabel.setFont(new Font("宋体", Font.BOLD, 20));
		lblNewLabel.setBounds(59, 23, 81, 32);
		contentPane.add(lblNewLabel);
		
		userNameTxt = new JTextField(LoginUser.student.getStudentUserName());
		userNameTxt.setEditable(false);
		userNameTxt.setBounds(129, 29, 125, 26);
		contentPane.add(userNameTxt);
		userNameTxt.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\u5BC6\u7801\uFF1A");
		lblNewLabel_1.setFont(new Font("宋体", Font.BOLD, 20));
		lblNewLabel_1.setBounds(59, 65, 74, 26);
		contentPane.add(lblNewLabel_1);
		
		pwdTxt = new JTextField(LoginUser.student.getStudentPassword());
		pwdTxt.setEditable(false);
		pwdTxt.setBounds(129, 68, 125, 26);
		contentPane.add(pwdTxt);
		pwdTxt.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("\u5B66\u53F7\uFF1A");
		lblNewLabel_2.setFont(new Font("宋体", Font.BOLD, 20));
		lblNewLabel_2.setBounds(59, 111, 68, 26);
		contentPane.add(lblNewLabel_2);
		
		studentNoTxt = new JTextField(LoginUser.student.getStudentId());
		studentNoTxt.setEditable(false);
		studentNoTxt.setBounds(129, 114, 125, 26);
		contentPane.add(studentNoTxt);
		studentNoTxt.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("\u59D3\u540D\uFF1A");
		lblNewLabel_3.setFont(new Font("宋体", Font.BOLD, 20));
		lblNewLabel_3.setBounds(59, 150, 68, 26);
		contentPane.add(lblNewLabel_3);
		
		studentNameTxt = new JTextField(LoginUser.student.getStudentName());
		studentNameTxt.setEditable(false);
		studentNameTxt.setBounds(129, 153, 125, 26);
		contentPane.add(studentNameTxt);
		studentNameTxt.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("\u6027\u522B\uFF1A");
		lblNewLabel_4.setFont(new Font("宋体", Font.BOLD, 20));
		lblNewLabel_4.setBounds(59, 192, 74, 26);
		contentPane.add(lblNewLabel_4);
		
		sexTxt = new JTextField(LoginUser.student.getSex());
		sexTxt.setEditable(false);
		sexTxt.setBounds(129, 192, 125, 26);
		contentPane.add(sexTxt);
		sexTxt.setColumns(10);
		
		btnNewButton = new JButton("\u786E\u8BA4");
		btnNewButton.setFont(new Font("宋体", Font.BOLD, 28));
		btnNewButton.setBounds(102, 241, 125, 32);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(e -> this.dispose());
		
	}
	
	
	/**
	 * 修改学生信息事件处理
	 */
	void updateInfo() {
		Connection con = null;
		try {
			con = myjdbc.getCon();
			//构建修改的学生信息
			Student student = LoginUser.student;
			student.setId(LoginUser.studentId);
			student.setStudentUserName(this.userNameTxt.getText());
			student.setStudentPassword(this.pwdTxt.getText());
			student.setSex(this.sexTxt.getText());
			student.setStudentName(this.studentNameTxt.getText());
			int update = studentDao.update(con ,student);
			if(update > 0) {
				JOptionPane.showMessageDialog(null, "修改成功！");
				this.dispose();
			}else {
				JOptionPane.showMessageDialog(null, "修改失败！");
			}
				
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
