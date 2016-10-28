package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class BaseDao {
	// 定义数据库连接对象
	private Connection connection = null;
	// 定义参数化的执行对象
	private PreparedStatement pment = null;
	// 定义一个结果集对象
	private ResultSet rs = null;

	public BaseDao() {
	}

	/**
	 * 获取数据库连接
	 */
	public Connection getConnection() {
		try {
			Context cxt = new InitialContext();
			DataSource ds = (DataSource) cxt.lookup("java:comp/env/jdbc/12306db");
			connection = ds.getConnection();
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}

	/**
	 * 关闭所有数据库操作对象
	 */
	public void closeAllObject(ResultSet rs, Statement pment, Connection connection) {
		try {
			if (rs != null)
				rs.close();
			if (pment != null)
				pment.close();
			if (connection != null)
				connection.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * 执行select语句时，获取结果集
	 * 
	 * @param sSql
	 *            要求执行的SQL语句
	 * @param oParams
	 *            执行SQL命令所需的参数列表
	 * @return 结果集
	 */
	public ResultSet getResultSet(String sSql, Object[] oParams) {
		rs = null;
		Connection conn = getConnection();
		try {
			// 基于connection连接对象，根据要求要执行的SQL命令创建执行对象
			pment = connection.prepareStatement(sSql);
			// 判断执行SQL命令所需的参数列表是否为空对象或空内容
			if (oParams != null && oParams.length != 0) {
				for (int i = 0; i < oParams.length; i++) {
					// 利用循环将执行SQL命令所需的参数列表逐个添加至执行对象
					pment.setObject((i + 1), oParams[i]);
				}
			}
			// 基于执行对象，执行修改操作(insert,update,delete语句)
			rs = pment.executeQuery();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return rs;
	}
}
