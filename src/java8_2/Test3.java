package java8_2;

import java.util.Arrays;
import java.util.List;

/**
 * 3.支持函数编程 为了支持函数编程，Java 8加入了一个新的包java.util.function，
 * 其中有一个接口java.util.function.Predicate是支持Lambda函数编程：
 */
public class Test3 {

	public static void main(String[] args) {
		List<String> languages = Arrays.asList("Java", "Scala", "C++",
				"Haskell", "Lisp");

		System.out.println("Languages which starts with J :");
		filter(languages, (str) -> (str).startsWith("J"));

		System.out.println("Languages which ends with a ");
		filter(languages, (str) -> (str).endsWith("a"));

		System.out.println("Print all languages :");
		filter(languages, (str) -> true);

		System.out.println("Print no language : ");
		filter(languages, (str) -> false);

		System.out.println("Print language whose length greater than 4:");
		 filter(languages, (str)->str.length() > 4);
	}

	public static void filter(List<String> names, MyPredicate<String> condition) {
		names.stream().filter((name) -> (condition.test(name)))
				.forEach(System.out::println);
	}
	public static void filter2(List<String> names, MyPredicate<String> condition) {
		for(String name:names){
			if(condition.test(name)){
				System.out.println(name);
			}
		}
		names.stream().filter((name) -> (condition.test(name)))
		.forEach((x)->System.out.println(x));
	}
}