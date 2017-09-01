package lru;

public class Test {

	public static void main(String[] args) {
		LRUCache cache = new LRUCache(5);
		cache.put("1", "a1");
		cache.put("2", "a2");
		cache.put("3", "a3");
		cache.put("4", "a4");
		cache.put("5", "a5");
		cache.put("6", "a6");
		cache.put("7", "a7");

		System.out.println(cache);
	}

}
