package listMapSet;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/**
 * hashMap的get可以传null,
 * concurrentHashMap的get不可以
 * @author BAO
 *
 */
public class MapTest {

	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("1",12);
//		System.out.println(map);
//		Object a = map.containsKey("a");
		System.out.println(map.get(null));
		System.out.println(map.get(1+""));
//		map.pu
//		
//		
//		String s = "12:";
//		String [] ss = s.split(":");
//		System.err.println(".."+ss[0]);
//		System.err.println(".."+ss[1]);
		
		
		Student st = null;
		if(st==null || st.age==0){
			System.out.println(st);
		}
		
		//ConcurrentHashMap是否可以存null? key和vlaue都不可以为null
		Map<String,String> conMap = new ConcurrentHashMap<>();
		String a = conMap.putIfAbsent("a", "b");
		String s = conMap.putIfAbsent("a", "d");
		System.out.println(conMap);
		System.out.println(a);
		System.out.println(s);
		System.err.println(conMap.get(null));
	}
}
