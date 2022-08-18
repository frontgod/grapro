package nuc.sw.frame;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import nuc.sw.dao.TeacherDao;
import nuc.sw.entity.Student;
import nuc.sw.entity.Teacher;
import nuc.sw.util.LoginUser;
import nuc.sw.util.Myjdbc;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import java.sql.Connection;

import javax.swing.JButton;

public class TeacherUpdateFrm extends JFrame {

	private JPanel contentPane;
	private JTextField userNameTxt;
	private JTextField passwordTxt;
	private JTextField TeacherNameTxt;
	private JTextField SexTxt;
	private JTextField PhoneTxt;
	
	
	private TeacherDao teacherDao = new TeacherDao();
    private Myjdbc myjdbc = new Myjdbc();
    private JTextField teacherIdTxt;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					TeacherUpdateFrm frame = new TeacherUpdateFrm();
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
	public TeacherUpdateFrm() {
		System.out.println(LoginUser.teacher);
		setTitle("\u6559\u5E08\u4E2A\u4EBA\u4FE1\u606F\u4FEE\u6539");
	
		setBounds(100, 100, 396, 388);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u8D26\u53F7\uFF1A");
		lblNewLabel.setFont(new Font("宋体", Font.BOLD, 20));
		lblNewLabel.setBounds(83, 40, 62, 25);
		contentPane.add(lblNewLabel);
		
		userNameTxt = new JTextField(LoginUser.teacher.getTeacherUserName());
		userNameTxt.setEditable(false);
		userNameTxt.setBounds(161, 41, 123, 25);
		contentPane.add(userNameTxt);
		userNameTxt.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\u5BC6\u7801\uFF1A");
		lblNewLabel_1.setFont(new Font("宋体", Font.BOLD, 20));
		lblNewLabel_1.setBounds(83, 79, 62, 27);
		contentPane.add(lblNewLabel_1);
		
		passwordTxt = new JTextField(LoginUser.teacher.getTeacherPassword());
		passwordTxt.setBounds(161, 81, 123, 25);
		contentPane.add(passwordTxt);
		passwordTxt.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("\u59D3\u540D\uFF1A");
		lblNewLabel_2.setFont(new Font("宋体", Font.BOLD, 20));
		lblNewLabel_2.setBounds(83, 153, 62, 25);
		contentPane.add(lblNewLabel_2);
		
		TeacherNameTxt = new JTextField(LoginUser.teacher.getTeacherName());
		TeacherNameTxt.setBounds(161, 154, 123, 27);
		contentPane.add(TeacherNameTxt);
		TeacherNameTxt.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("\u6027\u522B\uFF1A");
		lblNewLabel_3.setFont(new Font("宋体", Font.BOLD, 20));
		lblNewLabel_3.setBounds(83, 188, 68, 27);
		contentPane.add(lblNewLabel_3);
		
		SexTxt = new JTextField(LoginUser.teacher.getSex());
		SexTxt.setBounds(161, 191, 123, 27);
		contentPane.add(SexTxt);
		SexTxt.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("\u7535\u8BDD\uFF1A");
		lblNewLabel_4.setFont(new Font("宋体", Font.BOLD, 20));
		lblNewLabel_4.setBounds(83, 225, 62, 27);
		contentPane.add(lblNewLabel_4);
		
		PhoneTxt = new JTextField(LoginUser.teacher.getPhone());
		PhoneTxt.setBounds(161, 228, 123, 27);
		contentPane.add(PhoneTxt);
		PhoneTxt.setColumns(10);
		
		JButton btnNewButton = new JButton("\u4FEE\u6539");
		btnNewButton.setFont(new Font("宋体", Font.BOLD, 25));
		btnNewButton.setBounds(28, 283, 123, 40);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(e -> updateInfo());
		
		
		JButton btnNewButton_1 = new JButton("\u53D6\u6D88");
		btnNewButton_1.setFont(new Font("宋体", Font.BOLD, 25));
		btnNewButton_1.setBounds(231, 283, 123, 40);
		contentPane.add(btnNewButton_1);
		btnNewButton_1.addActionListener(e -> this.dispose());
		
		JLabel lblNewLabel_5 = new JLabel("\u5DE5\u53F7\uFF1A");
		lblNewLabel_5.setFont(new Font("宋体", Font.BOLD, 20));
		lblNewLabel_5.setBounds(83, 116, 62, 27);
		contentPane.add(lblNewLabel_5);
		
		teacherIdTxt = new JTextField(LoginUser.teacher.getTeacherId());
		teacherIdTxt.setBounds(161, 118, 123, 26);
		contentPane.add(teacherIdTxt);
		teacherIdTxt.setColumns(10);
		
	}
	/**
	 * 修改教师信息事件处理
	 */
	void updateInfo() {
		Connection con = null;
		try {
			con = myjdbc.getCon();
			//构建修改的教师信息
			Teacher teacher = LoginUser.teacher;
			teacher.setId(LoginUser.teacherId);
			teacher.setTeacherPassword(this.passwordTxt.getText());
			teacher.setTeacherId(this.teacherIdTxt.getText());
			teacher.setTeacherName(this.TeacherNameTxt.getText());
			teacher.setSex(this.SexTxt.getText());
			teacher.setPhone(this.PhoneTxt.getText());
			int update = teacherDao.update(con ,teacher);
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
