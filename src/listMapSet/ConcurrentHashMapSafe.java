package listMapSet;

import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListSet;

public class ConcurrentHashMapSafe {
	private static ConcurrentHashMap<String,String> map = new ConcurrentHashMap<String,String>();
	static {
		System.out.println("static");
	}
	public static void main(String args[]) throws InterruptedException{
		Thread t = new Thread(new Runnable() {
			@Override
			public void run() {
				for(int i=0; i<100000; i++){
					new Thread(new Runnable() {
						@Override
						public void run() {
							map.put(UUID.randomUUID().toString(),"");							
						}
					},"unsafe map" + i).start();
					
				}
			}
		},"main");
		t.start();
		t.join();
		System.out.println("i");
		for(int i = 0;i<10000;i++){
			map.put(i+"","");
		}
		System.out.println(map.size());
	}
}
