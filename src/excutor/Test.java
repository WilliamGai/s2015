package excutor;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 执行器
 *2017年2月20日15:37:48 查看
 *
 */
public class Test {
	Executor e;
	ExecutorService es;
	ThreadPoolExecutor te;//线程执行器
	ScheduledThreadPoolExecutor ste;
	ForkJoinPool fp;
	public static void main(String[] args) throws Exception {
		test();
	}
	/**
	 * Callable<T> 具有返回值的线程
	 * Future<T> 表示Callable的返回值
	 * @throws ExecutionException 
	 * @throws InterruptedException 
	 */
	public static void test() throws Exception{
		Callable<Integer> call = ()->1;
		ExecutorService es = Executors.newFixedThreadPool(1);
		Future<Integer> f1 = es.submit(call);
		System.out.println(f1.get());
	}
	/**
	 * Fork/Join
	 * ForkJoinTask<T> 描述任务的抽象类
	 * ForkJoinPool 管理ForkJoinTask的线程池
	 * RecursiveAction ForkJoinTask子类,描述无返回值的任务
	 * RecursiveTask<V> ForkJoinTask子类,描述有返回值的任务
	 * @throws Exception
	 */
	public static void test2() throws Exception{
		Callable<Integer> call = ()->1;
		ExecutorService es = Executors.newFixedThreadPool(1);//不要用这种方式
		Future<Integer> f1 = es.submit(call);
		System.out.println(f1.get());
	}
}
