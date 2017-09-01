package alex;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * 某网友的写法
 * http://lsk569937453.iteye.com/blog/2286415
 */
public class TestRollBackNetFriend {


	private static class Rollback {
		public Rollback(Boolean needRoolBack) {
			this.needRoolBack = needRoolBack;
		}

		private Boolean needRoolBack = false;

		public Boolean getNeedRoolBack() {
			return needRoolBack;
		}

		public void setNeedRoolBack(Boolean needRoolBack) {
			this.needRoolBack = needRoolBack;
		}
	}


	private static class Task implements Runnable {
		/**
		 * 监控10个子任务的执行
		 */
		private CountDownLatch childMonitor;
		/**
		 * 监控主线程
		 */
		private CountDownLatch mainMonitor;

		/**
		 * 存储线程的返回结果
		 */
		private BlockingDeque<Boolean> resultList;
		/**
		 * 回滚类
		 */
		private Rollback rollback;

		public Task(CountDownLatch childCountDown, CountDownLatch mainCountDown, BlockingDeque<Boolean> result, Rollback rollback) {
			this.childMonitor = childCountDown;
			this.mainMonitor = mainCountDown;
			this.resultList = result;
			this.rollback = rollback;
		}

		private void shouldRollBack() {
			System.out.println(Thread.currentThread().getName()+"开始回滚");

		}

		/**
		 * 事务提交
		 */
		private void submit() {
		}

		/**
		 * 执行任务,返回false表示任务执行错误，需要回滚
		 * 本案例中根据线程名字包含Thread-8判断是否回滚
		 * @return
		 */
		private Boolean processTask() {

			if(Thread.currentThread().getName().contains("Thread-8"))
				return false;
			return true;
		}

		@Override public void run() {
			System.out.println(Thread.currentThread().getName()+"子线程开始执行任务");

			Boolean result = processTask();
			//向队列中添加处理结果
			resultList.add(result);
			//等待其他的子线程执行完成，一起执行主线程的判断逻辑
			childMonitor.countDown();
			try {
				//等待主线程的判断逻辑执行完，执行下面的是否回滚逻辑
				mainMonitor.await();
			} catch (Exception e) {
				e.printStackTrace();
			}

			System.out.println(Thread.currentThread().getName()+"子线程执行剩下的任务");
			//需要回滚
			if (rollback.getNeedRoolBack())
				shouldRollBack();
			else
			//不需要回滚->事务提交
				submit();

		}
	}

	public static void main(String[] args) {
		//监控10个子线程的任务执行
		CountDownLatch childMonitor = new CountDownLatch(10);
		//监控主线程，是否需要回滚
		CountDownLatch mainMonitor = new CountDownLatch(1);
		//存储任务的返回结果，返回true表示不需要回滚，反之，则回滚
		BlockingDeque<Boolean> results = new LinkedBlockingDeque<Boolean>(10);

		Rollback rollback = new Rollback(false);

		for (int i = 0; i < 10; i++) {
			//10个任务启动
			Thread thread = new Thread(new Task(childMonitor, mainMonitor, results, rollback));
			thread.start();
		}

		try {

			//监测10个子线程的执行
			childMonitor.await();
			System.out.println("主线程开始执行任务");

			//根据返回结果来确定是否回滚
			for (int i = 0; i < 10; i++) {
				Boolean result = results.take();
				if (!result) {
					rollback.setNeedRoolBack(true);
				}
			}
			//10个子线程开始执行
			mainMonitor.countDown();

			if(rollback.getNeedRoolBack())
				System.out.println("Fail");
			else System.out.println("Success");
		} catch (Exception e) {

		}
	}
}
