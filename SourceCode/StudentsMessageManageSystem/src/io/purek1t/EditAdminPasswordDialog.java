package io.purek1t;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.ColorUIResource;

import javax.swing.plaf.FontUIResource;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.HeadlessException;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.SystemColor;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

public class EditAdminPasswordDialog extends JDialog {
	private JTextField tbUserName; 			//用户名
	
		private final JPanel contentPanel = new JPanel();
		private User user;
		private JPasswordField tbNewPassword;
		private JTextField tbOldPassword;
		public User getUser() {
			return user;
	}
	

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			EditAdminPasswordDialog dialog = new EditAdminPasswordDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public EditAdminPasswordDialog() {
		getContentPane().setBackground(SystemColor.window);
		setBackground(SystemColor.window);
		setIconImage(Toolkit.getDefaultToolkit().getImage(EditAdminPasswordDialog.class.getResource("/Images/EditAdminPassword.png")));
		setTitle("\u7BA1\u7406\u5458\u4FEE\u6539\u5BC6\u7801");
		setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 13));
		setBounds(100, 100, 450, 310);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(SystemColor.window);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(SystemColor.window);
			buttonPane.setBounds(0, 230, 436, 33);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnConfrim = new JButton("\u786E\u5B9A");
				btnConfrim.setIcon(new ImageIcon(EditAdminPasswordDialog.class.getResource("/Images/Confrim.png")));
				btnConfrim.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 13));
				btnConfrim.setBackground(SystemColor.window);
				btnConfrim.addActionListener(new ActionListener() {

					public void actionPerformed(ActionEvent e) {
						String username = tbUserName.getText();
						String password = tbOldPassword.getText();
						String newPassword =new String(tbNewPassword.getPassword());
						
						 try {
							user = DbUtil.getLoginUser(username, password);
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							JOptionPane.showMessageDialog(EditAdminPasswordDialog.this,
									"用户名或密码错误！", "错误",
									JOptionPane.ERROR_MESSAGE);
							e1.printStackTrace();
						}//利用用户名判断密码是否正确
						 if(user == null) {
							 JOptionPane.showMessageDialog(EditAdminPasswordDialog.this,
									 "用户名或者密码错误!!!!!！", "错误", 
									 JOptionPane.ERROR_MESSAGE);
							 return;
						 }else {
							 JOptionPane.showConfirmDialog(EditAdminPasswordDialog.this,
									 "密码正确!!!!!!", "成功", 
									 JOptionPane.YES_OPTION);
							 try {
								if(DbUtil.updateAdminPassword(username, newPassword)==true) {
									 JOptionPane.showConfirmDialog(EditAdminPasswordDialog.this,
												"管理员密码修改成功", "成功", 
												 JOptionPane.YES_OPTION);
								 }else {
									 JOptionPane.showMessageDialog(EditAdminPasswordDialog.this,
											 "密码修改失败！", "失败", 
											 JOptionPane.ERROR_MESSAGE);
								 }
							} catch (HeadlessException | SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							 
					 
													
						}
						
						 LoginDialog dialog = new LoginDialog();
							dialog.setModal(true);
							dialog.setVisible(true);
							
					}
				});
				btnConfrim.setActionCommand("OK");
				buttonPane.add(btnConfrim);
				getRootPane().setDefaultButton(btnConfrim);
			}
			{
				JButton btnCancel = new JButton("\u53D6\u6D88");
				btnCancel.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						EditAdminPasswordDialog.this.dispose();
					}
				});
				btnCancel.setIcon(new ImageIcon(EditAdminPasswordDialog.class.getResource("/Images/Cancel.png")));
				btnCancel.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 13));
				btnCancel.setBackground(SystemColor.window);
				btnCancel.setActionCommand("Cancel");
				buttonPane.add(btnCancel);
			}
		}
		
		JLabel lblOldPassword = new JLabel("\u539F\u5BC6\u7801\uFF1A");
		lblOldPassword.setBackground(SystemColor.window);
		lblOldPassword.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 13));
		lblOldPassword.setBounds(122, 144, 75, 14);
		contentPanel.add(lblOldPassword);
		
		JLabel lblNewPassword = new JLabel("\u65B0\u5BC6\u7801\uFF1A");
		lblNewPassword.setBackground(SystemColor.window);
		lblNewPassword.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 13));
		lblNewPassword.setBounds(122, 172, 75, 14);
		contentPanel.add(lblNewPassword);
		
		JLabel lblUserName = new JLabel("\u7528\u6237\u540D\uFF1A");
		lblUserName.setBackground(SystemColor.window);
		lblUserName.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 13));
		lblUserName.setBounds(122, 119, 75, 14);
		contentPanel.add(lblUserName);
		
		tbUserName = new JTextField();
		tbUserName.setBackground(SystemColor.window);
		tbUserName.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 13));
		tbUserName.setBounds(172, 113, 120, 20);
		contentPanel.add(tbUserName);
		tbUserName.setColumns(10);
		
		tbNewPassword = new JPasswordField();
		tbNewPassword.setBackground(SystemColor.window);
		tbNewPassword.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 13));
		tbNewPassword.setBounds(172, 169, 120, 20);
		contentPanel.add(tbNewPassword);
		
		tbOldPassword = new JTextField();
		tbOldPassword.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 13));
		tbOldPassword.setBackground(SystemColor.window);
		tbOldPassword.setBounds(172, 141, 120, 20);
		contentPanel.add(tbOldPassword);
		tbOldPassword.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(EditAdminPasswordDialog.class.getResource("/Images/EditAdminPassword.png")));
		lblNewLabel.setBounds(184, 11, 153, 119);
		contentPanel.add(lblNewLabel);
		
		//修改本页面的showMessage/Confirm/dialog的显示主题
		UIManager.put("OptionPane.background",Color.white);
		UIManager.put("Panel.background", Color.white);
		UIManager.put("Button.background", Color.white);
		UIManager.put("OptionPane.buttonFont", new FontUIResource(new Font("Microsoft YaHei UI", Font.PLAIN, 13)));
		UIManager.put("OptionPane.font", new FontUIResource(new Font("Microsoft YaHei UI", Font.PLAIN, 13)));
		UIManager.put("Panel.font", new FontUIResource(new Font("Microsoft YaHei UI", Font.PLAIN, 13)));	
		
	}



}
