package concurrent.lock;

import java.util.concurrent.atomic.AtomicReference;

/***
 * 自旋锁,重入会死锁
 */
public class SpinLockTest
{
    private AtomicReference<Thread> owner =new AtomicReference<>();
    public void lock(){
        Thread current = Thread.currentThread();
        while(!owner.compareAndSet(null, current)){
            //
        }
    }
    public void unlock(){
        Thread current = Thread.currentThread();
        owner.compareAndSet(current, null);
    }
}