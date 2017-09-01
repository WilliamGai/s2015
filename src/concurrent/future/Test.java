package concurrent.future;

import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * 2016年12月1日14:56:38
 * @author BAO
 * Future,Callable
 */
public class Test {
	private static SecureRandom random = new SecureRandom();
	public static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS ");

	public static String now(){
		return sdf.format(new Date());
	}

	public static void main(String[] args) throws Exception{
		System.out.println(now() + "start ");
		Callable<Integer> call =()-> {
			Thread.sleep(2000);
			return random.nextInt();
			};
		int r = call.call();
		System.out.println(now() + "call " + r);
		
		FutureTask<Integer> future = new FutureTask<>(call);
	    new Thread(future).start();
	    int r2  = future.get();
	    System.err.println(now() + "futrue end"+ r2);
	}
}
