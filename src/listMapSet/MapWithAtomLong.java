package listMapSet;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

public class MapWithAtomLong {

	public static void main(String[] args) {
		Map<String, AtomicLong> map = new HashMap<>();
		map.put("1",new AtomicLong());
		map.get("1").addAndGet(100);
		System.out.println(map);
	}
}
