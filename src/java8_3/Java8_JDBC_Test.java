package java8_3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;

/*我的理解，()->{}就是传一个函数实现，而这个方法是通过一种特殊的接口来定义参数列表和返回值的*/
public class Java8_JDBC_Test {
	public static void main(String args[]) {
		System.out.println("test 1");

		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost/db_boot?user=root&password=root" + "&useUnicode=true&characterEncoding=GBK";// 指定jdbc数据源
		String tablename = "t_weight";
		String sql = "select * from " + tablename;// + " where id =?";
		Connection conn = null;

		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url);
		} catch (Exception e) {
			e.printStackTrace();
		}
		select(conn, sql, (rs, n) -> {
			System.out.println(rs.getInt(1) + "," + n);
		},1);
	}

	public static void select(Connection conn, String sql, ResultSetProcessor pr, Object... params) {
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			int n = 0;
			for (Object p : params) {
				ps.setObject(++n, p);
			}
			ResultSet rs = ps.executeQuery();
			long rowsNum = 0;
			while (rs.next()) {
				pr.process(rs, rowsNum++);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
