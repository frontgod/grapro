package nuc.sw.frame;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import nuc.sw.dao.StudentDao;
import nuc.sw.entity.Project;
import nuc.sw.entity.ProjectType;
import nuc.sw.entity.Student;
import nuc.sw.util.Myjdbc;
import nuc.sw.util.StringUtil;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.awt.event.ActionEvent;

public class ZhuceStudentFrm extends JFrame {

	private JPanel contentPane;
	private JTextField StudentUserNameTxt;
	private JTextField StudentIdTxt;
	private JTextField StudentNameTxt;
	private JTextField SexTxt;
	private JTextField passwordTxt;
	
	
	private Myjdbc myjdbc = new Myjdbc();
	private StudentDao studentDao = new StudentDao();

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					ZhuceStudentFrm frame = new ZhuceStudentFrm();
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
	public ZhuceStudentFrm() {
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 457, 532);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u5B66\u751F\u8D26\u53F7\uFF1A");
		lblNewLabel.setFont(new Font("宋体", Font.BOLD, 16));
		lblNewLabel.setBounds(71, 110, 84, 26);
		contentPane.add(lblNewLabel);
		
		StudentUserNameTxt = new JTextField();
		StudentUserNameTxt.setBounds(177, 110, 216, 26);
		contentPane.add(StudentUserNameTxt);
		StudentUserNameTxt.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\u767B\u5F55\u5BC6\u7801\uFF1A");
		lblNewLabel_1.setFont(new Font("宋体", Font.BOLD, 16));
		lblNewLabel_1.setBounds(71, 163, 84, 29);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u5B66\u751F\u6CE8\u518C\u754C\u9762");
		lblNewLabel_2.setIcon(new ImageIcon(ZhuceStudentFrm.class.getResource("/images/student_56.277278562259px_1218516_easyicon.net.png")));
		lblNewLabel_2.setFont(new Font("微软雅黑", Font.BOLD, 35));
		lblNewLabel_2.setBounds(81, 25, 286, 61);
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("\u6CE8\u518C");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				zhuceActionPerformed(e);
			}
		});
		btnNewButton.setFont(new Font("幼圆", Font.BOLD, 30));
		btnNewButton.setBounds(34, 407, 132, 50);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u91CD\u7F6E");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetValueActionPerformed(e);
			}
		});
		btnNewButton_1.setFont(new Font("幼圆", Font.BOLD, 30));
		btnNewButton_1.setBounds(279, 407, 126, 50);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_3 = new JLabel("   \u5B66\u53F7\uFF1A");
		lblNewLabel_3.setFont(new Font("宋体", Font.BOLD, 16));
		lblNewLabel_3.setBounds(71, 215, 84, 26);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("   \u59D3\u540D\uFF1A");
		lblNewLabel_4.setFont(new Font("宋体", Font.BOLD, 16));
		lblNewLabel_4.setBounds(71, 266, 84, 26);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("   \u6027\u522B\uFF1A");
		lblNewLabel_5.setFont(new Font("宋体", Font.BOLD, 16));
		lblNewLabel_5.setBounds(71, 318, 84, 26);
		contentPane.add(lblNewLabel_5);
		
		StudentIdTxt = new JTextField();
		StudentIdTxt.setBounds(177, 219, 145, 26);
		contentPane.add(StudentIdTxt);
		StudentIdTxt.setColumns(10);
		
		StudentNameTxt = new JTextField();
		StudentNameTxt.setBounds(177, 270, 110, 26);
		contentPane.add(StudentNameTxt);
		StudentNameTxt.setColumns(10);
		
		SexTxt = new JTextField();
		SexTxt.setBounds(177, 322, 110, 29);
		contentPane.add(SexTxt);
		SexTxt.setColumns(10);
		
		passwordTxt = new JTextField();
		passwordTxt.setBounds(177, 168, 216, 26);
		contentPane.add(passwordTxt);
		passwordTxt.setColumns(10);
	}
	/**
	 * 注册事件处理
	 * @param e
	 */
	private void zhuceActionPerformed(ActionEvent e) {
		
		String studentUserName = this.StudentUserNameTxt.getText();
		String studentPassword = this.passwordTxt.getText();
		String studentId = this.StudentIdTxt.getText();
		String studentName= this.StudentNameTxt.getText();
		String sex = this.SexTxt.getText();
		
		if(StringUtil.isEmpty(studentUserName)) {
			JOptionPane.showMessageDialog(null, "学生账号不能为空！");
			return;
		}
		if(StringUtil.isEmpty(studentPassword)) {
			JOptionPane.showMessageDialog(null, "登陆密码不能为空！");
			return;
		}
		if(StringUtil.isEmpty(studentId)) {
			JOptionPane.showMessageDialog(null, "学号不能为空！");
			return;
		}
		if(StringUtil.isEmpty(studentName)) {
			JOptionPane.showMessageDialog(null, "姓名不能为空！");
			return;
		}
		if(StringUtil.isEmpty(sex)) {
			JOptionPane.showMessageDialog(null, "性别不能为空！");
			return;
		}
		
//		ProjectType projectType = (ProjectType)TypeJrb.getSelectedItem();
//		int projectTypeId = projectType.getId();
		
		Student student = new Student(studentUserName, studentPassword, studentId, studentName, sex);
		
		Connection con = null;
		try {
			con = myjdbc.getCon();
			int addNum = studentDao.add(con, student);
			if(addNum==1) {
				JOptionPane.showMessageDialog(null, " 注册成功！");
				resetValue();
				dispose();
			}else {
				JOptionPane.showMessageDialog(null, " 注册失败！");
			}
		}catch(Exception evt){
			evt.printStackTrace();
			JOptionPane.showMessageDialog(null, " 注册失败！");
		}finally {
			try {
				
			}catch(Exception ec) {
				ec.printStackTrace();
			}
		}
	}

	/**
	 * 重置事件处理
	 * @param e
	 */
	private void resetValueActionPerformed(ActionEvent e) {
		this.StudentUserNameTxt.setText("");
		this.passwordTxt.setText("");
		this.StudentIdTxt.setText("");
		this.StudentNameTxt.setText("");
		this.SexTxt.setText("");
		
	}
	/**
	 * 重置方法
	 */
	private void resetValue() {
		this.StudentUserNameTxt.setText("");
		this.passwordTxt.setText("");
		this.StudentIdTxt.setText("");
		this.StudentNameTxt.setText("");
		this.SexTxt.setText("");
		
	}
}
