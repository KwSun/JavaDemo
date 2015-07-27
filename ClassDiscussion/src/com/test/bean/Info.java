package com.test.bean;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.test.util.DBConnect;
/**
 * 通知
 * @author apple
 *
 */
public class Info {
	private int id;
	private String title;
	private String content;
	private String pubdate;
	private int typeid;//管理员还是普通成员
	private String author;
	private String typeName;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getPubdate() {
		return pubdate;
	}

	public void setPubdate(String pubdate) {
		this.pubdate = pubdate;
	}

	public int getTypeid() {
		return typeid;
	}

	public void setTypeid(int typeid) {
		this.typeid = typeid;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	/**
	 * 删除信息
	 * @return
	 */
	public int deleteinfo() {
		int flag = 0;
		String sql = "delete from  info where Id=?";
		try {
			DBConnect dbc = new DBConnect(sql);
			dbc.setInt(1, id);

			flag = dbc.executeUpdate();

		} catch (Exception e) {
			return flag;
		}
		return flag;
	}

	/**
	 * 更新信息
	 * @return
	 */
	public int modifyinfo() {
		int flag = 0;
		String sql = "update depart set 院系名称=? where 院系编号=?";
		try {
			DBConnect dbc = new DBConnect(sql);
			flag = dbc.executeUpdate();

			dbc.close();
		} catch (Exception e) {
			e.printStackTrace();
			return flag;
		}
		return flag;
	}

	
	/**
	 * 获取首页显示的信息，限制显示条数为5 获取类型，增加一个控制函数，用于控制是在首页显示还是在详细页显示
	 * @param type
	 * @param isIndex
	 * @return
	 */
	public List<Info> getInfo(int type, boolean isIndex) {
		List<Info> infoList = new ArrayList<Info>();

		String sql;
		if (isIndex) {
			sql = "select Id,title,pubdate from info where typid=? order by pubdate desc limit 5";
		} else {
			sql = "select Id,title,pubdate from info where typid=? order by pubdate desc";
		}
		DBConnect dbc;
		ResultSet rs = null;

		try {
			dbc = new DBConnect(sql);
			dbc.setInt(1, type);
			rs = dbc.executeQuery();
			while (rs.next()) {
				Info info = new Info();
				info.setId(rs.getInt(1));
				info.setTitle(rs.getString(2));
				info.setPubdate(rs.getString(3).substring(0, 19));

				infoList.add(info);
			}
			dbc.close();

		} catch (Exception e) {
			return null;
		}
		return infoList;
	}

	/**
	 * 增加通知
	 * @return
	 */
	public int addInfo() {
		int flag = -1;

		String sql = "insert into info(title,content,author,typid) values (?,?,?,?)";
		DBConnect dbc;
		ResultSet rs = null;

		String adpwd = null;
		try {
			dbc = new DBConnect(sql);
			dbc.setString(1, title);
			dbc.setString(2, content);
			dbc.setString(3, author);
			dbc.setInt(4, typeid);
			flag = dbc.executeUpdate();

			dbc.close();
		} catch (Exception e) {
			return flag;
		}
		return flag;

	}

	/**
	 * 获取信息
	 * @param infoId
	 * @return
	 */
	public Info getInfo(int infoId) {
		Info info = new Info();

		String sql = "select a.Id,title,content,pubdate,author,typeName from info a,type b where a.typid=b.Id and a.Id=? order by pubdate desc";

		DBConnect dbc;
		ResultSet rs = null;

		try {
			dbc = new DBConnect(sql);
			dbc.setInt(1, infoId);
			rs = dbc.executeQuery();
			while (rs.next()) {
				info.setId(rs.getInt(1));
				info.setTitle(rs.getString(2));
				info.setContent(rs.getString(3));
				info.setPubdate(rs.getString(4).substring(0, 19));
				info.setAuthor(rs.getString(5));
				info.setTypeName(rs.getString(6));
			}
			dbc.close();
		} catch (Exception e) {
			return null;
		}
		return info;
	}

	
	public String toString() {
		return title + pubdate + id;
	}

}
