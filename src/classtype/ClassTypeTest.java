package classtype;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/*  切记 Field中的Type是声明类型, 而Value值是运行时类型*/
public class ClassTypeTest {
	public static void main(String args[]) throws Exception{
		Map map = new HashMap();
		System.out.println(map.getClass());
		
		DataSimpleVO vo = new DataSimpleVO("hi", map);
		Field field = vo.getClass().getField("value");
		field.setAccessible(true);
		System.out.println(field.getType());
		System.out.println(field.get(vo).getClass());
		
	}
}
