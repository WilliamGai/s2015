package fanxing;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
// well done
public class Test2 {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		test2(list);

	}
//	public static void test(List<Number> numbers){
//		for( Number n:numbers){
//			System.out.println("list"+n);
//		}
//	}
	public static void test2(List<? extends Number> numbers){
		for( Number n:numbers){
			System.out.println("list"+n);
		}
	}
}
