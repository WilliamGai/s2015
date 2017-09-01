package java8_5_cuncurrent;

import java.net.URL;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.logging.Logger;

public class FutureTest {
	public Future<String> readPage(URL url){
		return new Future<String>() {
			@Override
			public boolean cancel(boolean mayInterruptIfRunning) {
				return false;
			}

			@Override
			public boolean isCancelled() {
				return false;
			}

			@Override
			public boolean isDone() {
				return false;
			}

			@Override
			public String get() throws InterruptedException, ExecutionException {
				return null;
			}

			@Override
			public String get(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
				return null;
			}
		};
	}
	public static class Parser{
		public static List<URL> getLinks(String page){
			return null;
		}
	}
	public static void main(String[] args) {
		Logger.getGlobal().info("niao");
//		CompletableFuture<String> contet

	}

}
