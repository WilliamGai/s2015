package listMapSet;

import org.springframework.util.StopWatch;

public class Test {

	public static void main(String[] args) {
		StopWatch sw = new StopWatch("main tw");
		sw.start("queue init ");
		ConcurrentLinkedQueueTest.INST.init(10000);
		sw.stop();
		sw.start("copylist init ");
		CopyOnWriteArrayListTest.INST.init(10000);
		sw.stop();
		sw.start("queue run");
		ConcurrentLinkedQueueTest.INST.test(10000);
		sw.stop();
		sw.start("copylist run");
		CopyOnWriteArrayListTest.INST.test(10000);
		sw.stop();
		System.out.println(sw.prettyPrint());
	}
}
