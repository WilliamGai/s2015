package thread;
import sun.jvmstat.monitor.MonitoredHost;
import sun.jvmstat.monitor.MonitoredVm;
import sun.jvmstat.monitor.MonitoredVmUtil;
import sun.jvmstat.monitor.VmIdentifier;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by bao on 2017/7/6.
 */
public class ThreadDumpTestLook {
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
            test();
        }
    }
    public static void test(){
        try{
            Thread.sleep(1000);
            System.out.println("sub"+Thread.currentThread().getName()+"---"+Thread.currentThread().getId());
            // 获取监控主机
            MonitoredHost local = MonitoredHost.getMonitoredHost("localhost");
            // 取得所有在活动的虚拟机集合
            Set<?> vmlist = new HashSet<Object>(local.activeVms());

            // 遍历集合，输出PID和进程名
            for(Object process : vmlist) {
                MonitoredVm vm = local.getMonitoredVm(new VmIdentifier("//" + process));
                // 获取类名
                String processname = MonitoredVmUtil.mainClass(vm, true);
                System.out.println(process + " ------> " + processname);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
