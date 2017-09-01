package listMapSet;

import java.util.Collections;
import java.util.UUID;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.locks.ReentrantLock;
/**
 * ConcurrentSkipListSet ÓÐÐò
 * @author BAO
 *
 */
public class CopyOnWriteArrayListTest {
	private static CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();
	private CopyOnWriteArrayListTest(){}
	private static ReentrantLock lock = new ReentrantLock();
	public static final CopyOnWriteArrayListTest INST = new CopyOnWriteArrayListTest();
	public void init(int n){
		
		for(int i = 0;i<n;i++){
			list.addIfAbsent(i+"");
		}
		Collections.shuffle(list);
		System.out.println(this.getClass().getSimpleName()+"->"+list.size());
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
							lock.lock();
							try {
								if(!list.isEmpty())
								list.remove(0);	
							}finally{
								lock.unlock();
							}
							
						}
					},"unsafe list" + i).start();
					
				}
				System.out.println("copylist:"+list.size());
			}
		},"main");
		t.start();
		try {
			t.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
