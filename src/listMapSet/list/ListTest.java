package listMapSet.list;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import com.google.common.collect.Lists;

public class ListTest {

	/**
	 * List可以存null
	 * Map的key和value也可以存null
	 * 但是Set不可以存null
	 */
	public static void main(String[] args) {
		List a = Lists.newArrayList();
		a.add(1);
		a.add(null);
		a.add("a");
//		a.remove("a");
		a.remove("a");
		System.out.println(a);
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put(null, null);
		map.put(null, 2);
		System.out.println(map);
		
		Set set = new TreeSet();
		set.add(null);//err
		set.add("a");
//		set.add(1);
		System.out.println(set);
	}

}
