package thread;

/**
 * Created by bao on 2018/2/4.
 */
public class RuntimeTest {
    public static void main(String args[]){
    //系统关闭时进行清理
 Runtime.getRuntime().addShutdownHook(new Thread() {
    public void run() {
    }
 });

    }
}
