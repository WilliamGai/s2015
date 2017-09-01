package listMapSet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.atomic.AtomicInteger;

public class ConcurrentSetFixBug2 {
	private static ConcurrentHashMap<String, String> map = new ConcurrentHashMap<String, String>();
	private static ConcurrentSkipListSet<String> set = new ConcurrentSkipListSet<String>();
	private static AtomicInteger acCount = new AtomicInteger(0);
	private static AtomicInteger upCount = new AtomicInteger(0);
	private static String os = "lianyun";
	private static String game_id = "1001";

	private static final String DATA_BASE_NAME = "test";
	private static final String TABLE_NAME = "t_code";
	private static final String DATABASE_USER = "root";
	private static final String DATABASE_PSW = "root";
	private static final String DATABASE_IP = "localhost";
	private static Connection con;
	static void init() {
		long time = System.currentTimeMillis();
		System.out.println("static");

		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://" + DATABASE_IP + ":3306/" + DATA_BASE_NAME
				+ "?user=" + DATABASE_USER + "&password=" + DATABASE_PSW
				+ "&useUnicode=true&characterEncoding=utf-8";

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		initSet(os, game_id);
		System.out.println("初始化数据库到内存的时间毫秒为"
				+ (System.currentTimeMillis() - time));
	}
	public static int getSetSize(){
		return set.size();
	}
	public static String getAndRemove(String openid) {
		return getAndRemove(openid, os, game_id);
	}

	public static String getAndRemove(String openid, String os, String game_id) {
		if (map.containsKey(openid)) {
			return map.get(openid);
		}
		String code = set.pollFirst();
		if (code == null) {
			return null;
		}
		map.put(openid, code);
		acCount.getAndIncrement();
		update(code, openid, os, game_id);
		return code;
	}

	private static void update(String code, String openid, String os,
			String game_id) {
		PreparedStatement pst = null;
		try {
			pst = con.prepareStatement("UPDATE " + TABLE_NAME
					+ " SET flag=? ,openid = ? WHERE code=? and game_id=?");
			pst.setInt(1, 1);
			pst.setString(2, openid);
			pst.setString(3, code);
			pst.setString(4, game_id);
			boolean flag = pst.execute();
			if (flag)
				upCount.incrementAndGet();
			pst.close();
		} catch (SQLException e) {
			System.err.println(e);

		} finally {
			if (con != null) {
				try {
					// con.close();
				} catch (Exception e) {
					System.err.println(e);
				}
			}
		}
	}

	public static void initSet(String os, String game_id) {
		PreparedStatement pst = null;
		try {
			pst = con
					.prepareStatement("SELECT code FROM "
							+ TABLE_NAME
							+ " WHERE flag=0 AND game_id=? AND os =? AND openid IS NULL;");
			pst.setString(1, game_id);
			pst.setString(2, os);
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				set.add(rs.getString(1));
			}
			pst.close();
			System.out.println("end");
			System.out.println("set initend start size()" + set.size());
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					// con.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static void main(String args[]) throws InterruptedException {
		long time = System.currentTimeMillis();

		Thread t = new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 10000; i++) {
					new Thread(new Runnable() {
						@Override
						public void run() {
							getAndRemove(UUID.randomUUID().toString());
						}
					}, "unsafe map" + i).start();
//					System.out.println("acount" + acCount);
				}
			}
		}, "main");
		t.start();
		t.join();
		System.out.println("最后更新的激活码个数" + acCount);
		System.out.println("剩余的set大小为" + set.size());
		System.out.println("最后更新的激活码时间毫秒为" + (System.currentTimeMillis()-time));
		for (int i = 0; i < 10; i++) {
			getAndRemove(i + "");
			getAndRemove(i + "");
			getAndRemove(i + "");
		}
		System.out.println("更新的激活码个数" + acCount);
		System.out.println("更新的激活码时间毫秒为" + (System.currentTimeMillis()-time));

		System.out.println("map的大小为" + map.size());
	}
}
