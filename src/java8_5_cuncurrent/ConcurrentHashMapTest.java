package java8_5_cuncurrent;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;

/**
 * 
 * ConcurrentHashMap是线性安全的,多个线程不需要对内部结构造成破坏，就可以删除或者添加元素。
 * 性能高，允许多个线程并发更新哈希表的不停部分，而不会造成相互堵塞
 * ConcurrentHashMap的size是int类型，J8为了应付数量巨大的并发哈希映射，引入了一个mappingCount方法
 * 用来返回一个反应大小的long型值 tips:哈希映射将会将具有相同哈希码的所有数据保存在同一个“块”中。某些应用程序使用了糟糕的哈希函数，
 * 导致所有数据项都被保存在了很小的一组块中，这严重影响了哈希映射的效率。即使是一般认为合理的哈希函数，
 * 例如String类的hashCode方法，也可能会存在问题。例如，攻击者可以通过构造一组大量的哈希码都一样的字符串来拉低程序的速度。
 * 在java8中，并发哈希映射用树形结构来组织“块”,而不再用散列表的结构，这样当键类实现了Comparable接口时, 可以保证性能为a(log(n))
 * tips:看起来一个本应线程安全的数据结构竟然允许线程不安全的操作。但是这是出于两种不同的考虑。
 * 如果多个线程修改一个普通的HashMap,他们可能会破坏内部结构(一个链表数组)。其中一些链接可能会丢失，或者形成了回路
 * 从而导致数据结构不可用。在conccurentHashMap中这永远不会发生。get和put代码永远不会破坏数据结构。
 * 但是由于操作顺序不是原子的，因此结果也无法预测。
 */
public class ConcurrentHashMapTest {

	public static void main(String[] args) {
		ConcurrentHashMap<String, Long> map = new ConcurrentHashMap<>();
		// ①错误的方式
		String word = "key";
		Long oldValue = map.get(word);
		Long newValue = oldValue == null ? 1 : oldValue + 1;
		map.put(word, newValue);
		// ②一种补救措施是使用replace操作，将一个已知的旧值替换为一个新值。
		do {
			oldValue = map.get(word);
			newValue = oldValue == null ? 1 : oldValue + 1;
		} while (!map.replace(word, oldValue, newValue));

		/** 改进方法1 */
		Map<String, AtomicLong> map2 = new ConcurrentHashMap<String, AtomicLong>();
		/** 改进方法2,仅限于java8以上 */
		Map<String, LongAdder> map3 = new ConcurrentHashMap<String, LongAdder>();
		map3.put(word, new LongAdder());
		/** 改进方法2.1,将两条语句合为一条 */
		map3.putIfAbsent(word, new LongAdder()).increment();//不对，可能会空指针
		/**
		 * j8提供了很多可以更方便进行原子更新的方法。compute可以通过一个键和一个函数来计算出新的值
		 * 该函数会获取键及其所关联的值(如果没有值则为null),然后计算出新的值 下面是更新一个整型计数器的映射
		 */
		map.compute(word, (k, v) -> v == null ? 1 : v + 1);
		/**
		 * 此外,ConcurrentHashMap还提供了computeIfPresent和computeIfAbsent方法，
		 * 分别在已经存在值和尚未存在值的情况下,才计算新值。因此LongAdder计算器的映射可以更新为如下代码：
		 * 这与之间的putIfAbsent的方法非常相似，但是LongAdder构造函数只有在需要一个 新计数器时才会调用
		 */
		map3.computeIfAbsent(word, k -> new LongAdder()).increment();
		/**
		 * 通常，当一个键第一次被加入到映射时,你需要做一些特殊的事情，那么使用merge方法会非常方便
		 * 它的一个参数用来表示键尚未存在时的初始值。相反，只有在已有值和初始值相结合的时候，你提供的函数才会被调用
		 * (不像compute方法，该函数不会处理键)
		 */
		map.merge(word, 1L, (existingVal, newVal) -> existingVal + newVal);
		/**
		 * 或者这样
		 * tips:①如果传递给compute或者merge方法的函数返回null,那么已有的数据项会从映射表中抹掉
		 * ②当你使用compute或者merge方法时,请牢记你所提供的函数不应该进行大量工作。
		 * 当函数运行时,其他一些更新映射的操作可能会被阻塞,当然该函数也不应该更新映射的其他部分
		 */
		map.merge(word, 1L, Long::sum);
		
		
		ConcurrentHashMap<String, Long> tmap = new ConcurrentHashMap<>();
		
		System.out.println(tmap.merge(word, 1L, (x,y)->null));
		System.out.println(tmap.merge(word, 1L, (x,y)->null));//如果有则删除，没有则设置为value,返回值为插入的值
		System.out.println(tmap);
		
		Map<String, LongAdder> map7 = new ConcurrentHashMap<String, LongAdder>();
		map7.putIfAbsent(word, new LongAdder()).increment();
		System.out.println(map7);
	}

}
