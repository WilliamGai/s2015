package listMapSet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

import com.google.common.collect.Lists;
/**
 * ConcurrentSkipListSet ÓÐÐò
 * @author BAO
 *
 */
public class ConcurrentLinkedQueueTest {
	public static final ConcurrentLinkedQueueTest INST = new ConcurrentLinkedQueueTest();
	private static ConcurrentLinkedQueue<String> queue = new ConcurrentLinkedQueue<>();

	private ConcurrentLinkedQueueTest(){
	}
		
	public void init(int n) {
		List<String> list = new ArrayList<>();
		for(int i = 0;i<n;i++){
			list.add(""+i);
		}
		Collections.shuffle(list);
		queue.addAll(list);
		System.out.println(this.getClass().getSimpleName()+"->"+list.size());
	}

	public static void main(String args[]) throws InterruptedException{
		INST.init(100);
	}
	public void test(int num){
		Thread t = new Thread(new Runnable() {
			@Override
			public void run() {
				for(int i=0; i<num; i++){
					final int n = i;
					new Thread(new Runnable() {
						@Override
						public void run() {
								queue.poll();					
						}
					},"unsafe list" + i).start();
					
				}
				System.out.println("queue.size:"+queue.size());
			}
		},"main");
		t.start();
		try {
			t.join();
			System.out.println("queue.size after join:"+queue.size());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
