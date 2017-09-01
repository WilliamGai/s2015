package listMapSet;

import java.util.concurrent.ConcurrentHashMap;
import java.util.HashMap;
import java.util.Map;
public class ConcurrenthashMapTestGet {

	private ConcurrentHashMap<String,String>  map = new ConcurrentHashMap<String,String>();
	
	public static void main(String[] args) {
		new ConcurrenthashMapTestGet().add();
		
	}
	public void add(){
		String c = map.putIfAbsent("a", "A");
		String d = map.putIfAbsent("a", "A");
		System.out.println(map);
		System.out.println(c);
		System.out.println(d);
	}
}
