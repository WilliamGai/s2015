package jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.util.HashMap;
import java.util.Map;

public class Test {
	public static void main(String args[]){
		String driver="com.mysql.jdbc.Driver";
		String url="jdbc:mysql://localhost/storage?user=root&password=daofeng" +
				"&useUnicode=true&characterEncoding=GBK";//指定jdbc数据源
		String tablename = "stockinfo";
		Connection conn = null;
		
		try {
			Class.forName(driver);
			conn=DriverManager.getConnection(url);
		} catch (Exception e) {e.printStackTrace();}
		
		Map dateMap = new HashMap<String, Date>();
		Date d = (Date)dateMap.get("a");
		System.out.println(d);
	}

}
