package bridgemethod;

import fanshe.method.ClassUtil;

public class Test2 implements ITest2<String> {

    @Override
    public String test(String t) {
        return t;
    }

    public static void main(String args[]) {
        String print = ClassUtil.getGenericMethodSimpleString(Test2.class);
        System.out.println(print);
    }
}