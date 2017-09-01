package java8_mytest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class TestForech {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		int [] count = new int[1];
		list.forEach(x->{
			count[0]++;
		});
		System.out.println(count[0]);
		
		String [] ss = new String[200];
		for (int i = 0; i < ss.length; i++) {
			ss[i]=i+"";
		}
		Stream.of(ss).forEach(System.out::println);
//		Stream.of(ss).parallel().forEachOrdered(System.out::println);
		
		
		//验证有序
		List<Integer> ll = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);  
//	    ll.stream().parallel().forEach(x -> System.out.println(x));  
//	    ll.stream().parallel().forEachOrdered(x -> System.out.println(x));
		
	    ll.stream().skip(5).forEach(System.err::println);
	}

}
