package nuc.sw.frame;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LogOnFrm extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LogOnFrm frame = new LogOnFrm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LogOnFrm() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 540, 395);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("\u5B66\u751F\u7AEF");
		btnNewButton.setIcon(new ImageIcon(LogOnFrm.class.getResource("/images/login.png")));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StudentLogOnFrm a = new StudentLogOnFrm();
				a.setVisible(true);		
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.BOLD, 25));
		btnNewButton.setBounds(70, 259, 157, 55);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u6559\u5E08\u7AEF");
		btnNewButton_1.setIcon(new ImageIcon(LogOnFrm.class.getResource("/images/reset.png")));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TeacherLogOnFrm b = new TeacherLogOnFrm();
				b.setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("宋体", Font.BOLD, 25));
		btnNewButton_1.setBounds(311, 259, 157, 55);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("\u6BD5\u4E1A\u8BBE\u8BA1\u7BA1\u7406\u7CFB\u7EDF");
		lblNewLabel.setFont(new Font("华文隶书", Font.BOLD, 35));
		lblNewLabel.setIcon(new ImageIcon(LogOnFrm.class.getResource("/images/graduation_cap_70.350194552529px_1301533_easyicon.net.png")));
		lblNewLabel.setBounds(70, 24, 382, 90);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(LogOnFrm.class.getResource("/images/student .png")));
		lblNewLabel_1.setBounds(86, 124, 121, 112);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(LogOnFrm.class.getResource("/images/teacher.png")));
		lblNewLabel_2.setBounds(324, 124, 128, 112);
		contentPane.add(lblNewLabel_2);
		
		this.setLocationRelativeTo(null);
	}
}
