package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * 测试引用参数的传递
 *
 */
public class TestMapNotNull {
    private static Map<String,String> map = null;
	public static void main(String[] args) {
		List<String> list = null;
		new TestMapNotNull().init(list,map);;
		System.out.println("?"+list);
		System.out.println("?"+map);
	}
	public void init(List<String> list,Map<String,String> map){
		list = new ArrayList<String>();
		list.add("a");
		map = new HashMap<String, String>();
		map.put("a", "b");
				
	}
}
