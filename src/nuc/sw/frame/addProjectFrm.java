package nuc.sw.frame;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import nuc.sw.dao.ProjectDao;
import nuc.sw.dao.ProjectSelfDao;
import nuc.sw.dao.ProjectTypeDao;
import nuc.sw.entity.Project;
import nuc.sw.entity.ProjectSelf;
import nuc.sw.entity.ProjectType;
import nuc.sw.util.Myjdbc;
import nuc.sw.util.StringUtil;

import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class addProjectFrm extends JInternalFrame {
	private JTextField ProjectNameTxt;
	private JTextField TeacherNameTxt;
	private JTextField TeacherPhoneTxt;
	private JComboBox TypeJrb;
	private JTextArea ProjectSummaryTxt;
	
	private Myjdbc myjdbc = new Myjdbc();
	private ProjectTypeDao projectTypeDao = new ProjectTypeDao();
	private ProjectDao projectDao = new ProjectDao();

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					addProjectFrm frame = new addProjectFrm();
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
	public addProjectFrm() {
		setClosable(true);
		setIconifiable(true);
		setTitle("\u53D1\u5E03\u6BD5\u8BBE\u9898\u76EE");
		setBounds(100, 100, 668, 607);
		getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("\u53D1\u5E03");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addProjectActionPreformed(e);
			}
		});
		btnNewButton.setFont(new Font("幼圆", Font.BOLD, 25));
		btnNewButton.setBounds(92, 490, 125, 57);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u91CD\u7F6E");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetValueActionPreformed(e);
			}
		});
		btnNewButton_1.setFont(new Font("幼圆", Font.BOLD, 25));
		btnNewButton_1.setBounds(455, 490, 125, 57);
		getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("\u8BFE\u9898\u540D\u79F0\uFF1A");
		lblNewLabel.setFont(new Font("宋体", Font.BOLD, 20));
		lblNewLabel.setBounds(58, 44, 104, 31);
		getContentPane().add(lblNewLabel);
		
		ProjectNameTxt = new JTextField();
		ProjectNameTxt.setBounds(172, 46, 178, 29);
		getContentPane().add(ProjectNameTxt);
		ProjectNameTxt.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\u6559\u5E08\u59D3\u540D\uFF1A");
		lblNewLabel_1.setFont(new Font("宋体", Font.BOLD, 20));
		lblNewLabel_1.setBounds(58, 90, 104, 31);
		getContentPane().add(lblNewLabel_1);
		
		TeacherNameTxt = new JTextField();
		TeacherNameTxt.setBounds(172, 92, 125, 31);
		getContentPane().add(TeacherNameTxt);
		TeacherNameTxt.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("\u8BFE\u9898\u7C7B\u578B\uFF1A");
		lblNewLabel_2.setFont(new Font("宋体", Font.BOLD, 20));
		lblNewLabel_2.setBounds(58, 193, 104, 31);
		getContentPane().add(lblNewLabel_2);
		
		TypeJrb = new JComboBox();
		TypeJrb.setBounds(173, 193, 141, 29);
		getContentPane().add(TypeJrb);
		
		JLabel lblNewLabel_3 = new JLabel("\u6559\u5E08\u7535\u8BDD\uFF1A");
		lblNewLabel_3.setFont(new Font("宋体", Font.BOLD, 20));
		lblNewLabel_3.setBounds(58, 141, 104, 28);
		getContentPane().add(lblNewLabel_3);
		
		TeacherPhoneTxt = new JTextField();
		TeacherPhoneTxt.setBounds(172, 142, 125, 31);
		getContentPane().add(TeacherPhoneTxt);
		TeacherPhoneTxt.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("\u8BFE\u9898\u4ECB\u7ECD\uFF1A");
		lblNewLabel_4.setFont(new Font("宋体", Font.BOLD, 20));
		lblNewLabel_4.setBounds(58, 244, 104, 31);
		getContentPane().add(lblNewLabel_4);
		
		ProjectSummaryTxt = new JTextArea();
		ProjectSummaryTxt.setBounds(172, 250, 408, 213);
		getContentPane().add(ProjectSummaryTxt);
		ProjectSummaryTxt.setBorder(new LineBorder(new java.awt.Color(127,157,185),1,false));
		this.fillProjectType();

	}
	/**
	 * 发布事件处理
	 * @param e
	 */
	private void addProjectActionPreformed(ActionEvent e) {
		String projectName = this.ProjectNameTxt.getText();
		String teacherName = this.TeacherNameTxt.getText();
		String teacherPhone = this.TeacherPhoneTxt.getText();
		String summary = this.ProjectSummaryTxt.getText();		
		
		if(StringUtil.isEmpty(projectName)) {
			JOptionPane.showMessageDialog(null, "课题名称不能为空！");
			return;
		}
		if(StringUtil.isEmpty(teacherName)) {
			JOptionPane.showMessageDialog(null, "教师姓名不能为空！");
			return;
		}
		if(StringUtil.isEmpty(teacherPhone)) {
			JOptionPane.showMessageDialog(null, "教师电话不能为空！");
			return;
		}
		if(StringUtil.isEmpty(summary)) {
			JOptionPane.showMessageDialog(null, "课题介绍不能为空！");
			return;
		}
		
		
		ProjectType projectType = (ProjectType)TypeJrb.getSelectedItem();
		int projectTypeId = projectType.getId();
		
		Project project = new Project(projectName, summary, projectTypeId, teacherName, teacherPhone);
		
		Connection con = null;
		try {
			con = myjdbc.getCon();
			int addNum = projectDao.add(con, project);
			if(addNum==1) {
				JOptionPane.showMessageDialog(null, " 发布成功！");
				resetValue();
			}else {
				JOptionPane.showMessageDialog(null, " 发布失败！");
			}
		}catch(Exception evt){
			evt.printStackTrace();
			JOptionPane.showMessageDialog(null, " 发布失败！");
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
	private void resetValueActionPreformed(ActionEvent e) {
		this.resetValue();
	}

	
/**
 * 初始化下拉框
 */
 private void fillProjectType() {
	Connection con = null;
	ProjectType projectType = null;	
	try {
		con = myjdbc.getCon();
		ResultSet rs = projectTypeDao.list(con,new ProjectType());
		while(rs.next()) {
			projectType = new ProjectType();
			projectType.setId(rs.getInt("ProjectTypeId"));
			projectType.setProjectTypeName(rs.getString("ProjectTypeName"));
			this.TypeJrb.addItem(projectType);
		}
	}catch(Exception e) {
		e.printStackTrace();
	}
}
 
 /**
	 * 重置方法
	 */
	private void resetValue() {
		this.ProjectNameTxt.setText("");
		this.TeacherNameTxt.setText("");
		this.TeacherPhoneTxt.setText("");
		this.ProjectSummaryTxt.setText("");
		if(this.TypeJrb.getItemCount()>0) {
			this.TypeJrb.setSelectedIndex(0);
		}
		
	}
}