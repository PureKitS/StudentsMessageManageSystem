package io.purek1t;

import java.awt.*;



import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.FontUIResource;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;



import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;

import java.awt.event.ActionListener;
import java.net.BindException;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class StudentsMessageDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable tblStudentsMessage;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			StudentsMessageDialog dialog = new StudentsMessageDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	
	
	
	/**
	 * Create the dialog.
	 */
	public StudentsMessageDialog() {
		setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 13));
		setBackground(SystemColor.window);
		setIconImage(Toolkit.getDefaultToolkit().getImage(StudentsMessageDialog.class.getResource("/Images/StudentFrame_studentMessageDialog.png")));
		setTitle("\u5B66\u751F\u4FE1\u606F\u7BA1\u7406");
		setBounds(100, 100, 1150, 680);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(SystemColor.window);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JScrollPane scrollPane = new JScrollPane();
			contentPanel.add(scrollPane, BorderLayout.CENTER);
			{
				tblStudentsMessage = new JTable();
				tblStudentsMessage.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
				tblStudentsMessage.setBackground(SystemColor.window);
				scrollPane.setViewportView(tblStudentsMessage);
			}
		}
		{
			//加载学生信息  
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(SystemColor.window);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnLoad = new JButton("\u52A0\u8F7D\u6570\u636E");
				btnLoad.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 13));
				btnLoad.setBackground(SystemColor.window);
				btnLoad.setIcon(new ImageIcon(StudentsMessageDialog.class.getResource("/Images/StudentsMessageDialog_Reload.png")));
				btnLoad.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
//						bindTableModel();
						bindStudentsMessageTableModel();
					}
				});
				btnLoad.setActionCommand("OK");
				buttonPane.add(btnLoad);
				getRootPane().setDefaultButton(btnLoad);
			}
			{
				//查询学生信息
				JButton btnSearch = new JButton("\u67E5\u627E\u4FE1\u606F");
				btnSearch.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 13));
				btnSearch.setBackground(SystemColor.window);
				btnSearch.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String searhingName = JOptionPane.showInputDialog(StudentsMessageDialog.this,
												"请输入要查找的学生姓名", "查找", 
												JOptionPane.YES_NO_CANCEL_OPTION);
						//判断输入的查找名是否为空
						if(searhingName==null) return;
						//定义第0行 地2列
						int row =0 , colu = 2;
						//for 循环开始
						for(row=0; row<tblStudentsMessage.getRowCount(); row++) {
							//获取第二列的姓名 存入 studentName 里面
							String studentName = (String)tblStudentsMessage.getValueAt(row, colu);
							//转换成大写进行比较
							if(searhingName.toUpperCase().equals(studentName.toUpperCase())) {
								break;//循环结束
							}
						}
						//判断row是否小于表格的长度 实行查找
						if(row<tblStudentsMessage.getRowCount()) {
							tblStudentsMessage.setRowSelectionInterval(row, row);
							tblStudentsMessage.scrollRectToVisible(tblStudentsMessage.getCellRect(row, 0, true));
						}else {
							JOptionPane.showMessageDialog(StudentsMessageDialog.this,
									"未找到学生"+searhingName+"!");
						}
 					}
				});
				btnSearch.setIcon(new ImageIcon(StudentsMessageDialog.class.getResource("/Images/StudentsMessageDialog_Search.png")));
				buttonPane.add(btnSearch);
			}
			{
				//更新修改学生信息
				JButton btnUpdate = new JButton("\u4FEE\u6539\u4FE1\u606F");
				btnUpdate.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 13));
				btnUpdate.setBackground(SystemColor.window);
				btnUpdate.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(tblStudentsMessage.getSelectedRowCount()<=0) {
							JOptionPane.showMessageDialog(null, "请选择一个学生");
							return ;
						}
						//获取当前行的编号
						int id = (int)tblStudentsMessage.getValueAt(
								tblStudentsMessage.getSelectedRow(),
								0);
						EditStudentMessageDialog dialog = new EditStudentMessageDialog(id);
						dialog.setModal(true);
						dialog.setVisible(true);
						if (dialog.okReturn()) {
							// 更新JTable数据
							bindStudentsMessageTableModel();
						}	
					}
				});
				btnUpdate.setIcon(new ImageIcon(StudentsMessageDialog.class.getResource("/Images/StudentsMessageDialog_Edit.png")));
				buttonPane.add(btnUpdate);
			}
			{
				//录入学生信息
				JButton btnAdd = new JButton("\u5F55\u5165\u4FE1\u606F");
				btnAdd.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 13));
				btnAdd.setBackground(SystemColor.window);
				btnAdd.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						//实例化对象 执行事件
						InsertStudentsMessageDialog dialog = new InsertStudentsMessageDialog();
						dialog.setModal(true);
						dialog.setVisible(true);
						if(dialog.okReturn()) {
							//更新JTable数据
							bindStudentsMessageTableModel();
						
						}
					}
				});
				btnAdd.setIcon(new ImageIcon(StudentsMessageDialog.class.getResource("/Images/StudentsMessageDialog_Add.png")));
				buttonPane.add(btnAdd);
			}
			{
				//移除选中学生的在籍状态 
				JButton btnWithdraw = new JButton("\u79FB\u9664\u5728\u7C4D");
				btnWithdraw.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 13));
				btnWithdraw.setBackground(SystemColor.window);
				btnWithdraw.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(tblStudentsMessage.getSelectedRowCount()<=0) {
							JOptionPane.showConfirmDialog(StudentsMessageDialog.this, "请先选择一个学生信息",
									"提示", 
									JOptionPane.INFORMATION_MESSAGE);
							return;
						}
						//获取当前行的学生信息编号
						int row = tblStudentsMessage.getSelectedRow();
						int id = (int)tblStudentsMessage.getValueAt(row, 0);
						String studentName = (String)tblStudentsMessage.getValueAt(row, 2);
						int sel = JOptionPane.showConfirmDialog(StudentsMessageDialog.this, 
								"确认要将'"+studentName+"'的在籍状态移除吗？", 
								"确认", JOptionPane.YES_NO_OPTION);
						if(sel == JOptionPane.YES_OPTION) {
							try {
								DbUtil.updateSutdentsMessageActive(id, false);
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
								JOptionPane.showConfirmDialog(StudentsMessageDialog.this, 
										"移除学生在籍状态失败！", "失败", 
										JOptionPane.ERROR_MESSAGE);
								return;
							}
						}
						//更新数据
						tblStudentsMessage.setValueAt(false, row, 10);
						bindStudentsMessageTableModel();
					}
				});
				
				btnWithdraw.setIcon(new ImageIcon(StudentsMessageDialog.class.getResource("/Images/StudentsMessageDialog_Remove.png")));
				btnWithdraw.setActionCommand("Cancel");
				buttonPane.add(btnWithdraw);
			}
		}
	}
	
	//获取显示students_message 表的数据
	private void bindTableModel() {
	    String[] columnNames = { "序号","学号","姓名","性别",
	        "部门|班级","宿舍号","Email", "手机号", "来源地","入学时间","在籍状态"};
	    Object[][] data = null;
		try {
			data = DbUtil.getStudentsMessage();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	     

	   
	}
	
	
	//使用自定义表格模型显示表的数据
	private void bindStudentsMessageTableModel() {
		
		StudentsMessageTableModel model = new StudentsMessageTableModel(); //利用new实例化
		tblStudentsMessage.setModel(model);
		 //设置各列宽度
		tblStudentsMessage.getColumnModel().getColumn(0).setPreferredWidth(10);
	    tblStudentsMessage.getColumnModel().getColumn(1).setPreferredWidth(40);
	    tblStudentsMessage.getColumnModel().getColumn(2).setPreferredWidth(10);
	    tblStudentsMessage.getColumnModel().getColumn(3).setPreferredWidth(5);
	    tblStudentsMessage.getColumnModel().getColumn(4).setPreferredWidth(20);
	    tblStudentsMessage.getColumnModel().getColumn(5).setPreferredWidth(20);
	    tblStudentsMessage.getColumnModel().getColumn(6).setPreferredWidth(140);
	    tblStudentsMessage.getColumnModel().getColumn(7).setPreferredWidth(40);
	    tblStudentsMessage.getColumnModel().getColumn(8).setPreferredWidth(45);
	    tblStudentsMessage.getColumnModel().getColumn(9).setPreferredWidth(65);
	    tblStudentsMessage.getColumnModel().getColumn(10).setPreferredWidth(1);
	    //设置单元格字体
	    tblStudentsMessage.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
	    //设置表格内容居中
	    DefaultTableCellRenderer r= new DefaultTableCellRenderer();   
	    r.setHorizontalAlignment(JLabel.CENTER);   
	    tblStudentsMessage.setDefaultRenderer(Object.class, r);
	    //设置选中行的颜色
	    tblStudentsMessage.setSelectionBackground(new Color(224, 242, 255));
	    //设置行高
	    tblStudentsMessage.setRowHeight(22);
	    //获取表头 更改表头标题字体
	    JTableHeader tab_header = this.tblStudentsMessage.getTableHeader();			
		tab_header.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));
		//更改标题的颜色
		tab_header.setBackground(new Color(230 ,230 ,250));
		
		
		
		//修改本页面的showMessage/Confirm/dialog的颜色
				UIManager.put("OptionPane.background",Color.white);
				UIManager.put("Panel.background", Color.white);
				UIManager.put("Button.background", Color.white);
				UIManager.put("OptionPane.buttonFont", new FontUIResource(new Font("Microsoft YaHei UI", Font.PLAIN, 13)));
				UIManager.put("OptionPane.font", new FontUIResource(new Font("Microsoft YaHei UI", Font.PLAIN, 13)));
				UIManager.put("Panel.font", new FontUIResource(new Font("Microsoft YaHei UI", Font.PLAIN, 13)));	
				
		
		
	}
	
	
	
}




