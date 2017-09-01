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
import java.util.Map.Entry;


public class Map_比例 {
	private static int  insert_count;  
	private static int  update_count;  
	  public static void addMap(Map<String,String> map, String fileName,String f, int cc){
			BufferedReader br;
			String s = "start size:"+map.size();
			int count =10;
			try {
				File file = new File(fileName);
				br = new BufferedReader(new FileReader(file));
				String line = null;//KEY
				while ((line = br.readLine()) != null) {
					String [] ss = line.split(f);
					map.put(ss[cc], "");
					if(count-->0)
					System.out.println(ss[cc]);
				}
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println(s+","+fileName+" num:"+map.size());

	  }
	  public static void log(String s){
		  System.out.println(s);
	  }
	  public static void main(String[] args) {
		  try {
			//uid,openid
			Map<String,String> map = new HashMap<String,String>();
//			addMap(map, "login51.log");
//			addMap(map, "logout51.log");//levelup51.log
//			addMap(map, "levelup51.log");//0505ac.txt
//			addMap(map, "0505ac.txt","\t", 0);//1zhuce.txt
			addMap(map, "1zhuce.txt","\t", 0);//1zhuce.txt
			Map<String,String> registMap = new HashMap<String,String>();

			addMap(registMap, "050100.log",",",3);//注册
			
			cacul(registMap,map);
			
		  } catch (Exception e) {
			  e.printStackTrace();
		  }
	  }
	private static <K,V> void cacul(Map<K, V> registMap, Map<K, V> map) {
		int num = 0;
		for (Iterator<Entry<K, V>> it = map.entrySet()
				.iterator(); it.hasNext();) {
			Map.Entry<K, V> entry = it.next();
			if(registMap.containsKey(entry.getKey())){
				
				num ++;
			}else{
				System.err.println("WW  "+entry.getKey());

			}
		}
		System.err.println("reslut:"+num);
	}
}
