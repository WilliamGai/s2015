package java8_2;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

/**
 * java.util.funciton.Predicate提供与或非的逻辑操作
 *
 */
public class Test4 {

	public static void main(String[] args) {
		
		List<String> list = Arrays.asList("A123","b123");
		Predicate<String> p1 = (n) -> n.startsWith("A");
		Predicate<String> p2 = (n) -> n.length() == 4;
		Predicate<String> p3 = Objects::nonNull;
		
		list.stream().filter(p1.and(p2)).forEach((n)->System.out.println(n));
		list.stream().filter(p1.and(p2)).forEach(System.out::println);
		list.stream().filter(p3.negate()).forEach(System.err::println);
	}

}
