package nuc.sw.frame;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import nuc.sw.dao.TeacherDao;

import nuc.sw.entity.Teacher;
import nuc.sw.util.Myjdbc;
import nuc.sw.util.StringUtil;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.awt.event.ActionEvent;

public class ZhuceTeacherFrm extends JFrame {

	private JPanel contentPane;
	private JTextField TeacherNameTxt;
	private JTextField SexTxt;
	private JTextField passWordTxt;
	private JTextField PhoneTxt;
	private JTextField TeacherUserNameTxt;
	
	private Myjdbc myjdbc = new Myjdbc();
	private TeacherDao teacherDao = new TeacherDao();
	private JTextField TeacherIdTxt;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					ZhuceTeacherFrm frame = new ZhuceTeacherFrm();
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
	public ZhuceTeacherFrm() {
		setTitle("\u6559\u5E08\u6CE8\u518C\u754C\u9762");
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 460, 556);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u6559\u5E08\u6CE8\u518C\u754C\u9762");
		lblNewLabel.setFont(new Font("微软雅黑", Font.BOLD, 35));
		lblNewLabel.setIcon(new ImageIcon(ZhuceTeacherFrm.class.getResource("/images/Teachers_64px_1185977_easyicon.net.png")));
		lblNewLabel.setBounds(88, 20, 280, 64);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u6559\u5E08\u8D26\u53F7\uFF1A");
		lblNewLabel_1.setFont(new Font("宋体", Font.BOLD, 16));
		lblNewLabel_1.setBounds(67, 108, 84, 26);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u767B\u5F55\u5BC6\u7801\uFF1A");
		lblNewLabel_2.setFont(new Font("宋体", Font.BOLD, 16));
		lblNewLabel_2.setBounds(67, 160, 84, 26);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("\u6559\u5E08\u59D3\u540D\uFF1A");
		lblNewLabel_3.setFont(new Font("宋体", Font.BOLD, 16));
		lblNewLabel_3.setBounds(69, 254, 84, 26);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("   \u6027\u522B\uFF1A");
		lblNewLabel_4.setFont(new Font("宋体", Font.BOLD, 16));
		lblNewLabel_4.setBounds(66, 305, 86, 26);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("   \u7535\u8BDD\uFF1A");
		lblNewLabel_5.setFont(new Font("宋体", Font.BOLD, 16));
		lblNewLabel_5.setBounds(67, 359, 84, 26);
		contentPane.add(lblNewLabel_5);
		
		TeacherNameTxt = new JTextField();
		TeacherNameTxt.setBounds(179, 255, 171, 28);
		contentPane.add(TeacherNameTxt);
		TeacherNameTxt.setColumns(10);
		
		SexTxt = new JTextField();
		SexTxt.setBounds(179, 306, 123, 26);
		contentPane.add(SexTxt);
		SexTxt.setColumns(10);
		
		passWordTxt = new JTextField();
		passWordTxt.setBounds(177, 162, 216, 26);
		contentPane.add(passWordTxt);
		passWordTxt.setColumns(10);
		
		PhoneTxt = new JTextField();
		PhoneTxt.setBounds(180, 362, 123, 26);
		contentPane.add(PhoneTxt);
		PhoneTxt.setColumns(10);
		
		TeacherUserNameTxt = new JTextField();
		TeacherUserNameTxt.setBounds(177, 110, 216, 26);
		contentPane.add(TeacherUserNameTxt);
		TeacherUserNameTxt.setColumns(10);
		
		JButton btnNewButton = new JButton("\u91CD\u7F6E");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetValueActionPerformed(e);
			}
		});
		btnNewButton.setFont(new Font("幼圆", Font.BOLD, 30));
		btnNewButton.setBounds(277, 434, 132, 50);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u6CE8\u518C");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ZhuceTeacherActionPerformed(e);
			}
		});
		btnNewButton_1.setFont(new Font("幼圆", Font.BOLD, 30));
		btnNewButton_1.setBounds(42, 435, 132, 50);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_6 = new JLabel("\u6559\u5E08\u5DE5\u53F7\uFF1A");
		lblNewLabel_6.setFont(new Font("宋体", Font.BOLD, 16));
		lblNewLabel_6.setBounds(67, 207, 84, 28);
		contentPane.add(lblNewLabel_6);
		
		TeacherIdTxt = new JTextField();
		TeacherIdTxt.setBounds(179, 210, 171, 26);
		contentPane.add(TeacherIdTxt);
		TeacherIdTxt.setColumns(10);
	}
	/**
	 * 注册事件处理
	 * @param e
	 */
	
	private void ZhuceTeacherActionPerformed(ActionEvent e) {
		String teacherUserName = this.TeacherUserNameTxt.getText();
		String teacherPassword = this.passWordTxt.getText();
		String teacherId =this.TeacherIdTxt.getText();
		String teacherName = this.TeacherNameTxt.getText();
		String sex = this.SexTxt.getText();
		String phone = this.PhoneTxt.getText();
		
		if(StringUtil.isEmpty(teacherUserName)) {
			JOptionPane.showMessageDialog(null, "教师账号不能为空！");
			return;
		}
		if(StringUtil.isEmpty(teacherPassword)) {
			JOptionPane.showMessageDialog(null, "登陆密码不能为空！");
			return;
		}
		if(StringUtil.isEmpty(teacherId)) {
			JOptionPane.showMessageDialog(null, "教师工号不能为空！");
			return;
		}
		if(StringUtil.isEmpty(teacherName)) {
			JOptionPane.showMessageDialog(null, "教师姓名不能为空！");
			return;
		}
		if(StringUtil.isEmpty(sex)) {
			JOptionPane.showMessageDialog(null, "性别不能为空！");
			return;
		}
		if(StringUtil.isEmpty(phone)) {
			JOptionPane.showMessageDialog(null, "电话不能为空！");
			return;
		}
		
		Teacher teacher = new Teacher(teacherUserName, teacherPassword, teacherId, teacherName, sex,
				phone);
		
		Connection con = null;
		try {
			con = myjdbc.getCon();
			int addNum = teacherDao.add(con, teacher);
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
	 * 重置方法
	 */
	private void resetValue() {
		this.TeacherUserNameTxt.setText("");
		this.passWordTxt.setText("");
		this.TeacherNameTxt.setText("");
		this.SexTxt.setText("");
		this.PhoneTxt.setText("");
		
	}

	/**
	 * 重置事件处理
	 * @param e
	 */
	private void resetValueActionPerformed(ActionEvent e) {
		this.TeacherUserNameTxt.setText("");
		this.passWordTxt.setText("");
		this.TeacherNameTxt.setText("");
		this.SexTxt.setText("");
		this.PhoneTxt.setText("");
		
	}
}
