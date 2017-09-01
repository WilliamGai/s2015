package listMapSet;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapTest {

	public static void main(String[] args) {
		LinkedHashMap<Integer, Student> map = new LinkedHashMap<Integer, Student>();
		map.put(1, new Student("tom",12));
		map.put(2, new Student("jose",13));
		map.put(2, new Student("jack",14));
		for (Student s : map.values()) {
			s.setAge(100);
		}
		testChange();
		
		System.out.println(map);
		System.out.println("have a think");
		Student [] ss = map.values().toArray(new Student[10]);
		System.out.println(Arrays.toString(ss));
		System.out.println("have a think2");
		Object[] s =  map.values().toArray();
//		Student [] ss2 = (Student [])s;
		Student st1  = new Student("lee",180);
		Object[] arr = new Student[]{new Student("lee",1),
				new Student("lee2",2),
				new Student("lee2",3),
				new Student("lee2",4),
				new Student("lee2",5),
				new Student("lee2",6),
		};
		Student[] st2 = (Student[])arr;
		System.out.println(Arrays.toString(s));
		System.out.println(Arrays.toString( map.values().toArray(arr)));
	}

	private static void testChange() {
		Map<Integer, String> map = new HashMap<Integer, String>();
		map.put(1, "A");
		map.put(2, "B");
		for (Iterator<Map.Entry<Integer, String>> it = map.entrySet()
				.iterator(); it.hasNext();) {
			Map.Entry<Integer, String> entry = it.next();
			String s = entry.getValue();
			s = "HAHA";
		}
		for (String s : map.values()) {
			s="haha";
		}
		System.err.println(map);
	}
}
