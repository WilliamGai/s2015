package thread;

public class ThreadTest1 {
	private int j;
   
	public static void main(String args[]) {
		ThreadTest1 tt = new ThreadTest1();
		Inc inc = tt.new Inc();
		Dec dec = tt.new Dec();
		for (int i = 0; i < 2; i++) {
			new Thread(inc).start();
			new Thread(dec).start();
//			Thread t = new Thread(inc);
//			t.start();
//			t = new Thread(dec);
//			t.start();
		}
	}

	//
	private synchronized void inc() {
		j++;
		System.out.println(Thread.currentThread().getName() + "增：" + j);
	}

	private synchronized void dec() {
		j--;
		System.out.println(Thread.currentThread().getName() + "减：" + j);
	}

	// 增
	class Inc implements Runnable {
		public void run() {
			for (int i = 0; i < 100; i++) {
				inc();
			}
		}
	}

	class Dec implements Runnable {
		public void run() {
			for (int i = 0; i < 100; i++) {
				dec();
			}
		}
	}
}
