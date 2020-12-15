package io.purek1t;

import java.util.Date;

public class StudentsMessage {
		private int id;    				//序号
		private String studentsID;		//学号
		private String name;			//姓名
		private String sex;				//性别
		private String department;      //班级
		private String roomID;			//宿舍号
		private String email;			//邮箱
	    private String phoneID;			//手机号
	    private String address;			//地址
	    private Date startSchoolDate;	//入学时间
		private boolean active;			//在籍状态
	    
	    
		// 生成各字段对应的get属性和set属性
	    public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
	    
		public String getStudentsID() {
			return studentsID;
		}
		public void setStudentsID(String studentsID) {
			this.studentsID = studentsID;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getSex() {
			return sex;
		}
		public void setSex(String sex) {
			this.sex = sex;
		}
		public String getDepartment() {
			return department;
		}
		public void setDepartment(String department) {
			this.department = department;
		}
		public String getRoomID() {
			return roomID;
		}
		public void setRoomID(String roomID) {
			this.roomID = roomID;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getPhoneID() {
			return phoneID;
		}
		public void setPhoneID(String phoneID) {
			this.phoneID = phoneID;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		public boolean isActive() {
			return active;
		}
		public void setActive(int active) {
			if (active==1) this.active = true;
			else this.active = false;
		}
		public void setActive(boolean isActive) {
			this.active = isActive;
		}
		public Date getStartSchoolDate() {
				return startSchoolDate;
			}
		public void setStartSchoolDate(Date startSchoolDate) {
				this.startSchoolDate = startSchoolDate;
			}
		
		
}
