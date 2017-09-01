package java8_5_cuncurrent;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAccumulator;
import java.util.concurrent.atomic.LongAdder;

public class ActomicChangeTest {

	public static void main(String[] args) {
		/* 不同线程检测最大值 */
		AtomicLong largest = new AtomicLong();
		long obsvValue = 0;
		/* 错误的方式,此更新不是原子性的 */
		largest.set(Math.max(largest.get(), obsvValue));
		/* 正确的方式,这种方式比锁快 */
		long oldValue;
		long newValue;
		do {
			oldValue = largest.get();
			newValue = Math.max(obsvValue, oldValue);
		} while (!largest.compareAndSet(oldValue, newValue));
		/* J8的方式 */
		largest.updateAndGet(x -> Math.max(x, obsvValue));
		/* 或者 */
		largest.accumulateAndGet(obsvValue, Math::max);

		/*
		 * 当有大量线程访问同一个原子值的时,由于乐观锁更需要太多次重试,因此会导致性能严重下降
		 * J8提供了LongAdder和LongAccumulator来解决该问题。LongAdder由多个变量组成，这些变量累加的值
		 * 就是当前值。多个线程可以更新不同的被加数
		 * ,当线程数量增加时会自动增加新的被加数。由于通常情况下都是直到所有工作完成后才需要总和值，所以这种方法效率很高
		 * 如果你的环境存在高度竞争，那就应当用LongAdder来代替AtomicLong二者之间的方法命名稍有不同
		 * 。Increment方法用来将计数器自增1，add方法用来加上某个数值，sum方法用来获取总和值
		 * tips:increment方法不会返回原始值。使用它只会抹杀掉总和值，拆分为多个被加数所带来的性能提升
		 */
		final LongAdder adder = new LongAdder();
		adder.increment();
		adder.increment();
		adder.increment();
		long total = adder.sum();
		/*
		 * LongAccumulator将这个思想带到了任意的累加操作中。在构造函数中，你需要提供操作类型及其中立元素
		 * 要与新值相加,你需要调用accumulate方法。饭后再调用get方法获取当前值。以下代码与LongAdder是一样的
		 */
		LongAccumulator adder2 = new LongAccumulator(Long::sum, 0);
		/*在某些线程中**/
		adder2.accumulate(52);
	
		
	}

}
