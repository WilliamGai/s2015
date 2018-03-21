package fanxing;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Test {

	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("a");
		list.add("b");
		list.add("c");
		test(list);
		test(list.toArray());

	}
	public static void test(List<Object> obs){
		for(Object o:obs){
			System.out.println("list"+o);
		}
	}
	public static void test(Object ... obs){
		//...
		for(Object o:obs){
			System.out.println(o);
		}
	}
}
