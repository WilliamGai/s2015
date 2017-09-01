package concurrent.cas;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * Created by bao on 2017/7/19.
 */
public class CASTest {
    public static void main(String args[]){
        /**会有ABA的问题**/
        AtomicLong largest = new AtomicLong();
        long obsvValue = 0;
        long oldValue;
        long newValue;
        do {
            oldValue = largest.get();
            newValue = Math.max(obsvValue, oldValue);
        } while (!largest.compareAndSet(oldValue, newValue));

        /** 解决ABA问题*/

        AtomicStampedReference<Integer> asr = new AtomicStampedReference<>(100, 1);
        int stamp = asr.getStamp();
    }
}
