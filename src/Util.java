

import java.util.Arrays;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class Util {
	public static boolean isLinux() {
		String os = System.getProperty("os.name").toLowerCase();
		if (!isEmpty(os) && os.contains("windows")) {
			return false;
		}
		return true;
	}

	public static boolean isEmpty(Object obj) {
		return Objects.isNull(obj);
	}

	public static boolean isEmpty(Object os[]) {
		return null == os || 0 == os.length;
	}

	public static boolean isEmpty(String str) {
		return null == str || 0 == str.length();
	}

	public static boolean isEmpty(Map<?, ?> map) {
		return null == map || 0 == map.size();
	}

	/** TU **/
	private static <K, V> String joinMap(Map<K, V> map) {
		StringBuilder sb = new StringBuilder();
		for (Iterator<Map.Entry<K, V>> it = map.entrySet().iterator(); it.hasNext();) {
			Map.Entry<K, V> entry = it.next();
			K k = entry.getKey();
			V v = entry.getValue();
			if (v.getClass().isArray()) {
				Object[] os = (Object[]) v;
				sb.append(k).append("=").append(Arrays.toString(os));
			} else {
				sb.append(k).append("=").append(v);
			}
		}
		return sb.toString();
	}

	/** to collect */
	public static String join(Enumeration<String> names, String separator) {
		StringBuilder sb = new StringBuilder();
		boolean first = true;
		while (names.hasMoreElements()) {
			if (first)
				first = false;
			else
				sb.append(separator);
			sb.append(names.nextElement());
		}
		return sb.toString();
	}

	public static String join(Collection<String> names, String separator) {
		return names.stream().collect(Collectors.joining(separator));
	}

	public static String format(String messagePattern, Object... arguments) {
		if ((messagePattern == null) || (arguments == null) || (arguments.length == 0)) {
			return messagePattern;
		}

		StringBuilder result = new StringBuilder();
		int escapeCounter = 0;
		int currentArgument = 0;
		for (int i = 0; i < messagePattern.length(); i++) {
			char curChar = messagePattern.charAt(i);
			if (curChar == '\\') {
				escapeCounter++;
			} else if ((curChar == '{') && (i < messagePattern.length() - 1) && (messagePattern.charAt(i + 1) == '}')) {
				int escapedEscapes = escapeCounter / 2;
				for (int j = 0; j < escapedEscapes; j++) {
					result.append('\\');
				}

				if (escapeCounter % 2 == 1) {
					result.append('{');
					result.append('}');
				} else {
					if (currentArgument < arguments.length)
						result.append(arguments[currentArgument]);
					else {
						result.append('{').append('}');
					}
					currentArgument++;
				}
				i++;
				escapeCounter = 0;
			} else {
				if (escapeCounter > 0) {
					for (int j = 0; j < escapeCounter; j++) {
						result.append('\\');
					}
					escapeCounter = 0;
				}
				result.append(curChar);
			}
		}
		return result.toString();
	}

	/** 鍏ㄩ儴涓嶄负绌烘椂杩斿洖鐪�,瀹冪殑闈炴槸鏈夎嚦灏戞湁涓�涓负绌� **/
	public static boolean nonNull(Object... objs) {
		if (null == objs)
			return false;
		for (Object o : objs) {
			if (null == o)
				return false;
		}
		return true;
	}
}
