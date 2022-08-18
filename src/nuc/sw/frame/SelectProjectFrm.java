package nuc.sw.frame;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import nuc.sw.dao.ProjectDao;
import nuc.sw.dao.SelectTypeDao;
import nuc.sw.entity.Project;
import nuc.sw.entity.SelectType;
import nuc.sw.entity.Student;
import nuc.sw.util.LoginUser;
import nuc.sw.util.Myjdbc;
import nuc.sw.util.StringUtil;

import javax.swing.JButton;
import java.awt.Font;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SelectProjectFrm extends JInternalFrame {
	private JTable Projecttable;
	
	private Myjdbc myjdbc = new Myjdbc();
	private ProjectDao projectDao = new ProjectDao();
	private SelectTypeDao selectTypeDao = new SelectTypeDao();
	
	
	private JTextField IdTxt;
	private JTextField ProjectNameTxt;
	private JTextField StudentIdTxt;
	private JRadioButton RadioButton2;
	private JRadioButton RadioButton1;
	private final ButtonGroup buttonGroup = new ButtonGroup();

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
	public SelectProjectFrm() {
		setClosable(true);
		setIconifiable(true);
		setTitle("\u9009\u62E9\u8BFE\u8BBE");
		setBounds(100, 100, 960, 659);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 83, 927, 287);
		getContentPane().add(scrollPane);
		
		Projecttable = new JTable();
		Projecttable.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				ProjecttableMousePressed(e);
				
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
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "\u8868\u5355\u64CD\u4F5C", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 380, 928, 242);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u8BFE\u9898\u7F16\u53F7\uFF1A");
		lblNewLabel.setFont(new Font("宋体", Font.BOLD, 16));
		lblNewLabel.setBounds(52, 29, 93, 40);
		panel.add(lblNewLabel);
		
		IdTxt = new JTextField();
		IdTxt.setEditable(false);
		IdTxt.setBounds(155, 39, 58, 24);
		panel.add(IdTxt);
		IdTxt.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\u8BFE\u9898\u540D\u79F0\uFF1A");
		lblNewLabel_1.setFont(new Font("宋体", Font.BOLD, 16));
		lblNewLabel_1.setBounds(279, 33, 92, 32);
		panel.add(lblNewLabel_1);
		
		ProjectNameTxt = new JTextField();
		ProjectNameTxt.setEditable(false);
		ProjectNameTxt.setBounds(381, 37, 153, 28);
		panel.add(ProjectNameTxt);
		ProjectNameTxt.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("\u5B66\u751F\u5B66\u53F7\uFF1A");
		lblNewLabel_2.setFont(new Font("宋体", Font.BOLD, 16));
		lblNewLabel_2.setBounds(604, 33, 93, 32);
		panel.add(lblNewLabel_2);
		
		StudentIdTxt = new JTextField();
		StudentIdTxt.setEditable(false);
		StudentIdTxt.setBounds(707, 37, 153, 28);
		panel.add(StudentIdTxt);
		StudentIdTxt.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("\u786E\u8BA4\u9009\u62E9");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SelectActionPerformed(e);
			}
		});
		btnNewButton_1.setFont(new Font("宋体", Font.BOLD, 17));
		btnNewButton_1.setBounds(52, 144, 135, 51);
		panel.add(btnNewButton_1);
		
		RadioButton1 = new JRadioButton("\u672A\u9009\u62E9");
		RadioButton1.setFont(new Font("宋体", Font.BOLD, 15));
		buttonGroup.add(RadioButton1);
		RadioButton1.setSelected(true);
		RadioButton1.setBounds(52, 97, 93, 23);
		panel.add(RadioButton1);
		
		RadioButton2 = new JRadioButton("\u5DF2\u9009\u62E9");
		RadioButton2.setFont(new Font("宋体", Font.BOLD, 16));
		buttonGroup.add(RadioButton2);
		RadioButton2.setBounds(149, 96, 104, 23);
		panel.add(RadioButton2);
		Projecttable.getColumnModel().getColumn(1).setPreferredWidth(150);
		Projecttable.getColumnModel().getColumn(2).setPreferredWidth(232);
		Projecttable.getColumnModel().getColumn(3).setPreferredWidth(127);
		Projecttable.getColumnModel().getColumn(4).setPreferredWidth(112);
		Projecttable.getColumnModel().getColumn(5).setPreferredWidth(109);

	}
	/**
	 * 选择事件处理
	 * @param e
	 */
	private void SelectActionPerformed(ActionEvent e) {
		String studentId = this.StudentIdTxt.getText();
		String projectName = this.ProjectNameTxt.getText();
		String projectId = this.IdTxt.getText();
		
		String state = "";
		if(RadioButton1.isSelected()) {
			state = "未选择";
		}else if(RadioButton2.isSelected()) {
			state = "已选择";
		}
			
		
		
		SelectType selectType = new SelectType(studentId, projectId, projectName, state);
		
		Connection con = null;
		try {
			con = myjdbc.getCon();
			int addNum = selectTypeDao.add(con, selectType);
			if(addNum == 1) {
				JOptionPane.showMessageDialog(null, " 选择成功！");
				resetValue();
				return;
			}else {
				JOptionPane.showMessageDialog(null, " 选择失败！");
			}
		}catch(Exception ev){
			ev.printStackTrace();
			JOptionPane.showMessageDialog(null, " 选择失败！");
		}finally {
			try {
				myjdbc.closeCon(con);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
	}
	private void resetValue() {
		this.IdTxt.setText("");
		this.StudentIdTxt.setText("");
		this.ProjectNameTxt.setText("");
		this.RadioButton1.setSelected(true);
		
	}
	/**
	 * 表格行点击事件
	 * @param e
	 */
	private void ProjecttableMousePressed(MouseEvent e) {
		int row = this.Projecttable.getSelectedRow();
		this.IdTxt.setText((String)Projecttable.getValueAt(row, 0));
		this.ProjectNameTxt.setText((String)Projecttable.getValueAt(row, 1));
		this.StudentIdTxt.setText(LoginUser.student.getStudentUserName());
		
	}
	/**
	 * 查询事件处理
	 * @param e
	 */
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
