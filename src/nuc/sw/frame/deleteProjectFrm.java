package nuc.sw.frame;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import nuc.sw.dao.ProjectDao;
import nuc.sw.entity.Project;
import nuc.sw.entity.ProjectType;
import nuc.sw.util.Myjdbc;
import nuc.sw.util.StringUtil;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class deleteProjectFrm extends JInternalFrame {
	private JTable projecttable;
	
	private Myjdbc myjdbc = new Myjdbc();
	private ProjectDao projectDao = new ProjectDao();

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					deleteProjectFrm frame = new deleteProjectFrm();
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
	public deleteProjectFrm() {
		setTitle("\u8BFE\u9898\u7684\u5220\u9664");
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 820, 425);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 793, 293);
		getContentPane().add(scrollPane);
		
		projecttable = new JTable();
		projecttable.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				deleteProjectMousePressed(e);
			}
		});
		scrollPane.setViewportView(projecttable);
		projecttable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u7F16\u53F7", "\u8BFE\u9898\u540D\u79F0", "\u8BFE\u9898\u4ECB\u7ECD", "\u8BFE\u9898\u7C7B\u522B", "\u6307\u5BFC\u6559\u5E08", "\u6559\u5E08\u7535\u8BDD"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		
		JButton btnNewButton = new JButton("\u5220\u9664");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteProjectActionPerformed(e);
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.BOLD, 25));
		btnNewButton.setBounds(26, 323, 130, 49);
		getContentPane().add(btnNewButton);
		projecttable.getColumnModel().getColumn(0).setPreferredWidth(73);
		projecttable.getColumnModel().getColumn(1).setPreferredWidth(103);
		projecttable.getColumnModel().getColumn(2).setPreferredWidth(209);
		projecttable.getColumnModel().getColumn(3).setPreferredWidth(139);
		projecttable.getColumnModel().getColumn(4).setPreferredWidth(109);
		projecttable.getColumnModel().getColumn(5).setPreferredWidth(137);
		
		this.fillTable(new Project());

	}
	/**
	 * 删除事件处理
	 * @param e
	 */
	private void deleteProjectActionPerformed(ActionEvent e) {
		int row = this.projecttable.getSelectedRow();
		String id = (String)projecttable.getValueAt(row, 0);
		if(StringUtil.isEmpty(id)) {
			JOptionPane.showMessageDialog(null, "请选择要删除的课程。");
			return;
		}
		int n = JOptionPane.showConfirmDialog(null, "确实要删除该课程吗？");
		if(n == 0) {
			Connection con = null;
			try {
				con = myjdbc.getCon();
				int deleteNum = projectDao.delete(con, id);
				if(deleteNum==1) {
					JOptionPane.showMessageDialog(null, " 删除成功！");
					this.fillTable(new Project());
				}else {
					JOptionPane.showMessageDialog(null, " 删除失败！");
				}
			}catch(Exception ev) {
				ev.printStackTrace();
				JOptionPane.showMessageDialog(null, " 删除失败！");
			}finally {
				try {
					myjdbc.closeCon(con);
				}catch(Exception evt){
					evt.printStackTrace();
				}
			}
		}
	}
	/**
	 * 行点击事件处理
	 * @param e
	 */
	private void deleteProjectMousePressed(MouseEvent e) {
		int row = this.projecttable.getSelectedRow();
		
	}
	/**
	 * 初始化表格数据
	 */
	private void fillTable(Project project) {
		DefaultTableModel dtm = (DefaultTableModel) projecttable.getModel();
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
