package java8_mytest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;
/**
 * lamda表达式不可以传递，不能用一个引用保存lamda表达式
 * @author BAO
 *
 */
public class FunctionSaveTest {

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("a");
		list.add("abc");
		list.add("ab");
		Comparator<String> comp = (x, y) -> {return x.compareTo(y);};
		BiFunction<String, String, Integer> compF = (x, y) ->{ return -1;};
		Collections.sort(list, (Comparator)compF);
		System.out.println(list);

	}

}
