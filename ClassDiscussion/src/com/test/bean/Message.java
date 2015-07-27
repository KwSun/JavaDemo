package com.test.bean;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.test.util.DBConnect;

public class Message {

	private int id;
	private String from;// 发送者账号
	private String to;// 接收者账号
	private String msg;// 发送内容
	private String sendtime;
	private String isRead;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getSendtime() {
		return sendtime;
	}

	public void setSendtime(String sendtime) {
		this.sendtime = sendtime;
	}

	public String getIsRead() {
		return isRead;
	}

	public void setIsRead(String isRead) {
		this.isRead = isRead;
	}

	public int addMsg() {
		int flag = -1;

		String sql = "insert into message(afrom,ato,msg) values (?,?,?)";
		DBConnect dbc;

		try {
			dbc = new DBConnect(sql);
			dbc.setString(1, from);
			dbc.setString(2, to);
			dbc.setString(3, msg);

			flag = dbc.executeUpdate();

			dbc.close();
		} catch (Exception e) {
			return flag;
		}
		return flag;

	}

	public List<Message> getMsgList(boolean isLimit) {
		List<Message> infoList = new ArrayList<Message>();

		String sql;
		if (isLimit) {
			sql = "select a.Id,sname,msg,sendTime,isRead from message a,classmate b where ato=? and a.afrom=b.sno order by sendTime desc limit 5";
		} else {
			sql = "select a.Id,sname,msg,sendTime,isRead from message a,classmate b where ato=? and a.afrom=b.sno order by sendTime desc";
		}
		DBConnect dbc;
		ResultSet rs = null;

		try {
			dbc = new DBConnect(sql);
			dbc.setString(1, to);

			rs = dbc.executeQuery();
			while (rs.next()) {
				Message msg = new Message();
				msg.setId(rs.getInt(1));
				msg.setFrom(rs.getString(2));
				msg.setMsg(rs.getString(3));
				msg.setSendtime(rs.getString(4).substring(0, 19));
				msg.setIsRead(rs.getString(5));
				infoList.add(msg);
			}
			dbc.close();

		} catch (Exception e) {
			return null;
		}
		return infoList;
	}

}
