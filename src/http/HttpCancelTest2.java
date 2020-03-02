package http;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

import util.DateUtil;
import util.ThreadTool;

public class HttpCancelTest2 {

	public static void main(String args[]) throws Exception {

		System.out.println("the weather is \n" + getWeather());
	}

	public static String getWeather() throws Exception {
		SynchronousQueue<String> queue = new SynchronousQueue<String>();
		new MyHttpThread("https://www.baidu.com", queue).start();
		ThreadTool.sleep(10);
		new MyHttpThread("https://cn.bing.com", queue).start();
//		ThreadTool.sleep(30);
		new MyHttpThread("https://github.com", queue).start();
		return queue.take();

	}

	public static class MyHttpThread extends Thread {
		private static AtomicInteger count = new AtomicInteger();
		private static AtomicBoolean cancled = new AtomicBoolean(false);
		private SynchronousQueue<String> queue;
		private String url;

		public MyHttpThread(String url, SynchronousQueue<String> queue) {
			this.queue = queue;
			this.url = url;
			this.setName(" thread"+count.getAndIncrement()+" ");
		}

		@Override
		public void run() {
			try {
				long time = System.currentTimeMillis();
				String result = get(url);
				System.out.println("耗时" + (System.currentTimeMillis() - time) + " "+Thread.currentThread().getName()+DateUtil.INSTANCE.getTodayStamp());
				if (setCancled()) {
					queue.offer(result);
					System.out.println("设置成功 " + Thread.currentThread().getName()+DateUtil.INSTANCE.getTodayStamp());
					return;
				}
				System.out.println("设置失败 " + Thread.currentThread().getName()+DateUtil.INSTANCE.getTodayStamp());
			} catch (CanceledException e) {
				System.out.println("被中断 " + Thread.currentThread().getName()+DateUtil.INSTANCE.getTodayStamp());
			}
		}

		public boolean setCancled() {
			return cancled.compareAndSet(false, true);
		}

		public boolean isCancled() {
			return cancled.get();
		}

		public String get(String strURL) throws CanceledException {
			try {
				AseertCancel();
				URL url = new URL(strURL);
				HttpURLConnection connection = (HttpURLConnection) url.openConnection();
				connection.setDoOutput(true);
				connection.setDoInput(true);
				connection.setUseCaches(false);
				connection.setInstanceFollowRedirects(true);
				connection.setRequestMethod("GET");
				connection.setRequestProperty("Accept", "application/json");
				connection.setRequestProperty("Content-Type", " application/x-www-form-urlencoded");
				AseertCancel();
				connection.connect();
				AseertCancel();
				OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream(), "UTF-8");
				out.append("");
				out.flush();
				AseertCancel();
				int length = (int) connection.getContentLength();
				if (length == -1) {
					return "result length error";
				}
				InputStream is = connection.getInputStream();
				// if (length != -1 && !isCancled()) {
				byte[] data = getStreamBytes(is);
				AseertCancel();
				System.err.println("读取结束 " + Thread.currentThread().getName()+DateUtil.INSTANCE.getTodayStamp());
				String result = new String(data, "UTF-8");
				// System.out.println("设置result"+result);
				return result;
			} catch (CanceledException e0) {
				System.err.println("AAAAAAAAAAAAAAAAXXXXXXXXXXEEEEEE");
				throw e0;
			} catch (Exception e) {
				System.err.println("XXXXXXXXXXEEEEEE" + e);
				e.printStackTrace();
				return "error";
			} finally {
				// somethings.close();
			}

		}

		public byte[] getStreamBytes(InputStream is) throws Exception {
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			byte[] buffer = new byte[1024];
			int len = 0;
			while ((len = read(is, buffer, 0, buffer.length)) != -1) {
				AseertCancel();
				baos.write(buffer, 0, len);
			}
			AseertCancel();
			byte[] b = baos.toByteArray();
			is.close();
			baos.close();
			return b;
		}

		public int read(InputStream is, byte b[], int off, int len) throws IOException {
			if (b == null) {
				throw new NullPointerException();
			} else if (off < 0 || len < 0 || len > b.length - off) {
				throw new IndexOutOfBoundsException();
			} else if (len == 0) {
				return 0;
			}
			AseertCancel();
			int c = is.read();
			if (c == -1) {
				return -1;
			}
			b[off] = (byte) c;

			int i = 1;
			try {
				for (; i < len; i++) {
					// ThreadTool.sleep(1);
					AseertCancel();
					c = is.read();
					if (c == -1) {
						break;
					}
					b[off + i] = (byte) c;
				}
			} catch (IOException ee) {
			}
			return i;
		}

		private void AseertCancel() {
//			System.err.println(Thread.currentThread().getName()+"---测试中断"+isCancled());
			if (isCancled()) {
				System.err.println("EEEEEEEEEEEEE");
				throw new CanceledException();
			}
		}

		public static class CanceledException extends RuntimeException {
			public CanceledException() {
				super("cancel occur");
			}
		}
	}
}
