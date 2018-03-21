package thread;

/**
 * Created by bao on 2017/10/1.
 * 后台线程是否会撤销？
 */
public class ThreadDeamoTest {
    public static void main(String args[]){
        Thread t = new DeamoThread();
        t.setDaemon(true);
        t.start();
    }
    private static class DeamoThread extends Thread{
        @Override
        public void run() {
            while(true){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("hei");
            }
        }
    }
}
