package alibb_shenxun;

import java.util.concurrent.locks.ReentrantLock;

public class DrdsPrefTest {
	private String share = "DRDS是阿里分布式数据库";
	private ReentrantLock lock = new ReentrantLock();
	/**
	 * share是共享变量
	 * 共享变量意味着多个不同的线程可以访问这个变量
	 * @param args, 非共享变量,java的方法栈动态生成的区域
	 * 多线程环境下，让计算机像我们一样去理解这个系统。
	 * 简单抽象来看，一个输入参，一个共享数据 ，进行一段计算，返回一个结果，最后返回一个共享数据的版本
	 * 再把它抽象来看，很多时候对数据库的操作就是操作这个共享数据。只是将原来本地的共享数据变成了一个远程的共享数据而已。
	 * 就是存储和计算分离的操作，存储和计算分离后会有性能的代价。
	 */
	public String doSth(String args){
		lock.lock();
		try {
			String tempStr = share + args;
			this.share = tempStr;
			return tempStr;
		}finally{
			lock.unlock();
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
