package static_problem;
/**
 * 构造函数和静态域，哪个先调用？
 * 答案是静态域先调用，这个例子具有迷惑性,把private static final TestStatic t = new TestStatic();删掉才能得出正确答案，
 * 因为这一行是静态变量所以在类加载的时候同样被先于构造函数调用了
 * @author admin
 *
 */
public class TestStatic {
	private static final TestStatic t = new TestStatic("b");
	static{
		System.out.println("static");
		t.hello();
	}
	public TestStatic(String tag){
		System.out.println("构造函数"+tag);//1
	}
	public static void hello(){
		System.out.println("hello");//2
	}
	public static void main(String args[]){
		new TestStatic("a");
		System.out.println("hi");
	}
}
