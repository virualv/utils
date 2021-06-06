package com.byteorc.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JDBC02Util {
	private static final ComboPooledDataSource DATA_SOURCE = new ComboPooledDataSource();

	/**
	 * 获得连接
	 * @return
	 */
	public static Connection getConnection() {
		Connection conn = null;
		try {
			 conn = DATA_SOURCE.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}

	/**
	 * 获得连接池
	 * @return
	 */
	public static DataSource getDataSource() {
		return DATA_SOURCE;
	}

	/**
	 * 释放资源
	 * @param conn
	 */
	public static void close(Connection conn) {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * 释放资源
	 * @param rs
	 * @param conn
	 */
	public static void close(ResultSet rs, Connection conn) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * 释放资源
	 * @param pst
	 * @param rs
	 * @param conn
	 */
	public static void close(PreparedStatement pst, ResultSet rs, Connection conn) {
		if (pst != null) {
			try {
				pst.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
