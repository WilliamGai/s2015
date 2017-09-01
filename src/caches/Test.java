package caches;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;

public class Test {

	public static void main(String[] args) {
		Map<String, Object> map = new HashMap<>();
		String ss[] = {"a", "v"};
		map.put("en", ss);
		System.out.println(map);
		String[] s = (String[]) map.get("en");

	}
//		Function<String, Object> fnc_get = Test::get;
////		BiConsumer<String, Object> fnc_set = TestArrys2Object::put;
//	}
//	public static String[] get(String key){
//		return null;
//	}
//	public static void put(String key, String[] s){
//	}
	public static <K,V> void put(K key, V s){
	}
}
