package future;

import util.ThreadTool;

public class ThreadCancelTest2 {

	public static void main(String[] args) {
		Thread t = new MyThread();
		t.start();
	}
	public static class MyThread extends Thread{
		t = new Thread(() -> {

			System.out.println("haha");
			while (true) {
				try {
					if(t.isInterrupted()) {
						
					}
					ThreadTool.sleep(200);
					System.out.println("haha2");
				} catch (Exception e) {
					System.err.println(e);
					return;
				}
			}

		});
		t.start();

		ThreadTool.sleep(400);
		t.interrupt();
		System.out.println("haha4");
	}
}
