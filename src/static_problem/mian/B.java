package static_problem.mian;
/**
 * 
http://blog.csdn.net/kkgbn/article/details/46003183
 *
 */
public class B extends A {
	static {
		System.out.println("static B");
	}
	
	public B(int b){
//		super();
		System.out.println("构造 b="+b);
	}
	public static void main(String args[]){
		A a = new B(1);
	}
}
