package fanshe.method;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Stream;

import fanshe.ReflectPoint;
/**
 * 调用某个对象的私有方法
 * getDeclaredField 是获取有的属性
 * getField只能是public
 * 
 * 同样的.getClass().getFields()也是只能取出public的字段
 */
public class TestField {
	
	public static void main(String args[]){
			ReflectPoint r = new ReflectPoint(8, 2);
			int s = getField(r, "x");
			System.out.println(s);
			
			List list = new ArrayList<>();
			list.add("");
			int size = getField(list, "size");
			System.out.println(size);
			System.out.println(getFields(r,x->x.getName().length()>2));
	}
	/**
	 * 获得某个对象的某个字段
	 */
	public static <T> T getField(Object r, String filedName){
		try {
			Field f = r.getClass().getDeclaredField(filedName);
		    f.setAccessible(true);
			return (T)f.get(r);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	public static Map<String, Object> getFields(Object r) {
		Map<String, Object> map = new HashMap<>();
		Stream.of(r.getClass().getDeclaredFields()).forEach(field -> {
			field.setAccessible(true);
			try {
				map.put(field.getName(), field.get(r));
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
		return map;
	}
	public static Map<String, Object> getFields(Object r, Predicate<Field> p) {
		Map<String, Object> map = new HashMap<>();
		Stream.of(r.getClass().getDeclaredFields()).forEach(field -> {
			if(!p.test(field))
				return;
			field.setAccessible(true);
			try {
				map.put(field.getName(), field.get(r));
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
		return map;
	}
}
