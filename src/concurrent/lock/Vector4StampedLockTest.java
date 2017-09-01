package concurrent.lock;

import java.util.concurrent.locks.StampedLock;

/*
 * J8添加了StampedLock类，它用来实现乐观读。 首先调用tryOptimisticRead方法,此时会获得一个“印戳”。然后读取值并检查“印戳”
 * 是否仍然有效(例如其他线程已经获得了一个读锁)。如果有效，就可以使用这个值。如果无效，就会获得一个读锁（它会阻塞所有的写锁）
 */
public class Vector4StampedLockTest {
	private int size;
	private Object[] elements;
	private StampedLock lock = new StampedLock();

	public Object get(int n) {
		long stamp = lock.tryOptimisticRead();
		Object[] currentElements = elements;
		int currentSize = size;
		if (!lock.validate(stamp)) {// 某个线程有了一个写锁
			stamp = lock.readLock();// 获得一个悲观锁?
			currentElements = elements;
			currentSize = size;
			lock.unlock(stamp);
		}
		return n < currentSize ? currentElements[n] : null;
	}
}
