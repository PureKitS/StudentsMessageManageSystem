package io.purek1t;

import java.awt.BorderLayout;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.FontUIResource;
import javax.swing.plaf.multi.MultiLabelUI;import org.w3c.dom.Text;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.HeadlessException;

import javax.swing.JTextField;
import javax.swing.JCheckBox;
import java.awt.Checkbox;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

public class EditStudentMessageDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField tbID;		  //序号
	private JTextField tbStudentsID;  //学号
	private JTextField tbName;		  //姓名
	private JTextField tbSex;		  //性别
	private JTextField tbDepartment;  //班级
	private JTextField tbRoomID;	  //宿舍号
	private JTextField tbEmail;		  //邮箱
	private JTextField tbPhoneID;	  //手机号
	private JTextField tbAddress;	  //来源地
	private JTextField tbStartSchool; //入学时间
	private JCheckBox chkActive;	  //在籍状态复选框

	
	
//	protected boolean okReturn;
	//当前正在编辑的学生信息
	private StudentsMessage studentsMessage = null;
	public StudentsMessage getStudentsMessage() {
		return studentsMessage;
	}
	
	
	public boolean okReturn = false; 	// 是否成功保存后返回
	//是否成功保存后返回
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			EditStudentMessageDialog dialog = new EditStudentMessageDialog(1);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	public EditStudentMessageDialog(int id) {
		getContentPane().setBackground(SystemColor.window);
		setBackground(SystemColor.window);
		setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 13));
		setIconImage(Toolkit.getDefaultToolkit().getImage(EditStudentMessageDialog.class.getResource("/Images/StudentsMessageDialog_Edit.png")));
		// TODO Auto-generated constructor stub
		init();
		try {
			studentsMessage = DbUtil.getStudentsMessage(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(this, 
					"读取 students_message 表数据出错！",
					"数据库错误",
					JOptionPane.ERROR_MESSAGE);
			return ;
		}
		showStudentsMessage();   //在窗体上显示当前学生的信息
	}
	//显示选中数据据到修改窗体
	private void showStudentsMessage() {
		// TODO Auto-generated method stub
		if(studentsMessage != null ) {
			tbID.setText(String.format("%d", this.studentsMessage.getId()));
			tbStudentsID.setText(studentsMessage.getStudentsID());
			tbName.setText(studentsMessage.getName());
			tbSex.setText(studentsMessage.getSex());
			tbDepartment.setText(studentsMessage.getDepartment());
			tbRoomID.setText(studentsMessage.getRoomID());
			tbEmail.setText(studentsMessage.getEmail());
			tbPhoneID.setText(studentsMessage.getPhoneID());
			tbAddress.setText(studentsMessage.getAddress());
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			tbStartSchool.setText(sdf.format(studentsMessage.getStartSchoolDate()));
			chkActive.setSelected(this.studentsMessage.isActive());
		}
		
	}
	
	//修改内容到studentsMessage
	private void setStudentsMessage() {
		if(this.studentsMessage == null) return;
		this.studentsMessage.setId(Integer.valueOf(tbID.getText()));
		this.studentsMessage.setStudentsID(tbStudentsID.getText());
		this.studentsMessage.setName(tbName.getText());
		this.studentsMessage.setSex(tbSex.getText());
		this.studentsMessage.setDepartment(tbDepartment.getText());
		this.studentsMessage.setRoomID(tbRoomID.getText());
		this.studentsMessage.setEmail(tbEmail.getText());
		this.studentsMessage.setPhoneID(tbPhoneID.getText());
		this.studentsMessage.setAddress(tbAddress.getText());
		this.studentsMessage.setStartSchoolDate(Date.valueOf(tbStartSchool.getText()));
		this.studentsMessage.setActive(chkActive.isSelected());
	}
	
	

	/**
	 * Create the dialog.
	 */
	public void init() {
		setTitle("\u4FEE\u6539\u5B66\u751F\u4FE1\u606F");
		setBounds(100, 100, 740, 440);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(SystemColor.window);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblStudentsID = new JLabel("\u5B66\u53F7\uFF1A");
			lblStudentsID.setBackground(SystemColor.window);
			lblStudentsID.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 13));
			lblStudentsID.setBounds(157, 51, 49, 14);
			contentPanel.add(lblStudentsID);
		}
		
		tbStudentsID = new JTextField();
		tbStudentsID.setHorizontalAlignment(SwingConstants.CENTER);
		tbStudentsID.setBackground(SystemColor.window);
		tbStudentsID.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 13));
		tbStudentsID.setBounds(197, 48, 136, 20);
		contentPanel.add(tbStudentsID);
		tbStudentsID.setColumns(10);
		
		JLabel lblName = new JLabel("\u59D3\u540D\uFF1A");
		lblName.setBackground(SystemColor.window);
		lblName.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 13));
		lblName.setBounds(377, 51, 49, 14);
		contentPanel.add(lblName);
		
		tbName = new JTextField();
		tbName.setHorizontalAlignment(SwingConstants.CENTER);
		tbName.setBackground(SystemColor.window);
		tbName.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 13));
		tbName.setBounds(418, 48, 115, 20);
		contentPanel.add(tbName);
		tbName.setColumns(10);
		
		JLabel lblSex = new JLabel("\u6027\u522B\uFF1A");
		lblSex.setBackground(SystemColor.window);
		lblSex.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 13));
		lblSex.setBounds(594, 51, 49, 14);
		contentPanel.add(lblSex);
		
		tbSex = new JTextField();
		tbSex.setHorizontalAlignment(SwingConstants.CENTER);
		tbSex.setBackground(SystemColor.window);
		tbSex.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 13));
		tbSex.setBounds(636, 48, 38, 20);
		contentPanel.add(tbSex);
		tbSex.setColumns(10);
		
		JLabel lblDepartment = new JLabel("\u73ED\u7EA7\uFF1A");
		lblDepartment.setBackground(SystemColor.window);
		lblDepartment.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 13));
		lblDepartment.setBounds(45, 121, 49, 14);
		contentPanel.add(lblDepartment);
		
		tbDepartment = new JTextField();
		tbDepartment.setHorizontalAlignment(SwingConstants.CENTER);
		tbDepartment.setBackground(SystemColor.window);
		tbDepartment.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 13));
		tbDepartment.setBounds(83, 118, 89, 20);
		contentPanel.add(tbDepartment);
		tbDepartment.setColumns(10);
		
		JLabel lblRoomID = new JLabel("\u5BBF\u820D\u53F7\uFF1A");
		lblRoomID.setBackground(SystemColor.window);
		lblRoomID.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 13));
		lblRoomID.setBounds(193, 121, 66, 14);
		contentPanel.add(lblRoomID);
		
		tbRoomID = new JTextField();
		tbRoomID.setHorizontalAlignment(SwingConstants.CENTER);
		tbRoomID.setBackground(SystemColor.window);
		tbRoomID.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 13));
		tbRoomID.setBounds(250, 118, 83, 20);
		contentPanel.add(tbRoomID);
		tbRoomID.setColumns(10);
		
		JLabel lblEmail = new JLabel("\u90AE\u7BB1\uFF1A");
		lblEmail.setBackground(SystemColor.window);
		lblEmail.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 13));
		lblEmail.setBounds(377, 121, 49, 14);
		contentPanel.add(lblEmail);
		
		tbEmail = new JTextField();
		tbEmail.setHorizontalAlignment(SwingConstants.CENTER);
		tbEmail.setBackground(SystemColor.window);
		tbEmail.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 13));
		tbEmail.setBounds(418, 118, 256, 20);
		contentPanel.add(tbEmail);
		tbEmail.setColumns(10);
		
		JLabel lblPhoneID = new JLabel("\u8054\u7CFB\u65B9\u5F0F\uFF1A");
		lblPhoneID.setBackground(SystemColor.window);
		lblPhoneID.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 13));
		lblPhoneID.setBounds(45, 193, 79, 14);
		contentPanel.add(lblPhoneID);
		
		tbPhoneID = new JTextField();
		tbPhoneID.setHorizontalAlignment(SwingConstants.CENTER);
		tbPhoneID.setBackground(SystemColor.window);
		tbPhoneID.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 13));
		tbPhoneID.setBounds(113, 190, 220, 20);
		contentPanel.add(tbPhoneID);
		tbPhoneID.setColumns(10);
		
		JLabel lblAddress = new JLabel("\u6765\u6E90\u5730\uFF1A");
		lblAddress.setBackground(SystemColor.window);
		lblAddress.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 13));
		lblAddress.setBounds(377, 193, 66, 14);
		contentPanel.add(lblAddress);
		
		tbAddress = new JTextField();
		tbAddress.setHorizontalAlignment(SwingConstants.CENTER);
		tbAddress.setBackground(SystemColor.window);
		tbAddress.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 13));
		tbAddress.setBounds(428, 190, 246, 20);
		contentPanel.add(tbAddress);
		tbAddress.setColumns(10);
		
		chkActive = new JCheckBox("\u5728\u7C4D\u72B6\u6001");
		chkActive.setBackground(SystemColor.window);
		chkActive.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 13));
		chkActive.setBounds(377, 255, 99, 23);
		contentPanel.add(chkActive);
		
		JLabel lblID = new JLabel("\u5E8F\u53F7\uFF1A");
		lblID.setBackground(SystemColor.window);
		lblID.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 13));
		lblID.setBounds(45, 53, 49, 14);
		contentPanel.add(lblID);
		
		tbID = new JTextField();
		tbID.setHorizontalAlignment(SwingConstants.CENTER);
		tbID.setBackground(SystemColor.window);
		tbID.setEditable(false);
		tbID.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 13));
		tbID.setBounds(83, 50, 33, 20);
		contentPanel.add(tbID);
		tbID.setColumns(10);
		
		JLabel lblStartSchool = new JLabel("\u5165\u5B66\u65F6\u95F4\uFF1A");
		lblStartSchool.setBackground(SystemColor.window);
		lblStartSchool.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 13));
		lblStartSchool.setBounds(45, 261, 79, 14);
		contentPanel.add(lblStartSchool);
		
		tbStartSchool = new JTextField();
		tbStartSchool.setHorizontalAlignment(SwingConstants.CENTER);
		tbStartSchool.setBackground(SystemColor.window);
		tbStartSchool.setEditable(false);
		tbStartSchool.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 13));
		tbStartSchool.setBounds(113, 258, 220, 20);
		contentPanel.add(tbStartSchool);
		tbStartSchool.setColumns(10);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(SystemColor.window);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnConfirm = new JButton("\u4FDD\u5B58");
				btnConfirm.setBackground(SystemColor.window);
				btnConfirm.setIcon(new ImageIcon(EditStudentMessageDialog.class.getResource("/Images/Confrim.png")));
				btnConfirm.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						//保存客户信息
						setStudentsMessage();
						
						try {
							if(DbUtil.updateStudentsMessage(studentsMessage)) {
								JOptionPane.showMessageDialog(EditStudentMessageDialog.this, 
										"保存学生信息成功!","成功",
										JOptionPane.INFORMATION_MESSAGE);
								okReturn = true;
								EditStudentMessageDialog.this.dispose();
								return;
							}
							else {
								JOptionPane.showMessageDialog(null, "保存学生信息失败！");
							}
					
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						JOptionPane.showMessageDialog(EditStudentMessageDialog.this, 
								"更新students表失败！","失败",
								JOptionPane.ERROR_MESSAGE);
						
						
						
					}
				});
				btnConfirm.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 13));
				btnConfirm.setActionCommand("OK");
				buttonPane.add(btnConfirm);
				getRootPane().setDefaultButton(btnConfirm);
			}
			{
				JButton btnCancel = new JButton("\u53D6\u6D88");
				btnCancel.setBackground(SystemColor.window);
				btnCancel.setIcon(new ImageIcon(EditStudentMessageDialog.class.getResource("/Images/Cancel.png")));
				btnCancel.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						EditStudentMessageDialog.this.dispose();
					}
				});
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



	public boolean okReturn() {
		// TODO Auto-generated method stub
		return false;
	}



}
