package future;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.ThreadPoolExecutor;

import org.apache.commons.httpclient.HttpClient;

public class FutureCancelTest {

	public static void main(String[] args) {
		ExecutorService es = Executors.newFixedThreadPool(1);
		Future<Integer> f1 = es.submit(() -> {
			System.out.println("haha");
			return 1;
		});
		
		ThreadPoolExecutor te = null;;
		Future<Integer> f2 = te.submit(task, result)bmit(()->{
			return -1;
		});
		
		f2.cancel(false);
		
		RunnableFuture<Boolean> rf;
		rf.cancel(false);
		FutureTask<Integer> futureTask;
		futureTask.cancel(mayInterruptIfRunning)
		HttpClient httpClient;
		HttpCHttpGet http;
	}

}
