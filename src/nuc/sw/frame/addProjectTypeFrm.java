package nuc.sw.frame;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import nuc.sw.dao.ProjectTypeDao;
import nuc.sw.entity.ProjectType;
import nuc.sw.util.Myjdbc;
import nuc.sw.util.StringUtil;

public class addProjectTypeFrm extends JInternalFrame {
	private JTextField ProjectNameTypeTxt;
	private JTextArea ProjectTypeDecoTxt;
	private Myjdbc myjdbc = new Myjdbc();
	private ProjectTypeDao projectTypeDao = new ProjectTypeDao();

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					addProjectTypeFrm frame = new addProjectTypeFrm();
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
	public addProjectTypeFrm() {
		setClosable(true);
		setIconifiable(true);
		setTitle("\u6DFB\u52A0\u6BD5\u8BBE\u7C7B\u578B");
		setBounds(100, 100, 672, 416);
		
		JLabel lblNewLabel = new JLabel("\u6BD5\u8BBE\u7C7B\u578B\u540D\u79F0\uFF1A");
		lblNewLabel.setBounds(87, 62, 146, 32);
		lblNewLabel.setFont(new Font("宋体", Font.BOLD, 20));
		
		JLabel lblNewLabel_1 = new JLabel("\u6BD5\u8BBE\u7C7B\u578B\u63CF\u8FF0\uFF1A");
		lblNewLabel_1.setBounds(87, 127, 146, 24);
		lblNewLabel_1.setFont(new Font("宋体", Font.BOLD, 20));
		getContentPane().setLayout(null);
		getContentPane().add(lblNewLabel);
		getContentPane().add(lblNewLabel_1);
		
		ProjectNameTypeTxt = new JTextField();
		ProjectNameTypeTxt.setBounds(243, 65, 284, 32);
		getContentPane().add(ProjectNameTypeTxt);
		ProjectNameTypeTxt.setColumns(10);
		
		ProjectTypeDecoTxt = new JTextArea();
		ProjectTypeDecoTxt.setBounds(243, 130, 284, 119);
		getContentPane().add(ProjectTypeDecoTxt);
		ProjectTypeDecoTxt.setBorder(new LineBorder(new java.awt.Color(127,157,185),1,false));
		
		JButton btnNewButton = new JButton("\u6DFB\u52A0");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addProjectTypeActionPerformed(e);
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.BOLD, 20));
		btnNewButton.setBounds(87, 284, 146, 41);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u91CD\u7F6E");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetValueActionPerformed(e);
			}
		});
		btnNewButton_1.setFont(new Font("宋体", Font.BOLD, 20));
		btnNewButton_1.setBounds(412, 284, 146, 41);
		getContentPane().add(btnNewButton_1);

	}
	/**
	 * 毕设类别添加处理
	 * @param e
	 */
	private void addProjectTypeActionPerformed(ActionEvent e) {
		String ProjectTypeName = this.ProjectNameTypeTxt.getText();
		String ProjectTypeDeco = this.ProjectTypeDecoTxt.getText();
		if(StringUtil.isEmpty(ProjectTypeName)) {
			JOptionPane.showMessageDialog(null, "毕设类别名称不能为空！");
			return;
		}
		ProjectType projectType = new ProjectType(ProjectTypeName,ProjectTypeDeco);
		Connection con = null;
		try {
			con = myjdbc.getCon();
			int n = projectTypeDao.add(con, projectType);
			if(n==1) {
				JOptionPane.showMessageDialog(null, "毕设类型添加成功！");
				restValue();
			}else {
				JOptionPane.showMessageDialog(null, "毕设类型添加失败！");
			}
		}catch(Exception evt){
			evt.printStackTrace();
			JOptionPane.showMessageDialog(null, "毕设类型添加失败！");	
		}finally {
			try {
				myjdbc.closeCon(con);
			} catch (Exception e1) {
				
				e1.printStackTrace();
			}
		}
		
		
	}
	/**
	 * 重置事件处理
	 * @param e
	 */
	private void resetValueActionPerformed(ActionEvent e) {
		this.ProjectNameTypeTxt.setText("");
		this.ProjectTypeDecoTxt.setText("");
	}

	private void restValue() {
		this.ProjectNameTypeTxt.setText("");
		this.ProjectTypeDecoTxt.setText("");
	}
		
	
}
