package listMapSet;

import java.util.HashMap;
import java.util.UUID;
/**
 * 非县城安全的hashMap,容易引起cpu100%
 * HashMap在并发执行put操作的时候会引起死循环，是因为多线程倒是HashMap的Entry链表形成环形数据结构，一旦形成环形结果，Entry的next节点就永远不为空，
 * 就会产生死循环获取Entry
 * 目前这段代码在java7 会卡死，在java8不会
 */
public class HashMapUnsafe {
	static final HashMap<String,String> map = new HashMap<String,String>(2);
	public static void main(String[] args) throws InterruptedException {
		Thread t = new Thread(new Runnable() {
			@Override
			public void run() {
				for(int i=0; i<100000; i++){
					new Thread(new Runnable() {
						@Override
						public void run() {
							map.put(UUID.randomUUID().toString(), "");							
						}
					},"unsafe map" + i).start();
					
				}
			}
		},"main");
		t.start();
		t.join();
	}
}
