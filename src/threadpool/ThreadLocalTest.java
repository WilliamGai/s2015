package threadpool;

import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;



public class ThreadLocalTest {
	/**
	 *	线程池不允许使用 Executors去创建，而是通过ThreadPoolExecutor的方式，这样的处理方式让写同学更加明确线程池运行规则，避资源耗尽风险。 
	 *	说明：Executors返回的线程池对象的弊端如下:
	 *	1）FixedThreadPool和 SingleThreadPool: 允许的请求队列长度为 Integer.MAX_VALUE，可 能会堆积大量的请求，从而导致 OOM。 
	 *	2）CachedThreadPool 和 ScheduledThreadPool : 允许的创建线程数量为 Integer.MAX_VALUE，可能会创建大量的线程，从而导致 OOM。
	 * */
	public static void main(String[] args) {
//		ThreadLocal<Port> pool = new ThreadLocal<>(); //java.lang.ThreadLocal<T>
		Executors executors;// java.util.concurrent.Executors
		ThreadPoolExecutor poolExecutor;//java.util.concurrent.ThreadPoolExecutor
//		poolExecutor= new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
//		poolExecutor.getThreadFactory().newThread(r);
		//线程的顶级接口Executor
		Executor e;
		Executors.newCachedThreadPool();
		
		
	}
	public static void test() throws Exception{
		Callable<Integer> call = ()->1;
		ExecutorService es = Executors.newFixedThreadPool(1);
		Future<Integer> f1 = es.submit(call);
		System.out.println(f1.get());
	}
	

}
