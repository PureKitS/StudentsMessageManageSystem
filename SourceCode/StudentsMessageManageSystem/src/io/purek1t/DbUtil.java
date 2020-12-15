package io.purek1t;

import java.sql.*;



public class DbUtil {
	private static final String url = "jdbc:mysql://localhost/students?serverTimezone=PRC";
	private static final String user = "root";
	private static final String password = "root";
	
	//获取数据库连接的方法
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url,user,password);
	}
	
	//关闭数据库连接的方法
	public static void Close(Connection conn) throws SQLException {
		if (conn!=null) {
			conn.close();
		}
	}
	
	//获取studentsMessage的数据
	public static Object[][] getStudentsMessage() throws SQLException {
		Connection conn = DbUtil.getConnection();
		//建立sql查询语句，获取查询结果
		String sql =  "select  id,students_id, name, sex, "
				+ " department, room_id, email, "
				+ " phone_id, address, start_school,"
				+ " active from students_message";
		PreparedStatement pstmt = conn.prepareStatement(sql,
				ResultSet.TYPE_SCROLL_INSENSITIVE,
				ResultSet.CONCUR_READ_ONLY);
		ResultSet rs = pstmt.executeQuery();//预处理查询语句
		//获取当前集合的行数，定义数组大小
		rs.last();
		Object[][] studentsMessage = new Object[rs.getRow()][];
		rs.beforeFirst();
		int row = 0;
		while(rs.next()) {
			Object[] stu = new Object[] {
					rs.getInt("id"),
					rs.getString("students_id"),
					rs.getString("name"),
					rs.getString("sex"),
					rs.getString("department"),
					rs.getString("room_id"),
					rs.getString("email"),
					rs.getString("phone_id"),
					rs.getString("address"),
					rs.getDate("start_school"),
					rs.getInt("active")==1?true:false
			};
			//每读取一行 ++
			studentsMessage[row++] = stu;
		}
		//关闭数据库
		DbUtil.Close(conn);
		return studentsMessage;
	}
	
	// 从数据库读取一条学生信息
	public static StudentsMessage getStudentsMessage(int id) throws SQLException {
		Connection conn = DbUtil.getConnection();
		String sql = "select id ,students_id,name, sex,"
				+ " department, room_id, email, "
				+ " phone_id, address,  start_school,active from students_message"
				+ " where id=?";
		PreparedStatement pstmt = conn.prepareStatement(sql); 
		pstmt.setInt(1,id);
		ResultSet rs = pstmt.executeQuery();
		StudentsMessage stu = null;
		if (rs.next()) {
			stu = new StudentsMessage();
			stu.setId(rs.getInt("id"));
			stu.setStudentsID(rs.getString("students_id"));
			stu.setName(rs.getString("name"));
			stu.setSex(rs.getString("sex"));
			stu.setDepartment(rs.getString("department"));
			stu.setRoomID(rs.getString("room_id"));
			stu.setEmail(rs.getString("email"));
			stu.setPhoneID(rs.getString("phone_id"));
			stu.setAddress(rs.getString("address"));
			stu.setStartSchoolDate(rs.getDate("start_school"));
			stu.setActive(rs.getInt("active"));
		}
		DbUtil.Close(conn);
		return stu;
	}
	
	
	//更新 修改 保存数据库
	public  static boolean updateStudentsMessage(StudentsMessage s) throws SQLException {
		//建立数据库连接
		Connection conn = DbUtil.getConnection();
		//定义语句 update
		String sql = "update students_message set  students_id=?,"
				+ " name=?, sex=?, department=?, room_id=?,"
				+ " email=?, phone_id=?, address=?, active=?"
				+ " where id=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, s.getStudentsID());
		pstmt.setString(2, s.getName());
		pstmt.setString(3, s.getSex());
		pstmt.setString(4, s.getDepartment());
		pstmt.setString(5, s.getRoomID());
		pstmt.setString(6, s.getEmail());
		pstmt.setString(7, s.getPhoneID());
		pstmt.setString(8, s.getAddress());
		pstmt.setBoolean(9,s.isActive());
		pstmt.setInt(10, s.getId());
		//更新数据表
		int sucess = pstmt.executeUpdate();
		//关闭数据库
		DbUtil.Close(conn);
		//判断更新是否成功
		return sucess>0;
	}
	
	
	//插入学生信息记录
	public static boolean insertStudentsMessage(StudentsMessage s) throws SQLException {
		Connection conn = DbUtil.getConnection();
		String sql = "insert into students_message(students_id,name,sex,"
				+ " department,room_id,email, phone_id,address, active)"
				+ " values(?,?,?,?,?,?,?,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, s.getStudentsID());
		pstmt.setString(2, s.getName());
		pstmt.setString(3, s.getSex());
		pstmt.setString(4, s.getDepartment());
		pstmt.setString(5, s.getRoomID());
		pstmt.setString(6, s.getEmail());
		pstmt.setString(7, s.getPhoneID());
		pstmt.setString(8, s.getAddress());
		pstmt.setInt(9, s.isActive()?1:0);
		int success = pstmt.executeUpdate();
		DbUtil.Close(conn);
		return success>0;
	}
	
	
	//删除学生学籍 在籍状态
	public static boolean updateSutdentsMessageActive(int id, boolean  isActive) 
			throws SQLException {
		Connection conn = getConnection();
		String sql = "update students_message set active=? "
				+ " where id=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setBoolean(1, isActive);
		pstmt.setInt(2, id);
		//更新数据表
		int success = pstmt.executeUpdate();
		//关闭数据库
		conn.close();
		//判断更新是否成功并且返回
		return success>0;
	}
	
	//判断给定用户名和密码能否登录
	//能登录返回User对象 不能登录返回null
	public static User getLoginUser(String username, String password)
			throws SQLException {
		User user = null;
		Connection conn = getConnection();
		String sql = "select admin_id, admin_name, admin_email, create_date,"
				+ " admin_active, username from admin"
				+ " where username=? and `password` = sha(?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, username);
		pstmt.setString(2, password);
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()) {
			user = new User();
			user.setAdminID(rs.getInt("admin_id"));
			user.setAdminName(rs.getString("admin_name"));
			user.setAdminEmail(rs.getString("admin_email"));
			user.setAdminCreateDate(rs.getDate("create_date"));
			user.setAdminActive(rs.getInt("admin_active"));
			user.setUserName(rs.getString("username"));
		}
		//关闭数据库连接
		conn.close();
		return user;
 	}
	
//	//修改管理员密码比对 数据库的用户名
//	public static User selAdminUserName(String username , String OldPassword) 
//			throws SQLException {
//		User user = null;
//		Connection conn = getConnection();
//		String sql = "select username ,password from admin"
//				+ " where username=? and 'password'=sha1(?) ";
//		PreparedStatement pstmt	=conn.prepareStatement(sql);
//		pstmt.setString(1, username);
//		pstmt.setString(2, OldPassword);
//		ResultSet rs = pstmt.executeQuery();
//		if(rs.next()) {
//			user = new User();
//			user.setUserName(rs.getString("username"));
//			user.setPassword(rs.getString("password"));
//		}
//		conn.close();
//		return user;
//		
//	}
	
	
	//管理员修改密码
	public  static boolean updateAdminPassword(String username, String newPassword) 
			throws SQLException {
		
		Connection conn = getConnection();
		String sql = "update admin set `password`=sha(?) "
				+ " where username=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1,newPassword);
		pstmt.setString(2, username);
	
		int success = pstmt.executeUpdate();
		conn.close();
		return success>0;
	}
	
}
