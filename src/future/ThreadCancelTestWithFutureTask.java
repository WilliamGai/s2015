package future;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import util.ThreadTool;

public class ThreadCancelTestWithFutureTask {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService es = Executors.newFixedThreadPool(1);
		Future<Integer> future = es.submit(()->{
			ThreadTool.sleep(2000);
			System.out.println("haha9999");
			return 100;
		});
		
		
		ThreadPoolExecutor pool = new ThreadPoolExecutor(1, 1,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>());
		
		
		ThreadTool.sleep(400);
		future.cancel(false);
		System.out.println("haha4");
		System.out.println("haha4"+future.get());
	}


}
