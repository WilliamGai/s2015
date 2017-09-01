package java8_mytest;
@FunctionalInterface
public interface ICamputor<T, F> {
	public String sum(T t, F f);
	public static void test_s(){
		
	};
	public default void test_d(){
		
	};
}
