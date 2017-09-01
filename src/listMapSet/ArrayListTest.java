package listMapSet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

import fanshe.method.TestField;
/**
 * ConcurrentSkipListSet 有序
 * @author BAO
 *
 */
public class ArrayListTest {
	public int num=0;
	public void add(){num++;}
	private static ArrayList<String> list = new ArrayList<>();
	private static List<Object> set4list = new ArrayList<>(5);
	private static AtomicInteger count = new AtomicInteger();
	private static ReentrantLock lock = new ReentrantLock();
	public static void main(String args[]) throws InterruptedException{
		
		for(int i = 0;i<100;i++){
			list.add(i+"");
		}
		System.out.println("leek->"+list);
		testList(list,20);
//		System.out.println("->"+list.size());
//		System.out.println("set->"+set4list.size());
//		System.out.println("count->"+count);
//		System.out.println("set->"+set4list.contains(null));
	}
	private static void testList(ArrayList<String> list,int num) throws InterruptedException {
		ArrayListTest a = new ArrayListTest();
		Thread t = new Thread(new Runnable() {
			@Override
			public void run() {
				
				for(int i=0; i<num; i++){
					final int n = i;
					
					new Thread(new Runnable() {
						@Override
						public void run() {
//							lock.lock();//不加锁会造空的时候依然执行,会让size减至-1,爆出数组越界的异常，即使不报异常，也会出现将null加进去的情况
							try {
//								if(!list.isEmpty()){
//									count.incrementAndGet();
								    a.add();
//									Object[] obs= (Object[])TestField.getField(set4list, "elementData");
									set4list.add(""+count.incrementAndGet());	
//								}
							}catch(Exception e){
//								e.printStackTrace();
								System.out.println(n+e.toString());
							}finally{
//								lock.unlock();
							}
							
						}
					},"unsafe list" + i).start();
					
				}
			}
		},"main");
		t.start();
		t.join();
		System.out.println("mset->"+set4list.contains(null));
		System.out.println("mset->"+set4list.size());
		System.out.println("mcount->"+count);
		Thread.sleep(1000);
		System.out.println("mset->"+set4list.size());
		System.out.println("mcount->"+count);
		System.out.println("look->"+set4list);
		System.out.println("a->"+a.num);
		Object[] obs = (Object[])TestField.getField(set4list, "elementData");
		System.out.println("arrk->"+Arrays.toString(obs));
		System.out.println("arrk.size"+obs.length);
	}
}
