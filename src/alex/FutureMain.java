package alex;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class FutureMain {

	private ConcurrentHashMap<String, Future<Queue<Integer>>> map = new ConcurrentHashMap<String, Future<Queue<Integer>>>();

	public Integer next(String tableName) throws InterruptedException,
			ExecutionException {
		Future<Queue<Integer>> queueFuture = map.get(tableName);

		if (null == queueFuture) {
			Callable<Queue<Integer>> resultCall = new Callable<Queue<Integer>>() {
				@Override
				public Queue<Integer> call() throws Exception {
					// gets the sequence from DB.
					int seqId = 1;
					int step = 1000;
					return new ArrayBlockingQueue<Integer>(step);
				}
			};

			FutureTask<Queue<Integer>> futureTask = new FutureTask<Queue<Integer>>(
					resultCall);

			queueFuture = this.map.putIfAbsent(tableName, futureTask);

			if (null == queueFuture) {
				queueFuture = futureTask;
				futureTask.run();
			}
		}

		Queue<Integer> queue = queueFuture.get();

		return queue.poll();
	}
}