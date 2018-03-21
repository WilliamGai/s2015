package threadlocal;

import util.Sys;
import util.ThreadTool;
import util.Util;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bao on 2017/10/25.
 * 查看内存回收
 *         ThreadLocal.ThreadLocalMap.Entry

 */
public class ThreadLocalTest {

    public static final int _1MB = 1024*1024;
    public static final int _10MB = 1024  * 1024 * 10;

    public static ThreadLocal<Object> threadLocal = new ThreadLocal(){
        @Override
        public Object initialValue(){
            return null;
        }
    };

    public static void main(String args[]){System.out.println();
        List<byte[]> list = new ArrayList<>();
        for(;;){
            new Thread(){
                @Override
                public void run() {
                    byte[] data = new byte[_10MB];
                    threadLocal.set(data);
//                    list.add(data);
                }
            }.start();
            ThreadTool.sleep(1000);
            System.out.println(Sys.getJVMStatus());
        }
    }
}
