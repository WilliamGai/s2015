package a_shengnan.a_mianshi.wm.excutor;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.Executor;
/**
 * ArrayDeque不是线程安全的，所以，用作堆栈时快于 Stack，在用作队列时快于 LinkedList
 *
 */
public class MyExcutor implements Executor{
	private final Queue<Runnable> tasks = new ArrayDeque<Runnable>();
	private final Executor executor;
	private Runnable active;
	public MyExcutor(Executor executor){
		this.executor = executor;
	}

	@Override
	public synchronized void execute(final Runnable command) {
		tasks.offer(new Runnable() {
			@Override
			public void run() {
				try {
					command.run();
				} finally {
					scheduleNext();
				}
			}
		});
		if(active == null){
			scheduleNext();
		}
	}
	protected synchronized void scheduleNext() {
		if((active = tasks.poll()) != null){
			executor.execute(active);
		}
		
	}
	public void display(){
		if(tasks.isEmpty()){
			System.out.println("this is null");
		}
		for(Runnable r : tasks){
			System.out.println(r.toString());
		}
	}
	public static void main(String[] args) {
		Runnable r1 = new Runnable() {
			@Override
			public void run() {
				int i = 0;
				System.out.println(" i = " + (++i));
			}
		};
		Runnable r2 = new Runnable() {
			@Override
			public void run() {
				int a = 3;
				System.out.println(" a = " + (++a));
			}
		};
		Runnable r3 = new Runnable() {
			@Override
			public void run() {
				int b = 7;
				System.out.println(" b = " + (++b));
			}
		};
		MyExcutor m = new MyExcutor(new Executor() {
			@Override
			public void execute(Runnable command) {
				command.run();
			}
		});
		m.execute(r1);
		m.execute(r2);
		m.execute(r3);
		m.display();
	}
}