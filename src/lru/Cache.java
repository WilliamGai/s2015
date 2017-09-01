package lru;

public interface Cache {
	 public void put(Object key, Object value);
	 public Object get(Object key);
}
