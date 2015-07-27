package com.test.bean;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.test.util.DBConnect;

public class Classmate {

	private int id;
	private String sno;
	private String pwd;
	private String sname;
	private String status;
	private int age;
	private int sex;
	private String qq;
	private String msn;
	private String phone;
	private String dormitory;
	private String uptime;
	private String image;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSno() {
		return sno;
	}

	public void setSno(String sno) {
		this.sno = sno;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getMsn() {
		return msn;
	}

	public void setMsn(String msn) {
		this.msn = msn;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getDormitory() {
		return dormitory;
	}

	public void setDormitory(String dormitory) {
		this.dormitory = dormitory;
	}

	public String getUptime() {
		return uptime;
	}

	public void setUptime(String uptime) {
		this.uptime = uptime;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int login() {
		int flag = -1;

		String sql = "select pwd from classmate where sno=?";
		DBConnect dbc;
		ResultSet rs = null;

		String adpwd = null;
		try {
			dbc = new DBConnect(sql);
			dbc.setString(1, sno);
			rs = dbc.executeQuery();
			while (rs.next()) {
				adpwd = rs.getString(1);
			}
			dbc.close();
		} catch (Exception e) {
			return flag;
		}

		if (adpwd != null && adpwd.equals(pwd)) {
			flag = 1;
		}
		return flag;
	}

	public Classmate getStudent() throws Exception {
		// private int id;
		//		
		// private String sname;

		Classmate student = new Classmate();

		// String sql =
		// "select sname,state,age,sex,qq,msn,phone,dormitory,updatetime,image "
		// +
		// "from classmate a,status b " +
		// "where a.sno=b.sno and a.sno=? " +
		// " order by updatetime desc limit 1";
		String sql = "select sname,state,age,sex,qq,msn,phone,dormitory,updatetime,image "
				+ "from (classmate as a left outer join status as b" + " on a.sno=b.sno) " + "where a.sno=? "
				+ "order by updatetime desc limit 1";
		DBConnect dbc;
		ResultSet rs = null;

		// try {
		dbc = new DBConnect(sql);
		dbc.setString(1, sno);
		rs = dbc.executeQuery();
		while (rs.next()) {
			student.setSno(sno);
			student.setSname(rs.getString(1));
			student.setStatus(rs.getString(2));
			student.setAge(rs.getInt(3));
			student.setSex(rs.getInt(4));
			student.setQq(rs.getString(5));
			student.setMsn(rs.getString(6));
			student.setPhone(rs.getString(7));
			student.setDormitory(rs.getString(8));
			String upt = rs.getString(9);
			student.setUptime(upt != null ? upt.substring(0, 19) : "");
			student.setImage(rs.getString(10));
		}
		dbc.close();

		// } catch (Exception e) {
		// return null;
		// }
		return student;

	}

	public List<Classmate> getStudentList() {
		List<Classmate> studentlist = new ArrayList<Classmate>();

		String sql = "select sno,sname,phone,dormitory,image from classmate order by sno";
		DBConnect dbc;
		ResultSet rs = null;

		try {
			dbc = new DBConnect();

			rs = dbc.executeQuery(sql);
			while (rs.next()) {
				Classmate student = new Classmate();
				student.setSno(rs.getString(1));
				student.setSname(rs.getString(2));
				student.setPhone(rs.getString(3));
				student.setDormitory(rs.getString(4));
				student.setImage(rs.getString(5));
				studentlist.add(student);
			}
			dbc.close();

		} catch (Exception e) {
			return null;
		}
		return studentlist;

	}

	public List<Classmate> getStudentStatusList() {
		List<Classmate> studentlist = new ArrayList<Classmate>();

		String sql = "select a.sno,sname,state,updatetime,image" + " from classmate a,status b" + " where a.sno=b.sno and a.sno!=?"
				+ " order by updatetime desc limit 5 ";

		DBConnect dbc;
		ResultSet rs = null;

		try {
			dbc = new DBConnect(sql);
			dbc.setString(1, sno);
			rs = dbc.executeQuery();
			while (rs.next()) {
				Classmate student = new Classmate();

				student.setSno(rs.getString(1));
				student.setSname(rs.getString(2));
				student.setStatus(rs.getString(3));
				student.setUptime(rs.getString(4));
				student.setImage(rs.getString(5));
				studentlist.add(student);
			}
			dbc.close();

		} catch (Exception e) {
			return null;
		}
		return studentlist;

	}

	public int uploadImage() {
		int flag = -1;

		String sql = "update classmate set image=? where sno=?";
		DBConnect dbc;
		try {
			dbc = new DBConnect(sql);
			dbc.setString(1, image);
			dbc.setString(2, sno);

			flag = dbc.executeUpdate();
			dbc.close();
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}

	public int modifyStatus(String status, String snoo) {
		int flag = -1;

		// String sql = "update status set state=? where sno=?";
		String sql = "insert into status(state,sno) values('" + status + "'," + snoo + ")";
		DBConnect dbc;

		try {
			dbc = new DBConnect(sql);
			flag = dbc.executeUpdate();
			dbc.close();
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}

	public int modifyInfo(boolean chgpwd) {
		int flag = -1;
		if (!chgpwd) {
			String sql = "update classmate set sname=?,age=?,sex=?,qq=?,msn=?,phone=?,dormitory=?  where sno=?";
			DBConnect dbc;
			try {
				dbc = new DBConnect(sql);
				dbc.setString(1, sname);
				dbc.setInt(2, age);
				dbc.setInt(3, sex);
				dbc.setString(4, qq);
				dbc.setString(5, msn);
				dbc.setString(6, phone);
				dbc.setString(7, dormitory);
				dbc.setString(8, sno);

				flag = dbc.executeUpdate();
				dbc.close();
			} catch (Exception e) {
				return flag;
			}
		}else{
			String sql = "update classmate set pwd=?,sname=?,age=?,sex=?,qq=?,msn=?,phone=?,dormitory=?  where sno=?";
			DBConnect dbc;
			try {
				dbc = new DBConnect(sql);
				dbc.setString(1, pwd);
				dbc.setString(2, sname);
				dbc.setInt(3, age);
				dbc.setInt(4, sex);
				dbc.setString(5, qq);
				dbc.setString(6, msn);
				dbc.setString(7, phone);
				dbc.setString(8, dormitory);
				dbc.setString(9, sno);

				flag = dbc.executeUpdate();
				dbc.close();
			} catch (Exception e) {
				return flag;
			}
		}
		return flag;
	}

	public String addStudent() {
		// int flag=-1;
		String flag = "success";

		String sql = "insert into classmate(sno,pwd,sname,age,sex,qq,msn,phone,dormitory) values(?,?,?,?,?,?,?,?,?)";
		DBConnect dbc;

		try {
			dbc = new DBConnect(sql);

			dbc.setString(1, sno);
			dbc.setString(2, pwd);
			dbc.setString(3, sname);
			dbc.setInt(4, age);
			dbc.setInt(5, sex);
			dbc.setString(6, qq);
			dbc.setString(7, msn);
			dbc.setString(8, phone);
			dbc.setString(9, dormitory);

			dbc.executeUpdate();
			dbc.close();
		} catch (Exception e) {
			return flag + e.getStackTrace() + e.getMessage();
		}
		return flag;
	}

	public String toString() {
		return sno + "," + pwd + "," + sname + "," + age + "," + sex + "," + qq + "," + msn + "," + phone + "," + dormitory + ",";
	}

}
