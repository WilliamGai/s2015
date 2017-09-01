package java8_mytest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;

import a_serial.data.Person;


public class CompareTest {

	public static void main(String[] args) {
		List<Person> list = new ArrayList<>();
		Person d = new Person("d", 4);
		list.add(new Person("a", 2));
		list.add(new Person("c", 3));
		list.add(new Person("b", 1));
		list.add(null);
		Function<Person, Integer> f = x -> x.getHeight();
		System.out.println(isEmpty(x -> x.getHeight(), d));
		list.forEach(System.out::println);
		list.stream().filter(Objects::nonNull).forEach(System.err::println);;
		Collections.sort(list, Comparator.comparing(Person::getHeight).reversed());
		System.out.println(list);
		

	}
	public static <T, R> boolean isEmpty(Function<T, R> f, T t){
		return isEmpty(f.apply(t));
	}
	public static boolean isEmpty(Object obj) {
		return Objects.isNull(obj);
	}

}
