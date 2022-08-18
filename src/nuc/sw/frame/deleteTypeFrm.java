package nuc.sw.frame;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import nuc.sw.dao.ProjectTypeDao;
import nuc.sw.entity.ProjectSelf;
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

public class deleteTypeFrm extends JInternalFrame {
	private JTable Typetable;
	
	
	private Myjdbc myjdbc = new Myjdbc();
	private ProjectTypeDao projectTypeDao = new ProjectTypeDao();

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					deleteTypeFrm frame = new deleteTypeFrm();
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
	public deleteTypeFrm() {
		setIconifiable(true);
		setClosable(true);
		setTitle("\u8BFE\u8BBE\u7C7B\u522B\u7684\u5220\u9664");
		setBounds(100, 100, 760, 373);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 728, 250);
		getContentPane().add(scrollPane);
		
		Typetable = new JTable();
		Typetable.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				deletetypeMousePressed(e);
			}
		});
		scrollPane.setViewportView(Typetable);
		Typetable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u7F16\u53F7", "\u8BFE\u8BBE\u7C7B\u522B\u540D\u79F0", "\u7C7B\u522B\u63CF\u8FF0"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		
		JButton btnNewButton = new JButton("\u5220\u9664");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteTypeActionPerformed(e);
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.BOLD, 20));
		btnNewButton.setBounds(29, 270, 129, 48);
		getContentPane().add(btnNewButton);
		Typetable.getColumnModel().getColumn(1).setPreferredWidth(109);
		Typetable.getColumnModel().getColumn(2).setPreferredWidth(288);
		
		ProjectType projectType = new ProjectType();
		this.fillTable(projectType);
	}

	/**
	 * 删除事件处理
	 * @param e
	 */
	private void deleteTypeActionPerformed(ActionEvent e) {
		int row = this.Typetable.getSelectedRow();
		String id = (String)Typetable.getValueAt(row, 0);
		if(StringUtil.isEmpty(id)) {
			JOptionPane.showMessageDialog(null, "请选择要删除的类型。");
			return;
		}
		int n = JOptionPane.showConfirmDialog(null, "确实要删除该类型吗？");
		if(n == 0) {
			Connection con = null;
			try {
				con = myjdbc.getCon();
				int deleteNum = projectTypeDao.delete(con, id);
				if(deleteNum==1) {
					JOptionPane.showMessageDialog(null, " 删除成功！");
					this.fillTable(new ProjectType());
				}else {
					JOptionPane.showMessageDialog(null, " 删除失败！");
				}
			}catch(Exception ev){
				ev.printStackTrace();
				JOptionPane.showMessageDialog(null, " 删除失败！");
			}finally {
				try {
					myjdbc.closeCon(con);
				}catch(Exception evt) {
					evt.printStackTrace();
				}
				
			
			}
	}
}

	/**
	 * 表格行点击事件处理
	 * @param e
	 */
	private void deletetypeMousePressed(MouseEvent e) {
		int row = this.Typetable.getSelectedRow();
		String id = (String)Typetable.getValueAt(row, 0);
		String projectTypeName = (String)Typetable.getValueAt(row, 1);
		String projectTypeDeco = (String)Typetable.getValueAt(row, 2);
		
	}
	/**
	 * 初始化表格数据
	 */
	private void fillTable(ProjectType projectType) {
		DefaultTableModel dtm = (DefaultTableModel) Typetable.getModel();
		dtm.setRowCount(0);
		Connection con = null;
		try {
			con = myjdbc.getCon();
			ResultSet rs = projectTypeDao.list(con, projectType);
			while(rs.next()) {
				Vector v = new Vector();
				v.add(rs.getString("ProjectTypeId"));
				v.add(rs.getString("ProjectTypeName"));
				v.add(rs.getString("ProjectTypeDeco"));
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
