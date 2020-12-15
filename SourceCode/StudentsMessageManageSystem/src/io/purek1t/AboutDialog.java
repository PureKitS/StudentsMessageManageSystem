package io.purek1t;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AboutDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			AboutDialog dialog = new AboutDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AboutDialog() {
		getContentPane().setBackground(SystemColor.window);
		setBackground(SystemColor.window);
		setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 13));
		setTitle("\u5173\u4E8E");
		setIconImage(Toolkit.getDefaultToolkit().getImage(AboutDialog.class.getResource("/Images/mao.png")));
		setBounds(100, 100, 450, 280);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(SystemColor.window);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblAboutImage = new JLabel("");
		lblAboutImage.setIcon(new ImageIcon(AboutDialog.class.getResource("/Images/StudentsFrame_Header_adout.png")));
		lblAboutImage.setBounds(70, 32, 135, 128);
		contentPanel.add(lblAboutImage);
		
		JLabel lblTitle = new JLabel("\u5B66\u751F\u4FE1\u606F\u7BA1\u7406\u7CFB\u7EDF");
		lblTitle.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 13));
		lblTitle.setBounds(246, 47, 141, 19);
		contentPanel.add(lblTitle);
		
		JLabel lblVersion = new JLabel("\u7248\u672C: 2.0.2(Beta)");
		lblVersion.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 13));
		lblVersion.setBounds(246, 87, 105, 19);
		contentPanel.add(lblVersion);
		
		JLabel lblCopyright = new JLabel("Copyright 2020-2021");
		lblCopyright.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 13));
		lblCopyright.setBounds(246, 106, 141, 19);
		contentPanel.add(lblCopyright);
		
		JLabel lblCopyrights = new JLabel("By PureK1t");
		lblCopyrights.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 13));
		lblCopyrights.setBounds(246, 123, 105, 24);
		contentPanel.add(lblCopyrights);
		
		JPanel buttonPane = new JPanel();
		buttonPane.setBackground(SystemColor.window);
		getContentPane().add(buttonPane, BorderLayout.SOUTH);
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		
		JButton btnConfrim = new JButton("\u786E\u5B9A");
		btnConfrim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AboutDialog.this.dispose();
			}
		});
		btnConfrim.setBackground(SystemColor.window);
		btnConfrim.setIcon(new ImageIcon(AboutDialog.class.getResource("/Images/Confrim.png")));
		btnConfrim.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 13));
		btnConfrim.setActionCommand("OK");
		buttonPane.add(btnConfrim);
		
		JButton cancelButton = new JButton("\u53D6\u6D88");
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AboutDialog.this.dispose();
			}
		});
		cancelButton.setBackground(SystemColor.window);
		cancelButton.setIcon(new ImageIcon(AboutDialog.class.getResource("/Images/Cancel.png")));
		cancelButton.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 13));
		cancelButton.setActionCommand("Cancel");
		buttonPane.add(cancelButton);
	}
}
