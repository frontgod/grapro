package nuc.sw.frame;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import nuc.sw.dao.ProjectSelfDao;
import nuc.sw.dao.ProjectTypeDao;
import nuc.sw.entity.ProjectSelf;
import nuc.sw.entity.ProjectType;
import nuc.sw.util.Myjdbc;
import nuc.sw.util.StringUtil;

import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DeleteProjectSelfFrm extends JInternalFrame {
	private JTextField StudentIdTxt;
	private JTable ProjectSelftable;
	private JTextField IdTxt;
	private JTextField SelfNameTxt;
	private JTextField StudentIdTxt2;
	private JTextArea DescTxt;
	private JComboBox Jcb;
	
	
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
//					UpdateProjectSelfFrm frame = new UpdateProjectSelfFrm();
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
	public DeleteProjectSelfFrm() {
		setClosable(true);
		setIconifiable(true);
		setBounds(100, 100, 852, 639);
		
		JLabel lblNewLabel = new JLabel("\u7EC4\u957F\u5B66\u53F7\uFF1A");
		lblNewLabel.setBounds(35, 22, 104, 27);
		lblNewLabel.setFont(new Font("宋体", Font.BOLD, 20));
		
		StudentIdTxt = new JTextField();
		StudentIdTxt.setBounds(145, 20, 167, 29);
		StudentIdTxt.setColumns(10);
		
		JButton btnNewButton = new JButton("\u67E5\u8BE2");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				projectSelfSearchActionPreformed(e);
			}
		});
		btnNewButton.setBounds(352, 11, 97, 41);
		btnNewButton.setFont(new Font("宋体", Font.BOLD, 25));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 62, 819, 194);
		
		ProjectSelftable = new JTable();
		ProjectSelftable.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				ProjectSelftableMousePressed(e);
			}
		});
		scrollPane.setViewportView(ProjectSelftable);
		ProjectSelftable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u7F16\u53F7", "\u81EA\u62DF\u9898\u76EE\u540D\u79F0", "\u8BFE\u9898\u4ECB\u7ECD", "\u8BFE\u9898\u7C7B\u522B", "\u7EC4\u957F\u5B66\u53F7"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		ProjectSelftable.getColumnModel().getColumn(0).setPreferredWidth(113);
		ProjectSelftable.getColumnModel().getColumn(1).setPreferredWidth(157);
		ProjectSelftable.getColumnModel().getColumn(2).setPreferredWidth(259);
		ProjectSelftable.getColumnModel().getColumn(3).setPreferredWidth(144);
		ProjectSelftable.getColumnModel().getColumn(4).setPreferredWidth(144);
		getContentPane().setLayout(null);
		getContentPane().add(lblNewLabel);
		getContentPane().add(StudentIdTxt);
		getContentPane().add(btnNewButton);
		getContentPane().add(scrollPane);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "\u8868\u5355\u64CD\u4F5C", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 276, 820, 326);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("\u7F16\u53F7\uFF1A");
		lblNewLabel_1.setFont(new Font("宋体", Font.BOLD, 16));
		lblNewLabel_1.setBounds(53, 42, 58, 26);
		panel.add(lblNewLabel_1);
		
		IdTxt = new JTextField();
		IdTxt.setEnabled(false);
		IdTxt.setBounds(121, 42, 92, 26);
		panel.add(IdTxt);
		IdTxt.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("\u81EA\u62DF\u9898\u76EE\u540D\u79F0\uFF1A");
		lblNewLabel_2.setFont(new Font("宋体", Font.BOLD, 16));
		lblNewLabel_2.setBounds(255, 42, 122, 26);
		panel.add(lblNewLabel_2);
		
		SelfNameTxt = new JTextField();
		SelfNameTxt.setBounds(377, 42, 136, 26);
		panel.add(SelfNameTxt);
		SelfNameTxt.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("\u8BFE\u9898\u7C7B\u522B\uFF1A");
		lblNewLabel_3.setFont(new Font("宋体", Font.BOLD, 16));
		lblNewLabel_3.setBounds(535, 42, 84, 26);
		panel.add(lblNewLabel_3);
		
		Jcb = new JComboBox();
		Jcb.setBounds(626, 42, 153, 26);
		panel.add(Jcb);
		
		JLabel lblNewLabel_4 = new JLabel("\u7EC4\u957F\u5B66\u53F7\uFF1A");
		lblNewLabel_4.setFont(new Font("宋体", Font.BOLD, 16));
		lblNewLabel_4.setBounds(37, 92, 84, 26);
		panel.add(lblNewLabel_4);
		
		StudentIdTxt2 = new JTextField();
		StudentIdTxt2.setBounds(121, 94, 143, 26);
		panel.add(StudentIdTxt2);
		StudentIdTxt2.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("\u8BFE\u9898\u4ECB\u7ECD\uFF1A");
		lblNewLabel_5.setFont(new Font("宋体", Font.BOLD, 16));
		lblNewLabel_5.setBounds(37, 139, 84, 26);
		panel.add(lblNewLabel_5);
		
		DescTxt = new JTextArea();
		DescTxt.setBounds(121, 142, 658, 91);
		panel.add(DescTxt);
		
		JButton btnNewButton_1 = new JButton("\u5220\u9664");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteProjectSelfActionPerformed(e);
			}
		});
		btnNewButton_1.setFont(new Font("宋体", Font.BOLD, 26));
		btnNewButton_1.setBounds(95, 251, 106, 36);
		panel.add(btnNewButton_1);
		
		DescTxt.setBorder(new LineBorder(new java.awt.Color(127,157,185),1,false));
		
		
		this.fillProjectSelfType("modify");

	}
	/**
	 * 删除事件处理
	 * @param e
	 */
	private void deleteProjectSelfActionPerformed(ActionEvent e) {
		String id = this.IdTxt.getText();
		if(StringUtil.isEmpty(id)) {
			JOptionPane.showMessageDialog(null, "请选择要删除的课题。");
			return;
		}
		
		int n = JOptionPane.showConfirmDialog(null, "确实要删除该课题吗？");
		if(n == 0) {
			Connection con = null;
			try {
				con = myjdbc.getCon();
				int deleteNum = projectSelfDao.delete(con, id);
				if(deleteNum==1) {
					JOptionPane.showMessageDialog(null, " 删除成功！");
					resetValue();
//					this.fillTable(new ProjectSelf());
					String studentId = this.StudentIdTxt.getText();
					ProjectSelf projectSelf = new ProjectSelf(studentId);
					this.fillTable(projectSelf);
				}else {
					JOptionPane.showMessageDialog(null, " 删除失败！");
				}
			}catch(Exception evt){
				evt.printStackTrace();
				JOptionPane.showMessageDialog(null, " 删除失败！");
			}finally {
				try {
					myjdbc.closeCon(con);
				}catch(Exception ec) {
					ec.printStackTrace();
				}
			}
		}
		
		
		
		
	}
	/**
	 * 重置方法
	 */
	private void resetValue() {
		this.IdTxt.setText("");
		this.SelfNameTxt.setText("");
		this.DescTxt.setText("");
		this.StudentIdTxt2.setText("");
		if(this.Jcb.getItemCount()>0) {
			this.Jcb.setSelectedIndex(0);
		}
		
	}
	/**
	 * 表格行点击事件处理
	 * @param e
	 */
	private void ProjectSelftableMousePressed(MouseEvent e) {
		int row = this.ProjectSelftable.getSelectedRow();
		this.IdTxt.setText((String)ProjectSelftable.getValueAt( row, 0));
		this.SelfNameTxt.setText((String)ProjectSelftable.getValueAt(row, 1));
		this.StudentIdTxt2.setText((String)ProjectSelftable.getValueAt(row, 4));
		this.DescTxt.setText((String)ProjectSelftable.getValueAt(row, 2));
		String projectTypeName = (String)this.ProjectSelftable.getValueAt(row, 3);
		int n = this.Jcb.getItemCount();
		for(int i=0;i<n;i++) {
			ProjectType item = (ProjectType)this.Jcb.getItemAt(i);
			if(item.getProjectTypeName().equals(projectTypeName)) {
				this.Jcb.setSelectedIndex(i);
			}
		}
		
	}

	/**
	 * 查询事件处理
	 * @param e
	 */
	private void projectSelfSearchActionPreformed(ActionEvent e) {
		String studentId = this.StudentIdTxt.getText();
		if(StringUtil.isEmpty(studentId)) {
			JOptionPane.showMessageDialog(null, "组长学号不能为空！");
			return;
		}
		ProjectSelf projectSelf = new ProjectSelf(studentId);
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
				this.Jcb.addItem(projectType);
			}
			while(rs.next()) {
				projectType = new ProjectType();
				projectType.setProjectTypeName(rs.getString("projectTypeName"));
				projectType.setId(rs.getInt("ProjectTypeId"));
				if("search".equals(type)) {
					this.Jcb.addItem(projectType);
				}else if("modify".equals(type)){
					this.Jcb.addItem(projectType);
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
