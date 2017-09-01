package jicheng.xiangtongbianliang;

/**
 * 所以子类最好和父类不要有相同变量。跟声明有关了，说明编译时决定
 */
public class BB extends AA {
	public String a = "BB.a";
	public static String aa ="BB.aa";
	public static void main(String args[]){
		AA a = new BB();
		System.out.println(a.a+"--"+a.aa);
		AA a1 = new BB();
		BB b = (BB)a1;
		System.out.println(b.a+"--"+b.aa);
	}
}
