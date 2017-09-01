package jdbc;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


public class jdbcUtil_存Map {
	private static Connection con;  
	private static int  insert_count;  
	private static int  update_count;  
	static {
		String driver="com.mysql.jdbc.Driver";
		String url="jdbc:mysql://119.29.52.126:3306/new_hz?user=gmuser&password=gmuser" +
				"&useUnicode=true&characterEncoding=utf-8";
		
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	  public static void addMap(Map<String,String> map, String fileName){
			System.out.println("start");
			String csn = Charset.defaultCharset().name();
			System.out.println(csn);
			BufferedReader br;
			int count = 0;
			try {
				File file = new File(fileName);
				br = new BufferedReader(new FileReader(file));
				String line = null;//KEY
				while ((line = br.readLine()) != null) {
					map.put(line, "");
				   count ++;
				}
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println(count*2);
			System.out.println(map.size());

	  }
	  public static void log(String s){
		  System.out.println(s);
	  }
	  public static void main(String[] args) {
		  try {
			//uid,openid
			Map<String,String> map = new HashMap<String,String>();
			addMap(map, "豪华礼包.txt");
			addRole(map);//添加openid和uid到role表里
			System.out.println(update_count+":"+insert_count);
		  } catch (Exception e) {
			  e.printStackTrace();
		  }
		  finally{
			  if (con != null) {
		    		try {
		    			con.close();
		    		} catch (SQLException e) {
		    			e.printStackTrace();
		    		}
		    	}
		  }
	  }
	private static void addRole(Map<String, String> map) {
		System.out.println("map size:"	+	map.size());
		PreparedStatement pst = null;
		StringBuilder sb = new StringBuilder("INSERT ignore INTO t_code VALUES");
		int count =0;
		
		try {
			for (Iterator<Map.Entry<String, String>> it = map.entrySet().iterator(); it.hasNext();) {
				Map.Entry<String, String> entry = it.next();
		        sb.append("('").append(entry.getKey())
		        .append("',null,null,null")
		        .append("),");

		        it.remove();
		        count++;
		        if(count++>20000||map.size()==0){
		        	String sql = sb.toString();
		        	sql = sql.substring(0, sql.length()-1);
					System.out.println("sql大小?:" + sql.length());
					System.out.println(count);
//					System.out.println(sql);
//					log("insert:" + openid + ","+value);
					pst = con.prepareStatement(sql);
					pst.execute();
					pst.close();
					addRole(map);
		        	return;
		        }
			}	
		} catch (SQLException e) {
			  e.printStackTrace();
		}
	}
}
