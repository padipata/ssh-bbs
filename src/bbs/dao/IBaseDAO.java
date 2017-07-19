package bbs.dao;

import java.sql.*;

public interface IBaseDAO {

	public final static String SQLDRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	public final static String URL = "jdbc:sqlserver://localhost:1433;databaseName=bbs";
	public final static String DBNAME = "sa";
	public final static String DBPASSWORD = "123456";

	public Connection getConnection(); // 创建数据库连接

	public void closeDB(); // 关闭数据库连接

	public ResultSet findDB(String sql, String[] param); // 数据库查询

	public boolean updateDB(String sql, String[] param); // 数据库更新
}
