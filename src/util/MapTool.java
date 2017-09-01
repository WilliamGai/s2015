package util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MapTool {

	public static void main(String[] args) {
		Map<Object, Object> map = new HashMap<>();
		String s = join(map);

	}

	/* jdk8 */
	private static <K, V> String join(Map<K, V> map) {
		StringBuilder sb = new StringBuilder();
		map.forEach((k, v) -> sb.append(k).append("=").append(v));
		return sb.toString();
	}

	/* minus 7 */
	private static <K, V> String joinMap(Map<K, V> map) {
		StringBuilder sb = new StringBuilder();
		for (Iterator<Map.Entry<K, V>> it = map.entrySet().iterator(); it.hasNext();) {
			Map.Entry<K, V> entry = it.next();
			K k = entry.getKey();
			V v = entry.getValue();
			sb.append(k).append("=").append(v);
		}
		return sb.toString();
	}
}
