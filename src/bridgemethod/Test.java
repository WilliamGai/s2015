package bridgemethod;

import fanshe.method.ClassUtil;

import java.lang.reflect.Method;

/**
 * Created by bao on 2017/10/14.
 */
public class Test implements ITest {

    @Override
    public <T> T test(T t) {
        return t;
    }

    public static void main(String args[]) {
        String print = ClassUtil.getGenericMethodSimpleString(Test.class);
        System.out.println(print);
    }
}
