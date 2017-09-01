package lru;

import java.util.LinkedHashMap;
import java.util.Map;


/**
 * 本地LRU缓存的实现
 * 
 */
public class LRUCache implements Cache {

    private final Map<Object, Object> store;

    public LRUCache(int size) {
    	this.store = new LinkedHashMap<Object,Object>(){
    		@Override
    		protected boolean removeEldestEntry(Map.Entry<Object, Object> eldest) {
    			return super.removeEldestEntry(eldest);
    		}
    	};
    }

    @Override
    public void put(Object key, Object value) {
        synchronized (store) {
            store.put(key, value);
        }
    }

    @Override
    public Object get(Object key) {
        synchronized (store) {
            return store.get(key);
        }
    }

	@Override
	public String toString() {
		return "LRUCache [store=" + store + "]";
	}
    
}