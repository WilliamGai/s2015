package 习惯用法.thread;

public class Test {

	public static void main(String[] args) {
		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("1"+Thread.currentThread());
			}
		}).start();

		new Thread(){
			@Override
			public void run() {
				System.out.println("2"+Thread.currentThread());
			};
		}.start();
		
		new Thread(()->System.out.println("j8"+Thread.currentThread())).start();
	}

}
