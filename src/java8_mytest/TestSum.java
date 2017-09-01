package java8_mytest;

import java.util.IntSummaryStatistics;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

public class TestSum {

	public static void main(String[] args) {
		int arr[] = {1,2,3};
		Stream<Integer> values = Stream.of();
		/*求和*/
//		Optional<Integer> b = values.reduce((x,y)->x+y);
//		Optional<Integer> c = values.reduce(Integer::sum);
		
		/*有初始值的求和*/
		int d = values.reduce(2,Integer::sum);
		
//		System.out.println(b);
		System.out.println(d);
		/* 属性求和*/
		Stream<String> words = Stream.of("gao","tian","tian");
//		int result = words.reduce(0, (x,y)->x+y.length(), (a,b)->a+b);
		/*用数字流求和*/
//		int result = words.mapToInt(String::length).sum();
//		System.out.println(result);
		/*收集结果*/
		String[] cc= new String[]{};
//		String[] result = words.toArray(String[]::new);//6666
//		System.out.println(Arrays.toString(result));
		/*线程不安全的HashSet处理情况**/
//		HashSet<String> result = words.collect(HashSet::new, HashSet::add, HashSet::addAll);
		/*更常用的方法是用collector*/
//		List<String>result = words.collect(Collectors.toList());
//		Set<String>result = words.collect(Collectors.toSet());
		/*控制得到的set结果类型*/
//		TreeSet<String> result = words.collect(Collectors.toCollection(TreeSet::new));
		/*字符串连接*/
//		String result = values.map(Object::toString).collect(Collectors.joining());
		/*总和，平均值，最大值*/
		IntSummaryStatistics summary = words.collect(Collectors.summarizingInt(String::length));
		double avg = summary.getAverage();
		int max = summary.getMax();
		long count = summary.getCount();
		long sum = summary.getSum();
		int min = summary.getMin();
		System.out.println("avg="+avg+",max="+max+",count="+count+",sum="+sum+",min"+min);
		Stream<Integer> stream = Stream.of(1, 1,3,4 ,5);
		
		
		Map<String, Long> counts = stream.collect(Collectors.groupingBy(String::valueOf, Collectors.counting()));
//		Map<String, Long> counts = stream.collect(Collectors.groupingBy(String::valueOf, Collectors.counting()));
		System.out.println(counts);
	}
	@Test
	public void test(){
		Stream<Integer> stream = Stream.of(1, 1,3,4 ,5);
		
		Function f = String::valueOf;
		Function<Integer,Integer> f2 =TestSum::getL;
		f.andThen(f);
		new StringBuilder().append("a").append("").toString();
		Map<String, Long> counts = stream.collect(Collectors.groupingBy(x->{
			x = x- x % 2;
			return new StringBuilder().append(x).append("~").append(x+2).toString();
		}, Collectors.counting()));
		System.out.println(counts);
	}
	public static int getL(int n){
		int a = 420;
		a = a - a %100;
		return a;
	}

}
