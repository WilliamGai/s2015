package listMapSet.list;

import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapTest {

	public static void main(String[] args) {
		Map<String, String> map = new HashMap<>();
		String c0= map.putIfAbsent("a", "b0");
		String c= map.putIfAbsent("a", "b1");
		String c1 = map.put("a1", "B1");
		String c2  = map.put("a1", "B2");
		System.out.println(c0);
		System.out.println(c);
		System.out.println(c1);
		System.out.println(c2);
		System.out.println(map);

	}

}
