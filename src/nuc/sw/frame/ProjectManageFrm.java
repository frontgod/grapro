package nuc.sw.frame;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import nuc.sw.dao.ProjectDao;
import nuc.sw.dao.ProjectTypeDao;
import nuc.sw.entity.Project;
import nuc.sw.entity.ProjectSelf;
import nuc.sw.entity.ProjectType;
import nuc.sw.util.Myjdbc;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ProjectManageFrm extends JInternalFrame {
	private JTable Projecttable;
	private JTextField ProjectNameTxt;
	private JTextField TeacherNameTxt;
	private JComboBox TypeJcb;
	
	
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
	public ProjectManageFrm() {
		setTitle("\u67E5\u8BE2\u6BD5\u8BBE\u9898\u76EE");
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 808, 477);
		
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
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(29)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 741, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 658, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblNewLabel))
					.addContainerGap(14, Short.MAX_VALUE))
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
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 303, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(64, Short.MAX_VALUE))
		);
		
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
		this.fillTable(new Project());

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
