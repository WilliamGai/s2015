package alex;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class Test1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String s = "12";
		int a = Integer.parseInt(s);
		int b = Integer.valueOf(s);
		System.out.println(a);
		System.out.println(b);
		HashMap map = null;
		ConcurrentHashMap cmp = null;
		List<String> list = new ArrayList<String>(3);
		list.add("a");
		list.add("b");
		System.out.println(list.size());
		System.out.println(list.get(0));
		System.out.println("你好".length());
		Set set = new HashSet<>();
		
	}

}
