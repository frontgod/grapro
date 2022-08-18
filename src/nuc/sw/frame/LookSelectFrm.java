package nuc.sw.frame;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import nuc.sw.dao.SelectTypeDao;
import nuc.sw.entity.Project;
import nuc.sw.entity.SelectType;
import nuc.sw.util.LoginUser;
import nuc.sw.util.Myjdbc;
import nuc.sw.util.StringUtil;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LookSelectFrm extends JInternalFrame {
	private JTable selecttable;
	
	
	private Myjdbc myjdbc = new Myjdbc();
	private SelectTypeDao selectTypeDao = new SelectTypeDao();

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					LookSelectFrm frame = new LookSelectFrm();
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
	public LookSelectFrm() {
		setTitle("\u67E5\u770B\u9009\u8BFE\u72B6\u6001");
		setClosable(true);
		setIconifiable(true);
		setBounds(100, 100, 636, 285);
		getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("\u67E5\u8BE2");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SearchActionPreformed(e);
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.BOLD, 30));
		btnNewButton.setBounds(23, 170, 129, 54);
		getContentPane().add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(23, 20, 575, 128);
		getContentPane().add(scrollPane);
		
		selecttable = new JTable();
		scrollPane.setViewportView(selecttable);
		selecttable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u5B66\u53F7", "\u8BFE\u9898\u7F16\u53F7", "\u8BFE\u9898\u540D\u79F0", "\u9009\u62E9\u72B6\u6001"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		selecttable.getColumnModel().getColumn(0).setPreferredWidth(91);
		selecttable.getColumnModel().getColumn(1).setPreferredWidth(70);
		selecttable.getColumnModel().getColumn(2).setPreferredWidth(127);
		selecttable.getColumnModel().getColumn(3).setPreferredWidth(88);
		
	}
	/**
	 * 查询事件处理
	 * @param e
	 */
	private void SearchActionPreformed(ActionEvent e) {
		String studentId = LoginUser.student.getStudentId();
		
		SelectType selectType = new SelectType(studentId);
		this.fillTable(new SelectType());
		
		
	}
	/**
	 * 初始化表格数据
	 */
	private void fillTable(SelectType selectType) {
		DefaultTableModel dtm = (DefaultTableModel) selecttable.getModel();
		dtm.setRowCount(0);
		Connection con = null;
		try {
			con = myjdbc.getCon();
			ResultSet rs = selectTypeDao.list(con, selectType);
			while(rs.next()) {
				Vector v = new Vector();
				v.add(rs.getString("StudentId"));
				v.add(rs.getString("ProjectId"));
				v.add(rs.getString("ProjectName"));
				v.add(rs.getString("state"));
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
