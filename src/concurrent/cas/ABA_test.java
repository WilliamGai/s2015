package concurrent.cas;

import util.ThreadTool;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * Created by bao on 2017/7/19.
 */
public class ABA_test {
    public static void main(String[] args) throws InterruptedException {
        String s;
        //testABA1();

        testABA2();
    }
    /*** ABA的问题*/
    private static void testABA1() throws InterruptedException {
        AtomicInteger atomicInt = new AtomicInteger(100);
        new Thread(() -> {
            atomicInt.compareAndSet(100, 101);
            atomicInt.compareAndSet(101, 100);
        }).start();

        new Thread(() -> {
            ThreadTool.sleep(1000);
            boolean c3 = atomicInt.compareAndSet(100, 102);
            System.out.println(c3);        //true
        }).start();
    }
    /**
     * 不会出现ABA问题
     */
    private static void testABA2() {
        AtomicStampedReference<Integer> rf = new AtomicStampedReference<>(100, 0);
        new Thread(() -> {
            ThreadTool.sleep(1000);
            rf.compareAndSet(100, 101, rf.getStamp(), rf.getStamp() + 1);
            rf.compareAndSet(101, 100, rf.getStamp(), rf.getStamp() + 1);
        }).start();

        new Thread(() -> {
            int stamp = rf.getStamp();
            System.out.println("before sleep : stamp = " + stamp);    // stamp = 0
            ThreadTool.sleep(2000);
            System.out.println("after sleep : stamp = " + rf.getStamp());//stamp = 1
            boolean c3 = rf.compareAndSet(100, 101, stamp, stamp + 1);
            System.out.println(c3);        //false
        }).start();
    }


}