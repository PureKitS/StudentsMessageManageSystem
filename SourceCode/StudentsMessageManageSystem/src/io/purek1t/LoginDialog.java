package io.purek1t;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.FontUIResource;

import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.SystemColor;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

public class LoginDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField tbUserName;
	private JPasswordField tbPassword;
	
	private User user;
	public User getUser() {
		return user;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			LoginDialog dialog = new LoginDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public LoginDialog() {
		getContentPane().setBackground(SystemColor.window);
		setBackground(SystemColor.window);
		setIconImage(Toolkit.getDefaultToolkit().getImage(LoginDialog.class.getResource("/Images/LoginBackgroud.png")));
		setTitle("\u7BA1\u7406\u5458\u767B\u5F55");
		setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 13));
		setBounds(100, 100, 480, 330);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(SystemColor.window);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblUserName = new JLabel("\u7528\u6237\u540D\uFF1A");
		lblUserName.setIcon(new ImageIcon(LoginDialog.class.getResource("/Images/LoginDialog_username.png")));
		lblUserName.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 13));
		lblUserName.setBounds(98, 158, 82, 14);
		contentPanel.add(lblUserName);
		
		JLabel lblPassword = new JLabel("\u5BC6   \u7801\uFF1A");
		lblPassword.setIcon(new ImageIcon(LoginDialog.class.getResource("/Images/LoginDialog_password.png")));
		lblPassword.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 13));
		lblPassword.setBounds(98, 197, 82, 14);
		contentPanel.add(lblPassword);
		
		tbUserName = new JTextField();
		tbUserName.setBackground(SystemColor.window);
		tbUserName.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 13));
		tbUserName.setBounds(164, 155, 181, 20);
		contentPanel.add(tbUserName);
		tbUserName.setColumns(10);
		
		tbPassword = new JPasswordField();
		tbPassword.setBackground(SystemColor.window);
		tbPassword.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 13));
		tbPassword.setBounds(164, 194, 181, 20);
		contentPanel.add(tbPassword);
		
		JLabel lblLoginImage = new JLabel("");
		lblLoginImage.setVerticalAlignment(SwingConstants.TOP);
		lblLoginImage.setIcon(new ImageIcon(LoginDialog.class.getResource("/Images/LoginBackgroud.png")));
		lblLoginImage.setBounds(164, 5, 143, 137);
		contentPanel.add(lblLoginImage);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(SystemColor.window);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnConfrim = new JButton("\u786E\u5B9A");
				btnConfrim.setBackground(SystemColor.window);
				btnConfrim.setIcon(new ImageIcon(LoginDialog.class.getResource("/Images/Confrim.png")));
				btnConfrim.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						//获取内容到user
						//验证用户登录 对比数据库表 数据
						String userName = tbUserName.getText();
						String password = new String(tbPassword.getPassword());
						try {
							
							user = DbUtil.getLoginUser(userName, password);
						} catch (SQLException e1) {
							JOptionPane.showConfirmDialog(LoginDialog.this, 
									"访问students数据库失败！", "错误",
									JOptionPane.ERROR_MESSAGE);
							e1.printStackTrace();
							return;
						}
						//判断内容是否为空
						if(user==null) {
							JOptionPane.showMessageDialog(LoginDialog.this,
									"输入的用户名和密码不存在！", "错误",
									JOptionPane.ERROR_MESSAGE);
							return;
						}
						LoginDialog.this.dispose();
					}
				});
				btnConfrim.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 13));
				btnConfrim.setActionCommand("OK");
				buttonPane.add(btnConfrim);
				getRootPane().setDefaultButton(btnConfrim);
			}
			{
				JButton btnCancel = new JButton("\u53D6\u6D88");
				btnCancel.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						LoginDialog.this.dispose();
					}
				});
				btnCancel.setBackground(SystemColor.window);
				btnCancel.setIcon(new ImageIcon(LoginDialog.class.getResource("/Images/Cancel.png")));
				btnCancel.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 13));
				btnCancel.setActionCommand("Cancel");
				buttonPane.add(btnCancel);
			}
		}
		
		
		//修改本页面的showMessage/Confirm/dialog的颜色
				UIManager.put("OptionPane.background",Color.white);
				UIManager.put("Panel.background", Color.white);
				UIManager.put("Button.background", Color.white);
				UIManager.put("OptionPane.buttonFont", new FontUIResource(new Font("Microsoft YaHei UI", Font.PLAIN, 13)));
				UIManager.put("OptionPane.font", new FontUIResource(new Font("Microsoft YaHei UI", Font.PLAIN, 13)));
				UIManager.put("Panel.font", new FontUIResource(new Font("Microsoft YaHei UI", Font.PLAIN, 13)));	
				
	}

	
}
