package future;

import byteint.IntBitUtil;
import util.ClassTool;
import util.Util;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by bao on 2017/7/18.
 */
public class FutureTest {
    public static void main(String args[]){
       //test();
       IntBitUtil.intToByte(11);

        System.out.println(ClassTool.getGenericMethodSimpleString(ExecutorService.class));
//        ExecutorService
//        ExecutorService
    }
    public static void test(){
        AtomicInteger count = new AtomicInteger();
        System.out.println("hullo");
        Callable<Integer> call = ()->{
            while(count.incrementAndGet() <100){
                TimeUnit.SECONDS.sleep(1);
            }
            return 0;
        };
        ExecutorService es = Executors.newFixedThreadPool(1);
        Future<Integer> f1 = es.submit(call);

        try {
            f1.get(3,TimeUnit.SECONDS);

        }catch (Exception e){
            e.printStackTrace();
            f1.cancel(true);
        }
        try {
            System.err.println("haha"+count.get());
            TimeUnit.SECONDS.sleep(6);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.err.println("haha"+count.get());

    }
}

