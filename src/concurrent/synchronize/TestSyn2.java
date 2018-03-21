package concurrent.synchronize;

import util.ThreadTool;

/**
 * Created by bao on 2017/10/25.
 * 结果是0可见 synchronize加在方法上锁定的是对象 方法互斥
 */
public class TestSyn2 {
    public static int count;
    public static void main(String args[]){
        String a = "c";
        TestSyn2 syn = new TestSyn2();
        new Thread(){
            @Override
            public void run() {
                syn.testAdd();
            }
        }.start();
        new Thread(){
            @Override
            public void run() {
                syn.testDel();
            }
        }.start();

        ThreadTool.sleep(1000);

        System.out.println(syn.count);
        ThreadTool.sleep(1000);

        System.out.println(syn.count);

    }
    public void testAdd(){
        int addNum = 1000;
        while(addNum-->0){
            new Thread(){
                @Override
                public void run() {
                   add();
                }
            }.start();
        }

    }
    public void testDel(){
        int addNum = 1000;
        while(addNum-->0){
            new Thread(){
                @Override
                public void run() {
                    del();
                }
            }.start();
        }

    }
    synchronized void add(){
//        Synchrognized的用法对么
        count ++;
    }
    synchronized  void del(){
        count --;
    }
}
