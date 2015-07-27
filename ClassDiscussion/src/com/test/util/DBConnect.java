package com.test.util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.naming.InitialContext;
import javax.sql.DataSource;
/**
 * 此类，用于servlet中数据库操作与连接池交互的通道
 * 
 */
public class DBConnect {
	Connection conn = null; // 数据库连接变量
	Statement stmt = null;// statement语句变量
	private PreparedStatement prepstmt = null;// 预定义statement 变量
	// private DBConnectionManager dcm=null;//连接池管理变量
	DataSource ds = null;

	private String user = "root";
	private String password = "930820";
	private String className = "com.mysql.jdbc.Driver";
	private String url = "jdbc:mysql://127.0.0.1:3306/webclass";

	public void init() throws Exception {
		try {
			Class.forName(className);
			conn = DriverManager.getConnection(url, user, password);
			conn.setAutoCommit(true);
		} catch (ClassNotFoundException e) {
			System.out.println("加载数据库驱动失败！");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("创建数据库连接失败！");
			conn = null;
			e.printStackTrace();
		}
	}

	// 构造数据库的连接和访问类
	public DBConnect() throws Exception {
		init();
		stmt = conn.createStatement();
	}

	public DBConnect(int resultSetType, int resultSetConcurrency)
			throws Exception {
		init();
		stmt = conn.createStatement(resultSetType, resultSetConcurrency);
	}

	// 执行sql语句，返回结果集
	public ResultSet executeQuery(String sql) throws SQLException {
		if (stmt != null) {
			return stmt.executeQuery(sql);
		} else
			return null;
	}

	public ResultSet executeQuery() throws SQLException {
		if (prepstmt != null) {
			return prepstmt.executeQuery();
		} else
			return null;
	}

	public int executeUpdate(String sql) throws SQLException {
		if (stmt != null) {
			return stmt.executeUpdate(sql);
		} else
			return -1;
	}

	public int executeUpdate() throws SQLException {
		if (prepstmt != null) {
			return prepstmt.executeUpdate();
		} else
			return -1;
	}

	// 够找数据库的连接和访问类
	// 预编译SQL语句
	public DBConnect(String sql) throws Exception {
		init();
		this.prepareStatement(sql);
	}

	public DBConnect(String sql, int resultSetType, int resultSetConcurrency)
			throws Exception {
		init();
		this.prepareStatement(sql, resultSetType, resultSetConcurrency);
	}

	// 返回连接
	public Connection getConnection() {
		return conn;
	}

	// 关闭连接
	public void close() throws Exception {
		if (stmt != null) {
			stmt.close();
			stmt = null;
		}
		if (prepstmt != null) {
			prepstmt.close();
			prepstmt = null;
		}
		if (conn != null) {
			conn.close();
		}
	}

	// preparedStatement 创建一个对象
	public void prepareStatement(String sql) throws SQLException {
		prepstmt = conn.prepareStatement(sql);

	}

	public void prepareStatement(String sql, int resultSetType,
			int resultSetConcurrency) throws SQLException {
		prepstmt = conn.prepareStatement(sql, resultSetType,
				resultSetConcurrency);
	}

	// 设置对应的值
	// index参数索引value对应值
	public void setString(int index, String value) throws SQLException {
		prepstmt.setString(index, value);
	}

	public void setInt(int index, int value) throws SQLException {
		prepstmt.setInt(index, value);
	}

	public void setBoolean(int index, boolean value) throws SQLException {
		prepstmt.setBoolean(index, value);
	}

	public void setDate(int index, Date value) throws SQLException {
		prepstmt.setDate(index, value);
	}

	public void setLong(int index, long value) throws SQLException {
		prepstmt.setLong(index, value);
	}

	public void setFloat(int index, float value) throws SQLException {
		prepstmt.setFloat(index, value);
	}

	public void setBytes(int index, byte[] value) throws SQLException {
		prepstmt.setBytes(index, value);
	}

	// 清除参数及返回状态
	public void clearParameters() throws SQLException {
		prepstmt.clearParameters();
		prepstmt = null;
	}

	public PreparedStatement getPreparedStatement() {
		return prepstmt;
	}

	public Statement getStatement() {
		return stmt;
	}
}

