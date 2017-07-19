package bbs.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bbs.dao.IBaseDAO;

public class BaseDAO implements IBaseDAO {

	private static Connection connection = null; // 数据库连接对象
	private static ResultSet rs = null; // 数据库查询结果集
	private static PreparedStatement pstmt = null; // 数据库操作对象

	// 创建数据库连接
	public Connection getConnection() {
		try {
			if (connection != null && !connection.isClosed()) {
				closeDB();
			}
			Class.forName(SQLDRIVER); // 注册驱动
			connection = DriverManager.getConnection(URL, DBNAME, DBPASSWORD); // 获取数据库连接

		} catch (ClassNotFoundException e) {
			System.out.println("数据库驱动类加载失败！");
		} catch (SQLException e) {
			System.out.println("数据库运行异常!");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("系统运行异常!");
			e.printStackTrace();
		}
		return connection;
	}

	// 关闭数据库连接
	public void closeDB() {
		try {
			if (rs != null) {
				rs.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
			if (connection != null) {
				connection.close();
			}
		} catch (SQLException e) {
			System.out.println("数据库运行异常!");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("系统运行异常!");
			e.printStackTrace();
		}
	}

	// 数据库查询
	public ResultSet findDB(String sql, String[] param) {
		try {
			connection = getConnection(); // 获取连接对象
			pstmt = connection.prepareStatement(sql); // 得到一个PreparedStatement对象
			if (param != null) {
				for (int i = 0; i < param.length; i++) {
					pstmt.setString(i + 1, param[i]); // 设置SQL查询参数
				}
			}
			rs = pstmt.executeQuery(); // 执行SQL，获取查询结果集
		} catch (SQLException e) {
			System.out.println("数据库运行异常!");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("系统运行异常!");
			e.printStackTrace();
		}
		return rs;
	}

	// 数据库更新
	public boolean updateDB(String sql, String[] param) {
		boolean updated = false;
		try {
			connection = getConnection(); // 获取连接对象
			pstmt = connection.prepareStatement(sql); // 得到一个PreparedStatement对象
			if (param != null) {
				for (int i = 0; i < param.length; i++) {
					pstmt.setString(i + 1, param[i]); // 设置SQL查询参数
				}
			}
			if (pstmt.executeUpdate() > 0) { // 执行数据库更新
				updated = true;
			}
		} catch (SQLException e) {
			System.out.println("数据库运行异常!");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("系统运行异常!");
			e.printStackTrace();
		} finally {
			closeDB();
		}
		return updated;
	}
}
