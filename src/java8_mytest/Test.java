package java8_mytest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.function.IntFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test {
	public static class IntegerTest{
		public IntegerTest(){}
		public IntegerTest(int value){}
	}

	public static void main(String[] args) {
		ICamputor<Integer, Integer> isum = Sum::sum;
		ICamputor<Integer, Integer> isum2 = (x,y)->{return "hh";};
		String s = isum.sum(100, 200);
		System.out.println(s);
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		IntFunction<Integer[]> generator = Integer[]::new;
		IntFunction<Integer> generat = Integer::new;
		IntFunction<IntegerTest> genera = IntegerTest::new;
		IntFunction<IntegerTest[]> genera2 = IntegerTest[]::new;
		IntegerTest[] aa = genera2.apply(2);
		System.out.println(Arrays.toString(aa));
		
		Integer[] ii = list.stream().toArray(Integer[]::new);
		List<String>bb = list.stream().map(x->{return x+"";}).collect(Collectors.toList());
		System.out.println(bb);
		int a = ii.length;
		
		Callable c;
		Runnable r;
	}

}
