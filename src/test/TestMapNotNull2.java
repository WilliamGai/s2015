package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * 测试引用参数的传递
 * 结论，对象的方法可以次修改普通属性
 */
public class TestMapNotNull2 {
    public Map<String,String> map = null;
    public static Map<String,String> mapStatic = null;
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		TestMapNotNull2 c = new TestMapNotNull2();
		c.init(list);;
		mapStatic = new HashMap<String, String>();
		mapStatic.put("a", "b2");
		System.out.println("?list="+list);
		System.out.println("?"+c.map);
		System.out.println("?"+c.mapStatic);
	}
	public void init(List<String> list){
//		list = new ArrayList<String>();
		list.add("a");
		map = new HashMap<String, String>();
		map.put("a", "b");
		
	}
}
