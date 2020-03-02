package http;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.LockSupport;

public class HttpCancelTest3 {
	private AtomicBoolean cancled = new AtomicBoolean(false);
	private Thread waitor;
	private String result;

	public static void main(String args[]) throws Exception {

		System.out.println("the weather is \n" + new HttpCancelTest3().getWeather());
	}

	public String getWeather() throws Exception {
		new MyHttpThread("https://www.baidu.com").start();
		new MyHttpThread("https://cn.bing.com").start();
		new MyHttpThread("https://github.com").start();
		// new MyHttpThread("https://sogou.com", queue).start();
		waitor = Thread.currentThread();
		LockSupport.park();
		
		return result;

	}

	private class MyHttpThread extends Thread {

		private String url;

		public MyHttpThread(String url) {
			HttpCancelTest3.this.waitor = waitor;
			this.url = url;
		}

		@Override
		public void run() {
			try {
				String result = get(url);
				if (setCancled()) {
					HttpCancelTest3.this.result = result;
					LockSupport.unpark(HttpCancelTest3.this.waitor);
					return;
				}
			} catch (CanceledException e) {
				e.printStackTrace();
				System.out.println("cancel " + Thread.currentThread().getName());
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
				byte[] data = getStreamBytes(is);
				AseertCancel();
				String result = new String(data, "UTF-8");
				return result;
			} catch (CanceledException e0) {
				throw e0;
			} catch (Exception e) {
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
			if (isCancled()) {
				throw new CanceledException();
			}
		}
	}

	private static class CanceledException extends RuntimeException {
		public CanceledException() {
			super("cancel occur");
		}
	}
}
