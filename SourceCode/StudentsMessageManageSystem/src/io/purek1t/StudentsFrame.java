package io.purek1t;

import java.awt.BorderLayout;



import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.util.Currency;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import java.awt.Font;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.JTextField;

public class StudentsFrame extends JFrame {

	private JPanel contentPane;
	//定义一个用户名
	private User currentUser = null;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentsFrame frame = new StudentsFrame();
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
	//调起登录界面
	public StudentsFrame() {
		setBackground(SystemColor.window);
		setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
		init();
		LoginDialog dialog = new LoginDialog();
		dialog.setModal(true);
		dialog.setVisible(true);
		currentUser = dialog.getUser();
		if (currentUser==null) {
			System.exit(0);
		}	
		
	}
	

	public void init() {
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(StudentsFrame.class.getResource("/Images/StudentsFrame_Header_adout.png")));
		setTitle("\u5B66\u751F\u4FE1\u606F\u7BA1\u7406\u7CFB\u7EDF");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1300, 780);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(SystemColor.window);
		setJMenuBar(menuBar);
		
		JMenu mnSystem = new JMenu("\u7CFB\u7EDF(S)");
		mnSystem.setBackground(SystemColor.window);
		mnSystem.setMnemonic('S');
		mnSystem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		mnSystem.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 13));
		mnSystem.setIcon(new ImageIcon(StudentsFrame.class.getResource("/Images/StudentsFrame_System.png")));
		menuBar.add(mnSystem);
		
		JMenuItem mntmLogout = new JMenuItem("\u6CE8\u9500(O)...");
		mntmLogout.setBackground(SystemColor.window);
		mntmLogout.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, InputEvent.CTRL_MASK));
		mntmLogout.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 13));
		mntmLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//注销弹出登录框
				StudentsFrame.this.dispose();
				currentUser = null;
				LoginDialog dialog = new LoginDialog();
				dialog.setModal(true);
				dialog.setVisible(true);
				currentUser = dialog.getUser();
				if (currentUser==null) {
					System.exit(0);
				
				
				}		
			}
		});
		mntmLogout.setIcon(new ImageIcon(StudentsFrame.class.getResource("/Images/StudentsFrame_Logout.png")));
		mnSystem.add(mntmLogout);
		
		mnSystem.addSeparator();
		
		JMenuItem mntmExit = new JMenuItem("\u9000\u51FA(X)");
		mntmExit.setBackground(SystemColor.window);
		mntmExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.ALT_MASK));
		mntmExit.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 13));
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//直接退出
				System.exit(0);
			}
		});
		mntmExit.setIcon(new ImageIcon(StudentsFrame.class.getResource("/Images/StudentsFrame_Exit.png")));
		mnSystem.add(mntmExit);
		
		JMenu mnStudentsManage = new JMenu("\u5B66\u751F\u7BA1\u7406(M)");
		mnStudentsManage.setBackground(SystemColor.window);
		mnStudentsManage.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 13));
		mnStudentsManage.setMnemonic('M');
		mnStudentsManage.setIcon(new ImageIcon(StudentsFrame.class.getResource("/Images/StudentsFrame_studentsManage.png")));
		menuBar.add(mnStudentsManage);
		
		JMenuItem mntmStudentsMessageInfo = new JMenuItem("\u5B66\u751F\u4FE1\u606F\u7BA1\u7406");
		mntmStudentsMessageInfo.setBackground(SystemColor.window);
		mntmStudentsMessageInfo.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 13));
		mntmStudentsMessageInfo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, InputEvent.CTRL_MASK));
		mntmStudentsMessageInfo.setIcon(new ImageIcon(StudentsFrame.class.getResource("/Images/StudentFrame_studentMessageDialog.png")));
		mntmStudentsMessageInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StudentsMessageDialog dialog = new StudentsMessageDialog();
				dialog.setModal(true);
				dialog.setVisible(true);
			}
		});
		mnStudentsManage.add(mntmStudentsMessageInfo);
		
		JMenu mnAdmin = new JMenu("\u7BA1\u7406\u5458(G)");
		mnAdmin.setIcon(new ImageIcon(StudentsFrame.class.getResource("/Images/StudentsFrameAdmin.png")));
		mnAdmin.setMnemonic('G');
		mnAdmin.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 13));
		menuBar.add(mnAdmin);
		
		JMenuItem mntmEditPassword = new JMenuItem("\u4FEE\u6539\u5BC6\u7801");
		mntmEditPassword.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, InputEvent.CTRL_MASK));
		mntmEditPassword.setIcon(new ImageIcon(StudentsFrame.class.getResource("/Images/StudentsFrame adminpassword.png")));
		mntmEditPassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EditAdminPasswordDialog dialog = new EditAdminPasswordDialog();
				dialog.setModal(true);
				dialog.setVisible(true);
			}
		});
		mntmEditPassword.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 13));
		mnAdmin.add(mntmEditPassword);
		
		JMenu mnHelp = new JMenu("\u5E2E\u52A9(H)");
		mnHelp.setBackground(SystemColor.window);
		mnHelp.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 13));
		mnHelp.setMnemonic('H');
		mnHelp.setIcon(new ImageIcon(StudentsFrame.class.getResource("/Images/StudentsFrame_Help.png")));
		menuBar.add(mnHelp);
		
		JMenuItem mntmAbout = new JMenuItem("\u5173\u4E8E");
		mntmAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AboutDialog dialog = new AboutDialog();
				dialog.setModal(true);
				dialog.setVisible(true);
				
			}
		});
		mntmAbout.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 13));
		mntmAbout.setBackground(SystemColor.window);
		mntmAbout.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T, InputEvent.CTRL_MASK));
		mntmAbout.setIcon(new ImageIcon(StudentsFrame.class.getResource("/Images/StudentsFrame_About .png")));
		mnHelp.add(mntmAbout);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.window);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(5, 694, 1276, 19);
		panel.setBackground(SystemColor.window);
		contentPane.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JLabel lblCopyright = new JLabel("Copyright by purek1t, ahcme 2020.11.17");
		lblCopyright.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCopyright.setBackground(SystemColor.window);
		lblCopyright.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
		panel.add(lblCopyright, BorderLayout.NORTH);
		
		JLabel lblPurekt = new JLabel("");
		lblPurekt.setIcon(new ImageIcon(StudentsFrame.class.getResource("/Images/StudentsFrame lbl.png")));
		lblPurekt.setBounds(526, 18, 194, 689);
		lblPurekt.setForeground(SystemColor.activeCaption);
		lblPurekt.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 98));
		lblPurekt.setBackground(Color.WHITE);
		contentPane.add(lblPurekt);

		
		
		
	}
}
