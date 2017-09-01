package concurrent.future;

import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 2016年12月1日16:09:55
 * Future,Callable
 * ExecutorCompletionService是顺序执行
 * Q:這是多綫程
 */
public class Test3 {
	private static SecureRandom random = new SecureRandom();
	public static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS ");
	public static String now(){
		return sdf.format(new Date());
	}
	public static void main(String[] args) {
	    System.out.println(now());
		ExecutorService threadPool = Executors.newSingleThreadExecutor();
		CompletionService<Integer> cs = new ExecutorCompletionService<>(threadPool);
		
		int count = 100;
		for(int i = 0;i < count; i++){
			final int _i = i;
			cs.submit(()->{
				System.out.println(now()+_i);
				Thread.sleep(random.nextInt(50)+100);
				return _i;});
		}
		 System.out.println(now()+"33");
		for(int i = 0;i<count; i++){
			try {
//				System.out.println(now()+cs.take().get());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
//	    threadPool.shutdown();
	}
}
