package io.purek1t;

import java.sql.SQLException;

import javax.swing.table.AbstractTableModel;

public class StudentsMessageTableModel extends AbstractTableModel{
	private String[] ColumnNames = { "序号","学号","姓名","性别",
	        "部门|班级","宿舍号","Email", "手机号", "来源地","入学时间","在籍状态"};
	private Object[][] studentsMessage ;
	
	
	public StudentsMessageTableModel() {
		try {
			this.studentsMessage = DbUtil.getStudentsMessage();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	
	@Override //获取行数
	public int getRowCount() {
		// TODO Auto-generated method stub
		return this.studentsMessage.length;
	}

	@Override  //获取列的名称
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
	    return ColumnNames[column];
	}

	@Override  //获取列的类型
	public Class<?> getColumnClass(int columnIndex) {
		// TODO  Auto-generated method stub
		return this.getValueAt(0, columnIndex).getClass();
	}

	@Override  //获取列的数量
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return this.ColumnNames.length;
	}

	@Override  //每一行每一列对应的值
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return studentsMessage[rowIndex][columnIndex];
	}

}
