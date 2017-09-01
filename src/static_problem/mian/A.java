package static_problem.mian;

public class A {
	static {
		System.out.println("static A");
	}
	public A(){
		System.out.println("构造 A");
	}
	public A(int a){
		System.out.println("构造a="+a);
	}
}
