package concurrent.future;

import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 2016年12月1日15:10:47
 * Future,Callable
 */
public class Test2 {
	private static SecureRandom random = new SecureRandom();
	public static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS ");
	public static String now(){
		return sdf.format(new Date());
	}
	public static void main(String[] args) throws Exception{
	    System.out.println(now());
		ExecutorService threadPool = Executors.newSingleThreadExecutor();
		Future<Integer> future = threadPool.submit(()-> {
			Thread.sleep(2000);
			return random.nextInt(10);
		});
		System.out.println(now()+future.get());
	    System.out.println(now()+future.get());
	    System.out.println(now()+future.get());
	    threadPool.shutdown();
	}
}
