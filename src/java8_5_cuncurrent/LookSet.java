package java8_5_cuncurrent;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 150 SET视图
 *
 */
public class LookSet {

	public static void main(String[] args) {
		/*
		 * 如何得到一个大的，线程安全的Set
		 * 它其实是对ConcurrentHashMap<K,Boolean>对象的封装，所有的映射的值都是Boolean.TRUE
		 */
		Set<String> words = ConcurrentHashMap.<String> newKeySet();
		words.add("a");
		words.add("a");
		words.add("b");
		System.out.println(words);
		/*
		 * 如果你已经有了一个映射，那么keySet会返回所有键的Set。该Set是可变的。如果你删除该Set中的元素，那么相应的键和值也会从映射中删除
		 * 但是无法向这个Set中添加元素
		 * ，因为无法添加相应的值。因此Java8给ConcurrentHashMap添加了一个keySet方法，它可以接受一个默认值
		 * ，以便向Set中添加元素。
		 */
		ConcurrentHashMap<String, Long> map = new ConcurrentHashMap<String, Long>();
		map.put("a", 1L);
		map.put("b", 2L);
		map.put("c", 3L);
		Set<String> set2 = map.keySet(1L);//默认值是1
		System.err.println(map);
		set2.remove("c");
		set2.add("d");// 如果改为map.keySet();set添加元素会抛出java.lang.UnsupportedOperationException
		System.err.println(set2);
		System.err.println(map);
	}

}
