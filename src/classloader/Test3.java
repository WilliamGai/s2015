package classloader;

import java.util.concurrent.ConcurrentHashMap;

/**
 * 改造ClassLoader的方法
 */
public class Test3 {
    public static void main(String args[]){
        ClassLoader c;
    }


    private final ConcurrentHashMap<String, Object> parallelLockMap = new ConcurrentHashMap<>();

    protected Object getClassLoadingLock(String className) {
        Object lock = this;
        if (parallelLockMap != null) {
            Object newLock = new Object();
            lock = parallelLockMap.putIfAbsent(className, newLock);
            if (lock == null) {
                lock = newLock;
            }
        }
        return lock;
    }
    protected Object getClassLoadingLock2(String className) {
        if (parallelLockMap != null) {
            return parallelLockMap.computeIfAbsent(className, (k)->new Object());
        }
        return this;
    }
}
