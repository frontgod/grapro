package nuc.sw.frame;

import java.awt.Font;
import java.sql.Connection;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import nuc.sw.dao.ProjectSelfDao;
import nuc.sw.dao.ProjectTypeDao;
import nuc.sw.entity.ProjectSelf;
import nuc.sw.entity.ProjectType;
import nuc.sw.util.Myjdbc;
import nuc.sw.util.StringUtil;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class addProbyselfFrm extends JInternalFrame {
	private JTextField ProjectSelfNameTxt;
	private JTextField StudentIdTxt;
	private JComboBox ProjectSelfTypeJcb;
	private JTextArea SummaryTxt;
	private Myjdbc myjdbc = new Myjdbc();
	private ProjectTypeDao projectTypeDao = new ProjectTypeDao();
	private ProjectSelfDao projectSelfDao = new ProjectSelfDao();

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					addProbyselfFrm frame = new addProbyselfFrm();
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
	public addProbyselfFrm() {
		setClosable(true);
		setIconifiable(true);
		setTitle("\u63D0\u4EA4\u81EA\u62DF\u9898\u76EE");
		setBounds(100, 100, 635, 521);
		getContentPane().setLayout(null);
		
		ProjectSelfNameTxt = new JTextField();
		ProjectSelfNameTxt.setBounds(181, 34, 378, 33);
		getContentPane().add(ProjectSelfNameTxt);
		ProjectSelfNameTxt.setColumns(10);
		
		StudentIdTxt = new JTextField();
		StudentIdTxt.setBounds(181, 82, 186, 33);
		getContentPane().add(StudentIdTxt);
		StudentIdTxt.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("\u8BFE\u9898\u540D\u79F0\uFF1A");
		lblNewLabel.setFont(new Font("宋体", Font.BOLD, 20));
		lblNewLabel.setBounds(67, 40, 104, 27);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u7EC4\u957F\u5B66\u53F7\uFF1A");
		lblNewLabel_1.setFont(new Font("宋体", Font.BOLD, 20));
		lblNewLabel_1.setBounds(67, 83, 104, 27);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u8BFE\u9898\u7C7B\u522B\uFF1A");
		lblNewLabel_2.setFont(new Font("宋体", Font.BOLD, 20));
		lblNewLabel_2.setBounds(67, 140, 104, 27);
		getContentPane().add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("\u63D0\u4EA4");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				projectSelfAddActionPerformed(e);
			}
		});
		btnNewButton.setFont(new Font("华文隶书", Font.BOLD, 25));
		btnNewButton.setBounds(109, 401, 118, 45);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u91CD\u7F6E");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetValueActionPreformed(e);
			}
		});
		btnNewButton_1.setFont(new Font("华文隶书", Font.BOLD, 25));
		btnNewButton_1.setBounds(394, 401, 118, 45);
		getContentPane().add(btnNewButton_1);
		
		ProjectSelfTypeJcb = new JComboBox();
		ProjectSelfTypeJcb.setBounds(181, 134, 163, 33);
		getContentPane().add(ProjectSelfTypeJcb);
		
		JLabel lblNewLabel_3 = new JLabel("\u8BFE\u9898\u4ECB\u7ECD\uFF1A");
		lblNewLabel_3.setFont(new Font("宋体", Font.BOLD, 20));
		lblNewLabel_3.setBounds(67, 189, 104, 27);
		getContentPane().add(lblNewLabel_3);
		
		SummaryTxt = new JTextArea();
		SummaryTxt.setBounds(182, 189, 377, 175);
		getContentPane().add(SummaryTxt);
		
		SummaryTxt.setBorder(new LineBorder(new java.awt.Color(127,157,185),1,false));
		
				
		fillProjectType();

	}
	/**
	 * 重置事件处理
	 * @param e
	 */
	private void resetValueActionPreformed(ActionEvent e) {
		this.resetValue();
		
	}
	/**
	 * 自拟题目添加处理
	 * @param e
	 */
	private void projectSelfAddActionPerformed(ActionEvent e) {
		String projectSelfName = this.ProjectSelfNameTxt.getText();
		String summary = this.SummaryTxt.getText();
		String studentId = this.StudentIdTxt.getText();
				
		
		if(StringUtil.isEmpty(projectSelfName)) {
			JOptionPane.showMessageDialog(null, "课题名称不能为空！");
			return;
		}
		if(StringUtil.isEmpty(summary)) {
			JOptionPane.showMessageDialog(null, "课题介绍不能为空！");
			return;
		}
		if(StringUtil.isEmpty(studentId)) {
			JOptionPane.showMessageDialog(null, "课题介绍不能为空！");
			return;
		}
		
		
		ProjectType projectType = (ProjectType)ProjectSelfTypeJcb.getSelectedItem();
		int ProjectTypeId = projectType.getId();
		
		ProjectSelf projectSelf = new ProjectSelf(projectSelfName, summary, ProjectTypeId, studentId);
		
		Connection con = null;
		try {
			con = myjdbc.getCon();
			int addNum = projectSelfDao.add(con, projectSelf);
			if(addNum==1) {
				JOptionPane.showMessageDialog(null, " 添加成功！");
				resetValue();
			}else {
				JOptionPane.showMessageDialog(null, " 添加失败！");
			}
		}catch(Exception evt){
			evt.printStackTrace();
			JOptionPane.showMessageDialog(null, " 添加失败！");
		}finally {
			try {
				
			}catch(Exception ec) {
				ec.printStackTrace();
			}
		}
	}
	
	
	private void resetValue() {
		this.ProjectSelfNameTxt.setText("");
		this.StudentIdTxt.setText("");
		this.SummaryTxt.setText("");
		if(this.ProjectSelfTypeJcb.getItemCount()>0) {
			this.ProjectSelfTypeJcb.setSelectedIndex(0);
		}
		
	}
	/**
	 * 初始化图书类别下拉框
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
				this.ProjectSelfTypeJcb.addItem(projectType);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
