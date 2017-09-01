package listMapSet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
/**
 * ConcurrentSkipListSet 有序,而且会帮你排序
 * @author BAO
 *
 */
public class ConcurrentSkipListSetTest {
	private static ConcurrentSkipListSet<String> set = new ConcurrentSkipListSet<String>();
	private static List<String> list = new ArrayList<>();
	static {
		System.out.println("static");
	}
	public static void main(String args[]) throws InterruptedException{
		Thread t = new Thread(new Runnable() {
			@Override
			public void run() {
				for(int i=0; i<10; i++){
					new Thread(new Runnable() {
						@Override
						public void run() {
//							set.add(UUID.randomUUID().toString());							
						}
					},"unsafe map" + i).start();
					
				}
				System.out.println(":"+set.size());
			}
		},"main");
		t.start();
		t.join();
		for(int i = 0;i<10;i++){
			list.add(i+"");
			list.add(i+"");
		}
		set.pollFirst();
//		Thread.sleep(1000);
		System.err.println(set.size());
		Collections.shuffle(list);
		set.addAll(list);
		System.err.println(list);
		System.err.println(set);
		set.remove("9");
		System.err.println(set);
	}
}
