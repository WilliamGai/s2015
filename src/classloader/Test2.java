package classloader;

public class Test2 {
    private Test2(){
    	System.out.println("构造函数");
    }
    public void sayHello(){
    	System.out.println("hello");
    }
    static {
//    	new Test2();
    	System.out.println("static");
    }
	public static void main(String[] args) {
		try {
			Class.forName("classloader.Test2").newInstance();
			Class.forName("classloader.Test2").newInstance();
			Test2 o = (Test2)Class.forName("classloader.Test2").newInstance();
			o.sayHello();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
