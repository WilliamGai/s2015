package java8_5_cuncurrent;

import java.util.concurrent.ConcurrentHashMap;

public class PiLiangTest {

	public static void main(String[] args) {
		/*
		 * java8为并发哈希映射提供了批量操作数据操作，即使在其他线程同时操作映射时也可以安全的执行。
		 * 批量数据操作会遍历映射并对匹配的元素进行操作。在批量操作过程中，不需要冻结映射的一个快照。除非你恰好知道在这段时间
		 * 内映射没有被修改，否则你应该将结果看作是映射状态的一个近似值。批量操作有三类
		 * a,search会对每个键或值应用一个函数，直到函数返回一个null的结果。然后search会终止并返回该函数的结果。
		 * b,reduce会通过提供的积累函数，将所有的键或指结合起来。c,forEach会对所有键或值对应一个函数。
		 * 使用这几种操作时，需要指定一个并行阈值
		 * ，如果映射包含的元素数目超过了这个阈值，批量操作以并行的方式执行。如果希望批量操作数据在一个线程执行，
		 * 请使用Long.MAX_VALUE作为阈值。如果希望批量操作尽可能使用更多的线程，则应该使用1作为阈值。
		 */
		/*
		 * 比如希望找到第一个出现超过1000次的的单词，我们需要搜索键和值。 返回结果为第一个匹配的元素，或者没有找到任何元素则返回null
		 */
		ConcurrentHashMap<String, Long> map = new ConcurrentHashMap<>();
		for (int i = 0; i < 1000; i++) {
			map.merge("a", 2L, Long::sum);//2000
			map.merge("b", 1L, Long::sum);//1000
		}
		String rs = map.search(1, (k, v) -> v > 1000 ? k : null);
		System.out.println(rs);
		/*
		 * foreach方法有两种，第一种只是对每个映射数据项简单的用一个消费者函数
		 * 第二种是额外接受一个转换器函数，首先会应用此转换器函数，然后再将结果传递给消费者函数、
		 * 转换器函数可以被用作一个过滤器。当转换器函数返回null时，值会被自动跳过
		 */
		map.forEach(1, (k, v) -> System.out.println(k + "->" + v));
		map.forEach(1, (k, v) -> k + "->" + v, System.out::println);
		map.forEach(1, (k, v) -> v > 1000 ? k + "->" + v : null, System.out::println);
		/*
		 *reduce操作将其输入与一个累加函数结合起来。例如下面是计算所有值的总和
		 */
		Long sum = map.reduceValues(1, Long::sum);
		/*
		 *同forEach一样，你也可以提供一个转换器函数。比如计算长度最长的键
		 */
		Integer maxLength = map.reduceKeys(1, 
				String::length, //转换器
				Integer::max);	//累加器
		System.out.println(maxLength);
		/*
		 * 转换器函数可以作为一个过滤器，通过返回null来排除不想要的输入。
		 * tips:如果映射是空的，或者所有的数据项都被过滤掉了，则reduce操作会返回null。如果只有一个元素，
		 * 那么会返回它转换后的值，并且不会应用累加函数。
		 */
		Long count = map.reduceValues(1, 
				v->v>1000?1L:null, //转换器
				Long::sum);	//累加器
		System.out.println(count);
		/*
		 * 对于int,long,double类型的输出，reduce操作提供了专门的方法，分别以ToInt,ToLong和ToDouble结尾。
		 * 你需要将输入转换为原始类型值，并指定一个默认值和累加器函数。当映射为空时返回默认值。
		 * tips:这几个专门的方法与用于对象的方法行为不同，它们只会考虑一个元素。与返回转换后的元素不同
		 * ，他们会对默认值进行累加，因此。默认值必须是累加器的中立元素。
		 */
		long sum2 = map.reduceValuesToLong(1, 
				Long::longValue, //转换为原始类型
				0, 			//空映射的默认值 
				Long::sum);//原始类型累加器
	}
}
