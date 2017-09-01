package java8_2;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * map和reduce
 *
 */
public class Test5List {

	public static void main(String[] args) {

		/* map和reduce */
		List<Integer> list = Arrays.asList(100, 500);
		list.stream().map((a) -> a + .12 * a).forEach(System.out::println);

		double sum = list.stream().map((a) -> a + .12 * a).reduce((a, b) -> a + b).get();
		System.out.println(sum);

		/* 通过filtering创建一个Strhing的集合 */
		List<String> sList = Arrays.asList("abc", "bcd", "defg", "jk");
		List<String> fList = sList.stream().filter(x -> x.length() > 2).collect(Collectors.toList());
		System.out.println(fList);

		/* 对集合中每个元素应用函数 */
		String rst = sList.stream().map(x -> x.toUpperCase()).collect(Collectors.joining(","));
		System.err.println(rst);

		/* 通过复制不同的值创建一个子列表 */
		List<Integer> numbers = Arrays.asList(1, 1, 2, 2, 3, 4, 5);
		List<Integer> distinctNumbers = numbers.stream().map(x -> x * x).distinct().collect(Collectors.toList());
		System.out.println(distinctNumbers);

		/* 计算list元素中的最大值，最小值，总和已经平均值 */
		List<Integer> primes = Arrays.asList(1, 3, 5, 2, 4, 6);//这是intger 不是 int!
		IntSummaryStatistics stats = primes.stream().mapToInt(x -> x).summaryStatistics();
		int max = stats.getMax();
		int min = stats.getMin();
		long all = stats.getSum();
		double avrg = stats.getAverage();
		System.out.printf("max:%s,min:%s,all:%s,average%s \n", max, min, all, avrg);

		/* b.new 排序和并ixng */
		System.out.println(primes.stream().sorted().count());
		primes.stream().sorted().forEach(System.out::println);
		primes.stream().filter(x -> x != null).sorted((y, x) -> x.compareTo(y)).forEach(System.out::println);
		primes.stream().filter(Objects::nonNull).sorted((y, x) -> x.compareTo(y)).forEach(System.err::println);

		System.out.println(primes);
	}

}
