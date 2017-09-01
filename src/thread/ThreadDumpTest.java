package thread;

/**
 * Created by bao on 2017/7/6.
 */
public class ThreadDumpTest {
    public static void main(String args[]) throws InterruptedException {
        new Thread(()->{
            try{
                Thread.sleep(1000);
                System.out.println("sub"+Thread.currentThread().getName()+"---"+Thread.currentThread().getId());
            }catch (Exception e){
                e.printStackTrace();
            }

        }).start();
        int n=0;
        while(n++<100){
            Thread.sleep(1000);
            System.out.println("thread dump test"+Thread.currentThread().getName()+"---"+Thread.currentThread().getId());

        }


    }
}
