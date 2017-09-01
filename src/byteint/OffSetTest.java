package byteint;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import sun.misc.Unsafe;

public class OffSetTest {
	public static long getOffSet(Object obj, String fieldName) throws NoSuchFieldException, SecurityException{
		Unsafe unsafe = getUnsafe();
		Field f = obj.getClass().getDeclaredField(fieldName);
		long offset = unsafe.objectFieldOffset(f);
		return offset;
	}
	public static void getOffSets(Object obj,String[] fieldNames,Map<Long,String> map) throws NoSuchFieldException, SecurityException{
		for (String fieldName : fieldNames) {
			map.put(getOffSet(obj, fieldName), fieldName);
		}
	}
	public static void main(String[] args) throws NoSuchFieldException, SecurityException {
		A a = new A();
		Field[] fields = a.getClass().getDeclaredFields();
		System.out.println(fields.length);
		String[] ss =  Arrays.stream(fields).map(t->t.getName()).collect(Collectors.toList()).toArray(new String[0]);
		TreeMap<Long, String> map = new TreeMap<Long, String>();
		getOffSets(a, ss, map);
		System.out.println(map);
	}
	public static Unsafe getUnsafe(){
		Field field;
		try {
			field = Unsafe.class.getDeclaredField("theUnsafe");
			field.setAccessible(true);
			Unsafe unsafe = (Unsafe)field.get(null);
			return unsafe;
		} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}
}
class A{
	int int0;
	int int1;
	int int2;
	char char0;
	char char1;
	char char2;
//	boolean bool0;
//	byte byte0;
//	byte byte1;
//	float float0;
//	float float1;
	double double0;
	double double1;
//	long long0;
//	long long1;
	List<Integer> list = Arrays.asList(1,2,3);
	Object obj0;
	Object obj1;
	
	List<String> list2;
}
