package nuc.sw.frame;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import nuc.sw.dao.ProjectDao;
import nuc.sw.entity.Project;
import nuc.sw.util.Myjdbc;

import javax.swing.JButton;
import java.awt.Font;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LookProjectFrm extends JInternalFrame {
	private JTable Projecttable;
	
	private Myjdbc myjdbc = new Myjdbc();
	private ProjectDao projectDao = new ProjectDao();

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					SelectProjectFrm frame = new SelectProjectFrm();
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
	public LookProjectFrm() {
		setClosable(true);
		setIconifiable(true);
		setTitle("\u67E5\u770B\u8BFE\u8BBE");
		setBounds(100, 100, 959, 420);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 83, 927, 299);
		getContentPane().add(scrollPane);
		
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
				false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		
		JButton btnNewButton = new JButton("\u67E5\u770B\u8BFE\u8BBE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LookProjectActionPerformed(e);
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.BOLD, 22));
		btnNewButton.setBounds(61, 10, 143, 69);
		getContentPane().add(btnNewButton);
		Projecttable.getColumnModel().getColumn(1).setPreferredWidth(150);
		Projecttable.getColumnModel().getColumn(2).setPreferredWidth(232);
		Projecttable.getColumnModel().getColumn(3).setPreferredWidth(127);
		Projecttable.getColumnModel().getColumn(4).setPreferredWidth(112);
		Projecttable.getColumnModel().getColumn(5).setPreferredWidth(109);

	}
	private void LookProjectActionPerformed(ActionEvent e) {
		Project project = new Project();
		this.fillTable(project);
		
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
