package future;

import util.LogCore;
import util.ThreadTool;

public class ThreadCancelTest {

	public static void main(String[] args) {
		Thread t = new Thread(() -> {

			System.out.println("haha");
			while (true) {
					if(Thread.currentThread().isInterrupted()) {
						System.out.println("haha4-----------------");
						return;
					}
					try {
						Thread.sleep(200);
					} catch (InterruptedException e) {
						System.out.println("thread sleep interrupted");
						return;
					}
					System.out.println("haha2"+Thread.currentThread().getName()+Thread.currentThread().isInterrupted());
			}

		});
		t.setName("t thread");
		t.start();

		ThreadTool.sleep(400);
		t.interrupt();
		System.out.println("haha4"+t.getName()+t.isInterrupted());
	}

}
