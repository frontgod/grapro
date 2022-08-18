package nuc.sw.frame;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import nuc.sw.dao.ProjectDao;
import nuc.sw.dao.ProjectTypeDao;
import nuc.sw.entity.Project;
import nuc.sw.entity.ProjectSelf;
import nuc.sw.entity.ProjectType;
import nuc.sw.util.Myjdbc;
import nuc.sw.util.StringUtil;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class UpdateProjectFrm extends JInternalFrame {
	private JTable Projecttable;
	private JTextField ProjectNameTxt;
	private JTextField TeacherNameTxt;
	private JComboBox TypeJcb;
	private JTextArea textArea;
	private JComboBox TypeJcb_1;
	
	
	private Myjdbc myjdbc = new Myjdbc();
	private ProjectTypeDao projectTypeDao = new ProjectTypeDao();
	private ProjectDao projectDao = new ProjectDao();
	private JTextField idTxt;
	private JTextField NameTxt;
	private JTextField TeacherTxt;
	private JTextField PhoneTxt;
	

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					ProjectManageFrm frame = new ProjectManageFrm();
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
	public UpdateProjectFrm() {
		setTitle("\u67E5\u8BE2\u6BD5\u8BBE\u9898\u76EE");
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 808, 767);
		
		JLabel lblNewLabel = new JLabel("\u67E5\u8BE2\u6761\u4EF6\uFF1A");
		lblNewLabel.setFont(new Font("华文隶书", Font.BOLD, 22));
		
		JScrollPane scrollPane = new JScrollPane();
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JButton btnNewButton = new JButton("\u67E5\u8BE2");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				projectSearchActionPreformed(e);
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.BOLD, 18));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "\u8868\u5355\u64CD\u4F5C", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(29)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(panel, GroupLayout.PREFERRED_SIZE, 658, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE))
								.addComponent(lblNewLabel)))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 776, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 776, Short.MAX_VALUE)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(52)
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 277, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 318, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("   \u7F16\u53F7\uFF1A");
		lblNewLabel_4.setFont(new Font("宋体", Font.BOLD, 16));
		lblNewLabel_4.setBounds(51, 41, 90, 23);
		panel_1.add(lblNewLabel_4);
		
		idTxt = new JTextField();
		idTxt.setEditable(false);
		idTxt.setBounds(133, 43, 66, 22);
		panel_1.add(idTxt);
		idTxt.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("\u8BFE\u9898\u540D\u79F0\uFF1A");
		lblNewLabel_5.setFont(new Font("宋体", Font.BOLD, 16));
		lblNewLabel_5.setBounds(238, 42, 84, 20);
		panel_1.add(lblNewLabel_5);
		
		NameTxt = new JTextField();
		NameTxt.setBounds(322, 39, 136, 30);
		panel_1.add(NameTxt);
		NameTxt.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("\u8BFE\u9898\u7C7B\u578B\uFF1A");
		lblNewLabel_6.setFont(new Font("宋体", Font.BOLD, 16));
		lblNewLabel_6.setBounds(498, 41, 84, 22);
		panel_1.add(lblNewLabel_6);
		
		TypeJcb_1 = new JComboBox();
		TypeJcb_1.setBounds(581, 39, 136, 28);
		panel_1.add(TypeJcb_1);
		
		JLabel lblNewLabel_7 = new JLabel("\u6307\u5BFC\u6559\u5E08\uFF1A");
		lblNewLabel_7.setFont(new Font("宋体", Font.BOLD, 16));
		lblNewLabel_7.setBounds(51, 99, 84, 23);
		panel_1.add(lblNewLabel_7);
		
		TeacherTxt = new JTextField();
		TeacherTxt.setBounds(133, 97, 141, 30);
		panel_1.add(TeacherTxt);
		TeacherTxt.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("\u6559\u5E08\u7535\u8BDD\uFF1A");
		lblNewLabel_8.setFont(new Font("宋体", Font.BOLD, 16));
		lblNewLabel_8.setBounds(344, 97, 84, 23);
		panel_1.add(lblNewLabel_8);
		
		PhoneTxt = new JTextField();
		PhoneTxt.setBounds(438, 96, 133, 32);
		panel_1.add(PhoneTxt);
		PhoneTxt.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("\u8BFE\u9898\u4ECB\u7ECD\uFF1A");
		lblNewLabel_9.setFont(new Font("宋体", Font.BOLD, 16));
		lblNewLabel_9.setBounds(51, 152, 84, 19);
		panel_1.add(lblNewLabel_9);
		
		textArea = new JTextArea();
		textArea.setBounds(133, 151, 584, 93);
		panel_1.add(textArea);
		textArea.setBorder(new LineBorder(new java.awt.Color(127,157,185),1,false));
		
		JButton btnNewButton_1 = new JButton("\u4FEE\u6539");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateActionPerformed(e);
				
			}
		});
		btnNewButton_1.setFont(new Font("宋体", Font.BOLD, 25));
		btnNewButton_1.setBounds(62, 254, 97, 43);
		panel_1.add(btnNewButton_1);
		
		JLabel lblNewLabel_1 = new JLabel("\u8BFE\u9898\u540D\u79F0\uFF1A");
		lblNewLabel_1.setFont(new Font("宋体", Font.BOLD, 15));
		
		ProjectNameTxt = new JTextField();
		ProjectNameTxt.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("\u6307\u5BFC\u6559\u5E08\uFF1A");
		lblNewLabel_2.setFont(new Font("宋体", Font.BOLD, 15));
		
		TeacherNameTxt = new JTextField();
		TeacherNameTxt.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("\u6BD5\u8BBE\u7C7B\u578B\uFF1A");
		lblNewLabel_3.setFont(new Font("宋体", Font.BOLD, 15));
		
		TypeJcb = new JComboBox();
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
					.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(ProjectNameTxt, GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel_2)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(TeacherNameTxt, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel_3)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(TypeJcb, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(22)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(TypeJcb, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
						.addComponent(TeacherNameTxt, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						.addComponent(ProjectNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(33, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		Projecttable = new JTable();
		Projecttable.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				selectMousePressed(e);
			}
		});
		scrollPane.setViewportView(Projecttable);
		Projecttable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u7F16\u53F7", "\u8BFE\u9898\u540D\u79F0", "\u8BFE\u9898\u4ECB\u7ECD", "\u8BFE\u9898\u7C7B\u578B", "\u6307\u5BFC\u6559\u5E08", "\u6559\u5E08\u7535\u8BDD"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, true, true, true, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		Projecttable.getColumnModel().getColumn(0).setPreferredWidth(72);
		Projecttable.getColumnModel().getColumn(1).setPreferredWidth(125);
		Projecttable.getColumnModel().getColumn(2).setPreferredWidth(186);
		Projecttable.getColumnModel().getColumn(3).setPreferredWidth(94);
		Projecttable.getColumnModel().getColumn(4).setPreferredWidth(80);
		Projecttable.getColumnModel().getColumn(5).setPreferredWidth(100);
		getContentPane().setLayout(groupLayout);
		
		this.fillProjectSelfType("search");
		this.fillProjectSelfType("modify");
		
		this.fillTable(new Project());

	}
	
	/**
	 * 修改事件处理
	 * @param e
	 */
	private void updateActionPerformed(ActionEvent e) {
		
		String id = this.idTxt.getText();
		if(StringUtil.isEmpty(id)) {
			JOptionPane.showMessageDialog(null, "请选择要修改的课题。");
			return;
		}
		String projectName = this.NameTxt.getText();
		String teacherName = this.TeacherTxt.getText();
		String teacherPhone = this.PhoneTxt.getText();
		String summary = this.textArea.getText();
		
		if(StringUtil.isEmpty(projectName)) {
			JOptionPane.showMessageDialog(null, "课题名称不能为空。");
			return;
		}
		
		if(StringUtil.isEmpty(teacherName)) {
			JOptionPane.showMessageDialog(null, "指导教师不能为空。");
			return;
		}
		
		if(StringUtil.isEmpty(teacherPhone)) {
			JOptionPane.showMessageDialog(null, "教师电话不能为空。");
			return;
		}
		if(StringUtil.isEmpty(summary)) {
			JOptionPane.showMessageDialog(null, "课题介绍不能为空。");
			return;
		}
		
		ProjectType projectType = (ProjectType)this.TypeJcb_1.getSelectedItem();
		int projectTypeId = projectType.getId();
		
		Project project = new Project(Integer.parseInt(id), projectName, summary, projectTypeId, teacherName,
				teacherPhone);
		
		Connection con = null;
		try {
			con = myjdbc.getCon();
			int updateNum = projectDao.update(con, project);
			if(updateNum==1) {
				JOptionPane.showMessageDialog(null, " 修改成功！");
				
				this.fillTable(new Project());
				resetValue();
			}else {
				JOptionPane.showMessageDialog(null, " 修改失败！");
			}
		}catch(Exception evt){
			evt.printStackTrace();
			JOptionPane.showMessageDialog(null, " 修改失败！");
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
		this.idTxt.setText("");
		this.NameTxt.setText("");
		this.PhoneTxt.setText("");
		this.TeacherTxt.setText("");
		this.textArea.setText("");
		if(this.TypeJcb_1.getItemCount()>0) {
			this.TypeJcb_1.setSelectedIndex(0);
		}
		
	}

	/**
	 * 行点击事件处理
	 * @param e
	 */
	private void selectMousePressed(MouseEvent e) {
		int row = this.Projecttable.getSelectedRow();
		this.idTxt.setText((String)Projecttable.getValueAt( row, 0));
		this.NameTxt.setText((String)Projecttable.getValueAt(row, 1));
		this.textArea.setText((String)Projecttable.getValueAt(row, 2));
		this.TeacherTxt.setText((String)Projecttable.getValueAt(row, 4));
		this.PhoneTxt.setText((String)Projecttable.getValueAt(row, 5));
		String projectTypeName = (String)this.Projecttable.getValueAt(row, 3);
		int n = this.TypeJcb_1.getItemCount();
		for(int i=0;i<n;i++) {
			ProjectType item = (ProjectType)this.TypeJcb_1.getItemAt(i);
			if(item.getProjectTypeName().equals(projectTypeName)) {
				this.TypeJcb_1.setSelectedIndex(i);
			}
		}
		
		
	}
	/**
	 * 查询事件处理
	 * @param e
	 */
	private void projectSearchActionPreformed(ActionEvent e) {
		String projectName = this.ProjectNameTxt.getText();
		String teacherName = this.TeacherNameTxt.getText();
		ProjectType projectType = (ProjectType)this.TypeJcb.getSelectedItem();
		int projectTypeId = projectType.getId();
		
		Project project = new Project(projectName, projectTypeId, teacherName);
		this.fillTable(project);
		
	}
	/**
	 * 初始化下拉框类型
	 * @param type
	 */
	private void fillProjectSelfType(String type) {
		Connection con = null;
		ProjectType projectType = null;
		try {
			con=myjdbc.getCon();
			ResultSet rs = projectTypeDao.list(con, new ProjectType());
			if("search".equals(type)) {
				projectType = new ProjectType();
				projectType.setProjectTypeName("全部");
				projectType.setId(-1);
				this.TypeJcb.addItem(projectType);
			}
			while(rs.next()) {
				projectType = new ProjectType();
				projectType.setProjectTypeName(rs.getString("projectTypeName"));
				projectType.setId(rs.getInt("ProjectTypeId"));
				if("search".equals(type)) {
					this.TypeJcb.addItem(projectType);
				}else if("modify".equals(type)){
					this.TypeJcb_1.addItem(projectType);
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				myjdbc.closeCon(con);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	/**
	 * 初始化表格数据
	 */
	private void fillTable(Project project) {
		DefaultTableModel dtm = (DefaultTableModel) Projecttable.getModel();
		dtm.setRowCount(0);
		Connection con = null;
		try {
			con = myjdbc.getCon();
			ResultSet rs = projectDao.list(con, project);
			while(rs.next()) {
				Vector v = new Vector();
				v.add(rs.getString("ProjectId"));
				v.add(rs.getString("ProjectName"));
				v.add(rs.getString("Summary"));
				v.add(rs.getString("ProjectTypeName"));
				v.add(rs.getString("TeacherName"));
				v.add(rs.getString("TeacherPhone"));
				dtm.addRow(v);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				myjdbc.closeCon(con);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
}
