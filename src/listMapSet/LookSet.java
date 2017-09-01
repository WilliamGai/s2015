package listMapSet;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;

public class LookSet {

	public static void main(String[] args) {
		Set set = new HashSet<>();
		set.add(null);
		set.add((double)1);
		System.out.println(set.contains("1"));
		System.out.println(set.contains(1));
		System.out.println(set.contains(new Integer(1)));
		System.out.println(set.contains(null));
		
		 ConcurrentLinkedQueue<String> queue = new ConcurrentLinkedQueue<>();
		 queue.add("a");
		 queue.add("b");
		 queue.add("b");
		 queue.add("c");
		 System.out.println(queue);
		 queue.remove("b");
		 System.out.println(queue);
	}

}
