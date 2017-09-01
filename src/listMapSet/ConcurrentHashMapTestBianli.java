package listMapSet;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapTestBianli {

	public static void main(String[] args) {
		ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();
		map.put("a", "A");
		map.put("b", "B");
		map.put("c", "C");
		map.put("d", "C");
		map.put("e", "C");
		for (int i = 0; i > 0; i++) {

		}
		for (Iterator<Map.Entry<String, String>> it = map.entrySet().iterator(); it.hasNext();) {
			Map.Entry<String, String> entry = it.next();
			if (entry.getValue().equals("C")) {
				it.remove();
				break;
			}
		}
		System.out.println(Arrays.toString(map.values().toArray()));

		for (Map.Entry<String, String> entry : map.entrySet()) {
			String k = entry.getKey();
			String v = entry.getValue();
		}
	}
}
