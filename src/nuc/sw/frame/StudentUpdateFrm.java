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
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class StudentUpdateFrm extends JFrame {

	private JPanel contentPane;
	private JTextField userNameTxt;
	private JTextField pwdTxt;
	private JTextField studentNoTxt;
	private JTextField studentNameTxt;
	private JTextField sexTxt;
	
	private Myjdbc myjdbc = new Myjdbc();
	private StudentDao studentDao = new StudentDao();
	private JButton btnNewButton_1;

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
	public StudentUpdateFrm() {
		System.out.println(LoginUser.student);
		setTitle("\u4E2A\u4EBA\u4FE1\u606F\u4FEE\u6539");
		


		setBounds(100, 100, 356, 331);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("\u8D26\u53F7\uFF1A");
		lblNewLabel.setBounds(78, 31, 62, 24);
		lblNewLabel.setFont(new Font("宋体", Font.BOLD, 20));
		
		userNameTxt = new JTextField(LoginUser.student.getStudentUserName());
		userNameTxt.setEditable(false);
		userNameTxt.setBounds(139, 31, 125, 25);
		userNameTxt.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\u5BC6\u7801\uFF1A");
		lblNewLabel_1.setBounds(78, 69, 62, 24);
		lblNewLabel_1.setFont(new Font("宋体", Font.BOLD, 20));
		
		pwdTxt = new JTextField(LoginUser.student.getStudentPassword());
		pwdTxt.setBounds(139, 69, 125, 24);
		pwdTxt.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("\u5B66\u53F7\uFF1A");
		lblNewLabel_2.setBounds(78, 109, 62, 24);
		lblNewLabel_2.setFont(new Font("宋体", Font.BOLD, 20));
		
		studentNoTxt = new JTextField(LoginUser.student.getStudentId());
		studentNoTxt.setBounds(139, 107, 125, 26);
		studentNoTxt.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("\u59D3\u540D\uFF1A");
		lblNewLabel_3.setBounds(78, 145, 62, 26);
		lblNewLabel_3.setFont(new Font("宋体", Font.BOLD, 20));
		
		studentNameTxt = new JTextField(LoginUser.student.getStudentName());
		studentNameTxt.setBounds(139, 145, 125, 26);
		studentNameTxt.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("\u6027\u522B\uFF1A");
		lblNewLabel_4.setBounds(78, 185, 62, 24);
		lblNewLabel_4.setFont(new Font("宋体", Font.BOLD, 20));
		
		sexTxt = new JTextField(LoginUser.student.getSex());
		sexTxt.setBounds(139, 187, 125, 26);
		sexTxt.setColumns(10);
		contentPane.setLayout(null);
		contentPane.add(lblNewLabel);
		contentPane.add(userNameTxt);
		contentPane.add(lblNewLabel_1);
		contentPane.add(pwdTxt);
		contentPane.add(lblNewLabel_2);
		contentPane.add(studentNoTxt);
		contentPane.add(lblNewLabel_3);
		contentPane.add(studentNameTxt);
		contentPane.add(lblNewLabel_4);
		contentPane.add(sexTxt);
		
		JButton btnNewButton = new JButton("\u786E\u8BA4");
		btnNewButton.setFont(new Font("宋体", Font.BOLD, 28));
		btnNewButton.setBounds(190, 241, 104, 42);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(e -> this.dispose());
		
		btnNewButton_1 = new JButton("\u4FEE\u6539");
		btnNewButton_1.setFont(new Font("宋体", Font.BOLD, 28));
		btnNewButton_1.setBounds(51, 241, 104, 42);
		contentPane.add(btnNewButton_1);
		btnNewButton_1.addActionListener(e -> updateInfo());
		
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
			student.setStudentPassword(this.pwdTxt.getText());
			student.setStudentId(this.studentNoTxt.getText());
			student.setStudentName(this.studentNameTxt.getText());
			student.setSex(this.sexTxt.getText());
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
