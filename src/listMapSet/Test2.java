package listMapSet;

public class Test2 {

	public static void main(String[] args) {
		new Thread(){
			public void run() {
				ConcurrentSetFixBug2.init();
			};
		}.start();
		int count =15000;
		while(count-->0){
			new Thread(){
				public void run() {
					int size = ConcurrentSetFixBug2.getSetSize();
					System.out.println(size);
				};
			}.start();
		}
	}
}
