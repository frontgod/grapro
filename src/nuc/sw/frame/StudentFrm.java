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
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;
import javax.swing.ImageIcon;

public class StudentFrm extends JFrame {

	private JPanel contentPane;
	private JDesktopPane table;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					StudentFrm frame = new StudentFrm();
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
	public StudentFrm() {
		setTitle("\u6BD5\u4E1A\u8BBE\u8BA1\u7BA1\u7406\u7CFB\u7EDF\uFF08\u5B66\u751F\u7AEF\uFF09");
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 784, 496);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(Color.WHITE);
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu_3 = new JMenu("\u81EA\u62DF\u6BD5\u8BBE\u9898\u76EE");
		mnNewMenu_3.setIcon(new ImageIcon(StudentFrm.class.getResource("/images/me.png")));
		mnNewMenu_3.setFont(new Font("宋体", Font.BOLD, 20));
		menuBar.add(mnNewMenu_3);
		
		JMenuItem mntmNewMenuItem_3_1 = new JMenuItem("\u63D0\u4EA4\u81EA\u62DF\u9898\u76EE");
		mntmNewMenuItem_3_1.setIcon(new ImageIcon(StudentFrm.class.getResource("/images/add.png")));
		mntmNewMenuItem_3_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addProbyselfFrm addprobyselfFrm = new addProbyselfFrm();
				addprobyselfFrm.setVisible(true);
				table.add(addprobyselfFrm);
			}
		});
		mntmNewMenuItem_3_1.setFont(new Font("宋体", Font.PLAIN, 15));
		mnNewMenu_3.add(mntmNewMenuItem_3_1);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("\u5220\u9664\u81EA\u62DF\u9898\u76EE");
		mntmNewMenuItem_3.setIcon(new ImageIcon(StudentFrm.class.getResource("/images/delete.png")));
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeleteProjectSelfFrm deleteProjectSelfFrm = new DeleteProjectSelfFrm();
				deleteProjectSelfFrm.setVisible(true);
				table.add(deleteProjectSelfFrm);
			}
		});
		mntmNewMenuItem_3.setFont(new Font("宋体", Font.PLAIN, 15));
		mnNewMenu_3.add(mntmNewMenuItem_3);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("\u4FEE\u6539\u81EA\u62DF\u9898\u76EE");
		mntmNewMenuItem_2.setIcon(new ImageIcon(StudentFrm.class.getResource("/images/bookManager.png")));
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UpdateProjectSelfFrm updateProjectSelfFrm = new UpdateProjectSelfFrm();
				updateProjectSelfFrm.setVisible(true);
				table.add(updateProjectSelfFrm);
			}
		});
		mntmNewMenuItem_2.setFont(new Font("宋体", Font.PLAIN, 15));
		mnNewMenu_3.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_5_1 = new JMenuItem("\u67E5\u8BE2\u81EA\u62DF\u9898\u76EE");
		mntmNewMenuItem_5_1.setIcon(new ImageIcon(StudentFrm.class.getResource("/images/login.png")));
		mntmNewMenuItem_5_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ProbyselfManageFrm probyselfManageFrm = new ProbyselfManageFrm();
				probyselfManageFrm.setVisible(true);
				table.add(probyselfManageFrm);
			}
		});
		mntmNewMenuItem_5_1.setFont(new Font("宋体", Font.PLAIN, 15));
		mnNewMenu_3.add(mntmNewMenuItem_5_1);
		
		JMenu mnNewMenu_4 = new JMenu("\u6BD5\u8BBE\u4FE1\u606F\u7BA1\u7406");
		mnNewMenu_4.setIcon(new ImageIcon(StudentFrm.class.getResource("/images/maintain.png")));
		mnNewMenu_4.setFont(new Font("宋体", Font.BOLD, 20));
		menuBar.add(mnNewMenu_4);
		
		JMenuItem mntmNewMenuItem_7 = new JMenuItem("\u9009\u62E9\u6BD5\u8BBE\u9898\u76EE");
		mntmNewMenuItem_7.setIcon(new ImageIcon(StudentFrm.class.getResource("/images/bookTypeManager.png")));
		mntmNewMenuItem_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SelectProjectFrm selectProjectFrm = new SelectProjectFrm();
				selectProjectFrm.setVisible(true);
				table.add(selectProjectFrm);
			}
		});
		mntmNewMenuItem_7.setFont(new Font("宋体", Font.PLAIN, 15));
		mnNewMenu_4.add(mntmNewMenuItem_7);
		
		JMenuItem mntmNewMenuItem_8 = new JMenuItem("\u67E5\u770B\u6BD5\u8BBE\u9898\u76EE");
		mntmNewMenuItem_8.setIcon(new ImageIcon(StudentFrm.class.getResource("/images/fabu.gif")));
		mntmNewMenuItem_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LookProjectFrm selectProjectFrm = new LookProjectFrm();
				selectProjectFrm.setVisible(true);
				table.add(selectProjectFrm);
			}
		});
		mntmNewMenuItem_8.setFont(new Font("宋体", Font.PLAIN, 15));
		mnNewMenu_4.add(mntmNewMenuItem_8);
		
		JMenuItem mntmNewMenuItem_6 = new JMenuItem("\u67E5\u8BE2\u6BD5\u8BBE\u9898\u76EE");
		mntmNewMenuItem_6.setIcon(new ImageIcon(StudentFrm.class.getResource("/images/search.png")));
		mntmNewMenuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ProjectManageFrm projectManageFrm = new ProjectManageFrm();
				projectManageFrm.setVisible(true);
				table.add(projectManageFrm);
			}
		});
		mntmNewMenuItem_6.setFont(new Font("宋体", Font.PLAIN, 15));
		mnNewMenu_4.add(mntmNewMenuItem_6);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("\u67E5\u8BE2\u9009\u8BFE\u72B6\u6001");
		mntmNewMenuItem_4.setIcon(new ImageIcon(StudentFrm.class.getResource("/images/money.png")));
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LookSelectFrm lookSelectFrm = new LookSelectFrm();
				lookSelectFrm.setVisible(true);
				table.add(lookSelectFrm);
			}
		});
		mntmNewMenuItem_4.setFont(new Font("宋体", Font.PLAIN, 15));
		mnNewMenu_4.add(mntmNewMenuItem_4);
		
		JMenu mnNewMenu_1 = new JMenu("\u4E2A\u4EBA\u4E2D\u5FC3");
		mnNewMenu_1.setIcon(new ImageIcon(StudentFrm.class.getResource("/images/studentuser.png")));
		mnNewMenu_1.setFont(new Font("宋体", Font.BOLD, 20));
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("\u67E5\u770B\u4E2A\u4EBA\u4FE1\u606F");
		mntmNewMenuItem.setIcon(new ImageIcon(StudentFrm.class.getResource("/images/search.png")));
		mntmNewMenuItem.addActionListener(e -> {
            StudentLookFrm studentLookFrm = new StudentLookFrm();
            studentLookFrm.setVisible(true);
        });
		mntmNewMenuItem.setFont(new Font("宋体", Font.PLAIN, 15));
		mnNewMenu_1.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("\u4FEE\u6539\u4E2A\u4EBA\u4FE1\u606F");
		mntmNewMenuItem_1.setIcon(new ImageIcon(StudentFrm.class.getResource("/images/about.png")));
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StudentUpdateFrm studentUpdateFrm = new StudentUpdateFrm();
				studentUpdateFrm.setVisible(true);
			}
		});
		mntmNewMenuItem_1.setFont(new Font("宋体", Font.PLAIN, 15));
		mnNewMenu_1.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_4_1 = new JMenuItem("\u5B89\u5168\u9000\u51FA\u7CFB\u7EDF");
		mntmNewMenuItem_4_1.setIcon(new ImageIcon(StudentFrm.class.getResource("/images/exit.png")));
		mntmNewMenuItem_4_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(null, "是否退出系统！");
				if(result == 0) {
					dispose();
				}
			}
		});
		mntmNewMenuItem_4_1.setFont(new Font("宋体", Font.PLAIN, 15));
		mnNewMenu_1.add(mntmNewMenuItem_4_1);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		table = new JDesktopPane();
		table.setBackground(Color.WHITE);
		contentPane.add(table, BorderLayout.CENTER);
		GroupLayout gl_table = new GroupLayout(table);
		gl_table.setHorizontalGroup(
			gl_table.createParallelGroup(Alignment.LEADING)
				.addGap(0, 1526, Short.MAX_VALUE)
		);
		gl_table.setVerticalGroup(
			gl_table.createParallelGroup(Alignment.LEADING)
				.addGap(0, 768, Short.MAX_VALUE)
		);
		table.setLayout(gl_table);
		this.setLocationRelativeTo(null);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		
	}
}
