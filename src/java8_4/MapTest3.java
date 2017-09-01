package java8_4;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import a_serial.data.Person;

/* 用并发造成随机数 */
public class MapTest3 {
	public static void main(String args[]) {
		List<Person> list = new ArrayList<>();
		list.add(new Person("a", 1));
		list.add(new Person("b", 2));
		list.add(new Person("c", 3));
		list.add(new Person("d", 4));
		System.out.println(list);
//		list.parallelStream().forEach(System.out::println);//的确会造成随机访问
//		list.stream().parallel().forEach(System.out::println);//访问也是随机的
		list.parallelStream().unordered().limit(3).forEach(System.out::println);//每次都是1，2，可能是因为数目太小


	}
}
