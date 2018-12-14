package com.bjsxt.kong.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

import com.bjsxt.util.DBUtil;

/**
 * 基本dao, 只能被dao实现类继承后使用
 * 
 * @author Administrator
 * 
 */
abstract class BaseDao {

	/**
	 * 执行增删改的统一方法
	 * 
	 * @param sql
	 *            DML的SQL语句
	 * @param params
	 *            待绑定的参数
	 * @return
	 */
	protected boolean update(String sql, Object... params) {
		Connection conn = DBUtil.getConn();
		PreparedStatement pstmt = DBUtil.getPstmt(conn, sql);
		DBUtil.bindParam(pstmt, params);
		try {
			int index = pstmt.executeUpdate();
			if (index > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(null, pstmt, conn);
		}
		return false;
	}

	/**
	 * 查询多条结果调用的方法
	 * 
	 * @param cls
	 *            泛型的类对象
	 * @param sql
	 *            要执行的查询语句
	 * @param params
	 *            待绑定的参数
	 * @return
	 */
	protected <T> List<T> query(Class<T> cls, String sql, Object... params) {
		List<T> list = new ArrayList<>();

		Connection conn = DBUtil.getConn();
		PreparedStatement pstmt = DBUtil.getPstmt(conn, sql);
		DBUtil.bindParam(pstmt, params);
		ResultSet rs = null;
		try {
			rs = pstmt.executeQuery();
			// 获取字段信息
			ResultSetMetaData metaData = rs.getMetaData();
			while (rs.next()) {
				// 创建T对象
				T bean = cls.newInstance();
				// 为对象的属性赋值
				for (int i = 0; i < metaData.getColumnCount(); i++) {
					BeanUtils.setProperty(bean, metaData.getColumnLabel(i + 1),
							rs.getObject(metaData.getColumnLabel(i + 1)));
				}
				// 将对象添加到List集合中
				list.add(bean);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs, pstmt, conn);
		}
		return list;
	}

	/**
	 * 查询单条结果调用的方法
	 * 
	 * @param cls
	 *            泛型的类对象
	 * @param sql
	 *            要执行的查询语句
	 * @param params
	 *            待绑定的参数
	 * @return
	 */
	protected <T> T queryOne(Class<T> cls, String sql, Object... params) {
		Connection conn = DBUtil.getConn();
		PreparedStatement pstmt = DBUtil.getPstmt(conn, sql);
		DBUtil.bindParam(pstmt, params);
		ResultSet rs = null;
		try {
			rs = pstmt.executeQuery();
			// 获取字段信息
			ResultSetMetaData metaData = rs.getMetaData();
			if (rs.next()) {
				// 创建T对象
				T bean = cls.newInstance();
				// 为对象的属性赋值
				for (int i = 0; i < metaData.getColumnCount(); i++) {
					BeanUtils.setProperty(bean, metaData.getColumnLabel(i + 1),
							rs.getObject(metaData.getColumnLabel(i + 1)));
				}
				return bean;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs, pstmt, conn);
		}
		return null;
	}

	/**
	 * 查询记录数的方法
	 * 
	 * @param sql
	 * @param params
	 * @return
	 */
	protected int queryCount(String sql, Object... params) {
		Connection conn = DBUtil.getConn();
		PreparedStatement pstmt = DBUtil.getPstmt(conn, sql);
		DBUtil.bindParam(pstmt, params);
		ResultSet rs = null;
		try {
			rs = pstmt.executeQuery();
			if (rs.next()) {
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs, pstmt, conn);
		}
		return 0;
	}
}
