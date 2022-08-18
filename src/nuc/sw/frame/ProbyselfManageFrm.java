package nuc.sw.frame;

import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import nuc.sw.dao.ProjectSelfDao;
import nuc.sw.dao.ProjectTypeDao;
import nuc.sw.entity.ProjectSelf;
import nuc.sw.entity.ProjectType;
import nuc.sw.util.Myjdbc;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ProbyselfManageFrm extends JInternalFrame {
	private JTable ProjectSelftable;
	private JTextField s_ProjectSelfNameTxt;
	private JTextField s_StudentIdTxt;
	private JComboBox s_ProjectSelfJcb;
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
//					ProbyselfManageFrm frame = new ProbyselfManageFrm();
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
	public ProbyselfManageFrm() {
		setClosable(true);
		setIconifiable(true);
		setTitle("\u67E5\u8BE2\u81EA\u62DF\u9898\u76EE");
		setBounds(100, 100, 837, 433);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 118, 807, 263);
		getContentPane().add(scrollPane);
		
		ProjectSelftable = new JTable();
		scrollPane.setViewportView(ProjectSelftable);
		ProjectSelftable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u7F16\u53F7", "\u81EA\u62DF\u8BFE\u9898\u540D\u79F0", "\u8BFE\u9898\u4ECB\u7ECD", "\u8BFE\u9898\u7C7B\u522B", "\u7EC4\u957F\u5B66\u53F7"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		ProjectSelftable.getColumnModel().getColumn(0).setPreferredWidth(54);
		ProjectSelftable.getColumnModel().getColumn(1).setPreferredWidth(119);
		ProjectSelftable.getColumnModel().getColumn(2).setPreferredWidth(245);
		ProjectSelftable.getColumnModel().getColumn(3).setPreferredWidth(88);
		ProjectSelftable.setFont(new Font("宋体", Font.PLAIN, 12));
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 37, 710, 56);
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		getContentPane().add(panel);
		
		JLabel lblNewLabel = new JLabel("\u81EA\u62DF\u8BFE\u9898\u540D\u79F0\uFF1A");
		lblNewLabel.setFont(new Font("宋体", Font.BOLD, 15));
		
		s_ProjectSelfNameTxt = new JTextField();
		s_ProjectSelfNameTxt.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\u7EC4\u957F\u5B66\u53F7\uFF1A");
		lblNewLabel_1.setFont(new Font("宋体", Font.BOLD, 15));
		
		s_StudentIdTxt = new JTextField();
		s_StudentIdTxt.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("\u8BFE\u9898\u7C7B\u522B\uFF1A");
		lblNewLabel_2.setFont(new Font("宋体", Font.BOLD, 15));
		
		s_ProjectSelfJcb = new JComboBox();
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(s_ProjectSelfNameTxt, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel_1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(s_StudentIdTxt, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(s_ProjectSelfJcb, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
					.addGap(50))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(s_ProjectSelfNameTxt, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1)
						.addComponent(s_StudentIdTxt, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
						.addComponent(s_ProjectSelfJcb, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
					.addGap(19))
		);
		panel.setLayout(gl_panel);
		
		JButton btnNewButton = new JButton("\u67E5\u8BE2");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				projectSelfSearchActionPreformed(e);
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.BOLD, 18));
		btnNewButton.setBounds(745, 46, 72, 36);
		getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_3 = new JLabel("\u641C\u7D22\u6761\u4EF6\uFF1A");
		lblNewLabel_3.setFont(new Font("华文隶书", Font.BOLD, 20));
		lblNewLabel_3.setBounds(10, 10, 120, 32);
		getContentPane().add(lblNewLabel_3);
		
		
		this.fillProjectSelfType("search");
		this.fillTable(new ProjectSelf());
	}
	/**
	 * 查询事件处理
	 * @param e
	 */
	private void projectSelfSearchActionPreformed(ActionEvent evt) {
		String projectSelfName = this.s_ProjectSelfNameTxt.getText();
		String studentId = this.s_StudentIdTxt.getText();
		ProjectType projectType = (ProjectType)this.s_ProjectSelfJcb.getSelectedItem();
		int projectTypeId = projectType.getId();
		
		ProjectSelf projectSelf = new ProjectSelf(projectSelfName, projectTypeId, studentId);
		this.fillTable(projectSelf);
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
				this.s_ProjectSelfJcb.addItem(projectType);
			}
			while(rs.next()) {
				projectType = new ProjectType();
				projectType.setProjectTypeName(rs.getString("projectTypeName"));
				projectType.setId(rs.getInt("ProjectTypeId"));
				if("search".equals(type)) {
					this.s_ProjectSelfJcb.addItem(projectType);
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
	private void fillTable(ProjectSelf projectSelf) {
		DefaultTableModel dtm = (DefaultTableModel) ProjectSelftable.getModel();
		dtm.setRowCount(0);
		Connection con = null;
		try {
			con = myjdbc.getCon();
			ResultSet rs = projectSelfDao.list(con, projectSelf);
			while(rs.next()) {
				Vector v = new Vector();
				v.add(rs.getString("Id"));
				v.add(rs.getString("ProjectSelfName"));
				v.add(rs.getString("Summary"));
				v.add(rs.getString("ProjectTypeName"));
				v.add(rs.getString("StudentId"));
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
