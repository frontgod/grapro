package nuc.sw.frame;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import nuc.sw.dao.TeacherDao;
import nuc.sw.util.LoginUser;
import nuc.sw.util.Myjdbc;

import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;

public class TeacherLookFrm extends JFrame {

	private JPanel contentPane;
	private JTextField UserNameTxt;
	private JTextField passwordTxt;
	private JTextField TeacherNameTxt;
	private JTextField SexTxt;
	private JTextField PhoneTxt;
	
	private TeacherDao teacherDao = new TeacherDao();
    private Myjdbc myjdbc = new Myjdbc();
    private JTextField teacherId;

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
	public TeacherLookFrm() {
		
		setTitle("\u4E2A\u4EBA\u4FE1\u606F\u67E5\u770B");

		setBounds(100, 100, 396, 443);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u8D26\u53F7\uFF1A");
		lblNewLabel.setFont(new Font("宋体", Font.BOLD, 20));
		lblNewLabel.setBounds(83, 29, 68, 27);
		contentPane.add(lblNewLabel);
		
		UserNameTxt = new JTextField(LoginUser.teacher.getTeacherUserName());
		UserNameTxt.setEditable(false);
		UserNameTxt.setBounds(161, 31, 135, 27);
		contentPane.add(UserNameTxt);
		UserNameTxt.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\u5BC6\u7801\uFF1A");
		lblNewLabel_1.setFont(new Font("宋体", Font.BOLD, 20));
		lblNewLabel_1.setBounds(83, 72, 68, 27);
		contentPane.add(lblNewLabel_1);
		
		passwordTxt = new JTextField(LoginUser.teacher.getTeacherPassword());
		passwordTxt.setEditable(false);
		passwordTxt.setBounds(161, 75, 135, 27);
		contentPane.add(passwordTxt);
		passwordTxt.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("\u59D3\u540D\uFF1A");
		lblNewLabel_2.setFont(new Font("宋体", Font.BOLD, 20));
		lblNewLabel_2.setBounds(83, 166, 62, 27);
		contentPane.add(lblNewLabel_2);
		
		TeacherNameTxt = new JTextField(LoginUser.teacher.getTeacherName());
		TeacherNameTxt.setEditable(false);
		TeacherNameTxt.setBounds(161, 167, 135, 27);
		contentPane.add(TeacherNameTxt);
		TeacherNameTxt.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("\u6027\u522B\uFF1A");
		lblNewLabel_3.setFont(new Font("宋体", Font.BOLD, 20));
		lblNewLabel_3.setBounds(83, 214, 68, 27);
		contentPane.add(lblNewLabel_3);
		
		SexTxt = new JTextField(LoginUser.teacher.getSex());
		SexTxt.setEditable(false);
		SexTxt.setBounds(161, 216, 135, 27);
		contentPane.add(SexTxt);
		SexTxt.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("\u7535\u8BDD\uFF1A");
		lblNewLabel_4.setFont(new Font("宋体", Font.BOLD, 20));
		lblNewLabel_4.setBounds(83, 263, 62, 27);
		contentPane.add(lblNewLabel_4);
		
		PhoneTxt = new JTextField(LoginUser.teacher.getPhone());
		PhoneTxt.setEditable(false);
		PhoneTxt.setBounds(161, 265, 135, 27);
		contentPane.add(PhoneTxt);
		PhoneTxt.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("\u786E\u8BA4");
		btnNewButton_1.setFont(new Font("宋体", Font.BOLD, 25));
		btnNewButton_1.setBounds(130, 329, 123, 40);
		contentPane.add(btnNewButton_1);
		btnNewButton_1.addActionListener(e -> this.dispose());
		
		JLabel lblNewLabel_5 = new JLabel("\u5DE5\u53F7\uFF1A");
		lblNewLabel_5.setFont(new Font("宋体", Font.BOLD, 20));
		lblNewLabel_5.setBounds(83, 124, 62, 27);
		contentPane.add(lblNewLabel_5);
		
		teacherId = new JTextField(LoginUser.teacher.getTeacherId());
		teacherId.setEditable(false);
		teacherId.setBounds(161, 126, 135, 27);
		contentPane.add(teacherId);
		teacherId.setColumns(10);
	}
}
