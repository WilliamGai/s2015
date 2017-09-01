package java8;


/**
 * 和本地变量不同的是，
 * lambda内部对于实例的字段以及静态变量是即可读又可写。
 * 该行为和匿名对象是一致的
 */
public class Test_07 {

    static int outerStaticNum;
    int outerNum;
    void testScopes() {
        Converter<Integer, String> stringConverter1 = (from) -> {
            outerNum = 23;
            return String.valueOf(from);
        };
        Converter<Integer, String> stringConverter2 = (from) -> {
            outerStaticNum = 72;
            return String.valueOf(from);
        };
    }
	
	public static void main(String[] args) {}
}
