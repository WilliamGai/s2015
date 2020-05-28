package http.cancel;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.LockSupport;

import observer.test.Observer;

public class HttpCancel<T> implements Subject{
	private AtomicBoolean cancled = new AtomicBoolean(false);
	private Thread waitor;
	private T result;
	protected List<Listener> listeners;

	
//	private final static ThreadLocal<HttpCancelTest5HttpUtil> portCurrent = new ThreadLocal<>();
	
	public static void main(String args[]) throws Exception {

		System.out.println("the weather is \n" + new HttpCancel().getWeather());
	}
	
	
	public HttpCancel() {
		listeners = new CopyOnWriteArrayList<>();
		this.waitor = Thread.currentThread();
	}
	
	public void waiting() {
		LockSupport.park();
	}
	public synchronized void fire(T result) {
		if(cancled.compareAndSet(false, true)) {
			this.result = result;
			LockSupport.unpark(this.waitor);
		}
	}

	public T getWeather() throws Exception {
		HttpCancel<String> cancel = new HttpCancel<>();
		new MyHttpThread().setUrl("https://www.baidu.com").setSubject(cancel).start();
		new MyHttpThread().setUrl("https://cn.bing.com").setSubject(cancel).start();
		new MyHttpThread().setUrl("https://github.com").setSubject(cancel).start();
		waiting();
		notice();
		return result;

	}

	private static class MyHttpThread extends Thread implements Listener{

		private String url;
		private Subject cancel;
        CloseableHttpClient httpClient = HttpClients.createDefault();
        


		public MyHttpThread setUrl(String url) {
			this.url = url;
			return this;
		}
		public MyHttpThread setSubject(Subject cancel) {
			this.cancel = cancel;
			this.cancel.attach(this);
			return this;
		}
		
		@Override
		public void run() {
			try {
				HttpGet request = new HttpGet(url);
		        CloseableHttpResponse response = httpClient.execute(request);
		        HttpEntity entry = response.getEntity();
		        int code = response.getStatusLine().getStatusCode();
		        String result = EntityUtils.toString(entry);
				 ((HttpCancel<String>)this.cancel).fire("");
			} catch (Exception e) {
		        HttpClientUtils.closeQuietly(response);
		        HttpClientUtils.closeQuietly(httpClient);
				e.printStackTrace();
			}
		}



		@Override
		public void release() {
	        HttpClientUtils.closeQuietly(response);
	        HttpClientUtils.closeQuietly(httpClient);
		}
	}

	@Override
	public void attach(Listener l) {
		this.listeners.add(l);
		
	}


	@Override
	public void detach(Listener l) {
		throw new UnsupportedOperationException();
	}


	@Override
	public void notice() {
		listeners.forEach(Listener::release);
		
	}
}
