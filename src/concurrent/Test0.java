package concurrent;

import java.util.Arrays;
import java.util.Objects;

import org.apache.commons.lang.Validate;

/**
 * i++,并不是原子操作
 */
public class Test0 {
	private static int  a = 0;
	private static  Integer arr[] = new Integer[10001];
	public static void main(String[] args) throws Exception {
		System.out.println("LOL");

		for(int i=0;i<20;i++){
//			Thread.sleep(2);
			startAdd(i);
		}
		Thread.sleep(2000);
		System.out.println(Arrays.toString(arr));
		System.out.println(a);
	}

	public static void startAdd(int i) {
		new Thread(() -> {
			try {
				Thread.sleep(2);
				arr[a++] = i;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}).start();
	}
}
