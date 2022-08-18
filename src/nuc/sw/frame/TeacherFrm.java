package nuc.sw.frame;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.JDesktopPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.ImageIcon;

public class TeacherFrm extends JFrame {

	private JPanel contentPane;
	private JDesktopPane table;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					TeacherFrm frame = new TeacherFrm();
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
	public TeacherFrm() {
		setTitle("\u6BD5\u4E1A\u8BBE\u8BA1\u7BA1\u7406\u7CFB\u7EDF\uFF08\u6559\u5E08\u7AEF\uFF09");
		
		setBounds(100, 100, 768, 503);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(Color.WHITE);
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu_2 = new JMenu("\u53D1\u5E03\u6BD5\u8BBE\u9898\u76EE");
		mnNewMenu_2.setIcon(new ImageIcon(TeacherFrm.class.getResource("/images/about.png")));
		mnNewMenu_2.setFont(new Font("宋体", Font.BOLD, 20));
		menuBar.add(mnNewMenu_2);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("\u53D1\u5E03\u6BD5\u8BBE");
		mntmNewMenuItem_2.setIcon(new ImageIcon(TeacherFrm.class.getResource("/images/add.png")));
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addProjectFrm addprojectFrm = new addProjectFrm();
				addprojectFrm.setVisible(true);
				table.add(addprojectFrm);
			}
		});
		mntmNewMenuItem_2.setFont(new Font("宋体", Font.PLAIN, 15));
		mnNewMenu_2.add(mntmNewMenuItem_2);
		
		JMenu mnNewMenu_3 = new JMenu("\u6BD5\u8BBE\u4FE1\u606F\u7BA1\u7406");
		mnNewMenu_3.setIcon(new ImageIcon(TeacherFrm.class.getResource("/images/teacherManage.png")));
		mnNewMenu_3.setFont(new Font("宋体", Font.BOLD, 20));
		menuBar.add(mnNewMenu_3);
		
		JMenu mnNewMenu = new JMenu("\u6BD5\u8BBE\u7C7B\u578B\u7BA1\u7406");
		mnNewMenu.setIcon(new ImageIcon(TeacherFrm.class.getResource("/images/fabu.gif")));
		mnNewMenu.setFont(new Font("宋体", Font.PLAIN, 15));
		mnNewMenu_3.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("\u6DFB\u52A0\u6BD5\u8BBE\u7C7B\u578B");
		mntmNewMenuItem.setIcon(new ImageIcon(TeacherFrm.class.getResource("/images/add.png")));
		mnNewMenu.add(mntmNewMenuItem);
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addProjectTypeFrm addprojectTypeFrm = new addProjectTypeFrm();
				addprojectTypeFrm.setVisible(true);
				table.add(addprojectTypeFrm);
			}
		});
		mntmNewMenuItem.setFont(new Font("宋体", Font.PLAIN, 15));
		
		JMenuItem mntmNewMenuItem_8 = new JMenuItem("\u5220\u9664\u6BD5\u8BBE\u7C7B\u578B");
		mntmNewMenuItem_8.setIcon(new ImageIcon(TeacherFrm.class.getResource("/images/bookManager.png")));
		mnNewMenu.add(mntmNewMenuItem_8);
		mntmNewMenuItem_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteTypeFrm deletetypeFrm = new deleteTypeFrm();
				deletetypeFrm.setVisible(true);
				table.add(deletetypeFrm);
			}
		});
		mntmNewMenuItem_8.setFont(new Font("宋体", Font.PLAIN, 15));
		
		JMenu mnNewMenu_4 = new JMenu("\u6BD5\u8BBE\u9898\u76EE\u7BA1\u7406");
		mnNewMenu_4.setIcon(new ImageIcon(TeacherFrm.class.getResource("/images/me.png")));
		mnNewMenu_4.setFont(new Font("宋体", Font.PLAIN, 15));
		mnNewMenu_3.add(mnNewMenu_4);
		
		JMenuItem mntmNewMenuItem_10 = new JMenuItem("\u5220\u9664\u6BD5\u8BBE\u9898\u76EE");
		mntmNewMenuItem_10.setIcon(new ImageIcon(TeacherFrm.class.getResource("/images/delete.png")));
		mnNewMenu_4.add(mntmNewMenuItem_10);
		mntmNewMenuItem_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteProjectFrm deleteprojectFrm = new deleteProjectFrm();
				deleteprojectFrm.setVisible(true);
				table.add(deleteprojectFrm);
			}
		});
		mntmNewMenuItem_10.setFont(new Font("宋体", Font.PLAIN, 15));
		
		JMenuItem mntmNewMenuItem_9 = new JMenuItem("\u4FEE\u6539\u6BD5\u8BBE\u9898\u76EE");
		mntmNewMenuItem_9.setIcon(new ImageIcon(TeacherFrm.class.getResource("/images/me.png")));
		mnNewMenu_4.add(mntmNewMenuItem_9);
		mntmNewMenuItem_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UpdateProjectFrm updateProjectFrm = new UpdateProjectFrm();
				updateProjectFrm.setVisible(true);
				table.add(updateProjectFrm);
			}
		});
		mntmNewMenuItem_9.setFont(new Font("宋体", Font.PLAIN, 15));
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("\u67E5\u8BE2\u6BD5\u8BBE\u9898\u76EE");
		mntmNewMenuItem_1.setIcon(new ImageIcon(TeacherFrm.class.getResource("/images/search.png")));
		mnNewMenu_4.add(mntmNewMenuItem_1);
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ProjectManageFrm projectManageFrm = new ProjectManageFrm();
				projectManageFrm.setVisible(true);
				table.add(projectManageFrm);
			}
		});
		mntmNewMenuItem_1.setFont(new Font("宋体", Font.PLAIN, 15));
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("\u67E5\u8BE2\u9009\u8BFE\u72B6\u6001");
		mntmNewMenuItem_5.setIcon(new ImageIcon(TeacherFrm.class.getResource("/images/login.png")));
		mnNewMenu_4.add(mntmNewMenuItem_5);
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TeacherLookSelectFrm teacherlookSelectFrm = new TeacherLookSelectFrm();
				teacherlookSelectFrm.setVisible(true);
				table.add(teacherlookSelectFrm);
			}
		});
		mntmNewMenuItem_5.setFont(new Font("宋体", Font.PLAIN, 15));
		
		JMenu mnNewMenu_1 = new JMenu("\u4E2A\u4EBA\u4E2D\u5FC3");
		mnNewMenu_1.setIcon(new ImageIcon(TeacherFrm.class.getResource("/images/teacherpersonal.png")));
		mnNewMenu_1.setFont(new Font("宋体", Font.BOLD, 20));
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("\u67E5\u770B\u4E2A\u4EBA\u4FE1\u606F");
		mntmNewMenuItem_3.setIcon(new ImageIcon(TeacherFrm.class.getResource("/images/search.png")));
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TeacherLookFrm teacherLookFrm = new TeacherLookFrm();
				teacherLookFrm.setVisible(true);
			}
		});
		mntmNewMenuItem_3.setFont(new Font("宋体", Font.PLAIN, 15));
		mnNewMenu_1.add(mntmNewMenuItem_3);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("\u4FEE\u6539\u4E2A\u4EBA\u4FE1\u606F");
		mntmNewMenuItem_4.setIcon(new ImageIcon(TeacherFrm.class.getResource("/images/reset.png")));
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TeacherUpdateFrm teacherUpdateFrm = new TeacherUpdateFrm();
				teacherUpdateFrm.setVisible(true);
			}
		});
		mntmNewMenuItem_4.setFont(new Font("宋体", Font.PLAIN, 15));
		mnNewMenu_1.add(mntmNewMenuItem_4);
		
		JMenuItem mntmNewMenuItem_5_1 = new JMenuItem("\u5B89\u5168\u9000\u51FA\u7CFB\u7EDF");
		mntmNewMenuItem_5_1.setIcon(new ImageIcon(TeacherFrm.class.getResource("/images/exit.png")));
		mntmNewMenuItem_5_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(null, "是否退出系统！");
				if(result == 0) {
					dispose();
				}
			}
		});
		mntmNewMenuItem_5_1.setFont(new Font("宋体", Font.PLAIN, 15));
		mnNewMenu_1.add(mntmNewMenuItem_5_1);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		table = new JDesktopPane();
		table.setBackground(Color.WHITE);
		contentPane.add(table, BorderLayout.CENTER);
		this.setLocationRelativeTo(null);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
	}
}
